package typefaster.models;

import org.joda.time.DateTime;

public interface IGame {
    DateTime getStartTime();
    void setStartTime();
    DateTime getEndTime();
    void setEndTime();
    IText getText();
    void setText(IText text);
    Double getTotalTime();
    Double getVelocity();
}
