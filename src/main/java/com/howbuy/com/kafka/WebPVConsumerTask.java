package com.howbuy.com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebPVConsumerTask extends BaseConsumer {
	
	private static Logger webpvlog = LoggerFactory.getLogger("web_pv");
	
	private static final String GROUP = "group_webpv";
	

	@Override
	protected String getGroup() {
		return GROUP;
	}


	@Override
	protected String getTopic() {
		
		return getWebpvTopic();
	}


	@Override
	protected Logger getLogger() {
		
		return webpvlog;
	}
	
	public static void main(String[] args) {
//		new Thread(new WebPVConsumerTask()).start();
		new WebPVConsumerTask().run();
	}

}
