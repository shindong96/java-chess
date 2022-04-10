package chess.domain;

import static chess.TestUtils.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import chess.domain.piece.Color;
import chess.domain.piece.Piece;
import chess.domain.position.Square;

public class ResultTest {

    @Test
    @DisplayName("룩1, 비숍1, 퀸1, 폰1 가 있으면 18점을 반환한다")
    void getStatus_rook1_bishop1_queen1_pawn1() {
        Map<Square, Piece> board = createBlankBoard();
        board.put(new Square("c3"), WHITE_QUEEN);
        board.put(new Square("c4"), WHITE_ROOK);
        board.put(new Square("c5"), WHITE_BISHOP);
        board.put(new Square("c6"), WHITE_PAWN);
        Board chessBoard = new Board(board);
        Result result = new Result(chessBoard);

        assertThat(result.calculateScore(Color.WHITE)).isEqualTo(18);
    }

    @Test
    @DisplayName("같은 세로줄에 폰이 2개가 있을 때 1점을 반환한다")
    void getStatus_pawn2_sameFile() {
        Map<Square, Piece> board = createBlankBoard();
        board.put(new Square("c5"), WHITE_PAWN);
        board.put(new Square("c6"), WHITE_PAWN);
        Board chessBoard = new Board(board);
        Result result = new Result(chessBoard);

        assertThat(result.calculateScore(Color.WHITE)).isEqualTo(1);
    }

    @Test
    @DisplayName("룩1, 비숍1, 퀸1, 폰3 가 있으면 18.5점을 반환한다(폰 3개가 같은 세로줄에 있다)")
    void getStatus_rook1_bishop1_queen1_pawn3() {
        Map<Square, Piece> board = createBlankBoard();
        board.put(new Square("c3"), WHITE_QUEEN);
        board.put(new Square("b4"), WHITE_ROOK);
        board.put(new Square("a5"), WHITE_BISHOP);
        board.put(new Square("c6"), WHITE_PAWN);
        board.put(new Square("c5"), WHITE_PAWN);
        board.put(new Square("c4"), WHITE_PAWN);
        Board chessBoard = new Board(board);
        Result result = new Result(chessBoard);

        assertThat(result.calculateScore(Color.WHITE)).isEqualTo(18.5);
    }
}
