package ch.bbw.rz.dao;

import ch.bbw.rz.model.Joke;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAccessMDB implements DataBaseAccess{

    public int jokeId = 4;

    @Override
    public void getAllJokes(ArrayList<Joke> jokes) throws SQLException {

        try {
            Connection connection = createConnection();
            Statement s = connection.createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM joke");
            while (rs.next()) {
                Joke joke = JokeFillerMDB.createJokeObject(rs);
                jokes.add(joke);
            }
            rs.close();
            s.close();
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:ucanaccess://C:/db/JokeDB.accdb"
        );
    }

    @Override
    public void addJoke(int id) throws SQLException {
        Connection connection = createConnection();
        Statement s = connection.createStatement();

        try {
            String sqlAdd = "INSERT INTO joke VALUES ( " + id + ", 'Sagte ein Mann zu seinem Hund...', 3, #2015-01-04#)";
            s.executeUpdate(sqlAdd);
            System.out.println("Joke added");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("FAILED");
        }
    }

    @Override
    public void deleteJoke(int id) throws SQLException {
        Connection connection = createConnection();
        Statement s = connection.createStatement();

        String sqlDelete = "DELETE FROM joke WHERE jokeId = " + id;
        System.out.println("Joke deleted");
        s.executeUpdate(sqlDelete);
        s.close();
        connection.close();
    }

    @Override
    public void editJoke(int id) throws SQLException {
        Connection connection = createConnection();
        Statement s = connection.createStatement();

        String sqlEdit = "UPDATE joke SET content = 'Sagte ein Mann zu seinem Hund bla bla bla und lachte' WHERE jokeId = " + id;
        System.out.println("Joke edited");
        s.executeUpdate(sqlEdit);
        s.close();
        connection.close();
    }

    @Override
    public void soutJoke(int id) throws SQLException {
        Connection connection = createConnection();
        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT * FROM joke WHERE jokeId = " + id);
        while(rs.next()){
            int colId = rs.getInt(1);
            String output = rs.getString(2);
            System.out.println("id: " + colId + " " + output);
        }
    }

    @Override
    public void bdProcess() throws SQLException {
        addJoke(jokeId);
        soutJoke(jokeId);
        editJoke(jokeId);
        soutJoke(jokeId);
        deleteJoke(jokeId);
    }
}
