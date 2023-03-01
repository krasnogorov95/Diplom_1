import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Spy
    Bun spyBun = new Bun("black bun", 20F);
    @Spy
    List<Ingredient> spyIngredients = new ArrayList<>();
    @Spy
    Ingredient spyIngredient_1 = new Ingredient(IngredientType.SAUCE, "hot sauce", 2F);
    @Spy
    Ingredient spyIngredient_2 = new Ingredient(IngredientType.FILLING, "hot filling", 2F);

    @Test
    public void getPriceReturnCorrectCost() {
        burger = new Burger();
        spyIngredients.add(spyIngredient_1);
        burger.setBuns(spyBun);
        burger.addIngredient(spyIngredients.get(0));
        float expectedResult = 42F;
        float actualResult = burger.getPrice();
        Assert.assertEquals("Цены должны быть равны", expectedResult, actualResult, 0);
    }

    @Test
    public void getReceiptReturnCorrectString() {
        burger = new Burger();
        burger.setBuns(spyBun);
        burger.addIngredient(spyIngredient_1);
        String expectedResult = "(==== black bun ====)\n= sauce hot sauce =\n(==== black bun ====)\n\nPrice: 42,000000\n";
        String actualResult = burger.getReceipt();
        assertEquals("Строки должны совппадать", expectedResult, actualResult);
    }

    @Test
    public void shouldAddIngredient() {
        burger = new Burger();
        spyIngredients.add(spyIngredient_1);
        int sizeBeforeAdd = burger.ingredients.size();
        burger.addIngredient(spyIngredients.get(0));
        int sizeAfterAdd = burger.ingredients.size();
        assertNotEquals("Размеры листа не должны совпадать", sizeBeforeAdd, sizeAfterAdd);
    }

    @Test
    public void shouldRemoveIngredient() {
        burger = new Burger();
        spyIngredients.add(spyIngredient_1);
        spyIngredients.add(spyIngredient_2);
        burger.addIngredient(spyIngredients.get(0));
        burger.addIngredient(spyIngredients.get(1));
        int sizeBeforeRemove = burger.ingredients.size();
        burger.removeIngredient(0);
        int sizeAfterRemove = burger.ingredients.size();
        assertNotEquals("Размеры листа не должны совпадать", sizeBeforeRemove, sizeAfterRemove);
    }

    @Test
    public void shouldMovedIngredient() {
        burger = new Burger();
        spyIngredients.add(spyIngredient_1);
        spyIngredients.add(spyIngredient_2);
        burger.addIngredient(spyIngredients.get(0));
        burger.addIngredient(spyIngredients.get(1));
        Ingredient elementBeforeMove = burger.ingredients.get(0);
        burger.moveIngredient(0, 1);
        Ingredient elementAfterMove = burger.ingredients.get(1);
        assertEquals("Элементы должны совпадать", elementBeforeMove, elementAfterMove);
    }
}
