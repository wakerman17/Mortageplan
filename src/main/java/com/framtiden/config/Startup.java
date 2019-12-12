package com.framtiden.config;

import com.framtiden.application.MortageplanService;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * When the program runs this class is executed once to setup the files 
 * 
 */
@Component
public class Startup implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
	  	String[] row = new String[4];
	  	List<String> lines = new ArrayList<String>();
	    File file = 
	  	      new File("D:\\JavaProgram\\Jobbtest\\Framtiden_11_dec\\Codetest-Mortageplan-Spring\\Mortageplan\\src\\main\\resources\\static\\prospects.txt");
	  	Scanner sc = new Scanner(file); 
	  	sc.nextLine();
	  	
	  	while (sc.hasNextLine()) {
	  		addLineIfPossible(sc.nextLine(), row, lines);
	  	}
	    Path newFile = Paths.get("output\\Prospect 1.txt");
	    Files.write(newFile, lines, StandardCharsets.UTF_8);
	  	sc.close();
	}
	
	private void addLineIfPossible(String nextLine, String[] row, List<String> lines) {
  	    if(nextLine.length() != 0 && nextLine.charAt(0) != '.') {
  	    	if (nextLine.charAt(0) == '\"') {
  		    	String[] textValueSeparator = nextLine.split("\",");
  		    	textValueSeparator[0] = textValueSeparator[0].substring(1, textValueSeparator[0].length());
  		    	textValueSeparator[0] = textValueSeparator[0].replace(',', ' ');
  		    	row[0] = textValueSeparator[0];
  		    	String[] numericalValues = textValueSeparator[1].split(",");
  		    	for (int i = 1; i < 4; i++) {
  		    		row[i] = numericalValues[i-1];
  		    	}
  	    	} else {
  		    	row = nextLine.split(",");
  		    }
  	    	lines.add(row[0] + " wants to borrow " + row[1] + " € for a period of " + row[3] + " years and pay " + MortageplanService.mortageplanCalculation(Double.valueOf(row[1]), Double.valueOf(row[2]), Integer.valueOf(row[3])) + " € each month");
  	    }
	}
}
