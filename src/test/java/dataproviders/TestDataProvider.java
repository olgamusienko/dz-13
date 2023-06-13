package dataproviders;

import com.rd.person.Man;
import com.rd.person.Woman;
import org.testng.annotations.DataProvider;

import java.util.Objects;

import static utils.DBReader.*;

public class TestDataProvider {

    @DataProvider(name = "womanIsRetiredData")
    public static Object[][] womanIsRetiredData() {

        return new Object[][]{
                {
                        new Woman("Mary", "Johnson", 61),
                        true
                },

                {
                        new Woman("Ciara", "Stone", 45),
                        false
                }
        };
    }

    @DataProvider(name = "manIsRetiredData")
    public static Object[][] manIsRetiredData() {

        return new Object[][]{
                {
                        new Man("Harry", "Potter", 75),
                        true
                },

                {
                        new Man("Will", "Smith", 55),
                        false
                }
        };

    }

    @DataProvider(name = "testRegisterPartnershipData")
    public static Object[][] testRegisterPartnershipData() {

        return new Object[][]{
                {
                    new Man("Daniel", "Smith", 65), new Woman("Stacy", "Parker", 62)
                },
                {
                    new Man("John", "Brown", 57), new Woman("Ciara", "Melony", 45)
                }
        };

    }

    @DataProvider(name = "testDeregisterPartnershipData")
    public static Object[][] testDeregisterPartnershipData(){
        Man man1 = new Man("Daniel", "Smith", 65);
        Woman woman1 = new Woman("Stacy", "Parker", 62);
        String maidenName1  = woman1.getLastName();
        woman1.registerPartnership(man1);

        Man man2 = new Man("John", "Brown", 57);
        Woman woman2 = new Woman("Ciara", "Melony", 45);
        String maidenName2  = woman2.getLastName();
        woman2.registerPartnership(man2);
        return new Object[][]{
                {
                    man1, woman1, maidenName1
                },
                {
                    man2, woman2, maidenName2
                }
        };
    }

    @DataProvider(name = "peopleDB")
    public static Object[][] peopleFromDB(){
            return getPeopleFromDB().stream().map(person -> new Object[]{
                    person.getFirst_name(),
                    person.getLast_name(),
                    person.getAge()})
                    .toArray(Object[][]::new);
    }


}
