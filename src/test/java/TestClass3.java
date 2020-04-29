import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestClass3 {

    @BeforeAll
    public void printEnv(){
        System.out.println(System.getProperty("currentEnv"));
    }

    @Test
    @DisplayName("TestClass3 Regression test method")
    @Tag("regression")
    public void testmethod1(){
        assertTrue(true);
    }

    @Test
    @DisplayName("TestClass3 method not regression")
    public void testmethod2(){
        assertTrue(true);
    }
}
