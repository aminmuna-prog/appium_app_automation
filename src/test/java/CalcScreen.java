import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalcScreen {
    @FindBy(id="com.google.android.calculator:id/op_div")
    WebElement btnDevide;
    @FindBy(id ="com.google.android.calculator:id/op_mul")
    WebElement btnMultiply;
    @FindBy(id = "com.google.android.calculator:id/op_sub")
    WebElement btnMinus;
    @FindBy(id = "com.google.android.calculator:id/op_add")
    WebElement btnPlus;
    @FindBy(id ="com.google.android.calculator:id/eq")
    WebElement btnEqual;
    @FindBy(id = "com.google.android.calculator:id/clr")
    WebElement btnClear;
    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement txtResult;
    @FindBy(id ="com.google.android.calculator:id/const_pi")
    WebElement btnPi;
    @FindBy(id = "com.google.android.calculator:id/op_pow")
    WebElement btnPower;
    @FindBy(id = "com.google.android.calculator:id/dec_point")
    WebElement btnPoint;
    AndroidDriver driver;
    public CalcScreen(AndroidDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

public String CalculateSeries(String series){
        for ( char ch: series.toCharArray()){
            if(Character.isDigit(ch)){
                driver.findElement(By.id("com.google.android.calculator:id/digit_"+ch)).click();
            } else if (ch == '/') {
               btnDevide.click();
            }else if (ch == '*') {
                btnMultiply.click();
            }else if (ch == '-') {
                btnMinus.click();
            }else if (ch == '+') {
                btnPlus.click();
            }
        }
        btnEqual.click();
        String result = txtResult.getText();
        return result;

}

public String CalculateCSVSeries(String CSVseries){
        for (int i = 0; i < CSVseries.length(); i++){
            if (Character.isDigit(CSVseries.charAt(i))){
                driver.findElement(By.id("com.google.android.calculator:id/digit_"+CSVseries.charAt(i))).click();
            }
            else if (CSVseries.charAt(i) == '/') {
                btnDevide.click();
            }
            else if (CSVseries.charAt(i) == '-') {
                btnMinus.click();
            }
            else if (CSVseries.charAt(i) == '+') {
                btnPlus.click();
            }
            else if (CSVseries.charAt(i) == '^') {
                btnPower.click();
            }
            else if (CSVseries.charAt(i) == '*') {
                btnMultiply.click();
            }
            else if(CSVseries.charAt(i) == 'p' && CSVseries.charAt(i+1) == 'i'){
                btnPi.click();
            }

        }
        btnEqual.click();
        String result = txtResult.getText();
        if (result.indexOf(".") != -1 && result.length() > result.indexOf(".")+2) {
            result = result.substring(0, result.indexOf(".") + 3);
        }
        return result;
    }

}
