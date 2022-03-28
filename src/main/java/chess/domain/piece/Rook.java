package chess.domain.piece;

import java.util.List;

import chess.domain.position.Direction;

public final class Rook extends Piece {
	private static final String BUG_MESSAGE_COLOR = "[BUG] 룩은 색상을 가져야합니다.";
	private static final String WHITE_ROOK = "♜";
	private static final String BLACK_ROOK = "♖";
	private static final List<Direction> MOVABLE_DIRECTIONS = List.of(
		new Direction(1, 0),
		new Direction(0, 1),
		new Direction(-1, 0),
		new Direction(0, -1)
	);

	Rook(Color color) {
		super(color, 5);
	}

	@Override
	public String getEmoji() {
		if (color == Color.NONE) {
			throw new IllegalArgumentException(BUG_MESSAGE_COLOR);
		}

		if (color == Color.BLACK) {
			return BLACK_ROOK;
		}

		return WHITE_ROOK;
	}

	@Override
	public boolean canMove(Direction direction, Piece target) {
		checkSameTeam(target);
		return direction.hasMultiple(MOVABLE_DIRECTIONS);
	}
}
