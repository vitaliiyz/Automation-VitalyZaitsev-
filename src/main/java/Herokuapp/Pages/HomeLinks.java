package Herokuapp.Pages;

public enum HomeLinks {
    CONTEXT_MENU("Context Menu"),
    DYNAMIC_CONTROLS("Dynamic Controls"),
    FILE_UPLOAD("File Upload"),
    FRAMES("Frames"),
    JAVASCRIPT_ALERTS("JavaScript Alerts");

    String link;

    HomeLinks(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}
