package twentyeighteen.one;

import common.AdventOfCodeProgram;
import common.Output;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProgramTwo extends AdventOfCodeProgram {
    @Override
    protected Output processData(List<String> dataPoints) {
        List<Integer> frequencies = dataPoints
                .stream()
                .filter(s -> !s.isEmpty())
                .map(Integer::new)
                .collect(Collectors.toList());

        Set<Integer> previousFrequencies = new HashSet<>();

        int current = 0;
        previousFrequencies.add(current);
        while (true) {
            for (Integer f : frequencies) {
                current += f;
                boolean newValue = previousFrequencies.add(current);
                if (!newValue) {
                    final Integer finalValue = current;
                    return () -> "" + finalValue;
                }
            }
        }
    }

    public static void main(String[] args) {
        new ProgramTwo().execute();
    }
}
