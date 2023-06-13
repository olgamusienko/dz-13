package person;

import com.rd.person.Man;
import dataproviders.TestDataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ManTests {
    @Test(dataProvider = "manIsRetiredData", dataProviderClass = TestDataProvider.class)
    public void testIsRetired(Man man, boolean expectedIsRetiredResult) {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(man.isRetired(), expectedIsRetiredResult, "Problems with isRetired method");
        softAssert.assertAll();
    }
}
