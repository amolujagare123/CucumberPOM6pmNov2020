package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pages.DarkSkyHomePage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DarkSkySD {

    DarkSkyHomePage darkSkyHomePage = new DarkSkyHomePage();

    @Given("I am on Darksky Home Page")
    public void i_am_on_darksky_home_page() {

        Assert.assertEquals(SharedSD.getDriver().getTitle(),
                "Dark Sky - Sansad Marg, New Delhi, Delhi"
        ,"This is not a darksky home page");

    }




    @Then("I verify current temp is equal to Temperature from Daily Timeline")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline() {


           int expected = darkSkyHomePage.getCurrTemp();
           int actual = darkSkyHomePage.getTimeLineTemp();

        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);


        Assert.assertEquals(actual,expected,"Test is failed");

    }


    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented()
            {

                ArrayList<Integer> timeList =   darkSkyHomePage.getTimeList();
                System.out.println(timeList);
                ArrayList<Integer> timeDiffList = new ArrayList<>();

                for(int i=0;i<timeList.size()-1;i++)
                {
                    int time1 = timeList.get(i);
                    int time2 = timeList.get(i+1);

                    int timeDiff = 0;

                    if(time2>time1)
                     timeDiff = time2 - time1;
                    else if (time1>time2)
                        timeDiff = (time2+12) - time1;

                    timeDiffList.add(timeDiff);

                }

                System.out.println(timeDiffList);

// lets find occarance of 2 in the timeDiffList
// if it is equal to the size of the list
// it means all the elements in the list are 2

          int occurance = Collections.frequency(timeDiffList,2) ;
          int size = timeDiffList.size();

          boolean result = occurance==size;

          Assert.assertTrue(result,"all the differences are not 2");


    }


    @Then("^I verify today's lowest and highest temp is displayed correctly$")
    public void i_verify_todays_lowest_and_highest_temp_is_displayed_correctly()
            {
                JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
                js. executeScript("window.scrollBy(0,800)", "");

                darkSkyHomePage.clickExpander();

                System.out.println(darkSkyHomePage.getBarTempList());
                System.out.println(darkSkyHomePage.getTimelineTempList());

                Assert.assertEquals(darkSkyHomePage.getBarTempList(),
                       darkSkyHomePage.getTimelineTempList(),
                        "temeprature are not correct" );


            }

}
