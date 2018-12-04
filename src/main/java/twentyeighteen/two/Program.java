package twentyeighteen.two;

import common.AdventOfCodeProgram;
import common.Output;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Program extends AdventOfCodeProgram {

    private Map<Character, Integer> groupByChar(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            final Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }
        return map;
    }

    private Predicate<Map<Character, Integer>> x(Integer threshold) {
        return (Map<Character, Integer> map) ->  map.values().stream().anyMatch((Integer count) -> count.equals(threshold));
    }

    @Override
    protected Output processData(List<String> dataPoints) {
        int twoCharCount = 0;
        int threeCharCount = 0;
        for (String dataPoint : dataPoints) {
            Map<Character, Integer> charMap = groupByChar(dataPoint);
            boolean hasTwoChars = charMap.values().stream().anyMatch(count -> count.equals(2));
            boolean hasThreeChars = charMap.values().stream().anyMatch(count -> count.equals(3));
            if (hasTwoChars) {
                twoCharCount++;
            }
            if (hasThreeChars) {
                threeCharCount++;
            }
        }

        final int finalCount = twoCharCount;
        final int finalCount2 = threeCharCount;
        return () -> "" + (finalCount * finalCount2);
    }

    public static void main(String[] args) {
        new Program().execute();
    }
}
