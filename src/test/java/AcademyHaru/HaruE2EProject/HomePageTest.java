package AcademyHaru.HaruE2EProject;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePageTest extends Base {
//Need to call methods written in Base class, we will use Inheritance

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Username, String Password) throws IOException {
		driver = initializeDriver();
		driver.get("http://www.qaclickacademy.com/");
		// Creating object to that class and invoke methods of it
		
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(Username);
		loginPage.getPassword().sendKeys(Password);

		loginPage.Submit().click();

	}

	@DataProvider
	public Object[][] getData() {
		// rows stands for how many different data types test should run
		// column stands for how many values per each test
		Object[][] data = new Object[2][2];
		// 0th row
		data[0][0] = "haru@gmail.com";
		data[0][1] = "password";
		// 1st row
		data[1][0] = "bhupi@gmail.com";
		data[1][1] = "bhupi";

		return data;
	}

}
