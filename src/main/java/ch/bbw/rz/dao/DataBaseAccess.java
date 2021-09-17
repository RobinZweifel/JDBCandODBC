package ch.bbw.rz.dao;

import ch.bbw.rz.model.Joke;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DataBaseAccess {
    void getAllJokes(ArrayList<Joke> jokes) throws SQLException;

    void addJoke(int id)throws SQLException;

    void deleteJoke(int id)throws SQLException;

    void editJoke(int id) throws SQLException;

    void soutJoke(int id) throws SQLException;

    void bdProcess() throws SQLException;

    Connection createConnection() throws SQLException;

}
