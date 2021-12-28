package com.company.calcium_collision;

import java.util.Arrays;

public class Elevator {

    private DoorStatus doorStatus = DoorStatus.CLOSE;
    private final int highestFloor;
    private int currentFloor = 1;
    private final int maxLoadKg;
    private int currentLoadKg;
    private final int capacity;
    private int occupiedPlaces = 0;
    private Human[] elevatorStorage;

    Elevator(int highestFloor, int maxLoadKg, int capacity){
        this.highestFloor = highestFloor;
        this.maxLoadKg = maxLoadKg;
        this.capacity = capacity;
        this.elevatorStorage = new Human[capacity];
    }

    public boolean closeDoor(){
        if (doorStatus == DoorStatus.OPEN){
            doorStatus = DoorStatus.CLOSE;
            return true;
        } else {
            return false;
        }
    }

    public boolean openDoor(){
        if (doorStatus == DoorStatus.CLOSE){
            doorStatus = DoorStatus.OPEN;
            return true;
        } else {
            return false;
        }
    }

    public boolean enterTheElevator(Human person){
        if (occupiedPlaces + 1 > capacity){
            return false;
        }
        if (currentLoadKg + person.getWeight() > maxLoadKg){
            return false;
        }
        openDoor();
        occupiedPlaces++;
        currentLoadKg += person.getWeight();
        elevatorStorage[occupiedPlaces-1] = person;
        closeDoor();

        return true;
    }

    public boolean getOffTheElevator(Human person){
        if (!humanInElevator(person)){
            return false;
        }
        openDoor();
        deleteFromArray(person);
        occupiedPlaces--;
        currentLoadKg -= person.getWeight();
        closeDoor();
        return true;
    }

    public void callElevator(int targetFloor){
        if (targetFloor < 1 || targetFloor > highestFloor){
            return;
        }
        if (currentFloor > targetFloor){
            currentFloor--;
            callElevator(targetFloor);
        } else if (currentFloor < targetFloor){
            currentFloor++;
            callElevator(targetFloor);
        } else {
            return;
        }
    }

    private void deleteFromArray(Human object){
        Human[] tempArray = new Human[capacity];
        int indexTemp = 0;
        for (int p=0; p < 8; p++){
            if (elevatorStorage[p] != object){
                tempArray[indexTemp++] = elevatorStorage[p];
            }
        }
        elevatorStorage = tempArray;
    }


    private boolean humanInElevator(Human person){
        boolean contains = Arrays.asList(elevatorStorage).contains(person);
        return contains;
    }

    public Human[] getElevatorStorage() {
        System.out.println(currentFloor + "current floor");
        System.out.println(currentLoadKg + "load kg");
        System.out.println(occupiedPlaces + "occupied places");
        return elevatorStorage;
    }
}
