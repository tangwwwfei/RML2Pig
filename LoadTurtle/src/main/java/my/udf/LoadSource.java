package my.udf;

import java.io.*;
import java.net.URL;
import com.alibaba.fastjson.JSON;
import com.google.common.io.CharSource;
import javafx.scene.text.TextFlow;
import loadfunc.EDInputFormat;
import org.apache.commons.io.input.ReaderInputStream;
import org.apache.commons.io.output.StringBuilderWriter;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.Text;
import org.apache.pig.parser.QueryParserUtils;
import org.eclipse.rdf4j.query.parser.QueryParserUtil;
import parser.ParseData;
import parser.ParseTutle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.pig.*;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.*;
import org.apache.pig.data.*;
import loadfunc.DataRetrieval;

import static parser.ParseTutle.IsURL;

public class LoadSource extends LoadFunc{

    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    protected RecordReader recordReader = null;
    private DataRetrieval dataRetrieval;
    public LoadSource(String parameters) {

        dataRetrieval = JSON.parseObject(parameters, DataRetrieval.class);
    }

    @Override
    public String relativeToAbsolutePath(String location, Path curDir) throws IOException {
        if (dataRetrieval.getName().isEmpty()) {
            return location;
        }
        return getAbsolutePath(dataRetrieval.getName(), curDir);
    }

    @Override
    public void setLocation(String location, Job job) throws IOException {
        if (IsURL(location)) {
            URL url = new URL(location);
            location = url.getFile().substring(1);
        }
        FileInputFormat.setInputPaths(job, location);
    }

    @Override
    public InputFormat getInputFormat() throws IOException {
        //dataRetrieval.setName(getAbsolutePath(dataRetrieval.getName(), curDir));
        return new EDInputFormat(dataRetrieval);
    }

    @Override
    public void prepareToRead(RecordReader recordReader, PigSplit pigSplit) throws IOException {
        this.recordReader = recordReader;
    }

    @Override
    public Tuple getNext() throws IOException {
        try {
            //将bag放入tuple中即可
            boolean flag = recordReader.nextKeyValue();
            if (!flag) {
                return null;
            }
            //String type = datatype;
            //CharSource.wrap(sb.toString()).openStream()
            //while(flag) {
            Text value = (Text)recordReader.getCurrentValue();
            flag = recordReader.nextKeyValue();
            //}

            Tuple ret = TupleFactory.getInstance().newTuple(value.toString());
            return ret;
        } catch (Exception e) {
            throw new ExecException("Read data error", PigException.REMOTE_ENVIRONMENT, e);
        }
    }

}