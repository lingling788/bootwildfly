package bootwildfly;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWildFlyController {
	@Value("${path}")
	private String path;

    @RequestMapping("hello")
    public String sayHello(){
    	try {
    	      File myObj = new File(path + "/filename.txt");
    	      if (myObj.createNewFile()) {
    	        System.out.println("File created: " + myObj.getName());
    	      } else {
    	        System.out.println("File already exists.");
    	      }
    	    } catch (IOException e) {
    	      System.out.println("An error occurred.");
    	      e.printStackTrace();
    	    }
        return ("Hello, SpringBoot on Wildfly");
    }
}