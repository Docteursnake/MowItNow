package com.mso;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReaderFileTest {
	
	ReaderFile readerFile = new ReaderFile();
	
	@Test	
	public void getPerimeterInDataTest(){
		String fileName = "test.txt";
		readerFile.getData(fileName);		
		readerFile.getPerimeterInData();
		
		assertEquals(5, Perimeter.maxAbs);
		assertEquals(5, Perimeter.maxOrd);
		
	}

	@Test
	public void testGetData() {
		
		assertNotNull("le fichier est non vide", readerFile.getData("test.txt"));
	}
	
	@Test
	public void getTondeusesTest(){
		
		String fileName = "test.txt";
		readerFile.getData(fileName);		
			
		assertNotNull("la liste des tondeuses est non vide", readerFile.getTondeuses());
		
	}
}
