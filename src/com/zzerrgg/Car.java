package com.zzerrgg;

public class Car implements Vehicle {
    private double maxSpeed;
    private double acceleration;
    private int score;
    private double kilometersTravelled;
    private int nitroLevel;

    public Car(double maxSpeed, double acceleration, int score, int nitroLevel) {
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
        this.score = score;
        this.nitroLevel = nitroLevel;
    }

    @Override
    public double getMaxSpeed() {
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

    public double getKilometersTravelled() {
        return kilometersTravelled;
    }

    public void setKilometersTravelled(double kilometersTravelled) {
        this.kilometersTravelled = kilometersTravelled;
    }

    @Override
    public int getNitroLevel() {
        return nitroLevel;
    }

}