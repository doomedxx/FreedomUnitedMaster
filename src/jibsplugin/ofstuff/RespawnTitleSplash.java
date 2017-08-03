package jibsplugin.ofstuff;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_12_R1.IChatBaseComponent;
public class RespawnTitleSplash extends JavaPlugin implements Listener {

	public void createArray() {
	ArrayList<String> respawn = new ArrayList<String>();
		respawn.add("Rise up and try again!");
		respawn.add("You're items are waiting for you! Go get it.");
	}
	
    @EventHandler
    public void PlayerRespawnEvent(PlayerRespawnEvent event)  {
    	Player player = event.getPlayer();
    	player.sendTitle("test", "test", 10, 70, 20);
       
	}
	
}
