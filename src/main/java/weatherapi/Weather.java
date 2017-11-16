package weatherapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

	private String name;
	public Main main;
	public Sys sys;
	public Wind wind;
	@JsonProperty("weather")
	public List<WeatherProperties> property;
	int cod;
	public long dt;
	
	public long getDt() {
		return dt;
	}
	public void setDt(long dt) {
		this.dt = dt;
	}
	public Sys getSys() {
		return sys;
	}
	public void setSys(Sys sys) {
		this.sys = sys;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public Wind getWind(){
		return this.wind;
	}
	public void setWind(Wind wind){
		this.wind = wind;
	}
	public List<WeatherProperties> getProperty() {
		return property;
	}
	public void setProperty(List<WeatherProperties> property) {
		this.property = property;
	}
	
	@Override
	public String toString() {
		return "Weather [name=" + name + ", main=" + main + ", property="
				+ property + "]";
	}
	
	
	
}
