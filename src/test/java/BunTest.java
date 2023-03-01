import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun("testBun", 42F);

    @Test
    public void getNameShouldReturnCorrectName() {
        String expectedResult = "testBun";
        String actualResult = bun.getName();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        float expectedResult = 42F;
        float actualResult = bun.getPrice();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }
}
