package r2ps.parser;

import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.apache.jena.ext.com.google.common.escape.Escaper;
import org.apache.jena.ext.com.google.common.net.UrlEscapers;
import org.apache.jena.graph.NodeFactory;
import org.apache.jena.iri.IRI;
import org.apache.jena.iri.IRIFactory;
import org.apache.jena.iri.impl.IRIFactoryImpl;
import org.apache.jena.util.URIref;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.Tuple;
import org.eclipse.rdf4j.common.net.ParsedIRI;
import org.eclipse.rdf4j.query.algebra.IRIFunction;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseTutle {

    public static String FixJsonpath(String jsonpath) {
        String str = jsonpath;
        if (jsonpath.endsWith(".")) {
            str = jsonpath.substring(0, jsonpath.length()-1);
        }
        return str;
    }

    public static String GetCommonPrefix(List<String> lst) {
        String[] strs = new String[lst.size()];
        strs = lst.toArray(strs);
        return GetCommonPrefix(strs);
    }

    public static String GetCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public static String FixXMLpath(String xmlpath) {
        String str = xmlpath;
        if (!xmlpath.startsWith("@")) {
            str = xmlpath.replaceAll("([^/\\[])@","$1/@");
        }
        if (xmlpath.endsWith("/")) {
            str = xmlpath.substring(0, xmlpath.length()-1);
        }
        return str;
    }

    public static List<String> extractValueFromTemplate(List<String> lst) {
        List<String> ret = new ArrayList<>();
        for (String template : lst) {
            if (template.contains("{")) {
                ret.addAll(extractValueFromTemplate(template));
            }
            else {
                if (template.contains(",")) {
                    String[] arr = template.split(",");
                    ret.addAll(Arrays.asList(arr));
                }
                else {
                    ret.add(template);
                }
            }
        }
        return ret;
    }

    public static List<String> extractValueFromTemplate(String template) {
        List<String> ret = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{(.*?)}");
        Matcher matcher = pattern.matcher(template);
        while(matcher.find()){
            ret.add(matcher.group(1));
        }
        return ret;
    }

    public static String Tuple2String(Tuple tuple, String split) throws ExecException {
        if (tuple.size() < 1) {
            return "";
        }
        StringBuilder res = new StringBuilder((String) tuple.get(0));
        for (int i = 1; i < tuple.size(); ++i) {
            res.append(split).append((String) tuple.get(i));
        }
        return res.toString();
    }

    public static String R2PEncode(String str){
        return str.replaceAll(",", "%2C");  //For Pig, ',' is the separator
    }

    public static String R2PDecode(String str) {
        return str.replaceAll("%2C", ",");
    }

    public static String IRIEncode(String str) throws URISyntaxException {
        //assert (str.startsWith("<") && str.endsWith(">"));
        String result = IRIFactory.iriImplementation().create(str).toURI().toASCIIString();
        //String result = URIref.encode(str.substring(1, str.length()-1));
        result = result.replaceAll("!", "%21");
        result = result.replaceAll("#", "%23");
        result = result.replaceAll("\\$", "%24");
        result = result.replaceAll("&", "%26");
        result = result.replaceAll("'", "%27");
        result = result.replaceAll("\\(", "%28");
        result = result.replaceAll("\\)", "%29");
        result = result.replaceAll("\\*", "%2A");
        result = result.replaceAll("\\+", "%2B");
        result = result.replaceAll(",", "%2C");
        result = result.replaceAll("/", "%2F");
        result = result.replaceAll(":", "%3A");
        result = result.replaceAll(";", "%3B");
        result = result.replaceAll("=", "%3D");
        result = result.replaceAll("\\?", "%3F");
        result = result.replaceAll("@", "%40");
        result = result.replaceAll("\\[", "%5B");
        result = result.replaceAll("]", "%5D");

        return result;
    }

    public static boolean IsValidLanguageTag(String lang) {
        try {
            LocaleUtils.toLocale(lang);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean IsURI(String uri) {
        String regexUri = "^([a-z][a-z0-9+.-]*):.*";
        return Pattern.matches(regexUri, uri);
    }

    public static boolean IsValidIRI(String iri) {
        try {
            new ParsedIRI(iri);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
