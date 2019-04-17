package com.solveit.problems.maps;

import java.util.*;

public class ResolveDependency {

/*
Your previous Plain Text content is preserved below:

# Given a project consisting of a list of source packages and dependencies for each package,
# determine a valid build order for the project

### e.g.
## A: []
## B :[A]
## C: [X]
## D: [A, B]
## E: [D]

## A valid build order: A, B, X, C, D, E

====


 */


    public static void main(String[] arg) {

        Map<String, List<String>> output = new HashMap<>();
        output.put("A", Arrays.asList(new String[]{}));
        output.put("B", Arrays.asList(new String[]{"A"}));
        output.put("C", Arrays.asList(new String[]{"X"}));
        output.put("D", Arrays.asList(new String[]{"A", "B"}));
        output.put("E", Arrays.asList(new String[]{"D"}));

        System.out.println(findOrder(output));
    }

    private static List<String> findOrder(Map<String, List<String>> pkgDep) {
        List<String> outPut = new LinkedList();

        for (String key : pkgDep.keySet()) {
            List<String> deps = pkgDep.get(key);
            if (outPut.isEmpty()) {
                outPut.addAll(deps);
            } else {
                for (String d : deps) {
                    if (!outPut.contains(d)) {
                        outPut.add(d);
                    }

                }


            }
            outPut.add(key);

        }

        return outPut;
    }


}
