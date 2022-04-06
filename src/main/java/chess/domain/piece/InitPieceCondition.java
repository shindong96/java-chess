package chess.domain.piece;

import chess.domain.position.File;
import chess.domain.position.Rank;

public final class InitPieceCondition {

    private final File file;
    private final Rank rank;

    InitPieceCondition(File file, Rank rank) {
        this.file = file;
        this.rank = rank;
    }

    boolean isKing() {
        return file == File.E && isNotPawnOrNone();
    }

    boolean isQueen() {
        return file == File.D && isNotPawnOrNone();
    }

    boolean isRook() {
        return (file == File.A || file == File.H) && isNotPawnOrNone();
    }

    boolean isBishop() {
        return (file == File.C || file == File.F) && isNotPawnOrNone();
    }

    boolean isKnight() {
        return (file == File.B || file == File.G) && isNotPawnOrNone();
    }

    private boolean isNotPawnOrNone() {
        return rank == Rank.ONE || rank == Rank.EIGHT;
    }

    boolean isPawn() {
        return rank == Rank.TWO || rank == Rank.SEVEN;
    }

    boolean isNone() {
        return rank == Rank.THREE || rank == Rank.FOUR || rank == Rank.FIVE || rank == Rank.SIX;
    }
}
