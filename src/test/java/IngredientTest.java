import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "testIngredient", 42F);

    @Test
    public void getNameShouldReturnCorrectName() {
        String expectedResult = "testIngredient";
        String actualResult = ingredient.getName();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getPriceShouldReturnCorrectPrice() {
        float expectedResult = 42F;
        float actualResult = ingredient.getPrice();
        Assert.assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void getTypeShouldReturnCorrectType() {
        IngredientType expectedResult = IngredientType.SAUCE;
        IngredientType actualResult = ingredient.getType();
        Assert.assertEquals(expectedResult, actualResult);
    }
}
