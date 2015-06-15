package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by prashanth_sams on 08/06/15.
 */

public class rnf_chennai_test extends SeleniumAbstractClass {

    @Test(description = "Empty search [Chennai]")
    public void Test01() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.clear();

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        List<WebElement> list = driver.findElements(By.cssSelector(".search-result-project-link"));

        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();

        for(WebElement temp: list){

            String text = temp.getText();
            String k = text.substring(text.length() - 5);
            a.add(k);
        }

        for(int i=a.size()-1; i>=0; i--){
            b.add(a.get(i));
        }
        System.out.println(a);
        System.out.println(b);

        if(a.equals(b)){
            System.out.println("failed");
            Assert.fail();
        }else{
            System.out.println("passed");
        }
    }

    @Test(description = "Search single location [Chennai]")
    public void Test02() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.sendKeys("Velachery");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Velachery')]"));
            driver.findElement(By.xpath(".search-result-project-link:contains('Velachery')"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "Search multiple locations [Chennai]")
    public void Test03() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.sendKeys("Velachery");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        search.sendKeys("Guindy");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        List<WebElement> list = driver.findElements(By.cssSelector(".search-result-project-link"));

        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        b.add("chery");
        b.add("uindy");

        for(WebElement temp: list){

            String text = temp.getText();
            String k = text.substring(text.length() - 5);
            a.add(k);
        }

        System.out.println(a);
        System.out.println(b);

        if(a.containsAll(b)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            Assert.fail();
        }
    }

    @Test(description = "Search Property - Apartment [Chennai]")
    public void Test04() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.clear();

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(1);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Apartments')]"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Apartment')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "Search Property - Villa [Chennai]")
    public void Test05() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.clear();

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(2);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Villas')]"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Villa')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "Search Property - Row House [Chennai]")
    public void Test06() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.clear();

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(3);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Row Houses')]"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Row House')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "Search Property - Plot [Chennai]")
    public void Test07() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.clear();

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(4);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Plots')]"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Plot')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "Search Property with single search location - Apartment [Chennai]")
    public void Test08() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.sendKeys("Velachery");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(1);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Velachery')]"));
            driver.findElement(By.xpath("//h1[contains(., 'Apartments')]"));
            driver.findElement(By.xpath(".search-result-project-link:contains('Velachery')"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Apartment')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "Search Property with single search location - Villa [Chennai]")
    public void Test09() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.sendKeys("Velachery");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(2);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Velachery')]"));
            driver.findElement(By.xpath("//h1[contains(., 'Villas')]"));
            driver.findElement(By.xpath(".search-result-project-link:contains('Velachery')"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Villa')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "Search Property with single search location - Row House [Chennai]")
    public void Test10() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.sendKeys("Velachery");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(3);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Velachery')]"));
            driver.findElement(By.xpath("//h1[contains(., 'Row Houses')]"));
            driver.findElement(By.xpath(".search-result-project-link:contains('Velachery')"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Row House')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "Search Property with single search location - Plot [Chennai]")
    public void Test11() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.sendKeys("Velachery");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(4);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Velachery')]"));
            driver.findElement(By.xpath("//h1[contains(., 'Plots')]"));
            driver.findElement(By.xpath(".search-result-project-link:contains('Velachery')"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Plot')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }


    @Test(description = "Search Property with multiple search locations - Apartment [Chennai]")
    public void Test12() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.sendKeys("Velachery");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        search.sendKeys("Guindy");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(1);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        List<WebElement> list = driver.findElements(By.cssSelector(".search-result-project-link"));

        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        b.add("chery");
        b.add("uindy");

        for(WebElement temp: list){

            String text = temp.getText();
            String k = text.substring(text.length() - 5);
            a.add(k);
        }

        System.out.println(a);
        System.out.println(b);

        if(a.containsAll(b)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            Assert.fail();
        }

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Velachery, Guindy')]"));
            driver.findElement(By.xpath("//h1[contains(., 'Apartments')]"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Apartment')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "Search Property with multiple search locations - Villa [Chennai]")
    public void Test13() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.sendKeys("Velachery");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        search.sendKeys("Guindy");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(2);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        List<WebElement> list = driver.findElements(By.cssSelector(".search-result-project-link"));

        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        b.add("chery");
        b.add("uindy");

        for(WebElement temp: list){

            String text = temp.getText();
            String k = text.substring(text.length() - 5);
            a.add(k);
        }

        System.out.println(a);
        System.out.println(b);

        if(a.containsAll(b)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            Assert.fail();
        }

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Velachery, Guindy')]"));
            driver.findElement(By.xpath("//h1[contains(., 'Villas')]"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Villa')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "Search Property with multiple search locations - Row House [Chennai]")
    public void Test14() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.sendKeys("Velachery");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        search.sendKeys("Guindy");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(3);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        List<WebElement> list = driver.findElements(By.cssSelector(".search-result-project-link"));

        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        b.add("chery");
        b.add("uindy");

        for(WebElement temp: list){

            String text = temp.getText();
            String k = text.substring(text.length() - 5);
            a.add(k);
        }

        System.out.println(a);
        System.out.println(b);

        if(a.containsAll(b)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            Assert.fail();
        }

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Velachery, Guindy')]"));
            driver.findElement(By.xpath("//h1[contains(., 'Row Houses')]"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Row House')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "Search Property with multiple search locations - Plot [Chennai]")
    public void Test15() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.sendKeys("Velachery");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        search.sendKeys("Guindy");
        Thread.sleep(2000);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        Select selectproperty = new Select(driver.findElement(By.className("propertyType")));
        selectproperty.selectByIndex(4);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        List<WebElement> list = driver.findElements(By.cssSelector(".search-result-project-link"));

        List<String> a = new ArrayList<String>();
        List<String> b = new ArrayList<String>();
        b.add("chery");
        b.add("uindy");

        for(WebElement temp: list){

            String text = temp.getText();
            String k = text.substring(text.length() - 5);
            a.add(k);
        }

        System.out.println(a);
        System.out.println(b);

        if(a.containsAll(b)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
            Assert.fail();
        }

        try{
            driver.findElement(By.xpath("//h1[contains(., 'Velachery, Guindy')]"));
            driver.findElement(By.xpath("//h1[contains(., 'Plots')]"));
            driver.findElement(By.xpath("//div[@class='search-details']//span[contains(., 'Plot')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

    }

    @Test(description = "1 BHK [Chennai]")
    public void Test16() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.clear();

        driver.findElement(By.cssSelector("//div[@class='bedroom-wrapper']//span[@class='select2-arrow']")).click();

        driver.findElement(By.cssSelector("(//label[starts-with(@for,'bedrooms')]//i)[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '1 BHK')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '2 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '2.5 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '3 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '3.5 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '4 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '4.5 BHK')]"));

    }

    @Test(description = "2 BHK [Chennai]")
    public void Test17() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.clear();

        driver.findElement(By.cssSelector("//div[@class='bedroom-wrapper']//span[@class='select2-arrow']")).click();

        driver.findElement(By.cssSelector("(//label[starts-with(@for,'bedrooms')]//i)[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '2 BHK')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '1 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '1.5 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '3 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '3.5 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '4 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '4.5 BHK')]"));

    }

    @Test(description = "3 BHK [Chennai]")
    public void Test18() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.clear();

        driver.findElement(By.cssSelector("//div[@class='bedroom-wrapper']//span[@class='select2-arrow']")).click();

        driver.findElement(By.cssSelector("(//label[starts-with(@for,'bedrooms')]//i)[3]")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '3 BHK')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '2 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '2.5 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '1 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '1.5 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '4 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '4.5 BHK')]"));

    }

    @Test(description = "4 BHK [Chennai]")
    public void Test19() throws Exception {

        WebElement search = driver.findElement(By.id("s2id_autogen1"));
        search.clear();

        driver.findElement(By.cssSelector("//div[@class='bedroom-wrapper']//span[@class='select2-arrow']")).click();

        driver.findElement(By.cssSelector("(//label[starts-with(@for,'bedrooms')]//i)[4]")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#parametric-search-button")).click();

        try{
            driver.findElement(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '4 BHK')]"));

        }catch(NullPointerException e){
            Assert.fail();
        }

        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '2 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '2.5 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '3 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '3.5 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '1 BHK')]"));
        isElementPresent(By.xpath("//div[@class='search-details']//ul[@class='RS-result clearfix']//p[1]//span[contains(., '1.5 BHK')]"));

    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return false;
//            Assert.fail();
        } catch (NoSuchElementException e) {
            return true;
        } catch(NullPointerException e) {
            return true;
        }
    }


}