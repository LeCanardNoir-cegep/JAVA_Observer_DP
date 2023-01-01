package org.LeCanardNoir.Observer;

import java.util.ArrayList;

public class DisplayStats implements IObserver, IDisplay{
    private ArrayList<Float> temperature;
    private ArrayList<Float> humidity;
    private ArrayList<Float> pression;
    private ISubject subject;

    public DisplayStats(ISubject subject) {
        this.temperature = new ArrayList<Float>();
        this.humidity = new ArrayList<Float>();
        this.pression = new ArrayList<Float>();

        this.subject = subject;
        this.subject.saveObserver(this);
    }

    public void display() {
        float t = average(temperature);
        float h = average(humidity);
        float p = average(pression);
        System.out.println("Moyenne: " + t + " Degré C\tHumidité: " + h + "%\tPression: " + p);

        t = minimum(temperature);
        h = minimum(humidity);
        p = minimum(pression);
        System.out.println("Minimum: " + t + " Degré C\tHumidité: " + h + "%\tPression: " + p);

        t = maximum(temperature);
        h = maximum(humidity);
        p = maximum(pression);
        System.out.println("Minimum: " + t + " Degré C\tHumidité: " + h + "%\tPression: " + p + "\n");
    }

    public void update(float temp, float humidity, float pression) {
        this.temperature.add(temp);
        this.humidity.add(humidity);
        this.pression.add(pression);
        display();
    }

    private float average(ArrayList<Float> data){
        float a = 0;
        int l = data.size();
        for (float d: data) {
            a+=d;
        }
        return a/l;
    }

    private float minimum(ArrayList<Float> data){
        return data.stream().min(Float::compare).get();
    }

    private float maximum(ArrayList<Float> data){
        return data.stream().max(Float::compare).get();
    }
}
