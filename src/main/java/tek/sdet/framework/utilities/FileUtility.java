package tek.sdet.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUtility {
	
	//why this class?
	// in environment configration we stored our data in files, so now we need a class and
	// method to read that file. BBD need to know what is my inviroment
	
	// this class has a method and return FileInputStream class which import from java.io.FileInputStream.
	// what does FileInputStream? it read the file from environment configration file based on the character.
	
	
	public static FileInputStream getFileInputStream(String filePath) throws FileNotFoundException {
		return new FileInputStream(new File(filePath));
	}
	
	
}
