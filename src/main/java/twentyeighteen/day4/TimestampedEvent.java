package twentyeighteen.day4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimestampedEvent implements Comparable<TimestampedEvent> {
    private static final Pattern pattern = Pattern.compile("\\[[0-9]{4}-([0-9]{2})-([0-9]{2}) ([0-9]{2}):([0-9]{2})\\] ([^\\n]+)");

    final String key;
    final String hour;
    final int minute;
    final String eventString;

    private TimestampedEvent(String key, String hour, int minute, String eventString) {
        this.key = key;
        this.hour = hour;
        this.minute = minute;
        this.eventString = eventString;
    }

    @Override
    public int compareTo(TimestampedEvent o) {
        int result = this.key.compareTo(o.key);
        if (result != 0) {
            return result;
        } else {
            result = this.hour.compareTo(o.hour);
            if (result != 0) {
                return result;
            } else {
                return this.minute - o.minute;
            }
        }
    }

    static TimestampedEvent build(String input) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new RuntimeException("Invalid datetime pattern. " + input);
        }
        String month = matcher.group(1);
        String date = matcher.group(2);
        String hour = matcher.group(3);
        int minute = Integer.parseInt(matcher.group(4));
        String eventString = matcher.group(5);
        return new TimestampedEvent(month + "-" + date, hour, minute, eventString);
    }
}
