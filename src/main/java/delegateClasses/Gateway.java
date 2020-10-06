package delegateClasses;


import java.io.Serializable;


public class Gateway implements Serializable {
	
	public static final long serialVersionUID = 1L;
	public int Temperature;
	public int Humidity;
	public boolean checkVentilationStatus;
	
	public int getTemperature() {
		return Temperature;
		}
	
		public void setTemperature(int Temperature) {
		this.Temperature = Temperature;
		}
	
	public float getHumidity() {
		return Humidity;
		}
	
		public void setHumidity(int Humidity) {
		this.Humidity = Humidity;
		}
	
	
	public boolean ventilationCheck() {
		return checkVentilationStatus;
		}
	
	public void setventilationStatus(boolean checkVentilationStatus) {
		this.checkVentilationStatus = checkVentilationStatus;
		System.out.println("VentilationStatus:"+checkVentilationStatus);
		}
	
	@Override
	public String toString() {
	return " Gateway [Temperature=" + Temperature + ", Humidity=" + Humidity
	+ ", VentilationStatus=" + checkVentilationStatus +
	"]";
	}

}
