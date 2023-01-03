package org.LeCanardNoir.Observer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class DisplayStats implements Observer, IDisplay{
    private ArrayList<Float> temperature;
    private ArrayList<Float> humidity;
    private ArrayList<Float> pression;
    private Observable observable;

    public DisplayStats(Observable observable) {
        this.temperature = new ArrayList<>();
        this.humidity = new ArrayList<>();
        this.pression = new ArrayList<>();

        this.observable = observable;
        this.observable.addObserver(this);
    }

    public void display() {
        float t = average(this.temperature);
        float h = average(this.humidity);
        float p = average(this.pression);
        System.out.println("Moyenne: " + t + " Degré C\tHumidité: " + h + "%\tPression: " + p);

        t = minimum(this.temperature);
        h = minimum(this.humidity);
        p = minimum(this.pression);
        System.out.println("Minimum: " + t + " Degré C\tHumidité: " + h + "%\tPression: " + p);

        t = maximum(this.temperature);
        h = maximum(this.humidity);
        p = maximum(this.pression);
        System.out.println("Minimum: " + t + " Degré C\tHumidité: " + h + "%\tPression: " + p + "\n");
    }

    private float average(@NotNull ArrayList<Float> data){
        float a = 0;
        int l = data.size();
        for (float d: data) {
            a+=d;
        }
        return a/l;
    }

    private float minimum(@NotNull ArrayList<Float> data){
        return data.stream().min(Float::compare).get();
    }

    private float maximum(@NotNull ArrayList<Float> data){
        return data.stream().max(Float::compare).get();
    }

    @Override
    public void update(Observable obs, Object arg) {
        if(obs instanceof MeteoData){
            MeteoData data = (MeteoData) obs;
            this.temperature.add(data.getTemperature());
            this.humidity.add(data.getHumidity());
            this.pression.add(data.getPression());
            display();
        }
    }
}
