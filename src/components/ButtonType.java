package components;

public class ButtonType {
    public final String icon;
    public final String title;
    public final String pageName;
        
    public ButtonType(String title, String pageName, String icon) {
        this.icon = icon;
        this.title = title;
        this.pageName = pageName;
    }
}