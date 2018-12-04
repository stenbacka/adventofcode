package twentyeighteen.day4;

import java.util.HashMap;
import java.util.Map;

public class Guard {
    public final int id;

    private Map<String, State[]> days;

    public Guard(int id) {
        this.id = id;
        this.days = new HashMap<>();
    }

    public void sleep(String key, int minute) {
        State[] minutesInHour = days.get(key);
        if (minutesInHour == null) {
            minutesInHour = new State[60];
            days.put(key, minutesInHour);
        }
        minutesInHour[minute] = State.Asleep;
    }

    public void awake(String key, int minute) {
        State[] minutesInHour = days.get(key);
        minutesInHour[minute] = State.Awake;
    }

    public int getMinutesAsleep() {
        int count = 0;
        for (State[] minutesInHour : days.values()) {
            boolean isAsleep = false;
            for (int i = 0; i < minutesInHour.length; ++i) {
                if (minutesInHour[i] == State.Asleep) {
                    isAsleep = true;
                } else if (minutesInHour[i] == State.Awake) {
                    isAsleep = false;
                }
                if (isAsleep) {
                    count++;
                }
            }
        }
        return count;
    }

    public int getMostSleepMinute() {
        int[] sleepCount = new int[60];
        for (State[] minutesInHour : days.values()) {
            boolean isAsleep = false;
            for (int i = 0; i < minutesInHour.length; ++i) {
                if (minutesInHour[i] == State.Asleep) {
                    isAsleep = true;
                } else if (minutesInHour[i] == State.Awake) {
                    isAsleep = false;
                }
                if (isAsleep) {
                    sleepCount[i]++;
                }
            }
        }
        int index = 0;
        for (int i = 0; i < sleepCount.length; ++i) {
            if (sleepCount[i] > sleepCount[index]) {
                index = i;
            }
        }
        return index;
    }

    public int getMostOccuranceOfSleep() {
        int[] sleepCount = new int[60];
        for (State[] minutesInHour : days.values()) {
            boolean isAsleep = false;
            for (int i = 0; i < minutesInHour.length; ++i) {
                if (minutesInHour[i] == State.Asleep) {
                    isAsleep = true;
                } else if (minutesInHour[i] == State.Awake) {
                    isAsleep = false;
                }
                if (isAsleep) {
                    sleepCount[i]++;
                }
            }
        }
        int index = 0;
        for (int i = 0; i < sleepCount.length; ++i) {
            if (sleepCount[i] > sleepCount[index]) {
                index = i;
            }
        }
        return sleepCount[index];
    }

    private enum State {
        Awake, Asleep;
        int minute;

    }
}
