package my.udf;

import be.ugent.mmlab.fno.java.ConcreteFunctionProcessor;
import be.ugent.mmlab.rml.vocabularies.FnVocabulary;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.BagFactory;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static parser.ParseTutle.Tuple2String;

public class execFunction extends EvalFunc<DataBag> {
    enum Parameter {
        Name,
        Value
    }
    private ConcreteFunctionProcessor fnProcessor = ConcreteFunctionProcessor.getInstance();
    @Override
    public DataBag exec(Tuple tuple) throws IOException {
        //tuple consists of serveral Tuples
        String functionName = "";
        Map<String, Object> parameters = new HashMap<String, Object>();
        Object executes = "fno:" + FnVocabulary.FnTerm.EXECUTES;
        for (int i = 0; i < tuple.size(); ++i) {
            Tuple parameter = (Tuple)tuple.get(i);
            String name = (String)parameter.get(Parameter.Name.ordinal());
            Object obj = parameter.get(Parameter.Value.ordinal());
            String value = "";
            if (obj instanceof String) {
                value = (String)obj;
            }
            else {
                value = Tuple2String((Tuple)obj, ",");
            }
            if (name.equals(executes)) {
                functionName = value;
            }
            else{
                parameters.put(name, value);
            }
        }
        DataBag bag = BagFactory.getInstance().newDistinctBag();
        List<Value> results = fnProcessor.processFunction(functionName, parameters);
        for (Value result : results) {
            bag.add(TupleFactory.getInstance().newTuple(result.stringValue()));
        }
        return bag;
    }
}
