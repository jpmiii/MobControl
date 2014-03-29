package com.jpmiii.MobControl;

import org.bukkit.plugin.java.JavaPlugin;



public final class MobControl extends JavaPlugin {
	String worldname = "";
	
	public void onEnable(){
		//getLogger().info("onEnable has been invoked!");
		this.saveDefaultConfig();
		
		getServer().getPluginManager().registerEvents(new MobListener(this), this);
		
        //getServer().getWorld(this.getConfig().getString("worldName")).setMonsterSpawnLimit(this.getConfig().getInt("mobsPerChunk"));
        
        worldname = this.getConfig().getString("worldName");
		
	}
	public void onDisable(){
		getLogger().info("onDisable has been invoked!");
	}

}
