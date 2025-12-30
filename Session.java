/**
 * Class Name: Session
 * Description: Represents a study session with a name and time range.
 * Author: Suon Caro
 * Date: 2025-12-30
 * Version: 1.1
 */
public class Session {

    /**
     * The session name. Must be non-null and non-empty after trimming.
     */
    private String sessionName;

    /**
     * Start time in HHmm 24-hour format (e.g., 0900 for 9:00 AM).
     */
    private int startTime;

    /**
     * End time in HHmm 24-hour format (e.g., 1730 for 5:30 PM).
     */
    private int endTime;

    /**
     * Constructs a Session with validation.
     *
     * @param sessionName the name of the session; must be non-null/non-empty
     * @param startTime   the start time in HHmm format
     * @param endTime     the end time in HHmm format; must be after startTime
     * @throws IllegalArgumentException if any argument is invalid
     */
    public Session(String sessionName, int startTime, int endTime) {
        setSessionName(sessionName);
        setDuration(startTime, endTime);
    }

    /**
     * Sets the session duration with validation.
     *
     * Rules:
     * - Times must be HHmm (0000–2359) with minutes 00–59.
     * - End time must be strictly after start time (positive duration).
     *
     * @param startTime start time in HHmm
     * @param endTime   end time in HHmm
     * @throws IllegalArgumentException if format is invalid or duration is not positive
     */
    public void setDuration(int startTime, int endTime) {
        if (!isValidTime(startTime)) {
            throw new IllegalArgumentException("Invalid start time format. Use HHmm (e.g., 0900).");
        }
        if (!isValidTime(endTime)) {
            throw new IllegalArgumentException("Invalid end time format. Use HHmm (e.g., 1700).");
        }

        int startMinutes = toMinutes(startTime);
        int endMinutes = toMinutes(endTime);
        if (endMinutes <= startMinutes) {
            throw new IllegalArgumentException("End time must be after start time.");
        }

        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns the session name.
     */
    public String getSessionName() {
        return sessionName;
    }

    /**
     * Sets the session name with validation.
     *
     * @param sessionName the new session name
     * @throws IllegalArgumentException if null or empty after trim
     */
    public void setSessionName(String sessionName) {
        if (sessionName == null || sessionName.trim().isEmpty()) {
            throw new IllegalArgumentException("Session name must be non-empty.");
        }
        this.sessionName = sessionName.trim();
    }

    /**
     * Returns the start time in HHmm.
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * Returns the end time in HHmm.
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * Returns the session duration in minutes.
     */
    public int getDurationMinutes() {
        return toMinutes(endTime) - toMinutes(startTime);
    }

    /**
     * Provides a readable representation of the session.
     */
    @Override
    public String toString() {
        return "Session{name='" + sessionName + "', start=" + formatHHmm(startTime) +
               ", end=" + formatHHmm(endTime) + ", duration=" + getDurationMinutes() + " min}";
    }

    // --- Helper methods ---

    /**
     * Validates HHmm time format and range.
     */
    private static boolean isValidTime(int hhmm) {
        if (hhmm < 0 || hhmm > 2359) return false;
        int hours = hhmm / 100;
        int minutes = hhmm % 100;
        if (hours < 0 || hours > 23) return false;
        if (minutes < 0 || minutes > 59) return false;
        return true;
    }

    /**
     * Converts HHmm to minutes since midnight.
     */
    private static int toMinutes(int hhmm) {
        int hours = hhmm / 100;
        int minutes = hhmm % 100;
        return hours * 60 + minutes;
    }

    /**
     * Formats HHmm into HH:mm string.
     */
    private static String formatHHmm(int hhmm) {
        int hours = hhmm / 100;
        int minutes = hhmm % 100;
        String h = hours < 10 ? ("0" + hours) : String.valueOf(hours);
        String m = minutes < 10 ? ("0" + minutes) : String.valueOf(minutes);
        return h + ":" + m;
    }
}