package com.zzerrgg;

import static com.zzerrgg.Constants.*;

public class Race {

    private Car yourCar;
    private Car opponentCar;
    private int distance;

    public Car getYourCar() {
        return yourCar;
    }

    public void setYourCar(Car yourCar) {
        this.yourCar = yourCar;
    }

    public Car getOpponentCar() {
        return opponentCar;
    }

    public void setOpponentCar(Car opponentCar) {
        this.opponentCar = opponentCar;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void printRaceResults() {
        System.out.println(RACES_RESULT);
        System.out.println(YOUR_POINTS_AFTER_RACE + yourCar.getScore());
        System.out.println(KILOMETERS_TRAVELED_ON_THIS_CAR + yourCar.getKilometersTravelled());
    }

    public int logicOfTheRace() {
        printFlag();
        boolean shortRaceWin = (distance <= SHORT_DISTANCE && yourCar.getAcceleration() > opponentCar.getAcceleration());
        boolean longRaceWin = (distance > LONG_DISTANCE && yourCar.getMaxSpeed() > opponentCar.getMaxSpeed());

        if (shortRaceWin || longRaceWin) {
            System.out.println(YOU_WON);
            double maxSpeed = Math.max(yourCar.getMaxSpeed(), opponentCar.getMaxSpeed());
            return (int) maxSpeed;
        } else if (yourCar.getAcceleration() == opponentCar.getAcceleration()) {
            System.out.println(DRAW);
            return ZERO_POINTS;
        } else {
            if (yourCar.getNitroLevel() >= opponentCar.getNitroLevel()) {
                System.out.println(YOU_LOST_BUT_SAVED_POINTS);
                return ZERO_POINTS;
            } else {
                System.out.println(YOU_LOST);
                return PENALTY_POINTS;
            }
        }
    }

    private static void printFlag() {
        System.out.println("_\n" +
                "\\'-,,.\n" +
                " \\    \\\n" +
                "  \\-..,\\\n" +
                "   \\\n" +
                "    \\\n");
    }

}
