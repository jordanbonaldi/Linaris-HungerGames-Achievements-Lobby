package net.theuniverscraft.HgAchievementsLobby;

import net.theuniverscraft.HgAchievements.AchievementType;
import net.theuniverscraft.HgAchievements.Managers.DbManager;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class AchievementsListener implements Listener {
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Block block = player.getWorld().getBlockAt(event.getTo());
		if(block.getType() == Material.WOOD_PLATE || block.getType() == Material.STONE_PLATE ||
				block.getType() == Material.GOLD_PLATE || block.getType() == Material.IRON_PLATE) {
			
			Location l = player.getLocation();			
			Location end = JumpEndManager.getInstance().getEndJump();			
			if(l.getBlockX() == end.getBlockX() && l.getBlockY() == end.getBlockY() && l.getBlockZ() == end.getBlockZ()) {
				DbManager.getInstance().addAction(player, AchievementType.END_JUMP_LOBBY);
			}
		}
	}
}
