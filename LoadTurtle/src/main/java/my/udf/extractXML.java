package my.udf;

import java.io.IOException;
import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import parser.ParseData;
import parser.ParseTutle;

import static parser.ParseTutle.FixXMLpath;

/*
* 3个参数
* (1) --- content--String
* (2) --- iterator -- String
* (3)..(n) -- target
* */
public class extractXML extends EvalFunc<DataBag> {
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    @Override
    public DataBag exec(Tuple input)
            throws IOException {
        if (input.size() <= extract.extractParameter.Parameters.ordinal()) {
            log.warn("extractXML parameters minimum 4.");
            return null;
        }
        String iterator = (String)input.get(extract.extractParameter.Iterator.ordinal());
        if (!iterator.endsWith("/")) {
            iterator = iterator + "/";
        }
        Tuple resultFormat = TupleFactory.getInstance().newTuple();
        LinkedHashSet<String> pathes = new LinkedHashSet<String>();
        for (int i = extract.extractParameter.Parameters.ordinal(); i < input.size(); ++i) {
            List<String> ps = ParseTutle.toStringList(input.get(i));
            ps = ParseTutle.extractValueFromTemplate(ps);
            for (int j = 0; j < ps.size(); ++j){
                String path = ps.get(j);
                if (!path.startsWith("/")) {
                    path = iterator + path;
                    ps.set(j, path);
                }
                else{
                    path = FixXMLpath(path);
                    ps.set(j, path);
                }
            }
            resultFormat.append(TupleFactory.getInstance().newTuple(ps));
            pathes.addAll(ps);
        }

        //iterator
        return new ParseData().ParseData((String)input.get(extract.extractParameter.Data.ordinal()), ParseData.SourceType.XML, new ArrayList<String>(pathes), resultFormat);
       /* XPathAll xpath = new XPathAll();
        //Now only two parameters accept
        ///transport/bus@id
        //transport/bus/route/stop/@id
        DataBag bag = BagFactory.getInstance().newDistinctBag();
        boolean isDuplicate = false;
        boolean isSwap = false;
        if (input.size() > 4) {
            String shortPath = ParseTutle.FixXMLpath((String)input.get(3));
            String longPath = ParseTutle.FixXMLpath((String)input.get(4));
            if (!shortPath.equals(longPath)) {
                if (shortPath.split("/").length > longPath.split("/").length) {
                    String str = shortPath;
                    shortPath = longPath;
                    longPath = str;
                    isSwap = true;
                }
                in.set(1, shortPath);
                Tuple t = xpath.exec(in);
                for (int i = 0; i < t.size(); ++i) {
                    String sp = shortPath;
                    String lp = longPath;
                    String samePrefix = ParseTutle.GetSameString(sp, lp);
                    String id = (String) t.get(i);
                    sp = sp.replaceAll("/(@.*)", "[$1=\"" + id + "\"]/");
                    lp = lp.replaceAll(ParseTutle.makeString2RegExp(samePrefix), sp);
                    in.set(1, lp);
                    Tuple t2 = xpath.exec(in);

                    for (int j = 0; j < t2.size(); ++j) {
                        Tuple line = TupleFactory.getInstance().newTuple();
                        if (isSwap) {
                            line.append(t2.get(j));
                            line.append(t.get(i));
                        }
                        else {
                            line.append(t.get(i));
                            line.append(t2.get(j));
                        }
                        bag.add(line);
                    }
                }
                return bag;
            }
            isDuplicate = true;
        }
        Tuple t = xpath.exec(in);
        for (int i = 0; i < t.size(); ++i) {
            String s = t.get(i).toString().trim();
            if (withQuotes) {
                s = "\"" + s + "\"";
            }
            if (!appendString.isEmpty()) {
                s = s + "^^" + appendString;
            }
            Tuple nt = TupleFactory.getInstance().newTuple();
            nt.append(s);
            if (isDuplicate) {
                nt.append(s);
            }
            bag.add(nt);
        }
        return bag;*/
    }
}