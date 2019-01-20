package observer;

public class textAudioPhotographOfObserver implements Observer {
    private String  text;
    private String  audio;
    private String  photograph;
    private Subject webSite;

    public textAudioPhotographOfObserver(Subject webSite) {
        this.webSite = webSite;
        webSite.registerObserver(this);
    }

    public void update(Observer observer, Object object) {
        if (observer instanceof WebSite) {
            WebSite webSite = (WebSite)observer;
            text = webSite.getText();
            audio = webSite.getAudio();
            photograph = webSite.getphotograph();
        }
    }
}
