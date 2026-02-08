package com.tests.automation.hooks;

import com.github.dockerjava.api.model.HealthCheck;
import com.tests.automation.constants.DriverType;
import com.tests.automation.factory.DriverManagerFactory;
import io.cucumber.java.Scenario;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.Header;
import io.cucumber.java.Before;
import io.restassured.http.Headers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

import java.io.IOException;

public class Setup {

    private static WebDriver driver;
    private static final Logger LOGGER = LogManager.getLogger(Setup.class);

    @Before(order = 0)
    public void sendAutomationIdentifier() {
        // Définir l'URL de base sans appeler d'endpoint spécifique
        RestAssured.baseURI = "https://fo-gessousl-d.caas-nonprod.intra.groupama.fr";

        // Configurer le RequestSpecification avec un header global
        // Ignorer les erreurs SSL
        // Ajouter le header global
        // Afficher les headers dans les logs

        // Appliquer cette spécification à toutes les requêtes
        RestAssured.requestSpecification = RestAssured.given()
                .relaxedHTTPSValidation()  // Ignorer les erreurs SSL
                .header("X-Test-Bot", "Selenium")  // Ajouter le header global
                .log().headers();

        // À ce point, tu peux effectuer une requête n'importe où plus tard, et le header sera appliqué
        System.out.println("Header global ajouté. Aucune requête n'est envoyée pour l'instant.");
    }

    /**
     * Initializes the WebDriver and sets up the browser before each test scenario.
     * This method is automatically called before the execution of each Cucumber scenario.
     *
     * @param scenario The current test scenario being executed.
     */
    @Before(order = 1)
    public void startDriver(Scenario scenario) throws IOException {
        LOGGER.info("Scenario: '{}' - started", scenario.getName());

        try {
            // Retrieve browser type from system property or default to Chrome
            String browser = System.getProperty("browser", DriverType.CHROME.name()).toUpperCase();

            // Validate and initialize the WebDriver
            driver = DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver();
            LOGGER.info("WebDriver initialized successfully for browser: {}", browser);
        } catch (IllegalArgumentException e) {
            LOGGER.error("Invalid browser type specified: {}", System.getProperty("browser"), e);
            throw new RuntimeException("Failed to initialize WebDriver due to invalid browser type.", e);
        } catch (Exception e) {
            LOGGER.error("Unexpected error while initializing WebDriver.", e);
            throw new RuntimeException("WebDriver initialization failed.", e);
        }

    }

    /**
     * Getter for the WebDriver instance.
     *
     * @return The current WebDriver instance.
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Ensure startDriver() is called before use.");
        }
        return driver;
    }

    /**
     * Getter for the Logger instance.
     *
     * @return The Logger instance.
     */
    public static Logger getLogger() {
        return LOGGER;
    }
}

