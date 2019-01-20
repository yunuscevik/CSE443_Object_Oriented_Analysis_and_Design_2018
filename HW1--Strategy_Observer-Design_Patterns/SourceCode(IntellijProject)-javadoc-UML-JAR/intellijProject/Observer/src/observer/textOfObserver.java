package observer;

public class textOfObserver implements Observer {
    private String  text;
    private Subject webSite;

    public textOfObserver(Subject webSite) {
        this.webSite = webSite;
        webSite.registerObserver(this);
    }

    public void update(Observer observer, Object object) {
        if (observer instanceof WebSite) {
            WebSite webSite = (WebSite)observer;
            text = webSite.getAudio();
        }
    }

}