package automation.framework.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class configProperties extends Properties {
	private static configProperties propsObj = null;

	private configProperties() {
	}

	public static configProperties getInstance() {
		if (propsObj == null) {
			try {
				propsObj = new configProperties();
				FileInputStream fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/env.properties");

				propsObj.load(fis);
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return propsObj;
	}
}