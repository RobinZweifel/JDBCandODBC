package ch.bbw.rz.dao;

import ch.bbw.rz.model.Joke;

import java.sql.*;
import java.util.ArrayList;

public class DataBaseAccessSQL implements DataBaseAccess{

    public int jokeId = 4;

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/jokedb", "root", "1234"
        );
    }

    @Override
    public void getAllJokes(ArrayList<Joke> jokes) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = createConnection();
            Statement s = connection.createStatement();

            ResultSet rs = s.executeQuery("SELECT * FROM joke");
            while (rs.next()) {
                Joke joke = JokeFillerSQL.createJokeObject(rs);
                jokes.add(joke);
            }
            rs.close();
            s.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void addJoke(int id) throws SQLException {
        Connection connection = createConnection();
        Statement s = connection.createStatement();

        String sqlAdd = "INSERT INTO joke VALUES ( " + id + ", 'Sagte ein Mann zu seinem Hund...', 3, '2021-09-09')";
        s.executeUpdate(sqlAdd);
        System.out.println("Joke wurde hinzugefügt");
        soutJoke(jokeId);


    }

    @Override
    public void deleteJoke(int id) throws SQLException {
        Connection connection = createConnection();
        Statement s = connection.createStatement();

        String sqlDelete = "DELETE FROM joke WHERE id = " + id;
        System.out.println("Joke deleted");
        s.executeUpdate(sqlDelete);
        s.close();
        connection.close();
    }

    @Override
    public void editJoke(int id) throws SQLException {
        Connection connection = createConnection();
        Statement s = connection.createStatement();

        String sqlEdit = "UPDATE joke SET text = 'Sagte ein Mann zu seinem Hund bla bla bla und lachte' WHERE id = " + id;
        System.out.println("Joke edited");
        s.executeUpdate(sqlEdit);
        soutJoke(jokeId);
        s.close();
        connection.close();
    }

    @Override
    public void soutJoke(int id) throws SQLException {
        Connection connection = createConnection();
        Statement s = connection.createStatement();

        ResultSet rs = s.executeQuery("SELECT * FROM joke WHERE id = " + id);
        while(rs.next()){
            int colId = rs.getInt(1);
            String output = rs.getString(2);
            System.out.println("id: " + colId + " " + output);
        }
    }

    @Override
    public void bdProcess() throws SQLException {
        addJoke(jokeId);
        editJoke(jokeId);
        deleteJoke(jokeId);
    }


}
