import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tag.RegressionSuite;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RegressionSuite
public class TestClass1 {
    @Test
    @DisplayName("TestClass1 Regression test")
    public void testmethod1(){
        assertTrue(false);
    }
}
