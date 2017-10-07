package com.mso;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import interfaces.IReaderData;



public class ReaderFile implements IReaderData{
	
	private List<String> contentFile = new ArrayList<String>();	
	private Perimeter perimeter = new Perimeter();
	private List<Tondeuse> TondeusesList = new ArrayList<>();
	
	
	
	public Perimeter getPerimeter() {
		return perimeter;
	}


	public void setPerimeter(Perimeter perimeter) {
		this.perimeter = perimeter;
	}

	
	@Override
	public Perimeter getPerimeterInData(){
		
		String firstLine = contentFile.get(0) ;
		String[] output = firstLine.split(" ");
		Perimeter.maxAbs = Integer.parseInt(output[0]);
		Perimeter.maxOrd = Integer.parseInt(output[1]);
		
		return perimeter;
			
	}
	
	@Override
	public List<Tondeuse> getTondeuses(){
			
			//	on commence � i=1 car la premi�re ligne correspond aux coordonn�es du coin sup�rieur droit de la pelouse			
			for (int i = 1; i < contentFile.size(); i++) {
				Tondeuse tondeuse = new Tondeuse();
				Position position = new Position();
				
				String crudeData = contentFile.get(i);
				String [] initialPosition = crudeData.split(" ");
				position.setX(Integer.parseInt(initialPosition[0]));
				position.setY(Integer.parseInt(initialPosition[1]));
				position.setOrientation(initialPosition[2].charAt(0));
				
				tondeuse.setInstruction(contentFile.get(i+1));
				
				
				tondeuse.setPosition(position);
				TondeusesList.add(tondeuse);
				
				i = i+1;
				
			}
		
			
		return 	TondeusesList;		
		
	}

	public List<String> getContentFile() {
		return contentFile;
	}

	public void setContentFile(List<String> contentFile) {
		this.contentFile = contentFile;
	}

	
	//cette fonction prend en argument le nom du fichier
	@Override
	public List<String> getData(String nameFile) {
		
		try (BufferedReader br = Files.newBufferedReader(Paths.get(nameFile))) {

			//On r�cupere les donnees brutes sous forme de List<String>
			contentFile = br.lines().collect(Collectors.toList());
						
			return contentFile;	

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return contentFile;
		
	}	

	
	
}
