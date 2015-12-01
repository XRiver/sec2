package po;

import java.io.Serializable;

public class DistancePO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1779913246249138401L;

	String city1;
	
	String city2;
	
	double distance;

	public String getCity1() {
		return city1;
	}

	public String getCity2() {
		return city2;
	}

	public double getDistance() {
		return distance;
	}

	public DistancePO(String city1, String city2, double d) {
		super();
		this.city1 = city1;
		this.city2 = city2;
		this.distance = d;
	}
	
	

}
