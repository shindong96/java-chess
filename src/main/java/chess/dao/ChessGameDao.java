package chess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import chess.domain.ChessGame;
import chess.domain.piece.Color;

public class ChessGameDao {

    public void save(ChessGame game, int board_id, Connection connection) {
        final String sql = "insert into chessGame (board_id,turn) values (?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, board_id);
            statement.setString(2, game.getTurn());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnector.closeDB(connection, statement);
    }

    public ChessGame find(int board_id, Connection connection) {
        final String sql = "select board_id, turn from chessGame where board_id = ?";
        ChessGame chessGame = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, board_id);
            resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return null;
            }
            chessGame = new ChessGame(
                new BoardDao().findAllPiecesOfBoard(board_id, DBConnector.getConnection()),
                Color.getColor(resultSet.getString("turn"))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnector.closeDB(connection, statement, resultSet);
        return chessGame;
    }

    public void update(ChessGame game, int board_id, Connection connection) {
        final String sql = "update chessGame SET turn = ? where board_id = ?";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, game.getTurn());
            statement.setInt(2, board_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnector.closeDB(connection, statement);
    }

    public void remove(int board_id, Connection connection) {
        final String sql = "delete from chessGame where board_id = ?";
        PreparedStatement statement = null;
        try {
            new BoardDao().remove(board_id, DBConnector.getConnection());
            statement = connection.prepareStatement(sql);
            statement.setInt(1, board_id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBConnector.closeDB(connection, statement);
    }
}