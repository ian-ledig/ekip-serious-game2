package t4.util;

public enum Home {
    SLEEP(new ActivityInfo(
            "Je suis fatigué, je vais dormir",
            1,
            0,
            0
        )
    ),
    TV(new ActivityInfo(
            "Je vais regarder la télé",
            0,
            1,
            0
        )
    ),
    PLAY_ONLINE(new ActivityInfo(
            "Jouer en ligne avec des amis",
            -1,
            2,
            0
        )
    );

    private final ActivityInfo info;

    Home(ActivityInfo info){
        this.info = info;
    }

    public ActivityInfo getInfo() {
        return info;
    }

    public static Home getByName(String name){
        for (int i = 0; i < values().length; i++) {
            Home value = Home.values()[i];
            if(value.getInfo().getName().equals(name))
                return value;
        }
        return null;
    }
}
