package r2ps.udf.pig;

import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pig.EvalFunc;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.Tuple;
import r2ps.loadfunc.DataRetrieval;
import r2ps.parser.ParseTutle;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static r2ps.parser.ParseData.transformDatatypeString;
import static r2ps.parser.ParseTutle.*;

public class R2PFORMAT extends EvalFunc<String> {
    static final Log LOG = LogFactory.getLog(ParseTutle.class.getName());

    @SneakyThrows
    @Override
    //10a
    //10b
    public String exec(Tuple input)
            throws IOException {
        if (input.size() < 2) {
            log.warn("parameters minimum 2.");
            return null;
        }
        if (input.get(1) == null){
            return null;
        }

        try {
            List<String> args = null;
            boolean bIRI = false;
            String fmt = (String) input.get(0);
            if (!fmt.contains("%s")) {
                fmt = fmt.replaceAll("\\{[^\\{\\}]+\\}", "%s");
            }

            if (fmt.startsWith("<") && fmt.endsWith(">")) {
                fmt = fmt.substring(1, fmt.length() - 1);
                bIRI = true;
                if (fmt.contains("%s")) {
                    //IRI - template
                    if (IsURI(fmt)) {
                        args = templateFormatURI(input);
                    }
                    else {
                        args = templateFormatURI2(input);
                    }
                } else {
                    //IRI - reference
                    fmt = "%s";
                    args = referenceFormatURI(input);
                }
            } else {
                if (fmt.startsWith("\"")) {
                    StringBuilder sb = new StringBuilder(fmt);
                    args = referenceFormat(input, sb);
                    fmt = sb.toString();
                } else {
                    args = templateFormat(input, fmt);
                }
            }
            if (args == null || args.isEmpty()) {
                return null;
            }
            if (StringUtils.countMatches(fmt, "%s") != args.size()) {
                return null;
            }

            //String str = String.format(fmt, args.toArray());
            //String str = MessageFormat.format(fmt, args.toArray());
            List<String> fmts = new ArrayList<>();
            fmts.addAll(Arrays.asList(fmt.split("%s")));
            for (int j = fmts.size(); j <= args.size(); ++j) {
                fmts.add("");
            }
            StringBuilder sb = new StringBuilder(fmts.get(0));
            for(int i = 0; i < args.size(); ++i) {
                sb.append(args.get(i));
                sb.append(fmts.get(i+1));
            }

            int idxAt = sb.indexOf("@");
            if (idxAt > 0) {
                //it has a languageTag
                //Tests a term map with an valid rr:language value
                String lang = sb.substring(idxAt+1);
                if (!IsValidLanguageTag(lang)) {
                    return null;
                }
            }

            if (bIRI) {
                return "<" + sb.toString() + ">";
            }
            return sb.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    boolean IsBlankNode(String s) {
        return s.startsWith("_:") ? true : false;
    }

    //"-" / "." / "_" / "~"
    //{firstName} {lastName}
    private List<String> templateFormat(Tuple input, String fmt) throws ExecException {
        List<String> args = new ArrayList<>();
        for (int seqArg = 1; seqArg < input.size(); ++seqArg) {
            Tuple t = (Tuple) input.get(seqArg);
            for (int i = 0; i < t.size(); ++i) {
                Object obj = t.get(i);
                String s = "";
                String second = DataRetrieval.RMLType.LITERAL.getType();
                if (obj instanceof Tuple) {
                    Tuple tp = (Tuple) obj;
                    s = (String) tp.get(0);
                    second = (String) tp.get(1);
                }
                else{
                    s = (String) t.get(i);
                }
                if (s.isEmpty()) {
                    continue;
                }
                s = R2PDecode(s);

                if (IsURI(s)) {
                    //IRI
                    //Do nothing
                } else if (IsBlankNode(fmt)) {
                    //BlankNode
                    if (second.equals(DataRetrieval.RMLType.DOUBLE.getType())
                            || second.equals(DataRetrieval.RMLType.DECIMAL.getType())) {
                        s = String.valueOf((int) Double.parseDouble(s));
                    }
                } else {
                    //Literal
                    //Do nothing
                }
                args.add(s);
            }
        }
        return args;
    }

    //<http://example/{id}>
    private List<String> templateFormatURI(Tuple input) throws ExecException, URISyntaxException {
        List<String> args = new ArrayList<>();
        for (int seqArg = 1; seqArg < input.size(); ++seqArg) {
            Tuple t = (Tuple) input.get(seqArg);
            for (int i = 0; i < t.size(); ++i) {
                Object obj = t.get(i);
                String s = "";
                String second = DataRetrieval.RMLType.LITERAL.getType();
                if (obj instanceof Tuple) {
                    Tuple tp = (Tuple) obj;
                    s = (String) tp.get(0);
                    second = (String) tp.get(1);
                }
                else{
                    s = (String) t.get(i);
                }
                if (s.isEmpty()) {
                    continue;
                }
                s = R2PDecode(s);
                if (IsURI(s)) {
                    //IRI
                    //TODO:
                    s = IRIEncode(s);
                    //s = "http://example.com/base/" + s;
                } else if (IsBlankNode(s)) {
                    //BlankNode
                    //impossible
                    assert (false);
                } else {
                    //Literal
                    s = IRIEncode(s);
                    //s = "http://example.com/base/" + s;
                }
                args.add(s);
            }
        }
        return args;
    }

    //<{FirstName}>
    private List<String> templateFormatURI2(Tuple input) throws ExecException {
        List<String> args = new ArrayList<>();
        for (int seqArg = 1; seqArg < input.size(); ++seqArg) {
            Tuple t = (Tuple) input.get(seqArg);
            for (int i = 0; i < t.size(); ++i) {
                Object obj = t.get(i);
                String s = "";
                String second = DataRetrieval.RMLType.LITERAL.getType();
                if (obj instanceof Tuple) {
                    Tuple tp = (Tuple) obj;
                    s = (String) tp.get(0);
                    second = (String) tp.get(1);
                }
                else{
                    s = (String) t.get(i);
                }
                if (s.isEmpty()) {
                    continue;
                }
                s = R2PDecode(s);
                if (IsURI(s)) {
                    //IRI
                    //TODO:
                    s = IRIEncode(s);
                    s = "http://example.com/base/" + s;
                } else if (IsBlankNode(s)) {
                    //BlankNode
                    //impossible
                    assert (false);
                } else {
                    //Literal
                    s = IRIEncode(s);
                    s = "http://example.com/base/" + s;
                }
                args.add(s);
            }
        }
        return args;
    }

    //<ID>
    private List<String> referenceFormatURI(Tuple input) throws ExecException {
        String fmt = (String)input.get(0);
        List<String> args = new ArrayList<>();
        for (int seqArg = 1; seqArg < input.size(); ++seqArg) {
            Tuple t = (Tuple) input.get(seqArg);
            for (int i = 0; i < t.size(); ++i) {
                Object obj = t.get(i);
                String s = "";
                String second = DataRetrieval.RMLType.LITERAL.getType();
                if (obj instanceof Tuple) {
                    Tuple tp = (Tuple) obj;
                    s = (String) tp.get(0);
                    second = (String) tp.get(1);
                }
                else{
                    s = (String) t.get(i);
                }
                if (s.isEmpty()) {
                    continue;
                }
                s = R2PDecode(s);
                if (IsURI(s)) {
                    //IRI
                    //Do nothing
                } else if (IsBlankNode(s)) {
                    //BlankNode
                    //impossible
                    assert (false);
                } else {
                    //Literal
                    if (!IsValidIRI(s)) {
                        return null;
                    }
                    s = "http://example.com/base/" + s;//IRIEncode(s);//TC20b
                }
                args.add(s);
            }
        }
        return args;
    }

    //A valid reference to a column or an element
    //"id"
    private List<String> referenceFormat(Tuple input, StringBuilder fmt) throws ExecException {
        List<String> args = new ArrayList<>();
        for (int seqArg = 1; seqArg < input.size(); ++seqArg) {
            Tuple t = (Tuple) input.get(seqArg);
            for (int i = 0; i < t.size(); ++i) {
                Object obj = t.get(i);
                String s = "";
                String datatype = DataRetrieval.RMLType.LITERAL.getType();
                if (obj instanceof Tuple) {
                    Tuple tp = (Tuple) obj;
                    s = (String) tp.get(0);
                    datatype = (String) tp.get(1);
                }
                else{
                    s = (String) t.get(i);
                }
                if (s.isEmpty()) {
                    continue;
                }
                s = R2PDecode(s);
                if (IsURI(s)) {
                    //IRI
                    //Do nothing
                } else if (IsBlankNode(s)) {
                    //BlankNode
                    if (datatype.equals(DataRetrieval.RMLType.DOUBLE.getType())
                            || datatype.equals(DataRetrieval.RMLType.DECIMAL.getType())) {
                        s = String.valueOf((int) Double.parseDouble(s));
                    }
                } else {
                    //Literal
                    if (datatype.equals(DataRetrieval.RMLType.LITERAL.getType())) {
                        s = StringUtils.replace(s, "\"", "\\\"");
                    }
                    else{
                        fmt.append("^^xsd:" + datatype);
                        s = transformDatatypeString(s, datatype);
                    }
                }
                args.add(s);
            }
        }
        return args;
    }
}