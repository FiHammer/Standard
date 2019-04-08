package org.Test.Test;

import java.util.ArrayList;

public class Raum<dataType> {
    private ArrayList<dataType> content;

    public Raum() {
        this.content = new ArrayList<>();
    }
    public Raum(ArrayList<dataType> content1) {
        this.content = content1;
    }

    /**
     * adds a thing to the room
     * @param data the data for the room
     *
     */
    public void add(dataType data) {
        this.content.add(data);
    }

    public int getLength() {
        return content.size();
    }


    public void timeIsGone() {
        this.timeIsGone(1);
    }

    public void timeIsGone(int time) {
        for (int i=0; i<time; i++) {
            for (dataType myOb : this.content) {
                try {
                    System.out.println(myOb);
                    //myOb.doWork();
                } catch (Exception e) {
                    System.out.println("Unsupported Class");
                }
            }
        }
    }

}
