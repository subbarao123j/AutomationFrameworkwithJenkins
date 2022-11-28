package dataProviiderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties pro;

	public ConfigDataProvider() {

		pro = new Properties();
		try {
			pro.load(new FileInputStream(new File("./ConfiguratiionFiles\\config.properties")));
		} catch (IOException e) {

			System.out.println("unable to load properties file" + e.getMessage());
		}

	}

	public String getBrowser() {

		return pro.getProperty("browser");

	}

	public String getStagingURL() {

		return pro.getProperty("stagingURL");
	}

}
