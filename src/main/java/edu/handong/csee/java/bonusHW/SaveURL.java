package edu.handong.csee.java.bonusHW;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * This is a class that writes a file, saving it in outputPath address.
 * @author 21300750, Jin, Young-In
 *
 */
public class SaveURL {
	
	/**
	 * This is a method that writes data into file.
	 * @param lineSaver : ArrayList String type variable that saves all lines that were read from BufferReader
	 * @param outputPath : Saving directory address
	 * @throws Exception : handling exceptions
	 */
	public static void writeFile(ArrayList<String> lineSaver, String outputPath) throws Exception{
		
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(outputPath));
		
		for(String str : lineSaver){
			System.out.println(str);
			osw.write(str);
		}
		osw.close();
	}


}
