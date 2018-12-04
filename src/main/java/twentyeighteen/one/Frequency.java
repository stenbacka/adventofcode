package twentyeighteen.one;

import common.Output;

public class Frequency implements Output {
    private int value;

    private Frequency(int value) {
        this.value = value;
    }

    public Frequency calibrate(Frequency current) {
        return new Frequency(current.value + value);
    }

    public static Frequency build(String input) {
        return new Frequency(Integer.parseInt(input));
    }

    @Override
    public String get() {
        return "" + value;
    }
}
