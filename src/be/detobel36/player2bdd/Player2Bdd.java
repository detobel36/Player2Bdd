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

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;

/**
 *
 * @author Detobel36
 */
public class Player2Bdd extends Plugin {

    private BungeeConfig config;
    private static Player2Bdd instance;
    
    @Override
    public void onEnable() {
        instance = this;
        
        initConfig();
        SQLUtilities.getUtilities().setup(this);
        getProxy().getPluginManager().registerListener(this, new Player2BddListener());
    }
    
    public static Player2Bdd getInstance() {
        return instance;
    }
    
    // Config
    private void initConfig() {
        config = new BungeeConfig(this);
    }
    
    public Configuration getConfig() {
        return config.getConfig();
    }
    
}
