package com.hadoop.mapreduce;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

import com.hadoop.mapper.Map;
import com.hadoop.reducer.Reduce;

public class WordCount {
	
	public static void main(String[] args) throws Exception {
		 	     JobConf conf = new JobConf(WordCount.class);
		 	     conf.setJobName("wordcount");
		 	
		 	     conf.setOutputKeyClass(Text.class);
		 	     conf.setOutputValueClass(IntWritable.class);
		 	
		 	     conf.setMapperClass(Map.class);
		 	     conf.setCombinerClass(Reduce.class);
		 	     conf.setReducerClass(Reduce.class);
		 	     

		 	     conf.setInputFormat(TextInputFormat.class);
		 	     conf.setOutputFormat(TextOutputFormat.class);
		 	     //hdfs://localhost:9000/test/abc.txt
		 	     FileInputFormat.setInputPaths(conf, new Path("textfile.txt"));
	    	     FileOutputFormat.setOutputPath(conf, new Path("output"));
			
		 	     JobClient.runJob(conf);
		 	   }
		 	}

