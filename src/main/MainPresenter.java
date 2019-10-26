package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import main.MainContract.View;
import model.Account;

public class MainPresenter implements MainContract.Presenter {

	private MainContract.View view;

	public MainPresenter(MainContract.View view) {
		this.view = view;
	}

	@Override
	public void start(Account account) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		String chromePath = "C:\\Users\\ADMIN\\AppData\\Local\\Google\\Chrome\\User Data\\";
		for (int i = 2; i < 3; i++) {

			ChromeOptions chromeProfile = new ChromeOptions();
			chromeProfile.addArguments("user-data-dir=" + chromePath + String.format("Profile %d", i));
			chromeProfile.addArguments(String.format("profile-directory=Profile %d", i));

			WebDriver driver = new ChromeDriver(chromeProfile);
			driver.navigate().to("http://m.facebook.com");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");

			driver.findElement(By.id(("requests_jewel"))).click();
		}
	}

	@Override
	public void loadAccount() {
		view.showAllAccounts(loadAccountsData(), loadColumnName());
	}

	private Object[] loadColumnName() {
		return new Object[] { "STT", "Name", "Birthday", "Friends", "Groups", "UserAccount", "Password", "Token",
				"Cookie", "Status" };
	}

	// temporary code
	protected Object[][] loadAccountsData() {
		return new Object[][] {
				{ "1", "Nguyen Van An", "1/1/2001", "abc", "123", "1000", "dfsfsdfds", "234dfssdfsfsf", "asd3adv24d",
						"Live" },
				{ "1", "Nguyen Van An", "1/1/2001", "abc", "123", "1000", "dfsfsdfds", "234dfssdfsfsf", "asd3adv24d",
						"Live" },
				{ "1", "Nguyen Van An", "1/1/2001", "abc", "123", "1000", "dfsfsdfds", "234dfssdfsfsf", "asd3adv24d",
						"Live" },
				{ "1", "Nguyen Van An", "1/1/2001", "abc", "123", "1000", "dfsfsdfds", "234dfssdfsfsf", "asd3adv24d",
						"Live" },
				{ "1", "Nguyen Van An", "1/1/2001", "abc", "123", "1000", "dfsfsdfds", "234dfssdfsfsf", "asd3adv24d",
						"Live" },
				{ "1", "Nguyen Van An", "1/1/2001", "abc", "123", "1000", "dfsfsdfds", "234dfssdfsfsf", "asd3adv24d",
						"Live" }, };
	}

	@Override
	public void deleteAllAccount() {
		// TODO Auto-generated method stub
		
	}
}
