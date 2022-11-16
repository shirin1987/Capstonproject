package tek.sdet.framework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {
	
	/*
	in this class we implement the concept of singleton designPattern. 
	What is singleton designPattern?
	it is a design which is used in programming to restrict the creation of an object to only
	an instance of a class. it will
	Why singleton designPattern?
	becuase we do not need to create the object of this class. we need only once.
	*/
	
	// The yaml files is key and value, so we create a Hashmap to store yaml files there.
	
	// then we create the constructor of this class private, in order to limit this and then
	// inside this constructor we will have a method to laod the files and we get the key and values.
	// so we need to read the yaml file and once the filed loaded we create the object of yaml class in
	// order to read the yaml file.
	
	
	
	
	private static ReadYamlFiles readYamlFiles;
	private HashMap propertyMap;
	
	private ReadYamlFiles(String filePath) throws FileNotFoundException {
		
		// in order to read the file
		FileInputStream fileInputStream = FileUtility.getFileInputStream(filePath);
	                                      	 // it is static and we call to load
		
		// in order to read the yaml file
		Yaml yaml = new Yaml();
		this.propertyMap = yaml.load(fileInputStream);
		
	}
	
	
	public static ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
		if(readYamlFiles==null)
			return new ReadYamlFiles(filePath);
		return readYamlFiles;
		
		
	}
	
	
	public HashMap getYamlProperty(String key) {
		return(HashMap) this.propertyMap.get(key);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
