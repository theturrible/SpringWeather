package com.forecastIO;

import com.github.dvdme.ForecastIOLib.FIOCurrently;
import com.github.dvdme.ForecastIOLib.ForecastIO;

/**
 * Created by Ivan on 6/28/2015.
 */
public class Weather {
    ForecastIO forecast;

    public Weather(String latitude, String longitude, String apiKey){
        forecast = new ForecastIO(latitude, longitude,apiKey);
        //set some defaults
        forecast.setUnits(ForecastIO.UNITS_US);
        forecast.setLang(ForecastIO.LANG_ENGLISH);
    }

    public void getCommonData(){
        //forecast.getForecast();
        System.out.println(forecast.getCurrently());
    }


    public void getCurrentWeather(){
        FIOCurrently currently = new FIOCurrently(forecast);
        //Print currently data
        System.out.println("\nCurrently\n");
        String [] f  = currently.get().getFieldsArray();
        for(int i = 0; i<f.length;i++)
            System.out.println(f[i]+": "+currently.get().getByKey(f[i]));
    }

}
