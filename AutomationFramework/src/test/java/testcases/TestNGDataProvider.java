package testcases;

import org.testng.annotations.DataProvider;

import dataProviiderFactory.DataProviderFactory;

public  class TestNGDataProvider {

	
	@DataProvider(name = "LoginData")
	public static Object[][] getDataFromSources() {

		System.out.println("LOG: INFO Running Data provider first to generate the data");

		int rows = DataProviderFactory.getExcel().getRows("Login");

		System.out.println("Total rows in Excel" + rows);

		Object[][] arr = new Object[rows][2];

		for (int i = 1; i < rows; i++) {
			arr[i][0] = DataProviderFactory.getExcel().getCellData("Login", i, 0);
			arr[i][1] = DataProviderFactory.getExcel().getCellData("Login", i, 1);
		}

		System.out.println("LOG:Info Data provider is ready for usage");

		return arr;

	}
}
