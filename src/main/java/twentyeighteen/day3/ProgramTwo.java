package twentyeighteen.day3;

import common.Output;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgramTwo extends Program {

    @Override
    protected Output processData(List<String> dataPoints) {
        List<Claim>[][] fabric = new List[1000][1000];
        List<Claim> claims = dataPoints
                .stream()
                .map(Claim::new)
                .collect(Collectors.toList());

        claims
                .forEach((claim -> {
                    applyClaim(fabric, claim);
                }));

        int id = 0;
        for (Claim claim : claims) {
            boolean hasOverlap = false;
            outer:for (int i = claim.x; i < claim.x + claim.w; ++i) {
                for (int j = claim.y; j < claim.y + claim.h; ++j) {
                    if (fabric[i][j].size() > 1) {
                        hasOverlap = true;
                        break outer;
                    }
                }
            }
            if (!hasOverlap) {
                id = claim.id;
                break;
            }
        }

//        Map<Integer, Boolean> claimOverlap = new HashMap<>();
//        for (int i = 0; i < fabric.length; ++i) {
//            for (int j = 0; j < fabric[i].length; ++j) {
//                if (fabric[i][j] != null) {
//                    for (Claim c : fabric[i][j]) {
//                        if (claimOverlap.containsKey(c.id)) {
//                            claimOverlap.put(c.id, true);
//                        } else {
//                            claimOverlap.put(c.id, false);
//                        }
//                    }
//                }
//            }
//        }

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < fabric.length; ++i) {
//            for (int j = 0; j < fabric[i].length; ++j) {
//                if (fabric[i][j] == null) {
//                    sb.append("  -  ");
//                } else {
//                    if (fabric[i][j].size() > 1) {
//                        sb.append("  x  ");
//                    } else {
//                        sb.append(" ").append(fabric[i][j].get(0).id);
//                    }
//                }
////                    for (Claim c : fabric[i][j]) {
////                        if (claimOverlap.containsKey(c.id)) {
////                            claimOverlap.put(c.id, true);
////                        } else {
////                            claimOverlap.put(c.id, false);
////                        }
////                    }
////                }
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);

//        for (Map.Entry<Integer, Boolean> entry : claimOverlap.entrySet()) {
//            if (entry.getValue().equals(Boolean.FALSE)) {
//                return () -> "" + entry.getValue();
//            }
//        }

        final int finalId  = id;
        return () -> "" + finalId;
    }

    public static void main(String[] args) {
        new ProgramTwo().execute();
    }
}
