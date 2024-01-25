package second_degree_equation.e2e;

import io.cucumber.java.After;
import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StepDefinitions {

    private final WebDriver driver = new ChromeDriver();

    @Given("J'accède au site {string}")
    public void j_accède_au_site(String url) {
        driver.get(url);
    }

    @Then("Je devrais voir le formulaire {string}")
    public void je_devrais_voir_le_formulaire(String idForm) {
        WebElement equationForm = driver.findElement(By.id(idForm));
        assertEquals(true, equationForm.isDisplayed());
    }

    @When("Je saisis {string} dans le champ {string}")
    public void je_saisis_dans_le_champ(String value, String champ) {
        WebElement inputField = driver.findElement(By.id("input_" +
                champ.toLowerCase()));
        inputField.sendKeys(value);
    }

    @When("Je clique sur le bouton")
    public void je_clique_sur_le_bouton() {
        WebElement submitButton = driver.findElement(By.id("submit_form"));
        submitButton.click();
    }

    @Then("je devrais etre redirigé sur la page {string} avec les resultats {string}")
    public void je_devrais_etre_redirigé_sur_la_page_avec_les_resultats(String expectedUrl, String expectedResults) {

        // Attendre que l'URL change si nécessaire
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(expectedUrl));

        // Vérifier que l'URL actuelle est celle attendue
        assertEquals(expectedUrl, driver.getCurrentUrl());

        // Attendre que le conteneur de résultats soit visible
        WebElement resultsContainer = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("roots")));

        // Récupérer les résultats affichés sur la page
        String actualResults = resultsContainer.getText();

        System.out.println("actualResults = " + actualResults);
        System.out.println("expectedResults = " + expectedResults);

        assertTrue(actualResults.contains(expectedResults));
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

}
