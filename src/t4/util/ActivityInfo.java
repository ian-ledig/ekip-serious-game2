package t4.util;

public class ActivityInfo {

    private final String name;
    private final int health;
    private final int happiness;
    private final int money;

    public ActivityInfo(String name, int health, int happiness, int money){
        this.name = name;
        this.health = health;
        this.happiness = happiness;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }
}
