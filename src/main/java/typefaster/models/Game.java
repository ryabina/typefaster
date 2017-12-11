package typefaster.models;

import org.joda.time.DateTime;
import org.joda.time.Duration;

public class Game implements IGame{
    IText text;
    DateTime startTime;
    DateTime endTime;
    @Override
    public DateTime getStartTime() throws Exception {
        if (startTime == null) {
            throw new Exception("game wasn't started yet");
        }
        return startTime;
    }

    @Override
    public void setStartTime() {
        startTime = getCurrentTime();

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
    public void setText(String text) {
        this.text.setText(text);
    }

    @Override
    public Double getTotalTime() throws Exception {
        Duration totalTime = new Duration(getStartTime(), getEndTime());
        return (double) totalTime.getStandardSeconds();
    }

    @Override
    public Double getVelocity() throws Exception{
        if (getTotalTime() == 0)
            throw new ArithmeticException("Total time is 0");
        return text.getLength()/getTotalTime();
    }
    public DateTime getCurrentTime(){
        return new DateTime();
    }
}
