package ladder.domain;

import java.util.Objects;

public class User {
    public static final int MAXIMUM_USER_NAME_LENGTH = 5;
    private final String name;

    private User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAXIMUM_USER_NAME_LENGTH) {
            throw new IllegalArgumentException("참여자 이름은 최대 5글자 입니다.");
        }
    }

    public static User create(String name) {
        return new User(name);
    }

    public String name() {
        return this.name;
    }

}
