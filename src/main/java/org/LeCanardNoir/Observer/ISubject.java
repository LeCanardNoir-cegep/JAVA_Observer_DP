package org.LeCanardNoir.Observer;

public interface ISubject {
    public void saveObserver(IObserver o);
    public void deleteObserver(IObserver o);
    public void notifyObserver();
}
