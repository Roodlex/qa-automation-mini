package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {
    @Test
    public void additionTest() {
        Assert.assertEquals(2 + 3, 5);
    }
}
