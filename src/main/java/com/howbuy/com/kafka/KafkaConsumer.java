package com.howbuy.com.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class KafkaConsumer {
	
	private static Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
//	ExecutorService webpvExec = Executors.newFixedThreadPool(1);
//	
//	ExecutorService webeventExec = Executors.newFixedThreadPool(1);
//	
//	ExecutorService webclickExec = Executors.newFixedThreadPool(1);
//	
//	ExecutorService apppvExec = Executors.newFixedThreadPool(1);
//	
//	ExecutorService appeventExec = Executors.newFixedThreadPool(1);
//	
//	ExecutorService appclickExec = Executors.newFixedThreadPool(1);
//	
//	ExecutorService appactivateExec = Executors.newFixedThreadPool(1);
	
	public static void init() throws InterruptedException{
		
		logger.info("starting kafka consume");
		
		new Thread(new WebClickConsumerTask(),"web_click").start();
		
		new Thread(new WebPVConsumerTask(),"web_pv").start();
		
		new Thread(new WebEventConsumerTask(),"web_event").start();
		
		new Thread(new AppPVConsumerTask(),"app_pv").start();
		
		new Thread(new AppEventConsumerTask(),"app_event").start();
		
//		new Thread(new AppClickConsumerTask(),"app_click").start();
//		
		new Thread(new AppActivationConsumerTask(),"app_activation").start();
		
		new Thread(new H5PVConsumerTask(),"h5_pv").start();
		
	}
	
	public void destroy(){
		
		logger.info("destroy kafka consumer...........");
		
//		webpvExec.shutdown();
//		
//		webclickExec.shutdown();
//		
//		webeventExec.shutdown();
//		
//		logger.info("destroy kafka consumer finished.......");
	}
	
	public static void main(String[] args) {
		try {
			init();
		} catch (InterruptedException e) {
			logger.error("",e);
		}
	}

}
