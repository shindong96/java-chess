package chess.domain.piece;

import java.util.List;

import chess.domain.position.Direction;

public final class King extends Piece {
	private final static String BUG_MESSAGE_COLOR = "[BUG] 킹은 색상을 가져야합니다.";
	private static final String WHITE_KING = "♚";
	private static final String BLACK_KING = "♔";
	private static final List<Direction> MOVABLE_DIRECTIONS = List.of(
		new Direction(0, 1),
		new Direction(0, -1),
		new Direction(1, 0),
		new Direction(1, -1),
		new Direction(1, 1),
		new Direction(-1, 0),
		new Direction(-1, -1),
		new Direction(-1, 1)
	);

	King(Color color) {
		super(color, 0);
	}

	@Override
	public String getEmoji() {
		if (color == Color.NONE) {
			throw new IllegalArgumentException(BUG_MESSAGE_COLOR);
		}

		if (color == Color.BLACK) {
			return BLACK_KING;
		}

		return WHITE_KING;
	}

	@Override
	public boolean canMove(Direction direction, Piece target) {
		checkSameTeam(target);
		return direction.hasSame(MOVABLE_DIRECTIONS);
	}

	@Override
	public boolean isKing() {
		return true;
	}
}
