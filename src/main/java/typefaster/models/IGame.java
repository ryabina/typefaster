package typefaster.models;

import java.util.Date;

public interface IGame {
    Date getStartTime();
    void setStartTime();
    Date getEndTime();
    void setEndTime();
    IText getText();
    void setText(IText text);
    Double getTotalTime();
    Double getVelocity();
}
