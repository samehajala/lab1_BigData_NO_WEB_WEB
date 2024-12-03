package lab1.manip3;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class CensusMapper extends Mapper<LongWritable, Text, Text, NumPair> {

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String[] fields = value.toString().split(",");
        if (fields.length > 12) {
            String maritalStatus = fields[5].trim();
            int hoursPerWeek = Integer.parseInt(fields[12].trim());
            context.write(new Text(maritalStatus), new NumPair(hoursPerWeek, 1));
        }
    }
}
