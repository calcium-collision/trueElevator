package com.company.calcium_collision;



public class Main {

    public static void main(String[] args) {
        Human pers1 = new Human();
        Elevator elevator = new Elevator(25,800,8);
        elevator.callElevator(12);
        elevator.enterTheElevator(pers1);
        elevator.callElevator(16);
        elevator.getOffTheElevator(pers1);
    }
}
