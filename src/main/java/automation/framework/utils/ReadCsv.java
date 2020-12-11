package automation.framework.utils;

import java.beans.IntrospectionException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import java.util.HashMap;
import org.openqa.selenium.WebElement;
import au.com.bytecode.opencsv.*;

public  class ReadCsv {
	
	private static HashMap<String, List<String>> elementRepo = new HashMap<String, List<String>>();
	private static List<String> addElementList = new ArrayList<String>();
	WebElement webElement = null;
	
	

	public  static HashMap<String, List<String>> readElementRepositoryByCsvFile(String filepath) {
		  try {
			
			  CSVReader reader = new CSVReader(new FileReader(filepath));
			  String [] nextLine;
				int i=0;
				while ((nextLine = reader.readNext()) != null) {
					i=i+1;
					if (nextLine.length==1) 
						continue;
					else if (nextLine[0].toString().contains("#")) {
						continue;
					}
					
					if (nextLine.length <4) {
						System.out.println("Line No "+i+" Unknown element repository format ... expecting CSV file: namespace, property, JavaScript-Type, value.");
						
						try {
							
							throw new IntrospectionException ("Line No "+i+" Unknown data repository format ...");
						} catch (IntrospectionException e) {
							e.printStackTrace();
						}
						continue;
					}
					String newValue = null;
					String context = nextLine[0].trim();
				    String property = nextLine[1].trim();
				    String jsType = nextLine[2].trim();
				    String value = nextLine[3].trim();
				    
				    if (value.substring(0).contains("\"")) {
				    	newValue = value.substring(1);
				    }
				    
				    
						System.out.println("Element Logical name= "+property+"--Element Value= "+value);
						addElementList = new ArrayList();
						addElementList.add(jsType);
						addElementList.add(newValue);
						elementRepo.put(property, addElementList);
						
				}
			  
		  } catch(FileNotFoundException Ex) {
			  Ex.printStackTrace();
		  } catch(IOException Ex) {
			  Ex.printStackTrace();
		  }
		  
		  return elementRepo;
	  }
}
