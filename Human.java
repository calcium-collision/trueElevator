package com.company.calcium_collision;

public class Human {
    private int weight;

    Human(){
        weight = (int) (60 +  (Math.random() * 30));
    }

    public int getWeight() {
        return weight;
    }
}
