import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    @Test
    public void createEmptyBurgerTest(){
        Burger burger = new Burger();
        Assert.assertNull(burger.bun);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void setBunsTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void setIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        Assert.assertNull(burger.bun);
        Assert.assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest(){
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);

        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredientTest(){
        String ingredient1Name = "IN1";
        String ingredient2Name = "IN2";
        Burger burger = new Burger();
        Mockito.when(ingredient1.getName()).thenReturn(ingredient1Name);
        Mockito.when(ingredient2.getName()).thenReturn(ingredient2Name);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(1,0);

        Assert.assertEquals(2, burger.ingredients.size());
        Assert.assertEquals(ingredient1Name, burger.ingredients.get(1).getName());
        Assert.assertEquals(ingredient2Name, burger.ingredients.get(0).getName());
    }

    @Test
    public void burgerPriceTest(){
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(2f);
        Mockito.when(ingredient1.getPrice()).thenReturn(3f);
        Mockito.when(ingredient2.getPrice()).thenReturn(4f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        Assert.assertEquals(11f, burger.getPrice(), 0);
    }

    @Test
    public void burgerReceiptTest(){
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(2f);
        Mockito.when(bun.getName()).thenReturn("bun");
        Mockito.when(ingredient1.getPrice()).thenReturn(3f);
        Mockito.when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient1.getName()).thenReturn("cutlet");
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);

        Assert.assertNotNull(burger.getReceipt());
        Assert.assertFalse(burger.getReceipt().isEmpty());
        Assert.assertEquals(burger.getReceipt(), "(==== bun ====)\n" + "= filling cutlet =\n" + "(==== bun ====)\n" + "\n" + "Price: 7.000000\n");
    }
}
