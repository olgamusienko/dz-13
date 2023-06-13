package person;

import com.rd.person.Man;

import com.rd.person.Woman;
import dataproviders.TestDataProvider;
import models.Person;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.DBReader;

import java.util.List;

public class PersonTests {

    @Test(dataProvider = "testRegisterPartnershipData", dataProviderClass = TestDataProvider.class)
    public void testRegisterPartnership(Man man, Woman woman){

        List<Person> people = DBReader.getPeopleFromDB();

        SoftAssert softAssert = new SoftAssert();
        woman.registerPartnership(man);
        softAssert.assertEquals(woman.getPartner(), man, "Problems with RegisterPartnership method");
        softAssert.assertEquals(man.getPartner(), woman, "Problems with RegisterPartnership method");
        softAssert.assertEquals(woman.getLastName(), man.getLastName(), "The last name is incorrect");
        softAssert.assertAll();
    }

    @Test(dataProvider = "testDeregisterPartnershipData", dataProviderClass = TestDataProvider.class)
    public void testDeregisterPartnership(Man man, Woman woman, String maidenName){
        System.out.println(man.getPartner());
        SoftAssert softAssert = new SoftAssert();
        man.deregisterPartnership(true);
        softAssert.assertEquals(woman.getPartner(), null, "Problems with DeregisterPartnership method");
        softAssert.assertEquals(man.getPartner(), null, "Problems with DeregisterPartnership method");
        softAssert.assertEquals(woman.getLastName(), maidenName, "The maiden name is incorrect" );
        softAssert.assertAll();

    }

}
