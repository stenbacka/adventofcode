package twentyeighteen.day5;

import common.AdventOfCodeProgram;
import common.Output;

import java.util.List;

public class Program extends AdventOfCodeProgram {

    private StringBuilder fullyReactPolymer(StringBuilder polymer) {
        for (int i = 0; i < polymer.length() - 1;) {
            int c = polymer.charAt(i);
            int next = polymer.charAt(i + 1);
            if ((c + 32) == next || (c - 32) == next) {
                polymer.delete(i, i + 2);
                i = 0;
            } else {
                ++i;
            }
        }
        return polymer;
    }

    @Override
    protected Output processData(List<String> dataPoints) {
        final StringBuilder polymer = new StringBuilder(dataPoints.get(0).trim());

        System.out.println("Result #1: " + fullyReactPolymer(polymer).toString().length());

        final StringBuilder polymer2 = new StringBuilder(dataPoints.get(0).trim());

        StringBuilder shortest = null;
        for (int upper = 65; upper <= 65 + 25; ++upper) {
            int lower = upper + 32;
            StringBuilder sb2 = new StringBuilder(polymer);

            for (int i = 0; i < sb2.length();) {
                int c = sb2.charAt(i);
                if (c == lower || c == upper) {
                    sb2.deleteCharAt(i);
                } else {
                    ++i;
                }
            }

            fullyReactPolymer(sb2);

            if (shortest == null) {
                shortest = sb2;
            } else {
                if (sb2.length() < shortest.length()) {
                    shortest = sb2;
                }
            }
        }

        System.out.println("Result #2: " + shortest.toString().length());

        return () -> "";
    }

    public static void main(String[] args) {
        new Program().execute();
    }
}
