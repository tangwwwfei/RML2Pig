package my.udf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import parser.ParseTutle;

import java.io.IOException;
public class extract extends EvalFunc<DataBag> {
    enum extractParameter{
        Data,
        Formulation,
        Iterator,
        Parameters
    }
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    @Override
    public DataBag exec(Tuple input) throws IOException {
        if (input.size() < 1) {
            return null;
        }
        String formul = (String)input.get(extractParameter.Formulation.ordinal());
        if (formul.equalsIgnoreCase("ql:xpath")) {
            return new extractXML().exec(input);
        }
        else if (formul.equalsIgnoreCase("ql:jsonpath")) {
            return new extractJson().exec(input);
        }
        else{
            //default csv
            return new extractCSV().exec(input);
        }
    }
}