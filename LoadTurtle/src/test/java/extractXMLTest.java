import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import parser.ParseTutle;
import my.udf.extractXML;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.junit.Test;

import java.io.IOException;

//import static org.apache.pig.parser.

public class extractXMLTest {

    @Test
    public void testExec() throws IOException {
        extractXML xml = new extractXML();
        Tuple input = TupleFactory.getInstance().newTuple();
        String str = ParseTutle.ReadFileFromLocal("transport.xml");
        //String xpath = String.format("/transport/bus[@id=\"%s\"]/route/stop", 25);
        /*String xpath = String.format("/transport/bus[@id=\"%s\"]/@type", 25);
        input.append(false);
        input.append("");
        input.append(str);
        input.append(xpath);
        Tuple res = xml.exec(input);*/

        XmlMapper mapper = new XmlMapper();
        JsonNode sub = mapper.readTree(str);
        JsonNode path = sub.findPath("/transport/bus");
        JsonNode val = sub.findValue("$.bus/@id");
        String test = val.toString();
        System.out.printf(test);
    }
}