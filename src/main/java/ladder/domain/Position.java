package ladder.domain;

import java.util.Objects;

public class Position {
    private final int position;

    private Position(int position) {
        validatePositive(position);
        this.position = position;
    }

    private void validatePositive(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치값은 음수일 수 없습니다.");
        }
    }

    public static Position create(int position) {
        return new Position(position);
    }

    public int moveToRight() {
        return this.position + 1;
    }

    public int moveToLeft() {
        return this.position - 1;
    }

    public int position() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
