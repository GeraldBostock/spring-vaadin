package weatherapi;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

	private String name;
	public Main main;
	@JsonProperty("weather")
	public List<WeatherProperties> property;
	
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
