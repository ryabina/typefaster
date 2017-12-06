package typefaster.models;

import org.joda.time.DateTime;

public interface IGame {
    DateTime getStartTime() throws Exception;
    void setStartTime();
    DateTime getEndTime();
    void setEndTime();
    IText getText();
    void setText(IText text);
    Double getTotalTime() throws Exception;
    Double getVelocity() throws Exception;
    DateTime getCurrentTime();
}
