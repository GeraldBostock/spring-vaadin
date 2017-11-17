package com.dogauzunali.springvaadin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import weatherapi.Weather;

import com.vaadin.annotations.Theme;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("colored")
public class VaadinUI extends UI{
	
	private static final long serialVersionUID = 5021273462572274733L;
	@Autowired
	private Service service;
	private WeatherComponent component;
	private List<Weather> weatherList = new ArrayList<Weather>();
	int counter = 0;
	Button next = new Button("next");
	Button prev = new Button("previous");
	
	@Override
	protected void init(VaadinRequest request) {
		Label cityName = new Label("City name here:");
		Label error = new Label("City could not be found.");
		TextField city = new TextField();
		Button button = new Button("Search", VaadinIcons.SEARCH);
		HorizontalLayout search = new HorizontalLayout(city, button);
		VerticalLayout searchVertical = new VerticalLayout(cityName, search);
		VerticalLayout weatherLayout = new VerticalLayout();
		HorizontalLayout nextPrev = new HorizontalLayout(prev, next);
		VerticalLayout temp = new VerticalLayout(nextPrev);
		VerticalLayout layout = new VerticalLayout(searchVertical, weatherLayout, temp);
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);
		error.addStyleName("errorLabel");
		next.setEnabled(false);
		prev.setEnabled(false);
		
		button.addClickListener(new ClickListener(){
			private static final long serialVersionUID = -8424487726640573041L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				weatherList = service.getWeather(city.getValue());
				
				draw(weatherLayout);
			}
		});
		
		next.addClickListener(new ClickListener(){

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				counter += 2;
				draw(weatherLayout);
			}
			
		});
		
		prev.addClickListener(new ClickListener(){

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				if(counter != 0){
					counter -= 2;
					draw(weatherLayout);
				}		
			}
			
		});
	}
	
	public void draw(VerticalLayout weatherLayout){
		if(counter == 0) prev.setEnabled(false);
		else prev.setEnabled(true);
		
		if(counter + 2 < weatherList.size()) next.setEnabled(true);
		else next.setEnabled(false);
		
		weatherLayout.removeAllComponents();
		
		for(int i = counter; i < counter + 2; i++){
			if( i < weatherList.size()){
				component = new WeatherComponent(weatherList.get(i));
				weatherLayout.addComponent(component.getLayout());
			}	
		}
	}

}
