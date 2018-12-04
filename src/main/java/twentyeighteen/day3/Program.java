package twentyeighteen.day3;

import common.AdventOfCodeProgram;
import common.Output;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.StreamSupport;

public class Program extends AdventOfCodeProgram {

    private List<Claim>[][] computeFabricClaimMatrix(List<String> dataPoints) {
        List<Claim>[][] fabric = new List[1000][1000];
        dataPoints
                .stream()
                .map(Claim::new)
                .forEach((claim -> {
                    applyClaim(fabric, claim);
                }));
        return fabric;
    }

    @Override
    protected Output processData(List<String> dataPoints) {
        List<Claim>[][] fabric = computeFabricClaimMatrix(dataPoints);

        int count = 0;
        for (int i = 0; i < fabric.length; ++i) {
            for (int j = 0; j < fabric[i].length; ++j) {
                if (fabric[i][j] != null && fabric[i][j].size() >= 2) {
                    count++;
                }
            }
        }

        final int finalCount = count;
        return () -> "" + finalCount;
    }

    protected void applyClaim(List<Claim>[][] fabric, Claim claim) {
        for (int i = claim.x; i < claim.x + claim.w; ++i) {
            for (int j = claim.y; j < claim.y + claim.h; ++j) {
                if (fabric[i][j] == null) {
                    fabric[i][j] = new LinkedList<>();
                }
                fabric[i][j].add(claim);
            }
        }
    }

    public static void main(String[] args) {
        new Program().execute();
    }
}
