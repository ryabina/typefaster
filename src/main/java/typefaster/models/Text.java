package typefaster.models;

public class Text implements IText {
    private String text;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public Integer getLength() {
        return text.length();
    }
}
