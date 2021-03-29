package t4.util;

public enum Extra {
    SAVE(new ActivityInfo(
            "Économiser",
            0,
            1,
            0
        )
    ),
    GIVE(new ActivityInfo(
            "Donner à un sans-abri",
            0,
            2,
            -1
        )
    ),
    RESTAURANT(new ActivityInfo(
            "Aller au restaurant",
            1,
            2,
            -2
        )
    );

    private final ActivityInfo info;

    Extra(ActivityInfo info){
        this.info = info;
    }

    public ActivityInfo getInfo() {
        return info;
    }

    public static Extra getByName(String name){
        for (int i = 0; i < values().length; i++) {
            Extra value = Extra.values()[i];
            if(value.getInfo().getName().equals(name))
                return value;
        }
        return null;
    }
}
