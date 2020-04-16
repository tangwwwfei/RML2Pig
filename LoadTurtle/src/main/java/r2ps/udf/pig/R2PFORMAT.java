package r2ps.udf.pig;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.github.jsonldjava.utils.Obj;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.impl.util.Pair;
import org.eclipse.rdf4j.query.algebra.Str;
import org.mapdb.Atomic;
import r2ps.loadfunc.DataRetrieval;
import r2ps.parser.ParseTutle;

import static r2ps.parser.ParseData.transformDatatypeString;
import static r2ps.parser.ParseTutle.*;

public class R2PFORMAT extends EvalFunc<String> {
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());
    enum SMType{
        Default,
        Template,
        Reference,
        Constant
    }
    @SneakyThrows
    @Override
    public String exec(Tuple input)
            throws IOException {
        if (input.size() < 2) {
            log.warn("parameters minimum 2.");
            return null;
        }

        boolean bIRI = false;
        SMType type = SMType.Default;
        String fmt = (String)input.get(0);
        if (fmt.startsWith("<") && fmt.endsWith(">")) {
            fmt = fmt.substring(1, fmt.length()-1);
            bIRI = true;
            type = SMType.Template;
        }
        if (input.get(1) == null){
            return null;
        }
        if (!fmt.contains("%")) {
           fmt=fmt.replaceAll("\\{[^\\{\\}]+\\}", "%s");
           if (!fmt.contains("%s")) {
               //It is a reference value in subject map
               fmt = "%s";
               type = SMType.Reference;
               bIRI = true;
           }
        }

        List<String> args = new ArrayList<>();
        for (int seqArg = 1; seqArg < input.size(); ++seqArg) {
            Tuple t = (Tuple)input.get(seqArg);
            for (int i = 0; i < t.size(); ++i) {
                Tuple pair = (Tuple)t.get(i);
                String first = (String) pair.get(0);
                String second = (String) pair.get(1);
                String s = R2PDecode(first);
                if (s.isEmpty()) {
                    continue;
                }
                if (!bIRI) {
                    if (second.equals(DataRetrieval.RMLType.LITERAL.getType())) {
                        s = s.replaceAll("\"", "\\\\\"");
                    }
                    else{
                        if (fmt.startsWith("_:")) {
                            if (second.equals(DataRetrieval.RMLType.DOUBLE.getType())
                                || second.equals(DataRetrieval.RMLType.DECIMAL.getType())) {
                                s = String.valueOf((int)Double.parseDouble(first));
                            }
                        }
                        else{
                            fmt += "^^xsd:" + second;
                            s = transformDatatypeString(first, second);
                        }
                    }
                } else {
                    if (type == SMType.Template) {
                        if (IsURI(fmt)) {
                            s = IRIEncode(s);
                        } else {
                            s = "http://example.com/base/" + IRIEncode(s);
                        }
                    } else if (type == SMType.Reference) {
                        if (!IsURI(s)) {
                            if (!IsValidIRI(s)) {
                                return null;
                            }
                            s = "http://example.com/base/" + s;//IRIEncode(s);//TC20b
                        }
                    }
                }
                args.add(s);
            }
        }
        if (StringUtils.countMatches(fmt, "%s") != args.size()) {
            return null;
        }

        String str = String.format(fmt, args.toArray());

        if (str.contains("@")) {
            //it has a languageTag
            //Tests a term map with an valid rr:language value
            String lang = str.split("@")[1];
            if (!IsValidLanguageTag(lang)) {
                return null;
            }
        }


        if (bIRI) {
            str = "<" + str + ">";
        }
        return str;
    }
}