package com.howbuy.com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 移动�?pv kafka消费�?
 * @author yichao.song
 *
 */
public class H5PVConsumerTask extends BaseConsumer {
	
	private Logger apppvlog = LoggerFactory.getLogger("h5_pv");
	
	private static final String GROUP = "group_h5pv";

	@Override
	protected String getGroup() {
		
		return GROUP;
	}

	@Override
	protected String getTopic() {
		
		return getH5PvTopic();
	}

	@Override
	protected Logger getLogger() {
		
		return apppvlog;
	}

}
