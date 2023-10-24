package com.zzerrgg;

public class Car implements Vehicle {
    private int maxSpeed;
    private double acceleration;
    private int score;
    private int kilometersTravelled;
    private int nitroLevel;

    public Car(int maxSpeed, double acceleration, int score, int nitroLevel) {
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.score = score;
        this.nitroLevel = nitroLevel;
    }

    @Override
    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public double getAcceleration() {
        return acceleration;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getKilometersTravelled() {
        return kilometersTravelled;
    }

    public void setKilometersTravelled(int kilometersTravelled) {
        this.kilometersTravelled = kilometersTravelled;
    }

    @Override
    public int getNitroLevel() {
        return nitroLevel;
    }

}