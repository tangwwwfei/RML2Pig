package my.udf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import parser.ParseTutle;

public class FORMAT extends EvalFunc<String> {
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    @Override
    public String exec(Tuple input)
            throws IOException {
        if (input.size() < 2) {
            log.warn("parameters minimum 2.");
            return null;
        }

        String fmt = (String)input.get(0);
        if (input.get(1) == null){
            return null;
        }
        if (!fmt.contains("%")) {
           fmt=fmt.replaceAll("\\{[^\\{\\}]+\\}", "%s");
        }
        Tuple t = (Tuple)input.get(1);
        List<String> args = new ArrayList<String>();
        for (int i = 0; i < t.size(); ++i) {
            args.add((String) t.get(i));
        };
        String str = String.format(fmt, args.toArray());

        return str;
    }
}