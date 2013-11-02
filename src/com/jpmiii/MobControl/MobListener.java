package com.jpmiii.MobControl;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

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
			List<ItemStack> ol = event.getDrops();
			for (ItemStack itst : ol) {
				Material itty = itst.getType();
				if (itty == Material.IRON_BOOTS
						|| itty == Material.IRON_CHESTPLATE
						|| itty == Material.IRON_HELMET
						|| itty == Material.IRON_LEGGINGS
						|| itty == Material.GOLD_BOOTS
						|| itty == Material.GOLD_CHESTPLATE
						|| itty == Material.GOLD_HELMET
						|| itty == Material.GOLD_LEGGINGS) {
					event.getDrops().clear();

				}
			}
		}
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void spawn(CreatureSpawnEvent event) {
		Location el = event.getLocation();
		SpawnReason sr = event.getSpawnReason();
		EntityType et = event.getEntity().getType();
		if (el.getWorld().getName()
				.equalsIgnoreCase(plugin.getConfig().getString("worldName"))) {

			// if(sr == SpawnReason.NATURAL || sr == SpawnReason.DEFAULT || sr
			// == SpawnReason.CHUNK_GEN) {

			if (et == EntityType.CREEPER || et == EntityType.ENDERMAN
					|| et == EntityType.SPIDER || et == EntityType.SKELETON
					|| et == EntityType.ZOMBIE) {
				if (el.getY() > 55 || el.getBlock().getLightLevel() > 9) {
					event.setCancelled(true);
				}

				// }
			}
			if ((sr != SpawnReason.BREEDING && sr != SpawnReason.SPAWNER_EGG)
					&& (et == EntityType.CHICKEN || et == EntityType.COW
							|| et == EntityType.HORSE
							|| et == EntityType.MUSHROOM_COW
							|| et == EntityType.OCELOT || et == EntityType.WOLF
							|| et == EntityType.PIG || et == EntityType.SHEEP)) {
				event.setCancelled(true);
			}

		}
		if (et == EntityType.BAT || et == EntityType.ENDER_DRAGON
				|| et == EntityType.IRON_GOLEM ||
				// et == EntityType.SILVERFISH ||
				// et == EntityType.SQUID ||
				et == EntityType.WITCH || et == EntityType.VILLAGER) {
			event.setCancelled(true);
		}

	}

}
