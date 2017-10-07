package com.mso;

import static org.junit.Assert.*;

import org.junit.Test;


public class TondeuseTest {
	
	Tondeuse tondeuse = new Tondeuse();	
	Position position = new Position();
	Perimeter perimeter;
	
	@Test
	public void avancerVersNordMaxTest() {
		Perimeter.maxAbs = 5;
		Perimeter.maxOrd = 5;
		
		position.setX(0);
		position.setY(5);
		position.setOrientation('N');		
		tondeuse.setPosition(position);
		tondeuse.deplacerTondeuse('A');
		
		assertEquals(0, tondeuse.getPosition().getX());
		assertEquals(5, tondeuse.getPosition().getY());
		
				
	}
	
	@Test
	public void avancerVersNordTest() {
		Perimeter.maxAbs = 5;
		Perimeter.maxOrd = 5;
		
		position.setX(0);
		position.setY(1);
		position.setOrientation('N');		
		tondeuse.setPosition(position);
		tondeuse.deplacerTondeuse('A');
		
		assertEquals(0, tondeuse.getPosition().getX());
		assertEquals(2, tondeuse.getPosition().getY());
		
				
	}
	
	@Test
	public void avancerVersSudTest() {
		Perimeter.maxAbs = 5;
		Perimeter.maxOrd = 5;
		
		position.setX(2);
		position.setY(3);
		position.setOrientation('S');		
		tondeuse.setPosition(position);
		tondeuse.deplacerTondeuse('A');
		
		assertEquals(2, tondeuse.getPosition().getX());
		assertEquals(2, tondeuse.getPosition().getY());
		
				
	}
	
	@Test
	public void avancerVersSudMaxTest() {
		Perimeter.maxAbs = 5;
		Perimeter.maxOrd = 5;
		
		position.setX(2);
		position.setY(0);
		position.setOrientation('S');		
		tondeuse.setPosition(position);
		tondeuse.deplacerTondeuse('A');
		
		assertEquals(2, tondeuse.getPosition().getX());
		assertEquals(0, tondeuse.getPosition().getY());
		
				
	}	
	

	@Test
	public void avancerVersEstTest() {
		Perimeter.maxAbs = 5;
		Perimeter.maxOrd = 5;
		
		position.setX(0);
		position.setY(1);
		position.setOrientation('E');		
		tondeuse.setPosition(position);
		tondeuse.deplacerTondeuse('A');
		
		assertEquals(1, tondeuse.getPosition().getX());
		assertEquals(1, tondeuse.getPosition().getY());
		
		
				
	}

	@Test
	public void avancerVersEstMaxTest() {
		Perimeter.maxAbs = 5;
		Perimeter.maxOrd = 5;
		
		position.setX(5);
		position.setY(5);
		position.setOrientation('E');		
		tondeuse.setPosition(position);
		tondeuse.deplacerTondeuse('A');
		
		assertEquals(5, tondeuse.getPosition().getX());
		assertEquals(5, tondeuse.getPosition().getY());
		
		
				
	}
	
	
	@Test
	public void avancerVersWestTest() {
		Perimeter.maxAbs = 5;
		Perimeter.maxOrd = 5;
		
		position.setX(4);
		position.setY(2);
		position.setOrientation('W');		
		tondeuse.setPosition(position);
		tondeuse.deplacerTondeuse('A');
		
		assertEquals(3, tondeuse.getPosition().getX());
		assertEquals(2, tondeuse.getPosition().getY());
		
		
				
	}
	
	@Test
	public void avancerVersWesMaxtTest() {
		Perimeter.maxAbs = 5;
		Perimeter.maxOrd = 5;
		
		position.setX(0);
		position.setY(0);
		position.setOrientation('W');		
		tondeuse.setPosition(position);
		tondeuse.deplacerTondeuse('A');
		
		assertEquals(0, tondeuse.getPosition().getX());
		assertEquals(0, tondeuse.getPosition().getY());
		
		
				
	}
	
	@Test
	public void orientationTondeuseTest(){
		
		position.setX(2);
		position.setY(2);
		
		position.setOrientation('N');		
		tondeuse.setPosition(position);
		tondeuse.pivoterTondeuse('G');		
		assertEquals('W', tondeuse.getPosition().getOrientation());
		
		position.setOrientation('N');		
		tondeuse.setPosition(position);
		tondeuse.pivoterTondeuse('D');		
		assertEquals('E', tondeuse.getPosition().getOrientation());
		
		position.setOrientation('S');		
		tondeuse.setPosition(position);
		tondeuse.pivoterTondeuse('D');		
		assertEquals('W', tondeuse.getPosition().getOrientation());
		
		position.setOrientation('S');		
		tondeuse.setPosition(position);
		tondeuse.pivoterTondeuse('G');		
		assertEquals('E', tondeuse.getPosition().getOrientation());
		
		position.setOrientation('E');		
		tondeuse.setPosition(position);
		tondeuse.pivoterTondeuse('G');		
		assertEquals('N', tondeuse.getPosition().getOrientation());
		
		position.setOrientation('E');		
		tondeuse.setPosition(position);
		tondeuse.pivoterTondeuse('D');		
		assertEquals('S', tondeuse.getPosition().getOrientation());
		
		position.setOrientation('W');		
		tondeuse.setPosition(position);
		tondeuse.pivoterTondeuse('G');		
		assertEquals('S', tondeuse.getPosition().getOrientation());
		
		position.setOrientation('W');		
		tondeuse.setPosition(position);
		tondeuse.pivoterTondeuse('D');		
		assertEquals('N', tondeuse.getPosition().getOrientation());
		
		
	}
	
	@Test
	public void lancerInstructionTest(){
		Perimeter.maxAbs = 5;
		Perimeter.maxOrd = 5;
		
		position.setX(1);
		position.setY(2);
		position.setOrientation('N');
		tondeuse.setPosition(position);
		tondeuse.setInstruction("GAGAGAGAA");
		
		tondeuse.executerInstructions();
		
		assertEquals(1, tondeuse.getPosition().getX());
		assertEquals(3, tondeuse.getPosition().getY());
		assertEquals('N', tondeuse.getPosition().getOrientation());
		
		//-------------------------------------------------------------------------------//
		
		position.setX(3);
		position.setY(3);
		position.setOrientation('E');
		tondeuse.setPosition(position);
		tondeuse.setInstruction("AADAADADDA");
		
		tondeuse.executerInstructions();
	
		assertEquals(5, tondeuse.getPosition().getX());
		assertEquals(1, tondeuse.getPosition().getY());
		assertEquals('E', tondeuse.getPosition().getOrientation());
	}
	
			
		
}
	
	
	

