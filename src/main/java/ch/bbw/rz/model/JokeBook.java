package ch.bbw.rz.model;

import ch.bbw.rz.dao.DataBaseAccess;
import ch.bbw.rz.dao.JokeFillerSQL;

import java.sql.*;
import java.util.ArrayList;

public class JokeBook {
    private ArrayList<Joke> jokes;

    public JokeBook(DataBaseAccess dao) throws SQLException {
        super();
        jokes = new ArrayList<>();
        dao.getAllJokes(jokes);
        dao.bdProcess();
    }

    public void print(){
        for(Joke i: jokes){
            System.out.println(i.getId());
            System.out.println(i.getText());
        }
    }
}