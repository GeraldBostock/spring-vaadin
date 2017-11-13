package weatherapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherProperties {

	private int id;
	private String main;
	private String description;
	private String imageName;
	private String icon;
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;	
	}
	
	public void setImageName(String imageName){
		this.imageName = imageName;
	}
	
	public String getImageName(){
		return this.imageName;
	}
	
	@Override
	public String toString() {
		return "WeatherProperties [id=" + id + ", main=" + main
				+ ", description=" + description + "]";
	}
}
