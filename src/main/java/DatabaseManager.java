/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 2417127
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DatabaseManager {
    private static DatabaseManager instance; 
    private Connection connection; 

    // Informations de connexion à la base de données
    private static final String URL = "jdbc:mysql://localhost:3306/garage"; // Remplacez "bibliotheque" par le nom de votre base
    private static final String USER = "cel"; // Nom d'utilisateur MySQL
    private static final String PASSWORD = ""; // Mot de passe MySQL (vide par défaut)

    /**
     * Constructeur privé pour empêcher l'instanciation externe.
     */
    private DatabaseManager() {
        try {
            // Établir la connexion
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connexion reussie a la bd!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }
    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            // Vérifiez si la connexion est fermée, reconnectez si nécessaire
            if (connection == null || connection.isClosed()) {
                
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermee avec succes !");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
