package zadachnik;

public class Time {
    static private final int SECONDS_IN_HOUR = 3600;
    static private final int SECONDS_IN_MINUTE = 60;
    static private final int HOURS_IN_DAY = 24;

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int secondsFromStartOfDay) {
        hours = 0;
        minutes = 0;
        seconds = 0;
        if (secondsFromStartOfDay < 0) {
            addTime(0);
        } else {
            addTime(secondsFromStartOfDay);
        }
    }

    private void addTime(int secondsFromStartOfDay) {
        int remainder = secondsFromStartOfDay;

        hours += remainder / SECONDS_IN_HOUR;
        remainder -= hours * SECONDS_IN_HOUR;

        minutes += remainder / SECONDS_IN_MINUTE;
        remainder -= minutes * SECONDS_IN_MINUTE;

        seconds = remainder;
    }

    @Override
    public String toString() {
        String res = "";

        res += hours % HOURS_IN_DAY + ":";

        if (minutes < 10) {
            res += "0";
        }
        res += minutes + ":";

        if (seconds < 10) {
            res += "0";
        }
        res += seconds;

        return res;
    }
}
