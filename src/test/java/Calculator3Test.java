import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Calculator3Test {

    @DataProvider(name="multiplyData")
    public Object[][] provideData(){
        return new Object[][]{
                {2,3,6},
                {0,5,0},equals(qq)1         `1      1
                {-2,4-8},
                {-3,-3,9}
        };
    }

    @Test(dataProvider = "multiplyData")
        public void testMultiply(int a, int b, int expected){
        Calculator3 calc = new Calculator3();
        Assert.assertEquals(calc.multiply(a,b), expected, "Multiplication result is wrong!");
    }


}
