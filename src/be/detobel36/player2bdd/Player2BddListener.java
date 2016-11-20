/*
 * Copyright (C) 2016 Detobel36.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package be.detobel36.player2bdd;

import net.md_5.bungee.api.connection.PendingConnection;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * 
 * @author Detobel36
 */
public class Player2BddListener implements Listener {
    
    private static final Player2Bdd plugin = Player2Bdd.getInstance();
    
    @EventHandler
    public void onPlayerLogin(LoginEvent event) {
        PendingConnection con = event.getConnection();
        String uuid = con.getUniqueId().toString();
        String ip = con.getAddress().getAddress().toString().trim().split("/")[1];
        
        String tableName = plugin.getConfig().getString("SQL.table_name");
        
        String requete = ("REPLACE INTO " + tableName + "(uuid, pseudo, ip) VALUES("
                + "'" + uuid + "', "
                + "'" + con.getName() + "', "
                + "'" + ip + "')");
        SQLUtilities.getUtilities().execUpdate(requete);
    }
    
}
