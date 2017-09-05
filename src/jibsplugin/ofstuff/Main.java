package jibsplugin.ofstuff;



import java.util.ArrayList;
import java.util.Random;

import javax.tools.DocumentationTool.Location;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.*;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;


public class Main extends JavaPlugin implements Listener {
	
	private String pfx = c("3") + "[" + c("b") + "Freedom United" + c("3") + "]" + c("7") + " "; //prefix for plugin messages [Freedom United]
	
	private String c(String color)
	{
		return "§" + color; //add squiggly wiggly thingy
	}
	
	private void FUBroadcast(String message)
	{
		getServer().broadcastMessage(pfx + message);
	}
	
	@Override
	public void onEnable() { //On plugin enable
		Bukkit.getServer().getPluginManager().registerEvents(this, this); //makes events work
	}
	
	@Override
	public void onDisable() { //On plugin disable
		
	}
	
////////////////////////// DEATH LOCATION /////////////////////////////////
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        String[] location = e.getEntity().getLocation().toString().split(",");
        String rawLocX = location[1].substring(2);
        String rawLocY = location[2].substring(2);
        String rawLocZ = location[3].substring(2);
        String locX = rawLocX.substring(0, rawLocX.indexOf('.'));
        String locY = rawLocY.substring(0, rawLocY.indexOf('.'));
        String locZ = rawLocZ.substring(0, rawLocZ.indexOf('.'));
        
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() { // Starts the delay

        	@Override
        	public void run() {
                e.getEntity().sendMessage(
                		"§f------------------------------------------" + 
                		"\n§bOh no, you died!  Here are the coordinates of your deathpoint:" +
                		"\n §bX: §7" + locX +
                		" §bY: §7" + locY +
                		" §bZ: §7" + locZ +
                		"\n§f------------------------------------------");
               
        	}

        	}, 100L); // Amount of ticks before executing the function above ^. FU's TPS = 20
        
    }
//////////////////////////--- END OF DEATH LOCATION ---/////////////////////////////////

///////////////////////// MOTIVATIONAL MESSAGE ////////////////////////////////

    @EventHandler
    public void PlayerRespawnEvent(PlayerRespawnEvent event)  {
    	String[] respawn = {"It's okay. Rise up and try again!",
    						"We learn from our mistakes.",
    						"Take a deep breath, now try it again!",
    						"Hey, atleast you've got full health and hunger!",
    						"Try to stay positive.",
    						"Remember what went wrong? Dont do it again!",
    						"Welcome back!",
    						"It was just a bad dream..",
    						"Get Psyched!",
    						"Your items! Go get them back!",
    						"Never dig down!",
    						"You get to fight another day!"
    						}; // Creates the messages..
    	    	
        Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable() {
        	
        
        @Override
        public void run() {
	        Random Dice = new Random(); 
	        int n = Dice.nextInt(respawn.length); //... Randomizes it
	    	Player player = event.getPlayer();
	    	player.sendTitle(" ", respawn[n], 10, 50, 20); //... prints it!
        }
        
        }, 60L);
       }
        
//////////////////////// END MOTIVATIONAL MESSAGE //////////////////////////
    
	@EventHandler
	public void onLogin(PlayerLoginEvent event)
	{
		
	}
	
	@Override
    public boolean onCommand(CommandSender sender,
            Command command,
            String label,
            String[] args) {
        if (sender.isOp()) //Op-only commands
	{
        	switch (command.getName().toLowerCase())
        	{
        		case "clearchat":
        			for (int i = 0; i < 250; i++)
        			{
        				getServer().broadcastMessage("");
        			}
        			FUBroadcast("Chat cleared by " + sender.getName());
        			return true;
        		case "reload":
        			FUBroadcast("Reloading...");
        			
        			return true;
        		case "commandname3":
        			
        			return true;
        		case "commandname4":
        			
        			return true;
        		case "commandname5":
        			
        			return true;
        	}
        }
		if (command.getName().equalsIgnoreCase("ip")) {
            
			return true;
        }
        return false;
    }
}
