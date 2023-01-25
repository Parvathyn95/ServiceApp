package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class DataProviderUtility {
	public static void sendKeyValue(WebDriver driver,WebElement element,String newString) {
		element.sendKeys(newString);
	}
	@DataProvider(name="formData")
	public static Object[][] getDataFromFormData(){
		return new Object[][] {
			{"Lewbricks Solutions","Mumbai","Mayank Vihar, Dombivilli East, Bombay","Andheri","047239","6734209836","nakul89@rediffmail.com"
				,"CG87OP54","56YU98","Samsung yfold phone screen display"}
		};
	}
	@DataProvider(name="formData2")
	public static Object[][] getDataFromFormData2(){
		return new Object[][] {
			{"vimal_h@reddifmail.com","Mobile Screenshot Sharpening"}
		};
	}
	@DataProvider(name="formData3")
	public static Object[][] getDataFromFormData3(){
		return new Object[][] {
			{"Lewbricks Solutions","Mumbai","Mayank Vihar, Dombivilli East, Bombay","Andheri","047239","6734209836","nakul89@rediffmail.com"
				,"CG87OP54","56YU98","Samsung yfold phone screen display"}
		};
	}
	@DataProvider(name="formData4")
	public static Object[][] getDataFromFormData4(){
		return new Object[][] {
			{"2WR6J89","Oppo Reno","Screen break","14 PLUS PRO","B6R4W32P0","25"}
		};
	}

}
