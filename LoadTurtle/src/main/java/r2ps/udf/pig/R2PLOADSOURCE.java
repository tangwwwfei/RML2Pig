package r2ps.udf.pig;

import java.io.*;
import java.net.URL;
import java.util.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.apache.hadoop.io.Text;
import org.apache.jena.datatypes.RDFDatatype;
import org.apache.pig.impl.util.Pair;
import r2ps.parser.ParseTutle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.pig.*;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.backend.hadoop.executionengine.mapReduceLayer.*;
import org.apache.pig.data.*;
import r2ps.loadfunc.DataRetrieval;

import static r2ps.parser.ParseData.Nested2Flatten;

public class R2PLOADSOURCE extends LoadFunc {

    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    protected RecordReader recordReader = null;
    private DataRetrieval dataRetrieval;
    private String loadLocation;
    private List<String[]> arrHeader = new ArrayList<>();

    public R2PLOADSOURCE(String parameters) {
        //LOG.info("LoadSource");
        dataRetrieval = JSON.parseObject(parameters, DataRetrieval.class);
    }

    public R2PLOADSOURCE(String parameters, String paths) {
        //LOG.info("LoadSource 2 args");
        try {
            JSONArray arr = (JSONArray) JSON.parse(paths);
            dataRetrieval = JSON.parseObject(parameters, DataRetrieval.class);
            dataRetrieval.setJsonArray(arr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String relativeToAbsolutePath(String location, Path curDir) throws IOException {

        String outpath = Long.toString(Calendar.getInstance().getTimeInMillis());
        LOG.info("relativeToAbsolutePath outpath:" + outpath);
        String absPath = getAbsolutePath(outpath, curDir);
        LOG.info("relativeToAbsolutePath absPath:" + absPath);
        dataRetrieval.setOutPath(absPath);
        Nested2Flatten(dataRetrieval);
        return absPath;
    }

    @Override
    public void setLocation(String location, Job job) throws IOException {
        loadLocation = location;
        FileInputFormat.setInputPaths(job, location);
    }

    @Override
    public InputFormat getInputFormat() {
        return new PigTextInputFormat();
    }

    @Override
    public void prepareToRead(RecordReader recordReader, PigSplit pigSplit) throws IOException {
        this.recordReader = recordReader;
        try {
            if (recordReader.nextKeyValue()) {
                Text header = (Text) recordReader.getCurrentValue();
                String[] cols = header.toString().split("\\|");
                for (String col : cols) {
                    arrHeader.add(col.split(","));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Tuple getNext() throws IOException {
        ArrayList<Object> lstObj = new ArrayList<Object>();
        try {

            if (!recordReader.nextKeyValue()) {
                return null;
            }
            Text value = (Text) recordReader.getCurrentValue();
            String line = value.toString();

            String[] fields = line.split("\\|");
            for (int i =0; i < fields.length;++i) {
                String field = fields[i];
                String[] header = arrHeader.get(i);
                String[] inCols = field.split(",");
                List<Object> ll = new ArrayList<>();
                for(int j =0; j < inCols.length; ++j) {
                    if (header[j].equals(DataRetrieval.RMLType.LITERAL.getType())) {
                        ll.add(inCols[j]);
                    }
                    else {
                        Tuple pair = TupleFactory.getInstance().newTuple(2);
                        pair.set(0, inCols[j]); //value
                        pair.set(1, header[j]); //datatype
                        ll.add(pair);
                    }
                }
                lstObj.add(TupleFactory.getInstance().newTupleNoCopy(ll));
            }
            Tuple ret = TupleFactory.getInstance().newTupleNoCopy(lstObj);
            return ret;
        } catch (Exception e) {
            LOG.error("getNext - Read data error");
            throw new ExecException("Read data error", PigException.REMOTE_ENVIRONMENT, e);
        }
    }

}