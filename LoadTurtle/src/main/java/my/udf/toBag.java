package my.udf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.EvalFunc;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.BagFactory;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import parser.ParseTutle;

public class toBag extends EvalFunc<DataBag> {
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    @Override
    public DataBag exec(Tuple input) {
        DataBag bag = BagFactory.getInstance().newDefaultBag();
        try {
            for (int i = 0; i < input.size(); ++i) {
                bag.add(TupleFactory.getInstance().newTuple(input.get(i)));
            }
        } catch (ExecException e) {
            e.printStackTrace();
        }
        return bag;
    }
}