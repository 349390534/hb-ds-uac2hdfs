package com.howbuy.com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 移动端 pv kafka消费者
 * @author yichao.song
 *
 */
public class AppPVConsumerTask extends BaseConsumer {
	
	private Logger apppvlog = LoggerFactory.getLogger("app_pv");
	
	private static final String GROUP = "group_apppv";

	@Override
	protected String getGroup() {
		
		return GROUP;
	}

	@Override
	protected String getTopic() {
		
		return getApppvTopic();
	}

	@Override
	protected Logger getLogger() {
		
		return apppvlog;
	}

}
