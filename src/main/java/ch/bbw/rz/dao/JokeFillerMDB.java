package ch.bbw.rz.dao;

import ch.bbw.rz.model.Joke;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JokeFillerMDB {
    private static void fillJoke(Joke joke, ResultSet entry) throws SQLException {
        joke.setupJoke(
                entry.getInt("jokeid"),
                entry.getString("content"),
                entry.getDate("date"),
                entry.getInt("rating")
        );
    }

    public static Joke createJokeObject(ResultSet entry) throws SQLException{
        Joke joke = new Joke();
        fillJoke(joke, entry);
        return joke;
    }
}
