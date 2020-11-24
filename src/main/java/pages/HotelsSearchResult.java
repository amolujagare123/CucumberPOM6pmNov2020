package pages;

import org.openqa.selenium.By;
import stepdefinitions.SharedSD;

import java.util.ArrayList;

public class HotelsSearchResult extends BasePage{


    By starList = By.xpath("//span[contains(@class,'star-rating-text')]");


    public  void clickStarRatings(String star)
    {
        SharedSD.getDriver().findElement(By.xpath("//input[@id='f-star-rating-"+star+"']")).click();
    }


    public ArrayList<String> getAllStars()
    {
        return getElementTextList(starList);
    }

}
