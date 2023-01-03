package org.LeCanardNoir.Observer;

import java.util.Observable;
import java.util.Observer;

public class DisplayCurrent implements Observer, IDisplay {
    private float temparature;
    private float humidity;
    private Observable observable;

    public DisplayCurrent(Observable observable) {
        this.observable = observable;
        this.observable.addObserver(this);
    }

    public void display() {
        System.out.println("Condition actuelle: " + temparature + " Degré C\nHumidité: " + humidity + "%\n");
    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof MeteoData){
            MeteoData data = (MeteoData) obs;
            this.temparature = data.getTemperature();
            this.humidity = data.getHumidity();
            display();
        }
    }
}
