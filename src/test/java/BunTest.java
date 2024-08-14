import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    private final String BUN_NAME = "булка";
    private final float BUN_PRICE = 10f;

    @Test
    public void bunNameIsOk(){
        Bun bun = standardBun();
        Assert.assertEquals(BUN_NAME, bun.getName());
    }

    @Test
    public void bunPriceIsOk(){
        Bun bun = standardBun();
        Assert.assertEquals(BUN_PRICE, bun.getPrice(), 0);
    }

    private Bun standardBun() {
        return new Bun(BUN_NAME, BUN_PRICE);
    }
}
