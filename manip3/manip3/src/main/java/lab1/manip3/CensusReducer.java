package lab1.manip3;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class CensusReducer extends Reducer<Text, NumPair, Text, Text> {

    public void reduce(Text key, Iterable<NumPair> values, Context context) throws IOException, InterruptedException {
        int sum = 0, count = 0;
        for (NumPair value : values) {
            sum += value.getSum();
            count += value.getCount();
        }
        double average = (double) sum / count;
        context.write(key, new Text("Moyenne: " + average));
    }
}
