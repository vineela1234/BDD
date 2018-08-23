package com.cg.pune.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.cg.pune.beans.OnlinePage;
import com.cg.pune.beans.Payment;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OnlineFeature {
	private WebDriver driver;
	private OnlinePage register;
	private Payment payment;
	
	@Before
	public void setUpStepEnv() {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();
		 driver.get("file:///D:/Login/ConferenceRegistartion.html");
	}
	
	@Given("^The user is in the registration page$")
	public void the_user_is_in_the_registration_page() throws Throwable {
	    register=new OnlinePage();
	    payment=new Payment();
	    PageFactory.initElements(driver,register);
	    PageFactory.initElements(driver, payment);	    
	}

	@When("^The user enters valid creadentials$")
	public void the_user_enters_valid_creadentials() throws Throwable {
	   register.setFirstName("vineela");
	   register.setLastName("K");
	   register.setEmail("viny@gmail.com");
	   register.setContactNo("9440616565");
	   register.setNoOfPeople("3");
	   register.setBuildingName("Saanvi pg");
	   register.setCity("Bangalore");
	   register.setAreaName("AECS Layout");
	   register.setState("Karnataka");
	   register.setMemberstatus("member");
	   register.onClick();   
	}

	@Then("^user is redirected to payment page$")
	public void user_is_redirected_to_payment_page() throws Throwable {
		driver.switchTo().alert().dismiss();
		driver.get("file:///D:/Login/PaymentDetails.html");
		   payment.setHname("Vineela Kolapalli");
		   payment.setDebit("123456789012");
		   payment.setCvv("111");
		   payment.setMonth("05");
		   payment.setYear("2023");
		   payment.clickSubmit();
	}

	@Then("^message is displayed$")
	public void message_is_displayed() throws Throwable {
		String expectedMessage="Conference Room Booking successfully done!!!"; 
		String actualMessage=driver.switchTo().alert().getText();		        
		Assert.assertEquals(expectedMessage, actualMessage);
		 driver.switchTo().alert().dismiss();
		 driver.close();
	}


}
