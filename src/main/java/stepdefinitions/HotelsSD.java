package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HotelsHomepage;
import pages.HotelsSearchResult;

import java.util.ArrayList;
import java.util.Collections;

public class HotelsSD {

    HotelsHomepage hotelsHomepage = new HotelsHomepage();
    HotelsSearchResult hotelsSearchResult = new HotelsSearchResult();

    @Given("^I am on hotels.com home page$")
    public void i_am_on_hotelscom_home_page() throws Throwable {

        Assert.assertEquals(SharedSD.getDriver().getTitle(),
                "Hotels.com India",
                "This is not hotels.com home page");
    }

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen()
            {
                hotelsHomepage.setTxtCity("Mumbai, India");
                hotelsHomepage.clickSearch();


    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars)  {

        // "5 stars"
        String star = stars.split(" ")[0]; // 5
        hotelsSearchResult.clickStarRatings(star);

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars)
             {
                 // stars -- "5 stars"

                 ArrayList  allStars = hotelsSearchResult.getAllStars();
                 System.out.println(allStars);

                 String star = stars.split(" ")[0]+"-star"; // 5-star

                 int occurance = Collections.frequency(allStars,star);
                 int size = allStars.size();

                 boolean result = occurance==size;

                 Assert.assertTrue(result,"all stars are not:"+star);


    }


}
