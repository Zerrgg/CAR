package com.zzerrgg;

public enum Menu {

    START_RACE("1 - Устроить заезд\n", "1"),
    SHOW_STATISTICS("2 - Показать статистику\n", "2"),
    STOP_GAME("3 - Закончить игру\n", "3"),
    DEFAULT("Сделайте ввод соответствующий пунктам меню\n", "-1");
    private static final String WHAT_YOU_CHOOSE = "\nЧто выберете?\n";
    private final String title;

    private final String code;

    Menu(String title, String code) {
        this.title = title;
        this.code = code;
    }

    public void printTitle() {
        System.out.println(this.title);
    }

    public static void print() {
        System.out.println(WHAT_YOU_CHOOSE +
                Menu.START_RACE.title +
                Menu.SHOW_STATISTICS.title +
                Menu.STOP_GAME.title);
    }

    public static Menu getMenuByCod(String code) {
        for (Menu value : Menu.values()) {
            if(value.code.equals(code)){
                return value;
            }
        }
        return null;
    }

    public String getTitle() {
        return title;
    }
}
