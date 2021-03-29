package t4.util;

public enum Work {
    BREAK(new ActivityInfo(
                    "Jour de repos",
                    1,
                    1,
                    -1
        )
    ),
    NORMAL(new ActivityInfo(
            "Jour de travail normal",
            0,
            0,
            0
        )
    ),
    OVERTIME(new ActivityInfo(
            "Faire des heures supplémentaires",
            -1,
            -1,
            1
        )
    )
    ;

    private final ActivityInfo info;

    Work(ActivityInfo info){
        this.info = info;
    }

    public ActivityInfo getInfo() {
        return info;
    }

    public static Work getByName(String name){
        for (int i = 0; i < values().length; i++) {
            Work value = Work.values()[i];
            if(value.getInfo().getName().equals(name))
                return value;
        }
        return null;
    }
}
