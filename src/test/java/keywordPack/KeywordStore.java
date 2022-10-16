package keywordPack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import selectorPack.SearchElement;
import utilitiyReader.InitiatePropertyFile;
import utilitiyReader.ReadKeywords;
import utilitiyReader.UtilityMethods;

public class KeywordStore {

	static ArrayList<String> selector=new ArrayList<String>();

	static ArrayList<String> selectorValue=new ArrayList<String>();
	public static EdgeDriver  driver;
	static ArrayList<String>testData=new ArrayList<>();
	public static void openBrowser() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(testData.get(0));

	}

	public static void input() throws InterruptedException {
		TimeUnit.SECONDS.sleep(1);
		SearchElement.searchElementBy(selector.get(1), selectorValue.get(1));

		SearchElement.element.sendKeys(testData.get(1));
	}
	public static void click() throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);

		SearchElement.searchElementBy(selector.get(2), selectorValue.get(2));
		SearchElement.element.click();
	}

	public static void select() throws InterruptedException {

		SearchElement.searchElementBy(selector.get(3), selectorValue.get(3));
		Select  dropDown=new Select(SearchElement.element);
		dropDown.selectByValue(testData.get(3));
	}


	public static void main(String[] args) throws InterruptedException {
		try {

			InitiatePropertyFile.ConfigFileReader();
			ReadKeywords.getKeyword(5);
			selector.addAll(ReadKeywords.dataTable);
			ReadKeywords.dataTable.clear();

			ReadKeywords.getKeyword(6);
			selectorValue.addAll(ReadKeywords.dataTable);
			ReadKeywords.dataTable.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ReadKeywords.getKeyword(4);
		} catch (IOException e) {
			e.printStackTrace();
		}
		testData.addAll(ReadKeywords.dataTable);

		openBrowser();
		input();
		click();

		UtilityMethods.Timer(3);
		select();
	}


}
