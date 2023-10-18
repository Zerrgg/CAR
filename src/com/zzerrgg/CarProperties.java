package com.zzerrgg;

public class CarProperties implements Vehicle {
    private double maxSpeed;
    private int initialScore;
    private double acceleration;
    private int nitroLevel;

    public CarProperties(double maxSpeed, double acceleration, int nitroLevel) {
        this.maxSpeed = maxSpeed;
        this.acceleration = acceleration;
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

    @Override
    public int getNitroLevel() {
        return nitroLevel;
    }

    public int getInitialScore() {
        return initialScore;
    }

}