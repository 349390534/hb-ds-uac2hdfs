package com.howbuy.com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * web 事件消费（开户，交易，绑卡....)
 * @author yichao.song
 *
 */
public class WebEventConsumerTask extends BaseConsumer {
	
	private static Logger webeventlog = LoggerFactory.getLogger("web_event");
	
	private static final String GROUP = "group_webevent";
	
	
	

	@Override
	protected String getGroup() {
		
		return GROUP;
	}

	@Override
	protected String getTopic() {
		
		return getWebeventTopic();
	}

	@Override
	protected Logger getLogger() {
		
		return webeventlog;
	}

}
