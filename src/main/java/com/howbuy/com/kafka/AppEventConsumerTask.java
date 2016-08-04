package com.howbuy.com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * 移动端事件kafka消费者
 */
public class AppEventConsumerTask extends BaseConsumer {
	
	private Logger appeventlog = LoggerFactory.getLogger("app_event");
	
	private static final String GROUP = "group_appevent";

	@Override
	protected String getGroup() {
		
		return GROUP;
	}

	@Override
	protected String getTopic() {
		
		return getAppeventTopic();
	}

	@Override
	protected Logger getLogger() {
		
		return appeventlog;
	}

}
