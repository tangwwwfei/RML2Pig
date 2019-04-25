package my.udf;

import org.apache.pig.EvalFunc;
import org.apache.pig.builtin.OutputSchema;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.logicalLayer.schema.Schema;
import org.apache.pig.impl.util.Utils;
import org.apache.pig.parser.ParserException;

import java.io.IOException;
import java.lang.reflect.Type;

/*
* accept 3 parameters
* $1---condition
* $2---bag
* $3---bag
* return if $1 > 0 then $2 else $3 endif;
* */
public class Fallback extends EvalFunc<DataBag> {

    @Override
    public DataBag exec(Tuple tuple) throws IOException {

        Long cnt = (Long) tuple.get(0);
        if (cnt > 0) {
            return (DataBag) tuple.get(1);
        }
        else{
            return (DataBag) tuple.get(2);
        }
    }
}
