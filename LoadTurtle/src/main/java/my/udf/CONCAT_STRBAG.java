package my.udf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import parser.ParseTutle;

import java.util.Iterator;

public class CONCAT_STRBAG extends EvalFunc<DataBag> {
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    @Override
    public DataBag exec(Tuple input) {
        if (input.size() < 2) {
            LOG.warn("CONCAT_STRBAG: need 2 parameters.");
            return null;
        }
        try {
            String str = (String)input.get(0);
            DataBag bag = (DataBag)input.get(1);
            Iterator itr= bag.iterator();
            while(itr.hasNext()) {
                Tuple t = (Tuple)itr.next();
                for (int i = 0; i < t.size(); ++i) {
                    String val = str + t.get(i);
                    t.set(i, val);
                }
            }
            return bag;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
