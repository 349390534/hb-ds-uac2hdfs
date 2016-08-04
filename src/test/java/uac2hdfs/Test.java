package uac2hdfs;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;


public class Test {

	public static void main(String[] args) throws IOException {
		
		Configuration conf = new Configuration();
		
//		conf.set("fs.defaultFS", "hdfs://192.168.220.154:9000");
		
		FileSystem hdfs = FileSystem.get(conf);
		
		
		Path srcp = new Path("E:/doc/hadoop-algorithms-master.zip");
		
		Path hdfsp = new Path("/doc1/hadoop-algorithms-master.zip");
		
//		hdfs.mkdirs(hdfsp.getParent());
		
		hdfs.copyFromLocalFile(srcp, hdfsp);
		
	}
}
