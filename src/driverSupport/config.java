package driverSupport;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class config {
	public  WebDriver driver;
	private static Properties prop;
	private static String filePath = System.getProperty("user.dir") + "\\.env";
	// Config property
	public config() {
		prop = new Properties();
		InputStream input = null;

		try {
			input = new FileInputStream(filePath);
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	// get peroperty
	public static String getProperty(String key) {

		prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(filePath);

			// load a properties file
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop.getProperty(key);
	}

	/*
	 * 
	 */
	public static String get(String key) {
		return getProperty(key);
	}
}
