import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeHasSauces() {
        String expectedResult = "SAUCE";
        String actualResult = IngredientType.valueOf("SAUCE").toString();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void ingredientTypeHasFilling() {
        String expectedResult = "FILLING";
        String actualResult = IngredientType.valueOf("FILLING").toString();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
