package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	private WebDriver driver;
    private By amountHeader = By.xpath("//th[@id='amount']");
    private By amountValues = By.xpath("//table//td[5]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAmountHeader() {
        driver.findElement(amountHeader).click();
    }

    public List<Double> getAmountValues() {
        List<WebElement> elements = driver.findElements(amountValues);
        return elements.stream()
                .map(WebElement::getText)
                .map(text -> text.replaceAll("[^\\d.-]", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public boolean isSortedAscending(List<Double> list) {
        List<Double> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        return list.equals(sorted);
    }
}

