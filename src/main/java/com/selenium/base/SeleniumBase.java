package com.selenium.base;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.selenium.design.Browser;
import com.selenium.design.Element;
import com.utils.Reporter;

public class SeleniumBase extends Reporter implements Browser, Element{

	public void click(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void append(WebElement ele, String data) {
		// TODO Auto-generated method stub
		
	}

	public void clear(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void clearAndType(WebElement ele, String data) {
		// TODO Auto-generated method stub
		
	}

	public String getElementText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBackgroundColor(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTypedText(WebElement ele) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectDropDownUsingText(WebElement ele, String value) {
		// TODO Auto-generated method stub
		
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyDisappeared(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyEnabled(WebElement ele) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void startApp(String url) {
		// TODO Auto-generated method stub
		
	}

	public void startApp(String browser, String url) {
		// TODO Auto-generated method stub
		
	}

	public WebElement locateElement(String locatorType, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public WebElement locateElement(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<WebElement> locateElements(String type, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public void switchToAlert() {
		// TODO Auto-generated method stub
		
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void typeAlert(String data) {
		// TODO Auto-generated method stub
		
	}

	public void switchToWindow(int index) {
		// TODO Auto-generated method stub
		
	}

	public void switchToWindow(String title) {
		// TODO Auto-generated method stub
		
	}

	public void switchToFrame(int index) {
		// TODO Auto-generated method stub
		
	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void switchToFrame(String idOrName) {
		// TODO Auto-generated method stub
		
	}

	public void defaultContent() {
		// TODO Auto-generated method stub
		
	}

	public boolean verifyUrl(String url) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyTitle(String title) {
		// TODO Auto-generated method stub
		return false;
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void quit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long takeSnap() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
