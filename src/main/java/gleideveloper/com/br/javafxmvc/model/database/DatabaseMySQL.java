package gleideveloper.com.br.javafxmvc.model.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Rafael Vargas Mesquita
 */
public class DatabaseMySQL implements Database {

    private Connection connection;
    private final String URL = "jdbc:mysql://localhost:3306/javafxmodel";
    private final String USERNAME = "root";
    private final String PASSWORD = "gl31d35";


    @Override
    public Connection conectar() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //Class.forName("com.mysql.jdbc.Driver");
            //this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafxmodel", "root","gl31d35");
            return this.connection;

        } catch (SQLException ex) {
            Logger.getLogger(DatabasePostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void desconectar(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabasePostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
