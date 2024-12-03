package lab1.manip3;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class CensusCombiner extends Reducer<Text, NumPair, Text, NumPair> {

    public void reduce(Text key, Iterable<NumPair> values, Context context) throws IOException, InterruptedException {
        int sum = 0, count = 0;
        for (NumPair value : values) {
            sum += value.getSum();
            count += value.getCount();
        }
        context.write(key, new NumPair(sum, count));
    }
}
