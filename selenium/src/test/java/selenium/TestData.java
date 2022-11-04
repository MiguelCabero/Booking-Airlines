package selenium;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider(name = "calc-data")
	Object[][] testData() {
		return new Object[][] { { "2+3", "5" }, { "sqrt 16", "4" },
				{ "3-2", "1" } };
	}

}
