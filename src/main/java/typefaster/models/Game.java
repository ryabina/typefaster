package typefaster.models;

import java.util.Date;

public class Game implements IGame{
    IText text;
    @Override
    public Date getStartTime() {
        throw new  Error("Not implemented");
    }

    @Override
    public void setStartTime() {
        throw new  Error("Not implemented");
    }

    @Override
    public Date getEndTime() {
        throw new  Error("Not implemented");
    }

    @Override
    public void setEndTime() {
        throw new  Error("Not implemented");
    }

    @Override
    public IText getText() {
        return text;
    }

    @Override
    public void setText(IText text) {
         this.text = text;
    }

    @Override
    public Double getTotalTime() {
        return null;
    }

    @Override
    public Double getVelocity() throws ArithmeticException{
        if (getTotalTime() == 0)
            throw new ArithmeticException("Total time is 0");
        return text.getLength()/getTotalTime();
    }
}
