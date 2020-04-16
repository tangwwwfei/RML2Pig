package r2ps.udf.scala;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.pig.data.BagFactory;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import r2ps.loadfunc.DataRetrieval;
import r2ps.udf.pig.R2PFORMAT;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import static r2ps.parser.ParseData.Nested2Flatten;

public class ScalaUDF {
    static public String R2PLOADSOURCE(String parameters, String paths) {
        JSONArray arr = (JSONArray) JSON.parse(paths);
        DataRetrieval dataRetrieval = JSON.parseObject(parameters, DataRetrieval.class);
        dataRetrieval.setJsonArray(arr);
        String outpath = Long.toString(Calendar.getInstance().getTimeInMillis());
        dataRetrieval.setOutPath(outpath);
        Nested2Flatten(dataRetrieval);
        return outpath;
    }

    static public String R2PFORMAT(Object fmt, Object arg) throws IOException {
        Tuple t = TupleFactory.getInstance().newTuple();
        t.append(fmt);
        t.append(arg);
        return new R2PFORMAT().exec(t);
    }

    static public Tuple R2PTOTUPLE(Object... args) {
        Tuple t = TupleFactory.getInstance().newTuple(Arrays.asList(args));
        return t;
    }

    static public DataBag R2PTOBAG(Tuple... args) {
        DataBag bag = BagFactory.getInstance().newDefaultBag(Arrays.asList(args));
        return bag;
    }
}
