package twentyeighteen.two;

import common.AdventOfCodeProgram;
import common.Output;

import java.util.List;

public class ProgramTwo extends AdventOfCodeProgram {
    @Override
    protected Output processData(List<String> dataPoints) {
        outer:for (String dataPoint : dataPoints) {
            for (String otherDataPoint : dataPoints) {
                int diffCount = 0;
                int lastDiffIndex = 0;
                for (int i = 0; i < dataPoint.length(); i++) {
                    char d1 = dataPoint.charAt(i);
                    char d2 = otherDataPoint.charAt(i);
                    if (d1 != d2) {
                        lastDiffIndex = i;
                        diffCount++;
                    }
                    if (diffCount > 1) {
                        break;
                    }
                }
                if (diffCount == 1) {
                    final int diffCharIndex = lastDiffIndex;
                    return () -> new StringBuilder(dataPoint).deleteCharAt(diffCharIndex).toString();
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        new ProgramTwo().execute();
    }
}
