package com.bwap.weatherapp.WeatherApp.view;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.bwap.weatherapp.WeatherApp.Service.WeatherService;
import com.bwap.weatherapp.WeatherApp.controller.WeatherController;
import com.bwap.weatherapp.WeatherApp.controller.WeatherDetailsController;
import com.bwap.weatherapp.WeatherApp.model.Weather;
import com.bwap.weatherapp.WeatherApp.model.WeatherDetails;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;


@SpringUI(path = "")
public class MainView<cityName> extends UI {
    @Autowired
    private WeatherController weatherController;
    private VerticalLayout mainLayout;
    private NativeSelect<String> unitSelect;
    private TextField cityTextField;
    private Button searchButton;
    private Label location ;
    private Label currentTemp;
    private Label weatherDescription;
    private Label weatherMin;
    private Label weatherMax;
    private Label pressureLabel;
    private Label humidityLabel;
    private Label windSpeedLabel;
    private Label feelsLike;
    private Image iconImg;
    private HorizontalLayout Dashboard;
    private HorizontalLayout mainDescriptionLayout;
    private Image logo;
    private HorizontalLayout footer;
    @Autowired
    private Weather weather;
    @Autowired
    private WeatherService weatherservice;
   

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setUpLayout();
        setHeader();
        setLogo();
        setForm();
        dashboardTitle();
        dashboardDetails();

        footer();
        searchButton.addClickListener(clickEvent -> {
           if (!cityTextField.getValue().equals("")){
               try {
                   updateUI();
               } catch (JSONException e) {
                   e.printStackTrace();
               }
           }else
               Notification.show("Please Enter The City");
        });


    }



    public void setUpLayout() {
        logo = new Image();
        iconImg = new Image();
        iconImg.setWidth("200px");
        iconImg.setHeight("200px");
        mainLayout = new VerticalLayout();
        mainLayout.setWidth("100%");
        mainLayout.setSpacing(true);
        mainLayout.setMargin(true);
        mainLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        mainLayout.setStyleName("BackColorGrey");
        setContent(mainLayout);
    }
    private void setHeader(){
        HorizontalLayout headerlayout = new HorizontalLayout();
        headerlayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        Label Title = new Label("Weather APP By K.V.Dinesh Reddy");
        Title.addStyleName(ValoTheme.LABEL_H1);
        Title.addStyleName(ValoTheme.LABEL_BOLD);
        Title.addStyleName(ValoTheme.LABEL_COLORED);

        headerlayout.addComponents(Title);
        mainLayout.addComponents(headerlayout);


    }
    private void setLogo() {
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setDefaultComponentAlignment(Alignment.MIDDLE_RIGHT);

        logo.setSource(new ExternalResource("https://lh3.googleusercontent.com/proxy/xsHMx9xGm0BQmcoPVHjyn4U3dLcmPVX_5VazKGvIBpPmMyumkvx-YQEfy7UV17J139vRUHePYQ9hIsy-BgVLq8BV1T3WMD-4bqYbQCMNPdoeg4QGPU4"));
        logo.setWidth("500px");
        logo.setHeight("340px");
        logo.setVisible(true);
        
        logoLayout.addComponents(logo);
        mainLayout.addComponents(logoLayout);
    }
    private void setForm(){
        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        formLayout.setSpacing(true);
        formLayout.setMargin(true);

        //Selection Components
        unitSelect = new NativeSelect<>();
        unitSelect.setWidth("70px");
        ArrayList<String> items = new ArrayList<>();
        items.add("C");
       

        unitSelect.setItems(items);
        unitSelect.setValue(items.get(0));
        formLayout.addComponents(unitSelect);


        //cityTextField
        cityTextField = new TextField();
        cityTextField.setWidth("80%");
        formLayout.addComponents(cityTextField);

        //Search Icon
        searchButton = new Button();
        searchButton.setIcon(VaadinIcons.SEARCH);
        formLayout.addComponent(searchButton);


        mainLayout.addComponents(formLayout);
    }
    private void dashboardTitle() {
        Dashboard = new HorizontalLayout();
        Dashboard.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);


       
        location = new Label("Currently");
        location.addStyleName(ValoTheme.LABEL_H2);
        location.addStyleName(ValoTheme.LABEL_LIGHT);

        
        currentTemp = new Label("10F");
        currentTemp.setStyleName(ValoTheme.LABEL_BOLD);
        currentTemp.setStyleName(ValoTheme.LABEL_H1);
        Dashboard.addComponents(location,iconImg, currentTemp);


    }
    private void dashboardDetails(){
        mainDescriptionLayout = new HorizontalLayout();
        mainDescriptionLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        
        VerticalLayout descriptionLayout = new VerticalLayout();
        descriptionLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

       
        weatherDescription = new Label("Description: Clear Skies");
        weatherDescription.setStyleName(ValoTheme.LABEL_SUCCESS);
        descriptionLayout.addComponents(weatherDescription);

        
        weatherMin = new Label("Min:53");
        descriptionLayout.addComponents(weatherMin);
      
        weatherMax = new Label("Max:22");
        descriptionLayout.addComponents(weatherMax);


        VerticalLayout pressureLayout = new VerticalLayout();
        pressureLayout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        pressureLabel = new Label("Pressure:123Pa");
        pressureLayout.addComponents(pressureLabel);

        humidityLabel = new Label("Humidity:34");
        pressureLayout.addComponents(humidityLabel);

        windSpeedLabel = new Label("124/hr");
        pressureLayout.addComponents(windSpeedLabel);

        feelsLike = new Label("FeelsLike:");
        pressureLayout.addComponents(feelsLike);




        mainDescriptionLayout.addComponents(descriptionLayout, pressureLayout);

    }

    

    private void footer(){
        footer = new HorizontalLayout();
        footer.setDefaultComponentAlignment(Alignment.BOTTOM_CENTER);
        footer.setSpacing(true);
        footer.setMargin(true);
        footer.setWidth("100%");
        footer.setHeight("40px");
        Label description = new Label();
        description.setValue("Weather App ");
        footer.addComponents(description);
        mainLayout.addComponents(footer);
    }


    private void updateUI() throws JSONException {
        
        String city = cityTextField.getValue();
        String defaultUnit;
        weather.setCityName(city);

       
            weather.setUnit("metric");
            defaultUnit = "\u00b0" + "C";
            unitSelect.setValue("C");
        


        
        location.setValue("Currently in "+city);
        JSONObject mainObject = weatherservice.returnMainObject();
        double temp = mainObject.getDouble("temp");
        currentTemp.setValue(temp + defaultUnit);


        
        String iconCode = null;
        String weatherDescriptionNew = null;
        JSONArray jsonArray = weatherservice.returnWeatherArray();
         for (int i = 0; i< jsonArray.length(); i++){
            JSONObject weatherObject = jsonArray.getJSONObject(i);
            iconCode = weatherObject.getString("icon");
            weatherDescriptionNew = weatherObject.getString("description");
            System.out.println(iconCode);
             }
        
         iconImg.setSource(new ExternalResource("http://openweathermap.org/img/wn/"+iconCode+"@2x.png"));
        logo.setSource(new ExternalResource("http://openweathermap.org/img/wn/" + iconCode + "@2x.png"));
        weatherDescription.setValue("Description: "+weatherDescriptionNew);
        weatherMax.setValue("Max Temp: "+weatherservice.returnMainObject().getInt("temp_max")+"\u00b0" +unitSelect.getValue());
        weatherMin.setValue("Min Temp: "+weatherservice.returnMainObject().getInt("temp_min")+"\u00b0" +unitSelect.getValue());
        pressureLabel.setValue("Pressure: "+weatherservice.returnMainObject().getInt("pressure"));
        humidityLabel.setValue("Humidity: "+weatherservice.returnMainObject().getInt("humidity"));
        windSpeedLabel.setValue("Wind: "+weatherservice.returnWindObject().getInt("speed")+"m/s");
        feelsLike.setValue("Feelslike: "+weatherservice.returnMainObject().getDouble("feels_like"));
        mainLayout.addComponents(Dashboard,mainDescriptionLayout,footer);
        
        WeatherDetailsController wc = new WeatherDetailsController();
        WeatherDetails wd = new WeatherDetails();
        wc.addWeatherDetailsDB(wd);
        
    }
}




        
        




        
       











