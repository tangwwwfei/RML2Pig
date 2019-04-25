import org.apache.pig.pigunit.PigTest;

public class PigScriptTest {

    @org.junit.Test
    public void testPigScript() throws Exception {

        PigTest pigTest = new PigTest("src/main/Pig/graph.pig");
        //pigTest = new PigTest("src/main/Pig/xml.pig");
        //pigTest = new PigTest("src/main/Pig/json.pig");
        //pigTest = new PigTest("C:\\eclipse-workspace\\RML2Pig\\samples\\output.pig");
        //pigTest = new PigTest("src/main/Pig/json.pig");
        pigTest.runScript();

    }
}