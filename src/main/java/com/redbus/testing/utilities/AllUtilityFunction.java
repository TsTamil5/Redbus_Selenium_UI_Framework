package com.redbus.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllUtilityFunction {
	Properties properties;

	public void AllUtililtyFunction() {
	}

	// ================= WINDOW MANAGEMENT =================

	public void setMaximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void setMinimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void setFullscreenBrowser(WebDriver driver) {
		driver.manage().window().fullscreen();
	}

	public Dimension getSize(WebDriver driver) {
		return driver.manage().window().getSize();
	}

	public void setSize(WebDriver driver, int width, int height) {
		driver.manage().window().setSize(new Dimension(width, height));
	}

	public Point getPosition(WebDriver driver) {
		return driver.manage().window().getPosition();
	}

	public void setPosition(WebDriver driver, int x, int y) {
		driver.manage().window().setPosition(new Point(x, y));
	}

	/*
	 * 
	 * // ================= NAVIGATION =================
	 * 
	 * public void navigateTo(String url) { driver.navigate().to(url); }
	 * 
	 * public void navigateBack() { driver.navigate().back(); }
	 * 
	 * public void navigateForward() { driver.navigate().forward(); }
	 * 
	 * public void refreshPage() { driver.navigate().refresh(); }
	 * 
	 * 
	 */

// ================= DETAILS =================

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	// ================= TIMEOUTS =================

	public void implicitlyWait(WebDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void pageLoadTimeout(WebDriver driver, int seconds) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}

	// ================= EXPLICIT WAIT =================

	public void waitForElementVisible(WebDriver driver, WebElement element, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForTitleContains(WebDriver driver, String title, int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.titleContains(title));
	}
	// ================= ALERT / POPUPS =================

	public void acceptPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dismissPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getPopupText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void printTextOnPopup(WebDriver driver) {
		System.out.println(driver.switchTo().alert().getText());
	}

	public void sendTextToPopup(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	// ================= WINDOW HANDLES =================

	public void switchToWindowByTitle(WebDriver driver, String textTitle) {
		Set<String> all = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		all.remove(currentWindowHandle);

		for (String window : all) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(textTitle)) {
				break;
			}
		}
	}

	public void switchToWindowByUrl(WebDriver driver, String url) {
		Set<String> all = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		all.remove(currentWindowHandle);

		for (String window : all) {
			driver.switchTo().window(window);
			if (driver.getCurrentUrl().contains(url)) {
				break;
			}
		}
	}

	// ================= WINDOW CLOSE =================

	public void closeBrowser(WebDriver driver) {
		driver.close();
	}

	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	// ==================== PROPERTIES UTILITIES ===============

	public void initPropertiesUtility(String path) {

		try (FileInputStream fis = new FileInputStream(path);) {
			properties = new Properties();
			properties.load(fis);
			System.out.println("Properties : " + properties);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getPropertyData(String key) {
		if (properties != null) {
			return properties.getProperty(key);
		} else {
			System.err.println("Invalid Operation try again with proper property file");
			return null;
		}
	}

	// ==================== JAVA UTILITIES ===============
	public int getRandomNumber(int range) {
		return new Random().nextInt(range);
	}

	public String getCurrentDate(String dateFormat) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
		return simpleDateFormat.format(new Date());
	}

	// ==================== EXCEL UTILITY =========================
	
	private static final String FILE_PATH = "./src/test/resources/Readers/Config.xlsx";

	Workbook workbook;
	Sheet sheet;

	 public void initWorkbook() {
	        try {
	            FileInputStream fis = new FileInputStream(FILE_PATH);
	            workbook = WorkbookFactory.create(fis);
	            fis.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


	    public void setSheet(String sheetName) {
	        sheet = workbook.getSheet(sheetName);
	    }


	    public String getData(int row, int col) {

	        if (sheet == null) {
	            throw new RuntimeException("Sheet not initialized. Call setSheet()");
	        }

	        Cell cell = sheet.getRow(row).getCell(col);

	        if (cell == null) return "";

	        switch (cell.getCellType()) {
	            case NUMERIC:
	                return String.valueOf((long) cell.getNumericCellValue());
	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());
	            default:
	                return cell.toString();
	        }
	    }


	    public int getRowCount() {
	        return sheet.getPhysicalNumberOfRows();
	    }


	    public int getColCount() {
	        return sheet.getRow(0).getPhysicalNumberOfCells();
	    }


	    public Object[][] getExcelDataAsArray(String sheetName) {

	        Sheet s = workbook.getSheet(sheetName);

	        int rows = s.getLastRowNum();
	        int cols = s.getRow(0).getLastCellNum();

	        Object[][] data = new Object[rows][cols];

	        DataFormatter formatter = new DataFormatter();

	        for (int i = 1; i <= rows; i++) {

	            Row row = s.getRow(i);

	            for (int j = 0; j < cols; j++) {

	                Cell cell = row.getCell(j);

	                data[i - 1][j] = formatter.formatCellValue(cell);
	            }
	        }

	        return data;
	    }
	    //screenshot utility
	    public class ScreenshotUtil {

	        public String takeScreenshot(WebDriver driver, String fileName) {

	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);

	            String path = System.getProperty("user.dir") + "/screenshots/" + fileName + ".png";

	            try {
	                FileUtils.copyFile(src, new File(path));
	            } catch (IOException e) {
	                e.printStackTrace();
	            }

	            return path;
	        }
	    }

	

}
