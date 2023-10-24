package com.zzerrgg;

import static com.zzerrgg.Constants.*;

public class RaceInformationManager {

    public void carInformation(Race race, String string) {
        if (string.equals(YOUR_CAR)) {
            System.out.println(YOUR_CAR);
            System.out.println(MAX_SPEED + race.getYourCar().getMaxSpeed());
            System.out.println(ACCELERATION + race.getYourCar().getAcceleration());
            System.out.println(NITRO_LEVEL + race.getYourCar().getNitroLevel());
        } else {
            System.out.println(OPPONENT_CAR);
            System.out.println(MAX_SPEED + race.getOpponentCar().getMaxSpeed());
            System.out.println(ACCELERATION + race.getOpponentCar().getAcceleration());
            System.out.println(NITRO_LEVEL + race.getOpponentCar().getNitroLevel());
        }
    }

    public void displayRaceInformation(Race race) {

        System.out.println(RACE_INFORMATION);
        System.out.println(RACE_DISTANCE + race.getDistance() + KM);
        carInformation(race, YOUR_CAR);
        carInformation(race, OPPONENT_CAR);
    }
}