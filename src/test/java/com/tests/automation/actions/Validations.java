package com.tests.automation.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import org.junit.jupiter.api.Assertions;

import com.tests.automation.hooks.Setup;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tests.automation.base.BasePage;
import org.openqa.selenium.support.Color;

import static org.apache.pdfbox.cos.COSDictionaryLateBinding.log;

/**
 * This class is used to perform various kinds of validations in the test cases.
 */
public class Validations extends BasePage {

	private static final Logger LOGGER = (Logger) LogManager.getLogger(ActionsUtils.class.getName());

	/** testCaseStatus the status of the test case. */
	boolean testCaseStatus = true;

	/** test status. */
	boolean testStatus;

	/**
	 * Instanciation de assertions.
	 */
	public Validations() {
        super(Setup.getDriver());
        this.driver = Setup.getDriver();
    }

	/**
	 * method verify whether element is present on screen.
	 *
	 * @param targetElement element to be present
	 * @return true if element is present else throws exception
	 */
	public Boolean isElementPresent(By targetElement) {
		return Setup.getDriver().findElements(targetElement).size() > 0;
	}

	/**
	 * methode Checks if is element displayed.
	 *
	 * @param element element web
	 * @return boolean
	 */
	public Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * methode Checks if is element selected
	 *
	 * @param element
	 * @return boolean
	 */
	public Boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	/**
	 * methode Checks if is element enabled.
	 *
	 * @param element
	 * @return boolean
	 */
	public Boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * method verify whether element is not present on screen.
	 *
	 * @param targetElement element not to be present
	 * @return true if element is not present else throws exception
	 */
	public Boolean isElementNotPresent(By targetElement) {
		return Setup.getDriver().findElements(targetElement).size() == 0;
	}

	/**
	 * methode Verif PDF text file.
	 *
	 * @param text
	 * @param pdfPath
	 * @return true, si c'est vrai
	 * @throws IOException Signal qu'une execption de type I/O s'est produite.
	 */
	public boolean verifyTextInFile(String text, String pdfPath) throws IOException {

		boolean exist = false;
		File file = new File(pdfPath);
		FileInputStream fis = new FileInputStream(file);
		PDFParser parser = new PDFParser(fis);

		parser.parse();

		COSDocument cosDoc = parser.getDocument();
		PDDocument pdDoc = new PDDocument(cosDoc);
		PDFTextStripper strip = new PDFTextStripper();
		String data = strip.getText(pdDoc);

		exist = data.contains(text);

		cosDoc.close();
		pdDoc.close();

		LOGGER.info("Text Found on the pdf File...");
		return exist;

	}

	/**
	 * methode Column contains value.
	 *
	 * @param pathToFile
	 * @param columnIndex
	 * @param targetValue
	 * @return true, si c'est vrai
	 * @throws IOException Signal qu'une execption de type I/O s'est produite.
	 */
	public boolean columnContainsValue(String pathToFile, int columnIndex, String targetValue) throws IOException {

		Reader in = new FileReader(pathToFile);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

		for (CSVRecord record : records) {
			String rowValue = record.get(columnIndex);
			if (targetValue.equals(rowValue))
				return true;
		}
		return false;
	}

	/**
	 * methode Check field is empty.
	 * 
	 * @param elementAttr
	 */
	public void checkFieldIsEmpty(WebElement elementAttr) {
		WebElement inputText = elementAttr;
		String text = inputText.getAttribute("value");

		if (text.isEmpty()) {
			LOGGER.info("input box is empty");
		}
	}

    /// //////////////////////////////////////////////////


    private WebDriver driver;


    /**
     * method verify element is present.
     */
    public void assertEquals(WebElement element, String text) {
        String text1 = element.getText();
        Assertions.assertEquals(text1, text);

    }

    public void assertTrue(WebElement element, String text) {
        String text1 = element.getText();
        Assertions.assertTrue(text1.contains(text));

    }


    public void checkUrlChange(String url) {
        String actualUrl = Setup.getDriver().getCurrentUrl();
        if (actualUrl.equals(url)) {
            log.info("The page did not change");
        } else {
            log.info("The page has changed");
        }
        log.info("Actual URL is : " + actualUrl);

    }
    /**
     * Assert command for checking the url in selenium webdriver
     * @param expectedURL URL
     */
    public void checkChangedURL(String expectedURL)
    {
        String URL = driver.getCurrentUrl();
        Assertions.assertEquals(URL, expectedURL);
    }

    /**
     * method Checks if the color selected has the same Hex Code
     *
     * @param element
     * @param expectedHex
     */
    public void assertElementColor(WebElement element, String expectedHex) {
        String cssColor = element.getCssValue("background-color");
        String actualHex = Color.fromString(cssColor).asHex();
        Assertions.assertEquals(expectedHex, actualHex);
    }

    public void assertTrue(boolean errorMessageDisplayed, String errorMessageExpected) {
        Assertions.assertTrue(errorMessageDisplayed, errorMessageExpected);
    }
}