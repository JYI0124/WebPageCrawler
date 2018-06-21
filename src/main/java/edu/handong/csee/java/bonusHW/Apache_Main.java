package edu.handong.csee.java.bonusHW;

import java.net.URL;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

/**
 * This class is an Apache Class that deals with CLI
 * @author 21300750, Jin, Young-In
 *
 */

public class Apache_Main {
	
	URL url;
	boolean verbose;
	boolean help;
	String inputPath;
	String outputPath;
	
	/**
	 * This is a main method that actually runs the program. 
	 * @param args
	 * @throws Exception 
	 */
public static void main(String[] args) throws Exception{

		Apache_Main m = new Apache_Main();
		m.run(args);
	}

	/**
	 * This is a method that actually runs cmd
	 * @param args : pass the argument value
	 * @throws Exception 
	 */
	private void run(String [] args) throws Exception{
		Options options = createOptions();
		
		if(parseOptions(options, args)){
			
			if(help){
				printHelp(options);
				return;
			}
			
	
			ReadURL.readURL(inputPath, outputPath);
			
			
			if(verbose){
				
				System.out.println("Your program is terminated. (This message is shown because you turned on -v option!");
			}
		}
	}
	
	/**
	 * This is a method that parse options
	 * @param options : options; v,h,u,d
	 * @param args : getting argument
	 * @return : returning true when right option was chosen
	 */
	private boolean parseOptions(Options options, String [] args){
		CommandLineParser parser = new DefaultParser();
		
		try{
			CommandLine cmd = parser.parse(options, args);
			
			verbose = cmd.hasOption("v");
			help = cmd.hasOption("h");
			inputPath = cmd.getOptionValue("u");
			outputPath = cmd.getOptionValue("d");
			
		} catch (Exception e) {
			printHelp(options);
			return false;
		}
		
		return true;
	}
	
	/**
	 * This method is creating options
	 * @return : returning the created option value
	 */
	private Options createOptions(){
		Options options = new Options();
		
		options.addOption(Option.builder("h").longOpt("help")
				.desc("Help")
				.build());
		
		options.addOption(Option.builder("u").longOpt("inputURL")
				.desc("Set a directory path that contains input files")
				.hasArg()
				.argName("Input URL path")
				.required()
				.build());
		
		options.addOption(Option.builder("d").longOpt("outputdir")
				.desc("Set a directory path that writes out file")
				.hasArg()
				.argName("Output Directory path")
				.required()
				.build());
		
		return options;
	}
	
	/**
	 * This is a method that pops up when user asks for help
	 * @param options : getting option value
	 */
	private void printHelp(Options options){
		HelpFormatter formatter = new HelpFormatter();
		String header = "CLI test program";
		String footer = "\nPlease report issues at https://github.com/JYI0124/WebPageCrawler";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}


}

