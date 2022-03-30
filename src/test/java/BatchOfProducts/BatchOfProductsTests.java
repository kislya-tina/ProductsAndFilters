package BatchOfProducts;

import static org.testng.Assert.*;

import ProductsAll.BatchOfProducts.BatchOfProducts;
import ProductsAll.PackagingProducts.IProductPackaging;
import ProductsAll.PackagingProducts.SingleProductPackaging;
import ProductsAll.Products.SingleProduct;
import org.testng.annotations.Test;
import ProductsAll.Package.Package;

public class BatchOfProductsTests {

    Package pack = new Package("Box", 10.0);
    SingleProduct apple = new SingleProduct("Apple", "Green apple", 100.0);
    SingleProductPackaging packApple = new SingleProductPackaging(pack, apple, 10);
    IProductPackaging[] products = {packApple, packApple};
    BatchOfProducts batch = new BatchOfProducts( "Some fruits", products);

    @Test
    public void testGetProducts() {
        assertEquals(batch.getProductPackaging(), products);
    }

    @Test
    public void testToString(){
        assertEquals(apple.toString(), "SingleProduct: Apple, description Green apple, singleWeight 100.0\n");
    }

    @Test
    public void testGetNetto() {
        assertEquals(batch.getGeneralWeight(), 2020.0);
    }

}