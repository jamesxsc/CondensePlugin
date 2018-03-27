package net.brocraftlive;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class LewisPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "LewisPlugin v1.0 has been enabled!");

        // Register our command "condense" (set an instance of your command class as executor)
        this.getCommand("condense").setExecutor(new CmdCondense());

    }
    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "LewisPlugin v1.0 has been disabled!");
    }
}
