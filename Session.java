public class Session {
    public String sessionName;
    public int startTime;
    public int endTime;

    public Session(String sessionName, int startTime, int endTime) {
        this.sessionName = sessionName;
        setDuration(startTime, endTime);
    }

    public void setDuration(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }
}