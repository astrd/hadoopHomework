package stubs;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class CountReducer extends Reducer<Text, Text, Text, IntWritable> {

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
	  int count = 0;
	  for (@SuppressWarnings("unused") Text value : values) {

			/*
			 * for each item in the list, increment the count
			 */
			count++;
		}

		context.write(key, new IntWritable(count));
	
	  /*
	   * TODO: implement
	   */
  }
}
