import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tag.RegressionSuite;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RegressionSuite
public class TestClass2 {

    @BeforeAll
    public void printEnv(){
        System.out.println(System.getProperty("currentEnv"));
    }

    @Test
    @DisplayName("TestClass2 Regression test")
    public void testmethod1(){
        assertTrue(true);
    }
}
