package my.udf;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import parser.ParseData;
import parser.ParseTutle;

import java.io.IOException;
import java.util.*;

public class extractCSV extends EvalFunc<DataBag> {
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    @Override
    public DataBag exec(Tuple input) throws IOException {
        if (input.size() <= extract.extractParameter.Parameters.ordinal()) {
            log.warn("extractCSV parameters minimum 4.");
            return null;
        }
        Tuple resultFormat = TupleFactory.getInstance().newTuple();
        LinkedHashSet<String> pathes = new LinkedHashSet<String>();
        for (int i = extract.extractParameter.Parameters.ordinal(); i < input.size(); ++i) {
            List<String> ps = ParseTutle.toStringList(input.get(i));
            ps = ParseTutle.extractValueFromTemplate(ps);
            resultFormat.append(TupleFactory.getInstance().newTuple(ps));
            pathes.addAll(ps);
        }

        return new ParseData().ParseData((String)input.get(extract.extractParameter.Data.ordinal()), ParseData.SourceType.CSV, new ArrayList<String>(pathes), resultFormat);
    }
}