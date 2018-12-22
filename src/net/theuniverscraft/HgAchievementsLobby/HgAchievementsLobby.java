package net.theuniverscraft.HgAchievementsLobby;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HgAchievementsLobby extends JavaPlugin {
	private static HgAchievementsLobby instance;
	public static HgAchievementsLobby getInstance() {
		return instance;
	}
	
	public void onEnable() {
		instance = this;
		
		getCommand("setjump").setExecutor(new CommandSetJump());
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new AchievementsListener(), this);
	}
}
