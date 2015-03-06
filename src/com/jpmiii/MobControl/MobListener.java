package com.jpmiii.MobControl;



import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.jpmiii.MobControl.MobControl;

public class MobListener implements Listener {
	private MobControl plugin;

	public MobListener(MobControl plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void newdrops(EntityDeathEvent event) {

		EntityType et = event.getEntityType();

		if (et == EntityType.SQUID) {
			ItemStack is = new ItemStack(Material.RAW_FISH, 1);
			event.getDrops().add(is);
		}

		if (et == EntityType.SKELETON || et == EntityType.ZOMBIE) {
			if (event.getDrops().contains(new ItemStack(Material.ROTTEN_FLESH))) {
				event.getDrops().remove(new ItemStack(Material.ROTTEN_FLESH));

			}
			if (event.getDrops().contains(new ItemStack(Material.ROTTEN_FLESH))) {
				event.getDrops().remove(new ItemStack(Material.ROTTEN_FLESH));

			}
			if (event.getDrops().contains(new ItemStack(Material.IRON_HELMET))) {
				event.getDrops().remove(new ItemStack(Material.IRON_HELMET));

			}
			if (event.getDrops().contains(new ItemStack(Material.IRON_BOOTS))) {
				event.getDrops().remove(new ItemStack(Material.IRON_BOOTS));

			}
			if (event.getDrops().contains(new ItemStack(Material.IRON_CHESTPLATE))) {
				event.getDrops().remove(new ItemStack(Material.IRON_CHESTPLATE));

			}
			if (event.getDrops().contains(new ItemStack(Material.IRON_LEGGINGS))) {
				event.getDrops().remove(new ItemStack(Material.IRON_LEGGINGS));

			}
			if (event.getDrops().contains(new ItemStack(Material.GOLD_BOOTS))) {
				event.getDrops().remove(new ItemStack(Material.GOLD_BOOTS));

			}
			if (event.getDrops().contains(new ItemStack(Material.GOLD_LEGGINGS))) {
				event.getDrops().remove(new ItemStack(Material.GOLD_LEGGINGS));

			}
			if (event.getDrops().contains(new ItemStack(Material.GOLD_CHESTPLATE))) {
				event.getDrops().remove(new ItemStack(Material.GOLD_CHESTPLATE));

			}
			if (event.getDrops().contains(new ItemStack(Material.GOLD_HELMET))) {
				event.getDrops().remove(new ItemStack(Material.GOLD_HELMET));

			}


		}
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void spawn(CreatureSpawnEvent event) {
		Location el = event.getLocation();
		SpawnReason sr = event.getSpawnReason();
		EntityType et = event.getEntity().getType();
		if (sr != SpawnReason.CUSTOM) {
		if (el.getWorld().getName()
				.equalsIgnoreCase(plugin.worldname)) {

			// if(sr == SpawnReason.NATURAL || sr == SpawnReason.DEFAULT || sr
			// == SpawnReason.CHUNK_GEN) {
			if (et == EntityType.ZOMBIE) {
				Zombie zom = (Zombie)event.getEntity();
				if (zom.isBaby()){
					zom.setBaby(false);
				}
			}
/*
			if (et == EntityType.CREEPER || et == EntityType.ENDERMAN
					//|| et == EntityType.SPIDER 
					|| et == EntityType.SKELETON
					|| et == EntityType.ZOMBIE) {
				if (el.getY() > 0 || el.getBlock().getLightLevel() > 9) {
					event.setCancelled(true);
				}

				// }
			}  */
			if(el.getZ()  < -3300) {
				
				if (et == EntityType.CREEPER || et == EntityType.CAVE_SPIDER
						|| et == EntityType.SPIDER 
						|| et == EntityType.SKELETON
						|| et == EntityType.ZOMBIE) {
					
						
						event.getEntity().setMaxHealth(40.0);
						event.getEntity().setHealth(40.0);
						PotionEffect pe = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100000,5);
						event.getEntity().addPotionEffect(pe);
						
						
					

					
				}  
				
			}
			if (((sr != SpawnReason.BREEDING )  && (sr != SpawnReason.SPAWNER_EGG))
					&& (et == EntityType.CHICKEN || et == EntityType.COW
							|| et == EntityType.MUSHROOM_COW
							//|| et == EntityType.OCELOT || et == EntityType.WOLF
							|| et == EntityType.PIG || et == EntityType.SHEEP
							|| et == EntityType.HORSE)) {
				event.setCancelled(true);
			}


		}

		if (et == EntityType.BAT || et == EntityType.ENDER_DRAGON
				|| et == EntityType.IRON_GOLEM ||
				// et == EntityType.SILVERFISH ||
				// et == EntityType.SQUID ||
				et == EntityType.WITCH || 
				et == EntityType.VILLAGER) 
		{
			event.setCancelled(true);
		}
		

	}
	}

}
