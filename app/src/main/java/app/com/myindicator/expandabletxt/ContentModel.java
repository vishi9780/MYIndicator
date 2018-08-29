package app.com.myindicator.expandabletxt;



public class ContentModel {
    private String text;
    private boolean isShrink;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isShrink() {
        return isShrink;
    }

    public void setShrink(boolean shrink) {
        isShrink = shrink;
    }
}
