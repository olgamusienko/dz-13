package person;

import com.rd.person.Woman;
import dataproviders.TestDataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WomanTests {
    @Test(dataProvider = "womanIsRetiredData", dataProviderClass = TestDataProvider.class)
    public void testIsRetired(Woman woman, boolean expectedIsRetiredResult) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(woman.isRetired(), expectedIsRetiredResult, "Problems with isRetired method");
        softAssert.assertAll();

    }


}
