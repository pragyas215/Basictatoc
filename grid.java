package tatoc1;
import java.util.List;



import org.openqa.selenium.Cookie;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class grid {

	public static void main(String args[]){
		WebDriver driver=new FirefoxDriver();
		//assignment 1
		driver.get("http://10.0.1.86");
		driver.get("http://10.0.1.86/tatoc");
		driver.get("http://10.0.1.86/tatoc/basic/grid/gate");
		
		driver.findElement(By.className("greenbox")).click();
		
		
		
	 //assignment 2
		driver.switchTo().frame("main");
		String color1= driver.findElement(By.cssSelector("#answer")).getAttribute("class");
		driver.switchTo().frame("child");
		String color2= driver.findElement(By.cssSelector("#answer")).getAttribute("class");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("main");
		while(!color1.equals(color2))
	    {  
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			driver.findElement(By.linkText("Repaint Box 2")).click();
		
			color1= driver.findElement(By.cssSelector("#answer")).getAttribute("class");
			driver.switchTo().frame("child");
			color2= driver.findElement(By.cssSelector("#answer")).getAttribute("class");
	    	
	    	if(color1.equals(color2)){
	    		driver.switchTo().defaultContent();
	    		driver.switchTo().frame("main");
	    		driver.findElement(By.linkText("Proceed")).click();
	    	   	break;
		    	}
		 }
		//assignment 3
		WebElement element = driver.findElement(By.id("dragbox"));
		WebElement target = driver.findElement(By.id("dropbox"));
		(new Actions(driver)).dragAndDrop(element, target).perform();
		
		driver.findElement(By.linkText("Proceed")).click();
		//assignment 4
		
		String  handle= driver.getWindowHandle(); 
		driver.findElement(By.xpath("//a[@href='#']")).click();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		driver.findElement(By.id("name")).sendKeys("Pragya");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(handle);
		List<WebElement> ds= driver.findElements(By.xpath("//a[@href='#']"));
		ds.get(1).click();
	
		//assignment 5
		driver.findElement(By.linkText("Generate Token")).click();
		String ck=driver.findElement(By.id("token")).getText();
		int y= ck.length(); String s="";
		for(int x=7;x<y ; x++){
			s+=ck.charAt(x);
		}
		System.out.println(s);
		Cookie token = new Cookie("Token", s);
		driver.manage().addCookie(token);
		List<WebElement> dd= driver.findElements(By.xpath("//a[@href='#']"));
		dd.get(1).click();
}
}


