package com.example.springvaadin;

import org.springframework.beans.factory.annotation.Autowired;

import weatherapi.Weather;

import com.vaadin.annotations.Theme;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI{

	@Autowired
	private Service service;
	private Weather weather;
	
	@Override
	protected void init(VaadinRequest request) {
		TextField name = new TextField("Enter your name:");
		Button button = new Button("Send");
		Button button2 = new Button("Receive");
		Label label = new Label("Hello");
		
		VerticalLayout layout = new VerticalLayout(name, button, button2, label);
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);
		
		button.addClickListener(new ClickListener(){
			private static final long serialVersionUID = -8424487726640573041L;

			@Override
			public void buttonClick(com.vaadin.ui.Button.ClickEvent event) {
				weather = service.getWeather(name.getValue());
				label.setValue(String.valueOf(weather.getMain().getTemp()) + "°C");
			}
		});
	}

}
