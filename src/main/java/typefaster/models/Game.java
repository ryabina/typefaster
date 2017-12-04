package typefaster.models;

import org.joda.time.DateTime;
import org.joda.time.Duration;

public class Game implements IGame{
    IText text;
    DateTime startTime;
    DateTime endTime;
    @Override
    public DateTime getStartTime() {
        return startTime;
    }

    @Override
    public void setStartTime() {
        startTime = new DateTime();
    }

    @Override
    public DateTime getEndTime() {
        if (endTime == null){
          setEndTime();
        }
        return endTime;
    }

    @Override
    public void setEndTime() {
        endTime = getCurrentTime();
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
        Duration totalTime = new Duration(getStartTime(), getEndTime());
        return (double) totalTime.getStandardSeconds();
    }

    @Override
    public Double getVelocity() throws ArithmeticException{
        if (getTotalTime() == 0)
            throw new ArithmeticException("Total time is 0");
        return text.getLength()/getTotalTime();
    }
    public DateTime getCurrentTime(){
        return new DateTime();
    }
}
