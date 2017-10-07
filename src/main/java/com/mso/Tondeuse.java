package com.mso;



public class Tondeuse {
	
	private Position position;

	private String instruction;
	
	public String getInstruction() {
		return instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
		
		
	
	public Position pivoterTondeuse(char newOrdre){
			
	        if(newOrdre == 'G' && position.getOrientation() == 'N'){	            
	            position.setOrientation('W');
	            return position;
	            
	        }
	        
	        if(newOrdre == 'D' && position.getOrientation() == 'N'){
	            position.setOrientation('E');
	            return position;
	            
	        }
	        
	        if(newOrdre == 'G' && position.getOrientation() == 'S'){
	            position.setOrientation('E');
	            return position;
	            
	        }
	        
	        if(newOrdre == 'D' && position.getOrientation() == 'S'){
	            position.setOrientation('W');
	            return position;
	            
	        }
	        
	        if(newOrdre == 'G' && position.getOrientation() == 'E'){
	            position.setOrientation('N');
	            return position;
	            
	        }
	        
	        if(newOrdre == 'D' && position.getOrientation() == 'E'){
	            position.setOrientation('S');
	            return position;
	            
	        }	
	        
	        if(newOrdre == 'G' && position.getOrientation() == 'W'){
	            position.setOrientation('S');
	            return position;
	            
	        }
	        
	        if(newOrdre == 'D' && position.getOrientation() =='W'){
	            position.setOrientation('N');
	            return position;
	            
	        }        
	       
	        
	        return position;
	        
	        
	 }
	
	 public Position deplacerTondeuse(char newOrdre){  
		 	
	    	
	        if(newOrdre == 'A' && position.getOrientation() == 'N'){
	        	
	        	avancerVersNord();
	           
	        }
	        
	        if(newOrdre == 'A' && position.getOrientation() == 'S'){
	           
	        	avancerVersSud();
	        }
	        
	        if(newOrdre == 'A' && position.getOrientation() == 'E'){
	            
	        	avancerVersEst();
	        }
	        
	        if(newOrdre == 'A' && position.getOrientation() == 'W'){
	        	avancerVersWest();
	        
	        }
	        
        
	        return position;
	    
	} 
	 
	
	private void avancerVersNord(){
		 
		 if(position.getY() + 1 <= Perimeter.maxOrd){
			 position.setY(position.getY() + 1);
                                    
		 }
			 
     }
	
	private void avancerVersSud(){
		
		 if(position.getY() - 1 >= Perimeter.minOrd){
			 position.setY(position.getY() - 1);
			            
         }
	}
	
	private void avancerVersEst(){
				
		if(position.getX() + 1 <= Perimeter.maxAbs){
            position.setX(position.getX() + 1);
           
        }
	}
	
	private void avancerVersWest(){
		
		 if(position.getX() - 1 >= Perimeter.minAbs){
			 position.setX(position.getX() - 1);
                        
         }
	}
	
	public void executerInstructions(){
		
		for (int i = 0; i < getInstruction().length(); i++) {
						
			char [] extractLettre = getInstruction().toCharArray();
						
			if(extractLettre [i] == 'G' || extractLettre [i] == 'D'){
				pivoterTondeuse(extractLettre [i]);
			}
			
			if(extractLettre [i] == 'A'){
				deplacerTondeuse(extractLettre [i]);
			}			
			
			
		}
		
	}
	
	@Override
	public String toString() {
		
		System.out.println("Position tondeuse en abscisse : " + getPosition().getX());
		System.out.println("Position tondeuse en ordonnee : " + getPosition().getY());
		System.out.println("Orientation tondeuse : " + getPosition().getOrientation());
		return super.toString();
	}
}