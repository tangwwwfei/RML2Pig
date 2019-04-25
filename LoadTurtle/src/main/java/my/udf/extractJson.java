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

import static parser.ParseTutle.*;

public class extractJson extends EvalFunc<DataBag> {
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    @Override
    public DataBag exec(Tuple input) throws IOException
    {
        if (input.size() <= extract.extractParameter.Parameters.ordinal()) {
            log.warn("extractJson parameters minimum 4.");
            return null;
        }
        String iterator = (String)input.get(extract.extractParameter.Iterator.ordinal());
        if (!iterator.endsWith(".")) {
            iterator = iterator + ".";
        }
        Tuple resultFormat = TupleFactory.getInstance().newTuple();
        LinkedHashSet<String> pathes = new LinkedHashSet<String>();
        for (int i = extract.extractParameter.Parameters.ordinal(); i < input.size(); ++i) {
            List<String> ps = ParseTutle.toStringList(input.get(i));
            ps = ParseTutle.extractValueFromTemplate(ps);
            for (int j = 0; j < ps.size(); ++j){
                String path = ps.get(j);
                if (!path.startsWith("$")) {
                    path = iterator + path;
                    ps.set(j, path);
                }
                else{
                    path = FixJsonpath(path);
                    ps.set(j, path);
                }
            }
            resultFormat.append(TupleFactory.getInstance().newTuple(ps));
            pathes.addAll(ps);
        }

        return new ParseData().ParseData((String)input.get(extract.extractParameter.Data.ordinal()), ParseData.SourceType.JSON, new ArrayList<String>(pathes), resultFormat);
        /*
        try {
            boolean withQuotes = false;
            withQuotes = (Boolean) input.get(0);
            String appendString = "";
            appendString = (String) input.get(1);


            List<String> jsonpathes = new ArrayList<String>();
            String json = (String)input.get(2);
            for (int i = 3; i < input.size(); ++i) {
                jsonpathes.add((String)input.get(i));
            }
            String prefix = GetSameString(jsonpathes);
            Object obj = JsonPath.read(json, FixJsonpath(prefix));
            List<Object> lstobj = new ArrayList<Object>();
            if (obj instanceof JSONArray) {
                lstobj = (List<Object>) obj;
            }else if (obj instanceof ArrayList){
                lstobj = (List<Object>)obj;
            } else {
                lstobj.add(obj);
            }

            DataBag bag = BagFactory.getInstance().newDistinctBag();
            if (input.size() <= 4) {
                for (Object st : lstobj) {
                    bag.add(TupleFactory.getInstance().newTuple(st));
                }
            }
            else{
                if (jsonpathes.get(0).equals(prefix)) {
                    for (Object o : lstobj) {
                        Tuple tup = TupleFactory.getInstance().newTuple();
                        tup.append(o);
                        tup.append(o);
                        bag.add(tup);
                    }
                }
                else {
                    for (Object sec : lstobj) {
                        Tuple tup = TupleFactory.getInstance().newTuple();
                        for (String jsonpath : jsonpathes) {

                            Object vals = null;
                            jsonpath = jsonpath.replaceAll(makeString2RegExp(prefix), "");
                            vals = JsonPath.read(sec, jsonpath);

                            List<String> lstval = new ArrayList<String>();
                            if (vals instanceof JSONArray) {
                                lstval = (List<String>) vals;
                            } else if (vals instanceof ArrayList) {
                                lstval = (List<String>) vals;
                            } else {
                                lstval.add((String) vals);
                            }
                            tup.append(lstval.get(0));
                        }
                        bag.add(tup);
                    }
                }
            }
            Iterator<Tuple> itr = bag.iterator();
            while(itr.hasNext()) {
                Tuple t = itr.next();
                for (int i = 0; i < t.size(); ++i) {
                    String s = (String)t.get(i);
                    s = s.trim();
                    if (withQuotes) {
                        s = "\"" + s + "\"";
                    }
                    if (!appendString.isEmpty()) {
                        s = s + "^^" + appendString;
                    }
                    t.set(i, s);
                }
            }

            return bag;

        } catch (ExecException e) {
            e.printStackTrace();
        }
        return null;*/
    }
}