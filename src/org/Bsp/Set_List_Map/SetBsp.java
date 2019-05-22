package org.Bsp.Set_List_Map;

import java.util.HashSet;
import java.util.Set;

public class SetBsp {
    private Set<String> set_hash;
    private int numbersOfSomething;

    public SetBsp() {
        // init the Set
        set_hash = new HashSet<>();
        numbersOfSomething = 0;
    }

    public void add() {
        // adds 'something' to the set
        set_hash.add("Something" + numbersOfSomething);
        numbersOfSomething++;
    }

    public void add(String s) {
        // adds the specific string to the set
        set_hash.add(s);
    }

    public void printAll() {
        for (String s: set_hash) {
            System.out.println(s);
        }
    }

    public int size() {
        return set_hash.size();
    }

}
