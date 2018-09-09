package br.com.same.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements DriverStrategy {

	@Override
	public WebDriver getDriver() {
		return new ChromeDriver();
	}

}
