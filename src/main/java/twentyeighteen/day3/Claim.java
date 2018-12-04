package twentyeighteen.day3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Claim {

    private static final Pattern claimPattern = Pattern.compile("#([0-9]+)\\ @\\ ([0-9]+),([0-9]+):\\ ([0-9]+)x([0-9]+)");

    public final int id;
    public final int x;
    public final int y;
    public final int w;
    public final int h;

    public Claim(String claim) {
        Matcher claimMatcher = claimPattern.matcher(claim);
        if (!claimMatcher.matches()) {
            throw new RuntimeException("Invalid input " + claim);
        }
        this.id = Integer.parseInt(claimMatcher.group(1));
        this.x = Integer.parseInt(claimMatcher.group(2));
        this.y = Integer.parseInt(claimMatcher.group(3));
        this.w = Integer.parseInt(claimMatcher.group(4));
        this.h = Integer.parseInt(claimMatcher.group(5));
    }
}
