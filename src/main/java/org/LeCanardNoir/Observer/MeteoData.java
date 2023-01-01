package org.LeCanardNoir.Observer;

import jdk.nashorn.internal.parser.JSONParser;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MeteoData implements ISubject {
    private ArrayList<IObserver> observers;
    private float temperature;
    private float humidity;
    private float pression;

    public MeteoData() throws MalformedURLException {
        observers = new ArrayList<IObserver>();
    }

    public void saveObserver(IObserver o) {
        observers.add(o);
    }

    public void deleteObserver(IObserver o) {
        observers.remove(o);
    }

    public void notifyObserver() {
        for (IObserver o: observers) {
            o.update(temperature, humidity, pression);
        }
    }

    public void updateData(){
        notifyObserver();
    }

    public void setData() throws IOException {
        URL apiUrl = new URL("https://api.weatherapi.com/v1/current.json?key=2a66ce834e8f400c83924041230101&q=Longueuil,Qc&aqi=no");
        String json = IOUtils.toString(apiUrl, Charset.forName("UTF-8"));
        JSONObject jsonData = new JSONObject(json);

        temperature = jsonData.getJSONObject("current").getFloat("temp_c");
        humidity = jsonData.getJSONObject("current").getFloat("humidity");
        pression = jsonData.getJSONObject("current").getFloat("pressure_in");

        updateData();
    }
}
