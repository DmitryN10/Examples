/**
 * Created by user on 20.10.2017.
 */
public class ResultAndTme {
    public Object result;

    public long startTime;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public ResultAndTme(Object result, long startTime) {
        this.result = result;
        this.startTime = startTime;
    }
}
