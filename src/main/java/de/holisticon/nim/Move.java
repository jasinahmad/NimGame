package de.holisticon.nim;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Move {

    @NotNull
    @Min(value = 1, message="Number of objects to take must be at least {value}")
    @Max(value = 3, message="Number of objects to take must not be higher than {value}")
    private int numberOfTakenObjects;

    public Move(){
    }

    public int getNumberOfTakenObjects() {
        return numberOfTakenObjects;
    }

    public void setNumberOfTakenObjects(int numberOfTakenObjects) {
        this.numberOfTakenObjects = numberOfTakenObjects;
    }
}
