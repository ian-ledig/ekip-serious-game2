package t4.util;

public enum Relaxation {
    HOME(new ActivityInfo(
            "Je reste chez moi",
            0,
            0,
            0
    )
    ),
    BAR(new ActivityInfo(
                    "Bar",
                    -1,
                    4,
                    -2
        )
    ),
    POOL(new ActivityInfo(
            "Piscine",
            1,
            1,
            -1
        )
    ),
    CINEMA(new ActivityInfo(
            "Cinéma",
            0,
            3,
            -2
        )
    )
    ;

    private final ActivityInfo info;

    Relaxation(ActivityInfo info){
        this.info = info;
    }

    public ActivityInfo getInfo() {
        return info;
    }

    public static Relaxation getByName(String name){
        for (int i = 0; i < values().length; i++) {
            Relaxation value = Relaxation.values()[i];
            if(value.getInfo().getName().equals(name))
                return value;
        }
        return null;
    }
}
