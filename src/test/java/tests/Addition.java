package tests;

//1+1 = 2
//2 + 2 = 4
//3 + 3 = 6

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Addition extends BaseTest{
    @DataProvider(name = "additionData")
    public Object[][] getAdditionData() {
        return new Object[][]{
                {1, 1, 2},
                {2, 2, 4},
                {3, 3, 6}
        };
    }


}

