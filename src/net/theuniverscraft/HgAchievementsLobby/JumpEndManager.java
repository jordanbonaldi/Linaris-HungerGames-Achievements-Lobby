package net.theuniverscraft.HgAchievementsLobby;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class JumpEndManager {
	private FileConfiguration m_config;
	private Location m_jumpEnd;
	
	private static JumpEndManager instance;
	public static JumpEndManager getInstance() {
		if(instance == null) instance = new JumpEndManager();
		return instance;
	}
	
	private JumpEndManager() {
		m_config = HgAchievementsLobby.getInstance().getConfig();
		if(m_config.contains("endjump")) {
			String w = m_config.getString("endjump.world");
			int x = m_config.getInt("endjump.x");
			int y = m_config.getInt("endjump.y");
			int z = m_config.getInt("endjump.z");
			
			m_jumpEnd = new Location(Bukkit.getWorld(w), x, y, z);
		}
		else {
			m_jumpEnd = Bukkit.getWorld("world").getSpawnLocation();
		}
	}
	
	public Location getEndJump() { return m_jumpEnd; }
	public void setEndJump(Location loc) {
		m_jumpEnd = loc;
		m_config.set("endjump.world", loc.getWorld().getName());
		m_config.set("endjump.x", loc.getBlockX());
		m_config.set("endjump.y", loc.getBlockY());
		m_config.set("endjump.z", loc.getBlockZ());
		HgAchievementsLobby.getInstance().saveConfig();
	}
}
