package typefaster.models;

import java.util.Date;

public class Game implements IGame{
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
        throw new  Error("Not implemented");
    }

    @Override
    public void setText(IText text) {
        throw new  Error("Not implemented");
    }

    @Override
    public Double getVelocity() {
        throw new  Error("Not implemented");
    }
}
