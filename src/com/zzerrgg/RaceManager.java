package com.zzerrgg;

import java.util.Random;

import static com.zzerrgg.Constants.*;

public class RaceManager {
    RaceInformationManager informationManager = new RaceInformationManager();

    Random random = new Random();

    public void startRace(Race race) {
        preparingForTheRace(race);
        System.out.println(RACE_START);
        int points = race.logicOfTheRace();
        changePointAndDistance(race.getYourCar(), points, race.getDistance());
        System.out.println(RACE_END);
        Menu.print();
    }

    private void preparingForTheRace(Race race){
        race.setOpponentCar(generateCar());
        System.out.println(RACE_PREPARING);
        int distance = generateInt(DISTANCE_FROM, DISTANCE_TO);
        race.setDistance(distance);
        informationManager.displayRaceInformation(race);
    }

    private void changePointAndDistance(Car car, int points, int distance) {
        car.setScore(car.getScore() + points);
        car.setKilometersTravelled(car.getKilometersTravelled() + distance);
    }

    public Car generateCar() {
        int maxSpeed = generateInt(SPEED_FROM, SPEED_TO);
        double acceleration = generateInt(ACCELERATION_FROM, ACCELERATION_TO) / ACCELERATION_DIVIDER;
        int nitroLevel = generateInt(NITRO_LEVEL_FROM, NITRO_LEVEL_TO);

        return new Car(
                maxSpeed,
                acceleration,
                ZERO_POINTS,
                nitroLevel
        );
    }

    public int generateInt(int from, int to) {
        int diapason = to - from;
        int offence = random.nextInt(diapason);
        return from + offence;
    }
}
