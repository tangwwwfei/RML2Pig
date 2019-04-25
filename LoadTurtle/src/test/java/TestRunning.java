import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestRunning extends TestCase {
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();/*
        suite.addTestSuite(LoadTurtleTest.class);
        suite.addTestSuite(ParseRMLSourceTest.class);*/
        return suite;
    }
}
