package observer;

public class textPhotographOfObserver implements Observer {
    private String  text;
    private String  photograph;
    private Subject webSite;

    public textPhotographOfObserver(Subject webSite) {
        this.webSite = webSite;
        webSite.registerObserver(this);
    }

    public void update(Observer observer, Object object) {
        if (observer instanceof WebSite) {
            WebSite webSite = (WebSite)observer;
            text = webSite.getText();
            photograph = webSite.getAudio();
        }
    }

}