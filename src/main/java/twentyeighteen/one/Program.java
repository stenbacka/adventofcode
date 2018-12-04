package twentyeighteen.one;

import common.AdventOfCodeProgram;
import common.Output;

import java.util.*;

public class Program extends AdventOfCodeProgram {
    @Override
    protected Output processData(List<String> dataPoints) throws IllegalStateException {
        return dataPoints
                .stream()
                .filter(s -> !s.isEmpty())
                .map(Frequency::build)
                .reduce((Frequency acc, Frequency curr) -> acc.calibrate(curr))
                .get();
    }

    public static void main(String[] args) {
        new Program().execute();
    }
}
