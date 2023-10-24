package com.zzerrgg;

import java.util.Scanner;

import static com.zzerrgg.Constants.*;
import static com.zzerrgg.Menu.*;

public class Game {
    Race race = new Race();
    RaceManager raceManager = new RaceManager();
    RaceInformationManager informationManager = new RaceInformationManager();

    public void start() {
        System.out.println(HELLO);
        race.setYourCar(raceManager.generateCar());
        informationManager.carInformation(race, YOUR_CAR);
        Menu.print();
        loop();
    }

    private void loop() {
        Scanner scanner = new Scanner(System.in);
        boolean isGameStart = true;

        while (isGameStart) {
            String playerChoice = scanner.nextLine();
            Menu menuByCod = Menu.getMenuByCod(playerChoice);

            if (menuByCod == null) {
                menuByCod = DEFAULT;
            }

            switch (menuByCod) {
                case START_RACE:
                    raceManager.startRace(race);
                    break;
                case SHOW_STATISTICS:
                    race.printRaceResults();
                    Menu.print();
                    break;
                case STOP_GAME:
                    System.out.println(SEE_YOU);
                    isGameStart = false;
                    break;
                case DEFAULT:
                default:
                    DEFAULT.printTitle();
            }
        }
    }
}
