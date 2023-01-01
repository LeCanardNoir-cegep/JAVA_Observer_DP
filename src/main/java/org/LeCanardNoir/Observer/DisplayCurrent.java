package org.LeCanardNoir.Observer;

public class DisplayCurrent implements IObserver, IDisplay {
    private float temparature;
    private float humidity;
    private ISubject subject;

    public DisplayCurrent(ISubject subject) {
        this.subject = subject;
        this.subject.saveObserver(this);
    }

    public void display() {
        System.out.println("Condition actuelle: " + temparature + " Degré C\nHumidité: " + humidity + "%\n");
    }

    public void update(float temp, float humidity, float pression) {
        this.temparature = temp;
        this.humidity = humidity;
        display();
    }
}
