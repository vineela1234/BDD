package com.cg.pune.beans;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class OnlinePage {

	@FindBy(how=How.ID,id="txtFirstName")
	private WebElement firstName;
	
	@FindBy(how=How.ID,id="txtLastName")
	private WebElement lastName;
	
	@FindBy(how=How.ID,id="txtEmail")
	private WebElement email;

	@FindBy(how=How.ID,id="txtPhone")
	private WebElement contactNo;
	
	@FindBy(how=How.XPATH,xpath="/html/body/form/table/tbody/tr[5]/td[2]/select")
	private List<WebElement> noOfPeople;
	
	@FindBy(how=How.ID,id="txtAddress1")
	private WebElement buildingName;

	@FindBy(how=How.ID,id="txtAddress2")
	private WebElement areaName;
	
	@FindBy(how=How.XPATH,xpath="/html/body/form/table/tbody/tr[9]/td[2]/select")
	private List<WebElement> city;
	
	@FindBy(how=How.XPATH,xpath="/html/body/form/table/tbody/tr[10]/td[2]/select")
	private List<WebElement> state;
	
	@FindBy(how=How.NAME,name="memberStatus")
	private List<WebElement> memberStatus;
	
	@FindBy(how=How.XPATH,xpath="/html/body/form/table/tbody/tr[14]/td/a")
	private WebElement next;
	
	public OnlinePage() {
		super();
	}

	public String getFirstName() {
		return firstName.getAttribute("value");
	}
	
	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}
	
	public String getLastName() {
		return lastName.getAttribute("value");
	}
	public void setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public String getEmail() {
		return email.getAttribute("value");
	}
	
	public void setEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public String getContactNo() {
		return contactNo.getAttribute("value");
	}
	
	public void setContactNo(String contactNo) {
		this.contactNo .sendKeys(contactNo);
	}
	
	public void setNoOfPeople(String noOfPeople) {
		Select select=new Select(this.noOfPeople.get(0));
		select.selectByVisibleText(noOfPeople);
//		this.noOfPeople.sendKeys(noOfPeople);
	}
	
	public String getBuildingName() {
		return buildingName.getAttribute("value");
	}
	
	public void setBuildingName(String buildingName) {
		this.buildingName.sendKeys(buildingName);
	}
	
	public String getAreaName() {
		return areaName.getAttribute("value");
	}
	
	public void setAreaName(String areaName) {
		this.areaName.sendKeys(areaName);
	}
	
	public void setCity(String city) {
		Select select = new Select(this.city.get(0));
	    select.selectByVisibleText(city);
	}
	
	public void setState(String state) {
		Select select = new Select(this.state.get(0));
	    select.selectByVisibleText(state);
	}
	
	public void setMemberstatus(String memberstatus) {
		for(WebElement status : memberStatus) {
			if(status.getAttribute("value").contains(memberstatus))
				status.click();
		}	
	}
	
	public void onClick() {
		next.click();
	}
}
