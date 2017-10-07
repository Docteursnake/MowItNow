package com.mso;


import java.util.List;

import interfaces.IReaderData;

public class Main {

	public static void main(String[] args) {
		
		String fileName = "test.txt";
		IReaderData readerFile = new ReaderFile();
		readerFile.getData(fileName);		
		readerFile.getPerimeterInData();
		
		List<Tondeuse> tondeusesList = readerFile.getTondeuses();		
		
		for (int i = 0; i < tondeusesList.size(); i++) {	
						
			Tondeuse uneTondeuse = tondeusesList.get(i);
			uneTondeuse.executerInstructions();	
			System.out.println("Position apres achevement des instructions : ");
			uneTondeuse.toString();
		}
		
		
	}

}
