package loadfunc;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.TaskAttemptContext;

import java.io.IOException;
import java.util.List;

public class EDInputFormat extends org.apache.hadoop.mapreduce.lib.input.FileInputFormat<LongWritable, Text> {
    private DataRetrieval dataRetrieval;
    public EDInputFormat(DataRetrieval dataRetrieval) {
        this.dataRetrieval = dataRetrieval;
    }

    @Override
    public org.apache.hadoop.mapreduce.RecordReader<LongWritable, Text> createRecordReader(InputSplit split, TaskAttemptContext context) {
        return new EDRecordReader(dataRetrieval);
    }

    @Override
    public List<InputSplit> getSplits(JobContext job) throws IOException {
        //job.getConfiguration();
        return super.getSplits(job);
    }
}
