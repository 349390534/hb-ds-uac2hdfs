package com.howbuy.com.kafka;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseConsumer implements Runnable{
	
	private static final String TOPIC_WEB_PV = "topicwebpv";
	
	private static final String TOPIC_WEB_CLICK = "topicwebclick";
	
	private static final String TOPIC_WEB_EVENT = "topicwebevent";
	
	private static final String TOPIC_APP_PV = "topicapppv";
	
	private static final String TOPIC_APP_CLICK = "topicappclick";
	
	private static final String TOPIC_APP_EVENT = "appeventtopic";
	
	private static final String TOPIC_APP_ACTIVATE = "topicappactivate";
	
	private static final String TOPIC_H5_PV = "topich5pv";
	
	private static final String ZOOKEEPER_URL = "zookerurl";
	
	private static Logger logger = LoggerFactory.getLogger(BaseConsumer.class);
	
	private static Properties prop = new Properties();
	
	static {
		
		
		
		try {
			InputStream input = BaseConsumer.class.getClassLoader()
					.getResourceAsStream("kafka.properties");
			
			prop.load(input);
			
			logger.info("properties: {}",prop);
		} catch (IOException e) {
			logger.error("",e);
		}
		
	}

	protected abstract String getGroup();
	
	protected abstract String getTopic();
	
	protected abstract Logger getLogger();
	
	
	protected String getWebpvTopic(){
		return prop.getProperty(TOPIC_WEB_PV);
	}
	
	protected String getWebclickTopic(){
		return prop.getProperty(TOPIC_WEB_CLICK);
	}
	
	protected String getWebeventTopic(){
		return prop.getProperty(TOPIC_WEB_EVENT);
	}
	
	protected String getApppvTopic(){
		return prop.getProperty(TOPIC_APP_PV);
	}
	
	protected String getAppclickTopic(){
		return prop.getProperty(TOPIC_APP_CLICK);
	}
	
	protected String getAppeventTopic(){
		return prop.getProperty(TOPIC_APP_EVENT);
	}
	
	protected String getAppactivateTopic(){
		return prop.getProperty(TOPIC_APP_ACTIVATE);
	}
	
	protected String getH5PvTopic(){
		return prop.getProperty(TOPIC_H5_PV);
	}
	
	protected String getZookeeperURL(){
		return prop.getProperty(ZOOKEEPER_URL);
	}
	
	private ConsumerConfig createConsumerConfig(){

	    Properties props = new Properties();
	    props.put("zookeeper.connect", getZookeeperURL());
	    props.put("group.id", getGroup());
	    props.put("zookeeper.session.timeout.ms", "2000");
	    props.put("zookeeper.sync.time.ms", "200");
	    props.put("auto.commit.interval.ms", "1000");

	    return new ConsumerConfig(props);
	}
	
	
	public ConsumerConnector getConsumer(){
		ConsumerConnector consumer  = Consumer.createJavaConsumerConnector(
	            								createConsumerConfig());
		return consumer;
	}

	@Override
	public void run() {
		
		logger.info("kafka consumer group : {},topic: {} started",getGroup(),getTopic() );
		
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>(){
			{put(getTopic(),new Integer(1));}
		};
	    
		ConsumerConnector consumer = getConsumer();
		
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
		
		List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(getTopic());
	    
	    KafkaStream<byte[], byte[]> stream =  streams.get(0);
	    
	    ConsumerIterator<byte[], byte[]> it = stream.iterator();
	    
	    while(it.hasNext()){
	    	String message = new String(it.next().message());
	    	
	    	getLogger().info(message);
	    }
	}

}
