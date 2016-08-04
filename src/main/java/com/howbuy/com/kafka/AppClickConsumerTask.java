package com.howbuy.com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 移动端 点击事件 kafka消费者
 * @author yichao.song
 *
 */
public class AppClickConsumerTask extends BaseConsumer {
	
	private Logger appclicklog = LoggerFactory.getLogger("app_click");
	
	private static final String GROUP = "group_appclick";

	@Override
	protected String getGroup() {
		
		return GROUP;
	}

	@Override
	protected String getTopic() {
		
		return getAppclickTopic();
	}

	@Override
	protected Logger getLogger() {
		
		return appclicklog;
	}

}
