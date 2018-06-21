package edu.handong.csee.java.bonusHW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;


/**
 * This class reads url and gets data from url
 * @author 21300750, Jin, Young-In
 *
 */
public class ReadURL {
	
	static ArrayList <String> lineSaver = new ArrayList<String>();

	/**
	 * This method gets url address and saving directory address from main class and actually reads data from input url.
	 * @param inputPath : url address
	 * @param outputPath : saving directory address
	 * @throws Exception : handling exceptions
	 */
	public static void readURL(String inputPath, String outputPath) throws Exception {

        URL url = new URL(inputPath);
        BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null){
        	  lineSaver.add(inputLine);
        }
        
        SaveURL.writeFile(lineSaver, outputPath);         
        
        in.close();
        
    }


}
