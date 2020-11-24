package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkSkyHomePage extends  BasePage{

    By currTemp = By.xpath("//span[@class='summary swap']");
    //76˚ Clear.
    By timelineTemp = By.xpath("//span[@class='first']//span");

    By tileTextList = By.xpath("//span[@class='hour']/span");

 By expander = By.xpath("//body/div[@id='week']/a[1]/span[3]");


    By barMinTemp = By.xpath("//a[@class='day revealed']//span[@class='minTemp']");
    By barMaxTemp = By.xpath("//a[@class='day revealed']//span[@class='maxTemp']");
    By timeLineMinTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='highTemp swip']//span[@class='temp']");
    By timeLineMaxTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[@class='temp']");


    public ArrayList<String> getBarTempList()
    {
        ArrayList<String> list = new ArrayList<>();

        list.add(getTextFromElement(barMinTemp).split("˚")[0]); // 49˚
        list.add(getTextFromElement(barMaxTemp).split("˚")[0]); // 77˚

        return list;

    }

    public ArrayList<String> getTimelineTempList()
    {
        ArrayList<String> list = new ArrayList<>();

        list.add(getTextFromElement(timeLineMinTemp).split("˚")[0]); // 49˚
        list.add(getTextFromElement(timeLineMaxTemp).split("˚")[0]); // 77˚

        return list;

    }



    public  void clickExpander()
 {
     clickOn(expander);
 }




    public ArrayList<Integer> getTimeList()
    {
        ArrayList<String> list = getElementTextList(tileTextList);
        ArrayList<Integer> timeList = new ArrayList<>();

        System.out.println(list);

        for(int i=0;i<list.size();i++)
        {
            String str = list.get(i); // e.g. "12pm"

            //how can we ignore the last 2 characters from the string.

            int l = str.length(); // length =4 , last character index -3,
                //i want to ignore last character  and a character previous to it

            String timeStr = str.substring(0,l-2);

            int time = Integer.parseInt(timeStr); //--> '12' in int

            timeList.add(time);
        }


        return  timeList;


    }


    public int getCurrTemp()
    {
        String rawTemp = getTextFromElement(currTemp);  //76˚ Clear.

        String tempStr =  rawTemp.split("˚")[0];

       return Integer.parseInt(tempStr);
    }

    public int getTimeLineTemp()
    {
        String rawTemp = getTextFromElement(timelineTemp);  //76°

        String tempStr =  rawTemp.split("°")[0];

        return Integer.parseInt(tempStr);
    }


}
