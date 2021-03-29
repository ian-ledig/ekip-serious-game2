package t4.util;

public enum Health {
    NOTHING(new ActivityInfo(
            "Tout va bien",
            0,
            0,
            0
        )
    ),
    ANTI_STRESS(new ActivityInfo(
                    "Prendre un médicament apaisant",
                    1,
                    1,
                    -1
        )
    ),
    DOCTOR(new ActivityInfo(
            "Aller chez le médecin",
            3,
            1,
            -2
        )
    )
    ;

    private final ActivityInfo info;

    Health(ActivityInfo info){
        this.info = info;
    }

    public ActivityInfo getInfo() {
        return info;
    }

    public static Health getByName(String name){
        for (int i = 0; i < values().length; i++) {
            Health value = Health.values()[i];
            if(value.getInfo().getName().equals(name))
                return value;
        }
        return null;
    }
}
