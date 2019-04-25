package parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.commons.lang.StringUtils;
import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;
import org.apache.tools.ant.types.Assertions;
import org.junit.Assert;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseTutle {



    public static boolean IsURL(String str) {
        if (str.startsWith("http:") || str.startsWith("https:")) {
            return true;
        }
        return false;
    }

    public static String ReadFileFromLocal(String filePath)
    {
        String content = "";
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));
            byte[] b = new byte[bis.available()];
            bis.read(b);
            content = new String(b);
            return content;
        } catch (Exception e) {
            //LOG.error("File not found.");
            e.printStackTrace();
        }

        return content;
    }

    public static String makeString2RegExp(String str) {
        if(StringUtils.isBlank(str)){
            return str;
        }

        return str.replace("\\", "\\\\").replace("*", "\\*")
                .replace("+", "\\+").replace("|", "\\|")
                .replace("{", "\\{").replace("}", "\\}")
                .replace("(", "\\(").replace(")", "\\)")
                .replace("^", "\\^").replace("$", "\\$")
                .replace("[", "\\[").replace("]", "\\]")
                .replace("?", "\\?").replace(",", "\\,")
                .replace(".", "\\.").replace("&", "\\&");
    }

    public static List<String> FixJsonNames(List<String> names)
    {
        List<String> fixNames = new ArrayList<String>();
        for (String name : names) {

            name = name.replace("$.", "");
            fixNames.add(name);
        }
        return fixNames;
    }

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

    public static String GetSameString(String s1, String s2) {
        String same = "";
        String ss1[] = s1.split("\\\\|\\/|\\.");
        String ss2[] = s2.split("\\\\|\\/|\\.");
        int size = ss1.length < ss2.length ? ss1.length : ss2.length;
        int i = 0;
        int count = 0;
        for (i = 0; i < size; ++i) {
            if (!ss1[i].equals(ss2[i])) {
                break;
            }
            count += ss1[i].length() + 1;
        }
        if (count > s1.length() || count > s2.length()) --count;
        same = s1.substring(0, count);
        return same;
    }

    public static String GetSameString(List<String> lstStr)
    {
        assert lstStr != null;
        assert lstStr.size() != 0;
        String same = lstStr.get(0);
        for (int i = 1; i < lstStr.size(); ++i) {
            same = GetSameString(same, lstStr.get(i));
        }
        return same;
    }

    public static String CSV2JSON(String csv) throws Exception {

        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();

        // Read data from CSV file
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(csv).readAll();

        ObjectMapper mapper = new ObjectMapper();

        // Write JSON formated data to output.json file

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(readAll);

        return json;
    }

    //DataBag
    //String
    public static List<String> toStringList(Object obj) {
        List<String> lst = new ArrayList<String>();
        try {
            if (obj instanceof DataBag) {
                DataBag bag = (DataBag) obj;
                Iterator itr = bag.iterator();
                int i = 0;
                while (itr.hasNext()) {
                    Tuple t = (Tuple) itr.next();
                    if (t.size() > 0) {
                        lst.add((String) t.get(0));
                    }
                }
            } else if (obj instanceof Tuple) {
                Tuple t = (Tuple) obj;
                for (int i = 0; i < t.size(); ++i) {
                    lst.add((String) t.get(i));
                }
            } else if (obj instanceof String) {
                lst.add((String) obj);
            }
        }
        catch (ExecException e) {
            e.printStackTrace();
        }
        return lst;
    }

    public static String CSVArgs2JSONArgs(String arg) {
        return "$[*]." + arg;
    }

    public static List<String> extractValueFromTemplate(List<String> lst) {
        List<String> ret = new ArrayList<String>();
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
        List<String> ret = new ArrayList<String>();
        Pattern pattern = Pattern.compile("\\{(.*?)\\}");
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
        String res = (String)tuple.get(0);
        for (int i = 1; i < tuple.size(); ++i) {
            res += split + (String)tuple.get(i);
        }
        return res;
    }
}
