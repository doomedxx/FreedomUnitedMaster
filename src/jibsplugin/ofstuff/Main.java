package jibsplugin.ofstuff;



import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.*;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;


public class Main extends JavaPlugin implements Listener {
	
	private String pfx = c("3") + "[" + c("b") + "Freedom United" + c("3") + "]" + c("7") + " "; //prefix for plugin messages [JPOS]
	
	private String c(String color)
	{
		return "§" + color; //add squiggly wiggly thingy
	}
	
	private void JBroadcast(String message)
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
                		"\n§9------------------------------------------" + 
                		"\n§bOh no, you died!  Here are the coordinates of your deathpoint:" +
                		"\n §bX: §7" + locX +
                		"\n §bY: §7" + locY +
                		"\n §bZ: §7" + locZ +
                		"\n§9------------------------------------------");
        	}

        	}, 100L); // Amount of ticks before executing the function above ^. FU's TPS = 20
        
    }
	
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
        	JBroadcast(command.getName() + " " + sender.getName());
        	switch (command.getName().toLowerCase())
        	{
        		case "clearchat":
        			for (int i = 0; i < 250; i++)
        			{
        				getServer().broadcastMessage("");
        			}
        			JBroadcast("Chat cleared by " + sender.getName());
        			return true;
        		case "reload":
        			JBroadcast("Reloading...");
        			
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
