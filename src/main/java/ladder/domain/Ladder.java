package ladder.domain;

import ladder.generator.PointGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        validateLadder(lines);
        this.lines = lines;
    }

    private void validateLadder(List<Line> lines) {
        if (isEmpty(lines)) {
            throw new IllegalArgumentException("Line is Empty");
        }
    }

    private boolean isEmpty(List<Line> lines) {
        return lines == null || lines.isEmpty();
    }

    public static Ladder create(int userCount, int height, PointGenerator pointGenerator) {
        return Stream.generate(() -> Line.create(userCount, pointGenerator))
                .limit(height)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Ladder::create));
    }

    public static Ladder create(List<Line> lines) {
        return new Ladder(lines);
    }

    public int height() {
        return this.lines.size();
    }

    public List<Line> lines() {
        return lines;
    }

    public int move(int index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

}
