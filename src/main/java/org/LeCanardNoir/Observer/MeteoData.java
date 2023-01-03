package org.LeCanardNoir.Observer;

import java.io.IOException;
import java.util.*;

public class MeteoData extends Observable {
    //private ArrayList<IObserver> observers;

    private float temperature;
    private float humidity;
    private float pression;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPression() {
        return pression;
    }


    public MeteoData(){
        //observers = new ArrayList<IObserver>();
    }

    /*public void saveObserver(IObserver o) {
        observers.add(o);
    }

    public void deleteObserver(IObserver o) {
        observers.remove(o);
    }*/

    /*public void notifyObserver() {
        for (IObserver o: observers) {
            o.update(temperature, humidity, pression);
        }
    }*/

    public void updateData(Object arg){
        if(arg != null)
            notifyObservers(arg);
        else
            notifyObservers();
    }

    public void setData(float temperature, float humidity, float pression) {

        this.temperature = temperature; //jsonData.getJSONObject("current").getFloat("temp_c");
        this.humidity = humidity; //jsonData.getJSONObject("current").getFloat("humidity");
        this.pression = pression; //jsonData.getJSONObject("current").getFloat("pressure_in");

        setChanged();
        updateData(null);
    }
}
