package com.howbuy.com.ext;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HDFS 文件上传
 * @author yichao.song
 *
 */
public class HDFSUploadLogTask implements Runnable {
	
	private Logger logger = LoggerFactory.getLogger(HDFSUploadLogTask.class);

	
	private String srcpath;
	
	private String hdfspath;
	
	private static Configuration conf = new Configuration();
	
	
	@Override
	public void run() {
		
		try {
			
			
			FileSystem hdfs = FileSystem.get(conf);
			
			Path srcp = new Path(srcpath);
			
			Path hdfsp = new Path(hdfspath);
			
			hdfs.copyFromLocalFile(srcp, hdfsp);
			
			logger.info("srcpath:{},to hdfspath:{} finished",srcpath,hdfspath);
			
		} catch (IOException e) {
			logger.warn("",e);
		}

	}
	
	
	public HDFSUploadLogTask(String srcpath,String topath){
		
		this.srcpath = srcpath;
		this.hdfspath = topath;
		
		logger.info("srcpath:{},to hdfspath:{} start",srcpath,hdfspath);
	}

}
