package com.zzerrgg;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarProperties userCarProperties =
                new CarProperties(
                        100,
                        0.7,
                        2
                );

        Car userCar = createCarByProperties(userCarProperties);
        System.out.println("Давно тебя не было в Яндекс.Гонках!");
        System.out.println("Характеристики твоего автомобиля:");
        System.out.println("- Максимальная скорость: " + userCar.getMaxSpeed());
        System.out.println("- Ускорение: " + userCar.getAcceleration());
        System.out.println("- Закись азота: " + userCar.getNitroLevel());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Что выберете?");
            System.out.println("1 - Устроить заезд");
            System.out.println("2 - Показать статистику");
            System.out.println("3 - Закончить игру");
            int command = scanner.nextInt();

            if (command == 1) {
                Car opponentCar = generateOpponentCar();
                System.out.println("Характеристики автомобиля соперника:");
                System.out.println("- Максимальная скорость: " + opponentCar.getMaxSpeed());
                System.out.println("- Ускорение: " + opponentCar.getAcceleration());
                System.out.println("- Закись азота: " + opponentCar.getNitroLevel());

                int distance = generateInt(5, 70);
                System.out.println("Гонка будет проходить на дистанции: " + distance + " км.");

                int points = makeRace(userCar, opponentCar, distance);
                changePointAndDistance(userCar, points, distance);

            } else if (command == 2) {
                System.out.println("- Количество заработанных очков: " + userCar.getScore());
                System.out.println("- Пройдено километров на этом авто: " + userCar.getKilometersTravelled());
            } else if (command == 3) {
                System.out.println("Увидимся!");
                break;
            }
        }
    }

    private static void changePointAndDistance(Car car, int points, int distance) {
        car.setScore(car.getScore() + points);
        car.setKilometersTravelled(car.getKilometersTravelled() + distance);
    }

    private static int makeRace(Car userCar, Car opponentCar, int distance) {
        int zero = 0;
        int penalty = -100;
        printFlag();
        boolean shortRaceWin = (distance <= 15 && userCar.getAcceleration() > opponentCar.getAcceleration());
        boolean longRaceWin = (distance > 50 && userCar.getMaxSpeed() > opponentCar.getMaxSpeed());

        if (shortRaceWin || longRaceWin) {
            System.out.println("Вы выиграли!");
            double maxSpeed = Double.max(userCar.getMaxSpeed(), opponentCar.getMaxSpeed());
            return (int) maxSpeed;
        } else if (userCar.getAcceleration() == opponentCar.getAcceleration()) {
            System.out.println("Ничья!");
            return zero;
        } else {
            if (userCar.getNitroLevel() >= opponentCar.getNitroLevel()) {
                System.out.println("Вы проиграли, но благодаря закиси азота сохранили очки.");
                return zero;
            } else {
                System.out.println("Вы проиграли(");
                return penalty;
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

    private static Car generateOpponentCar() {
        double maxSpeed = generateInt(75, 125);
        double acceleration = generateInt(4, 10) / 10.0;
        int score = 0;
        int nitroLevel = generateInt(1, 5);

        return new Car(
                maxSpeed,
                acceleration,
                score,
                nitroLevel
        );
    }

    private static int generateInt(int from, int to) {
        int diapason = to - from;
        int offence = new Random().nextInt(diapason);
        return from + offence;
    }

    private static Car createCarByProperties(CarProperties carProperties) {
        double maxSpeed = carProperties.getMaxSpeed();
        double acceleration = carProperties.getAcceleration();
        int score = carProperties.getInitialScore();
        int nitroLevel = carProperties.getNitroLevel();

        return new Car(
                maxSpeed,
                acceleration,
                score,
                nitroLevel
        );
    }
}