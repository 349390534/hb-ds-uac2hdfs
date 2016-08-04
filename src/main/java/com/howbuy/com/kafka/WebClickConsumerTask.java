package com.howbuy.com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebClickConsumerTask extends BaseConsumer {
	
	private Logger webclicklog = LoggerFactory.getLogger("web_click");
	
	private static final String GROUP = "group_webclick";
	

	@Override
	protected String getGroup() {
		
		return GROUP;
	}

	@Override
	protected String getTopic() {
		
		return getWebclickTopic();
	}

	@Override
	protected Logger getLogger() {
		
		return webclicklog;
	}

}
