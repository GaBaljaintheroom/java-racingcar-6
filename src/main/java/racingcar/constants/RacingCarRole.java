package racingcar.constants;

public enum RacingCarRole {

    MAX_CAR_NAME_LENGTH(5),
    MOVING_CONDITION(4),
    MIN_CARS_COUNT(2),
    NEXT_POSITION(1),
    END_ATTEMPT_NUMBER(0);

    private final int value;

    RacingCarRole(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}