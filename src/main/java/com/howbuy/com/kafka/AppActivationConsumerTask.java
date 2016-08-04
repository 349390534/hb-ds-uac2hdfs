package com.howbuy.com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 移动端 激活事件kafka消费者
 * @author yichao.song
 *
 */

public class AppActivationConsumerTask extends BaseConsumer {
	
	private Logger appactivationlog = LoggerFactory.getLogger("app_activation");
	
	private static final String GROUP = "group_appactivation";

	@Override
	protected String getGroup() {
		
		return GROUP;
	}

	@Override
	protected String getTopic() {
		
		return getAppactivateTopic();
	}

	@Override
	protected Logger getLogger() {
		
		return appactivationlog;
	}

}
