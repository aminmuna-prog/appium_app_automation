import config.SeriesDataSet;
import io.qameta.allure.Allure;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CalcTestRunner extends Setup{
    @Test(priority = 1, description = "find result of a series")
    public void doSeries(){
    CalcScreen calcScreen = new CalcScreen(driver);
    String finalResult =calcScreen.CalculateSeries("100/10*5-10+60");
    System.out.println(finalResult);
    Allure.description("series expression has got successful");
    }
    @Test(priority = 2, dataProvider ="SeriesCSVData", dataProviderClass = SeriesDataSet.class, description = "find output of a CSVfile series")
    public void CSVSeies(String expression, String expected_result){
        CalcScreen calcScreen = new CalcScreen(driver);
        String csvResult = calcScreen.CalculateCSVSeries(expression);
        System.out.println(csvResult);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(csvResult, expected_result);
        softAssert.assertAll();
        Allure.description("CSV series expression has got successful");
    }
    @AfterMethod
    public void clearScreen(){
        CalcScreen calcScreen = new CalcScreen(driver);
        calcScreen.btnClear.click();
    }
}
