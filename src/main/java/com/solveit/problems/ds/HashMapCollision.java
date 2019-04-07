package com.solveit.problems.ds;

import java.util.HashMap;
import java.util.Map;

public class HashMapCollision {

    public static void main(String[] str) {

        Map<Account, Integer> acctMap = new HashMap<>();

        acctMap.put(new Account(1, "sv"), 1000);
        acctMap.put(new Account(2, "chk"), 1001);

        acctMap.put(new Account(3, "sv"), 1002);

        acctMap.put(new Account(4, "sv4"), 1003);
        acctMap.put(new Account(5, "sv5"), 1004);
        acctMap.put(new Account(6, "sv6"), 1005);
        acctMap.put(new Account(7, "sv7"), 1006);
        acctMap.put(new Account(8, "sv8"), 1007);


        acctMap.put(new Account(280, "sv20008"), 2008);
        acctMap.put(new Account(281, "s210009"), 2009);
        acctMap.put(new Account(282, "sv1200010"), 2010);


        for(Account ac: acctMap.keySet()) {
            System.out.println("Key >>"+ ac + " Value >>>"+ acctMap.get(ac));
        }

    }

}
