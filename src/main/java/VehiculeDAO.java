/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 2417127
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehiculeDAO {
    private Connection connection;
    //private List<EmployeObserver> observers; // Liste des observateurs

    public VehiculeDAO() {
        this.connection = DatabaseManager.getInstance().getConnection();
}
    /**
     *
     * @param id
     * @param marque
     * @param modele
     * @param annee
     * @param proprietaire
     */
    public void ajouterVehicule(int id, String marque, String modele, int annee, String proprietaire) {
        String query = "INSERT INTO vehicule (id, marque, modele, annee, proprietaire) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, marque);
            stmt.setString(3, modele);
            stmt.setInt(4, annee);
            stmt.setString(5, proprietaire);

            stmt.executeUpdate();
            System.out.println("Vehicule ajouté avec succès !");
            //notifyObservers(); // Notifier les observateurs
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lire tous les vehicules
    public List<Object[]> lireVehicule() {
        List<Object[]> vehicules = new ArrayList<>();
        String query = "SELECT * FROM employes";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                vehicules.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("marque"),
                    rs.getString("modele"),
                    rs.getInt("annee"),
                    rs.getString("proprietaire"),
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicules;
    }

    // Modifier un vehicule
    public void modifierVehicule(int id, String marque, String modele, int annee, String proprietaire) {
        String query = "UPDATE vehicules SET marque = ?, modele = ?, annee = ?, proprietaire = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, marque);
            stmt.setString(3, modele);
            stmt.setInt(4, annee);
            stmt.setString(5, proprietaire);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Vehicule modifié avec succès !");
                //notifyObservers(); // Notifier les observateurs
            } else {
                System.out.println("Aucun Vehicule trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
// Supprimer un employé
    public void supprimerVehicule(int id) {
        String query = "DELETE FROM vehicule WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Vehicule supprimé avec succès !");
                //notifyObservers(); // Notifier les observateurs
            } else {
                System.out.println("Aucun vehicule trouvé avec cet ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public List<Object[]> rechercherVehicule(String nomPosteRecherche) {
    List<Object[]> vehicules = new ArrayList<>();
    String query = "SELECT * FROM vehicules WHERE nom LIKE ? OR poste LIKE ?";
    try (PreparedStatement stmt = connection.prepareStatement(query)) {
        // Ajouter des caractères génériques pour rechercher des titres partiels
        stmt.setString(1, "%" + nomPosteRecherche + "%");
        stmt.setString(2, "%" + nomPosteRecherche + "%");


        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Ajouter les données des vehicules trouvés dans la liste
                vehicules.add(new Object[]{
                    rs.getInt("id"),
                    rs.getString("marque"),
                    rs.getString("modele"),
                    rs.getInt("annee"),
                    rs.getString("proprietaire"),    
                });
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return vehicules;
}
}
