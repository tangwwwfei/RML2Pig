package r2ps.udf.pig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.EvalFunc;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import r2ps.parser.ParseTutle;

public class R2PTOTUPLE extends EvalFunc<Tuple> {
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    @Override
    public Tuple exec(Tuple input) {
        Tuple tuple = TupleFactory.getInstance().newTuple();
        try {
            for (int i = 0; i < input.size(); ++i) {
                tuple.append(input.get(i));
            }
        } catch (ExecException e) {
            e.printStackTrace();
        }
        return tuple;
    }
}