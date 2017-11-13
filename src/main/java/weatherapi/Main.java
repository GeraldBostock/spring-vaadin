package weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
	
	@JsonProperty("temp")
	private int temp;
	private int pressure;
	private String name;
	
	public int getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = (int) (Math.floor(temp) - 273);
	}
	public int getPressure() {
		return pressure;
	}
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}
	@Override
	public String toString() {
		return "Main [temp=" + temp + ", pressure=" + pressure + "]";
	}
	
	
}
