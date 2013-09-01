package com.jpmiii.MobControl;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import com.jpmiii.MobControl.MobControl;

public class MobListener implements Listener{
	private MobControl plugin;
	

    public MobListener(MobControl plugin) {
    	this.plugin = plugin;
	}
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void spawn(CreatureSpawnEvent event) {
    	Location el = event.getLocation();
    	SpawnReason sr = event.getSpawnReason();
    	EntityType et = event.getEntity().getType();
    	if (el.getWorld().getName().equalsIgnoreCase(plugin.getConfig().getString("worldName"))){
    		
    		//if(sr == SpawnReason.NATURAL || sr == SpawnReason.DEFAULT || sr == SpawnReason.CHUNK_GEN) {
    			

    	        if (et == EntityType.CREEPER || et == EntityType.ENDERMAN || 
    	        		et == EntityType.SPIDER || et == EntityType.SKELETON ||
    	        		et == EntityType.ZOMBIE) {
    	        	if (el.getY() > 55 || el.getBlock().getLightLevel() > 9) {
		                event.setCancelled(true);
		            }
    	        	


     		  //  }   	   
    	        }
    	        if ((sr != SpawnReason.BREEDING && sr != SpawnReason.SPAWNER_EGG) && (et == EntityType.CHICKEN ||
    	        		et == EntityType.COW ||
    	        		et == EntityType.HORSE ||
    	        		et == EntityType.MUSHROOM_COW ||
    	        		//et == EntityType.OCELOT ||
    	        		//et == EntityType.WOLF ||
    	        		et == EntityType.PIG ||
    	        		et == EntityType.SHEEP)){
    	        	event.setCancelled(true);
    	        }
    	        
    	    
    	}
    	if (et == EntityType.BAT ||
    			et == EntityType.ENDER_DRAGON ||
    			et == EntityType.IRON_GOLEM ||
    			//et == EntityType.SILVERFISH ||
    			et == EntityType.VILLAGER ||
    			et == EntityType.WITCH){
    		event.setCancelled(true);
    	}

    }
    
}
