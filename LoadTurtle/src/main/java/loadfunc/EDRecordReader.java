package loadfunc;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.RecordReader;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import parser.ParseData;

import java.io.IOException;

public class EDRecordReader extends org.apache.hadoop.mapreduce.RecordReader<LongWritable, Text> {
    private DataRetrieval dataRetrieval;
    private boolean isRead = true;
    public EDRecordReader(DataRetrieval dataRetrieval) {
        this.dataRetrieval = dataRetrieval;
    }
    @Override
    public void close() throws IOException {

    }

    @Override
    public void initialize(InputSplit inputSplit, TaskAttemptContext taskAttemptContext) throws IOException, InterruptedException {

    }

    @Override
    public boolean nextKeyValue() throws IOException, InterruptedException {
        return isRead;
    }

    @Override
    public LongWritable getCurrentKey() throws IOException, InterruptedException {
        return null;
    }

    @Override
    public Text getCurrentValue() throws IOException, InterruptedException {
        isRead = false;
        Text text = new Text(ParseData.LoadData(dataRetrieval));
        return text;
    }

    @Override
    public float getProgress() throws IOException {
        return 0;
    }
}
