import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("bulk")
public class TestClass4 {

    @BeforeAll
    public void printEnv(){
        System.out.println(System.getProperty("currentEnv"));
    }

    @Test
    @DisplayName("TestClass4 bulk test method")
    public void testmethod1(){
        assertTrue(true);
    }

    @Test
    @DisplayName("TestClass4 bulk test method with regression")
    @Tag("regression")
    public void testmethod2(){
        assertTrue(true);
    }
}
