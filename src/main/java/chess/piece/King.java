package chess.piece;

import java.util.ArrayList;
import java.util.List;

import chess.board.Direction;
import chess.board.Square;

public final class King extends Piece {
    private final static String BUG_MESSAGE_COLOR = "[BUG] 킹은 색상을 가져야합니다.";
    private static final String BLACK_KING = "♚";
    private static final String WHITE_KING = "♔";
    private static final List<Direction> DIRECTIONS = new ArrayList<>();

    static {
        DIRECTIONS.add(new Direction(0, 1));
        DIRECTIONS.add(new Direction(0, -1));
        DIRECTIONS.add(new Direction(1, 0));
        DIRECTIONS.add(new Direction(1, -1));
        DIRECTIONS.add(new Direction(1, 1));
        DIRECTIONS.add(new Direction(-1, 0));
        DIRECTIONS.add(new Direction(-1, -1));
        DIRECTIONS.add(new Direction(-1, 1));
    }

    King (Color color) {
        super(color);
    }

    @Override
    public String getEmoji() {
        if(color==Color.NONE){
            throw new IllegalArgumentException(BUG_MESSAGE_COLOR);
        }

        if(color==Color.BLACK){
            return BLACK_KING;
        }

        return WHITE_KING;
    }

    @Override
    public boolean canMove(Square source, Square target) {
        Direction direction = source.getGap(target);
        return direction.hasSame(DIRECTIONS);
    }
}
