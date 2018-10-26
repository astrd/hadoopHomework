package stubs;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LogMonthMapper extends Mapper<LongWritable, Text, Text, Text> {

  /**
   * Example input line:
   * 96.7.4.14 - - [24/Apr/2011:04:20:11 -0400] "GET /cat.jpg HTTP/1.1" 200 12433
   *
   */
	public static List<String> months = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {
	  String[] line = value.toString().split(" ");
	    
	 if (line.length>3)
	 {
		 String ip = line[0];
		 String[] date = line[3].split("/");
		 if(date.length > 1)
		 {
		        String theMonth = date[1];
		        
		        /* check if it's a valid month, if so, write it out */
		        if (months.contains(theMonth))
		        	context.write(new Text(ip), new Text(theMonth));

		 }
			 
		 
	 }
	 
    
	  /* TODO: implement */
	  
  }
}
