package com.example.springvaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.server.ClassResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
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
		Label cityNameLabel = new Label(cityName);
		Label descriptionLabel = new Label(description);
		
		if(icon.contains("n")) {
			icon = icon.replace("n", "d");
		}
		
		Image image = new Image(null, new ClassResource("/" + icon + ".png"));
		/*image.setWidth(60, Unit.PIXELS);
		image.setHeight(60, Unit.PIXELS);*/
		this.setLayout(new VerticalLayout(tempLabel, image, cityNameLabel, descriptionLabel));
	}

	public VerticalLayout getLayout() {
		return layout;
	}

	public void setLayout(VerticalLayout layout) {
		this.layout = layout;
	}
	
}
