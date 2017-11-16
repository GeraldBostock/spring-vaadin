package com.dogauzunali.springvaadin;

import java.util.Date;

import com.vaadin.server.ClassResource;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import weatherapi.Weather;

public class WeatherComponent{

	private int temp;
	private String cityName;
	private String description;
	private String icon;
	private VerticalLayout layout;
	
	public WeatherComponent(Weather weather){
		this.temp = weather.getMain().getTemp();
		this.cityName = weather.getName();
		this.description = weather.getProperty().get(0).getDescription();
		this.icon = weather.getProperty().get(0).getIcon();
		
		Label tempLabel = new Label(String.valueOf(temp) + "°C");
		tempLabel.addStyleName("tempLabel");
		Label cityNameLabel = new Label(cityName + " - " + weather.getSys().getCountry());
		Label descriptionLabel = new Label(description);
		Label infoLabel = new Label("Humidity: " + weather.getMain().getHumidity() + "% | Wind: " + weather.getWind().getSpeed() + " km/s");
		Date expiry = new Date(weather.getDt() * 1000);
		Label time = new Label("Time of calculation: " + expiry.toString());
		
		if(icon.contains("n")) icon = icon.replace("n", "d");
		
		Image image = new Image(null, new ClassResource("/" + icon + ".png"));
		
		HorizontalLayout imageDescription = new HorizontalLayout(image, descriptionLabel);
		
		this.setLayout(new VerticalLayout(tempLabel, cityNameLabel, imageDescription, infoLabel, time));
	}

	public VerticalLayout getLayout() {
		return layout;
	}

	public void setLayout(VerticalLayout layout) {
		this.layout = layout;
	}
	
}
