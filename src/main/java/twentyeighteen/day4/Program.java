package twentyeighteen.day4;

import common.AdventOfCodeProgram;
import common.Output;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Program extends AdventOfCodeProgram {


    private Map<Integer, Guard> guards = new HashMap<>();
    private Guard getGuard(int id) {
        Guard guard = guards.get(id);
        if (guard == null) {
            guard = new Guard(id);
            guards.put(id, guard);
        }
        return guard;
    }

    private int getGuardId(String event) {
        int indexIfHash = event.indexOf('#');
        int endIndex = event.indexOf(' ', indexIfHash);
        return Integer.parseInt(event.substring(indexIfHash + 1, endIndex));
    }

    @Override
    protected Output processData(List<String> dataPoints) {

        List<TimestampedEvent> events =
                dataPoints.stream()
                .map(TimestampedEvent::build)
                .sorted()
                .collect(Collectors.toList());

        Guard currentGuard = null;
        for (TimestampedEvent event : events) {
            if (event.eventString.equals("falls asleep")) {
                currentGuard.sleep(event.key, event.minute);
            } else if (event.eventString.equals("wakes up")) {
                currentGuard.awake(event.key, event.minute);
            } else {
                int guardId = getGuardId(event.eventString);
                currentGuard = getGuard(guardId);
            }
        }

        Guard sleepiestGuard = null;
        for (Guard guard : guards.values()) {
            if (sleepiestGuard == null) {
                sleepiestGuard = guard;
            } else {
                if (sleepiestGuard.getMostOccuranceOfSleep() < guard.getMostOccuranceOfSleep()) {
                    sleepiestGuard = guard;
                }
            }
        }

        final Guard g = sleepiestGuard;
        return () -> "" + (g.id * g.getMostSleepMinute());
//        return () -> "" + (g.id * g.getMostSleepMinute());
    }

    public static void main(String[] args) {
        new Program().execute();
    }
}
