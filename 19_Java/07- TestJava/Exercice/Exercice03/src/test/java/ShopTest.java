import jdk.jshell.spi.ExecutionControl;
import org.example.exercice05.Product;
import org.example.exercice05.Shop;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShopTest {

    private Shop shop;

    @Before
    public void setUp() {
        shop = new Shop();
    }

    @Test public void WhenSellInEqual0_ThenUpdateBeTrue() {

        //act
        Product product = new Product();
        product.setSellIn(1);
        product.setQuality(4);

        shop.update(product);

        Product productUpdated =  new Product();
        productUpdated.setSellIn(1 - 1);
        productUpdated.setQuality(4 - 2);

        //Assert
        Assert.assertEquals(product, productUpdated);
    }

    @Test public void WhenQualityEqual0_ThenUpdateBeFalse() {
        //act
        Product product = new Product();
        product.setSellIn(5);
        product.setQuality(1);

        shop.update(product);

        Product productUpdated =  new Product();
        productUpdated.setSellIn(4);
        productUpdated.setQuality(0);

        //assert
        Assert.assertNotEquals(product, productUpdated);
    }

    @Test public void WhenQualityMoreThan50_ThenUpdateBeFalse() {
        //act
        Product product = new Product();
        product.setQuality(55);
        product.setSellIn(5);

        shop.update(product);

        boolean excepted = product.getQuality() > 50;

        Assert.assertFalse(excepted);
    }
}
