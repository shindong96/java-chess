package chess.domain.position;

import java.util.Arrays;

public enum File {
    A("a", 1),
    B("b", 2),
    C("c", 3),
    D("d", 4),
    E("e", 5),
    F("f", 6),
    G("g", 7),
    H("h", 8);

    private static final String ERROR_MESSAGE_BOUND = "[ERROR] 체스판 범위를 벗어났습니다.";
    private final String value;
    private final int index;

    File(String value, int i) {
        this.value = value;
        this.index = i;
    }

    public static File find(String value) {
        return Arrays.stream(values())
                .filter(file -> file.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_BOUND));
    }

    public int getGap(File target) {
        return target.index - this.index;
    }

    public String getValue() {
        return value;
    }

    public File add(int dFile) {
        return Arrays.stream(values())
                .filter(file -> file.index == this.index + dFile)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_BOUND));
    }
}