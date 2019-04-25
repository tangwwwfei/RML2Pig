package my.udf;
import be.ugent.mmlab.rml.processor.StdConditionProcessor;
import org.apache.pig.FilterFunc;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.xpath.operations.Bool;

import java.io.IOException;
import java.util.Iterator;
import java.util.regex.Pattern;

import static parser.ParseTutle.Tuple2String;

public class equalCondition extends FilterFunc {
    enum Parameter{
        Binding,
        Condition
    }
    enum Binding{
        Reference,
        Variable,
    }

    @Override
    public Boolean exec(Tuple tuple) throws IOException {
        //tuple(bag{},'String')
        //where bag{tuple(binding),tuple(binding),...,tuple(binding)}
        DataBag bindings = (DataBag) tuple.get(Parameter.Binding.ordinal());
        String condition = (String)tuple.get(Parameter.Condition.ordinal());
        String expression = condition;
        Iterator<Tuple> itr = bindings.iterator();
        while(itr.hasNext()) {
            Tuple binding = itr.next();
            Tuple refs = (Tuple)binding.get(Binding.Reference.ordinal());
            String var = (String)binding.get(Binding.Variable.ordinal());

            for (int i = 0; i < refs.size(); ++i) {
                Object obj = refs.get(i);
                String ref = "";
                if (obj instanceof Tuple) {
                    ref = Tuple2String((Tuple)obj, ",");
                }
                else{
                    ref = (String)refs.get(i);
                }
                expression = expression.replaceAll("%%"+ Pattern.quote(var)+"%%", ref);
            }
        }

        //may have one or serveral binding

        return ProcessExpression(expression, bindings.size());
    }

    public Boolean ProcessExpression(String expression, long varsCount) {
        Boolean result = false;
        StdConditionProcessor processor = new StdConditionProcessor();
        if (expression.contains("!match")) {
            result = processor.processNotMatch(expression);
        } else if (expression.contains("match")) {
            result = processor.processMatch(expression);
        } else if (expression.contains("!contain")) {
            result = processor.processNotContains(expression);
        } else if (expression.contains("contain")) {
            result = processor.processContains(expression);
        } else if (expression.contains("!length")) {
            result = processor.processNotLength(expression);
        } else if (expression.contains("!hasField")) {
            return varsCount == 0;
        } else if (expression.contains("hasField")) {
            if (varsCount == 0)
                return false;
            else
                return true;
        }
        return result;
    }
}
