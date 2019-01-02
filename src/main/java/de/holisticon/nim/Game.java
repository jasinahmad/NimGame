package de.holisticon.nim;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Game {

    @NotNull(message = "Id can't be null")
    private Long id;

    @NotNull(message = "Size of heap can't be null")
    @Min(value = 1, message = "Size of heap must be at least {value}")
    private int heapSize;

    @NotNull(message = "Status can't be null")
    private Status status = Status.OPEN;

    private String winner;

    public void Game(){
    }

    public Game(Long id, int heapSize) {
        this.id = id;
        this.heapSize = heapSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
