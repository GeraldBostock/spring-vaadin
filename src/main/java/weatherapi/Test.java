package weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Test {

	@JsonProperty("0")
	public WeatherProperties property;

	public WeatherProperties getProperty() {
		return property;
	}

	public void setProperty(WeatherProperties property) {
		this.property = property;
	}

	@Override
	public String toString() {
		return "Test [property=" + property + "]";
	}
}
