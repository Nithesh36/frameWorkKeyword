package selectorPack;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import keywordPack.KeywordStore;



public class SearchElement {

	public static WebElement element;
	public static  By by;

	public static void  FindWebElement(By ele) {

		element= KeywordStore.driver.findElement(ele);
	}
	public static void  searchElementBy(String selector ,String value) {



		try {
			switch (selector.toLowerCase()) {
			case "xpath":
				System.out.println("xpath");
				by=By.xpath(value);
				FindWebElement(by);

				break;
			case "css":
				System.out.println("css");
				by=By.cssSelector(value);
				FindWebElement(by);			
				break;

			default:
				break;
			} 

		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {

		//		try {
		//			ReadKeywords.getKeyword(5);
		//			selector.addAll(ReadKeywords.dataTable);
		//			ReadKeywords.dataTable.clear();
		//
		//			ReadKeywords.getKeyword(6);
		//			selectorValue.addAll(ReadKeywords.dataTable);
		//			for (int i = 1; i < selector.size(); i++) {
		//
		//				searchElements(selector.get(i), selectorValue.get(i));
		//
		//			}
		//
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}


	}

}
