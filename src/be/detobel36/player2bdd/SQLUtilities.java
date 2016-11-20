/*
* Fichier créé par https://github.com/chaseoes
* (Peut être légérement modifié par mes soins (je sais plus xD))
*/
package be.detobel36.player2bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLUtilities {
    
    static SQLUtilities instance = new SQLUtilities();
    private static Player2Bdd plugin;
    private Connection conn;
    private boolean connected = false;
    
    public void setup(Player2Bdd p) {
        plugin = p;
        
        plugin.getProxy().getScheduler().runAsync(plugin, new Runnable() {
            @Override
            public void run() {
                String username = plugin.getConfig().getString("SQL.username");
                String password = plugin.getConfig().getString("SQL.password");
                String url = "jdbc:mysql://" + plugin.getConfig().getString("SQL.hostname") + ":" +
                        plugin.getConfig().getInt("SQL.port") + "/" + plugin.getConfig().getString("SQL.database_name") +
                        "?autoReconnect=true";
                String tableName = plugin.getConfig().getString("SQL.table_name");
                
                try {
                    conn = DriverManager.getConnection(url, username, password);
                    Statement st = conn.createStatement();
                    
                    
                    // Création de la table si elle n'existe pas
                    String table = "CREATE TABLE IF NOT EXISTS `" + tableName + "` ("
                            + "`uuid` varchar(255) NOT NULL, " // uuid
                            + "`pseudo` varchar(255) NOT NULL, " // pseudo
                            + "`ip` varchar(255) NOT NULL DEFAULT '0.0.0', " // ip
                            + "PRIMARY KEY (`uuid`))";
                    st.executeUpdate(table);
                    connected = true;
                } catch (SQLException e) {
                    connected = false;
                    plugin.getLogger().log(Level.SEVERE, "Could not connect to database! "
                            + "Verify your database details in the configuration are correct.");
                    plugin.getLogger().info(e.getMessage());
                }
            }
        });
    }
    
    public void execUpdate(String statement) {
        if (!this.connected) {
            setup(plugin);
            return;
        }
        
        try {
            if(conn.isClosed()) {
                setup(plugin);
                return;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SQLUtilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Statement st = conn.createStatement(1005, 1008);
            st.executeUpdate(statement);
        } catch (SQLException e) {
            plugin.getLogger().info(e.getMessage());
        }
    }
    
    /////////////////////////// STATIC ///////////////////////////
    public static SQLUtilities getUtilities() {
        return instance;
    }
    
}
