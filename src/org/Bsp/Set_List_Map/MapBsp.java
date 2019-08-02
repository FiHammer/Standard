package org.Bsp.Set_List_Map;

import java.util.ArrayList;
import java.util.HashMap;

public class MapBsp {
    private HashMap<ArrayList<Integer>, ArrayList<String>> hm;
    private ArrayList<Integer> arrInt;
    public MapBsp() {
        // init the Map

        hm = new HashMap<>();
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Date 1");
        arrInt = new ArrayList<>();
        arrInt.add(7);

        hm.put(arrInt, new ArrayList<>());
        hm.put(new ArrayList<Integer>(4), arr);

        /*

        {
        "string": [1,2,"h",5]
        }

        */

    }

    public void doWork() {
        System.out.println(hm.get(arrInt));
    }
}
