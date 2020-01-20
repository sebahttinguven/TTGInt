package com.guven.springdemo;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class ReadRandomFortuneFileService implements FortuneService {

	private String fileName="C:/fortune-data.txt";
	private List<String> theFortunes;
	
	private Random myRandom= new   Random();
	
	public  ReadRandomFortuneFileService() {
	File theFile= new File(fileName);
	
	System.out.println("Reading fortunes from file: " + theFile);

	theFortunes= new  ArrayList<String>();
	
	try {
		BufferedReader bufferedReader= new BufferedReader(new FileReader(theFile));
		String tempLine;
		tempLine=	bufferedReader.readLine();
		while((tempLine=bufferedReader.readLine())!=null){
				theFortunes.add(tempLine);
		}
		
		bufferedReader.close();
		
	} catch (IOException e) {
		e.printStackTrace();

	}
	
	}
	
	@Override
	public String getFortune() {
		int index=myRandom.nextInt(theFortunes.size());
		
		return theFortunes.get(index);
	}

}
