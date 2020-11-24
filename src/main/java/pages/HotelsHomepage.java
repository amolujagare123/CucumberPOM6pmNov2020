package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepdefinitions.SharedSD;

public class HotelsHomepage extends  BasePage{

    By txtCity  = By.xpath("//input[@id='qf-0q-destination']");

    By btnSearch = By.xpath("//button[@type='submit']");

    public void clickSearch()
    {
        clickOn(btnSearch);
    }


    public void setTxtCity(String city)
    {
        WebElement element = SharedSD.getDriver().findElement(txtCity);

        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();

        js.executeScript("arguments[0].setAttribute('value','"+city+"')",element);
    }

}
