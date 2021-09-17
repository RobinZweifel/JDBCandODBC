package ch.bbw.rz;

import ch.bbw.rz.dao.DataBaseAccess;
import ch.bbw.rz.dao.DataBaseAccessMDB;
import ch.bbw.rz.dao.DataBaseAccessSQL;
import ch.bbw.rz.model.JokeBook;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {

        //Access
        System.out.println("________Access________");
        System.out.println();
        DataBaseAccess daoMDB = new DataBaseAccessMDB();
        JokeBook jokeBookMDB = new JokeBook(daoMDB);
        jokeBookMDB.print();
        System.out.println();


        //MariaDB
        System.out.println("________Maria DB________");
        System.out.println();
        DataBaseAccess daoSQL = new DataBaseAccessSQL();
        JokeBook jokeBookSQL = new JokeBook(daoSQL);
        jokeBookSQL.print();


    }
}
