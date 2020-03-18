package springbook.user.domain;

public enum Level {
    GOLD(3, null), SILVER(2, GOLD), BASIC(1, SILVER);

    private final int value;
    private final Level nextValue;

    Level(int value, Level nextValue) {
        this.value = value;
        this.nextValue = nextValue;
    }

    public int intValue() {
        return value;
    }

    public Level nextLevel() {
        return nextValue;
    }

    public static Level valueOf(int value) {
        switch (value) {
            case 1 : return BASIC;
            case 2 : return SILVER;
            case 3 : return GOLD;
            default : throw new AssertionError("Unknown Value : " + value);
        }
    }
}
