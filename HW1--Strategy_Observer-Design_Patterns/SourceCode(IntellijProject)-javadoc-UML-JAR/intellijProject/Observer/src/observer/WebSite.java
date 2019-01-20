package observer;

import java.util.*;

public class WebSite implements Subject {
    private ArrayList<Observer> observers;
    private String text;
    private String audio;
    private String photograph;

    public WebSite() {
        observers = new ArrayList<Observer>();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(observer,new Object());
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(String text,String audio,String photograph) {
        this.text = text;
        this.audio= audio;
        this.photograph = photograph;
        measurementsChanged();
    }

    public String  getText() {
        return text;
    }

    public String  getAudio() {
        return audio;
    }

    public String getPhotograph() {
        return photograph;
    }


}