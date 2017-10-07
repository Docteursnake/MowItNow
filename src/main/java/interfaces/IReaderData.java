package interfaces;

import java.util.List;

import com.mso.Perimeter;
import com.mso.Tondeuse;



public interface IReaderData {
	
	public List<String> getData(String nameFile);
	public List<Tondeuse> getTondeuses();
	public Perimeter getPerimeterInData();
	

}
