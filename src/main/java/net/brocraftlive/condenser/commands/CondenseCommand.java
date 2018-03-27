/*
* 
* LICENSED UNDER APACHE LICENSE 2.0
* COPYRIGHT 2018 615283 (James Conway) & lewis2470(Lewis Hitching)
* DO NOT REMOVE THIS NOTICE FROM THIS FILE OR ANY OTHER FILE WITHIN THIS REPOSITORY CONTAINING THIS NOTICE
* 
*/

package net.brocraftlive.condenser.commands;

import net.brocraftlive.condenser.CondensePlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CondenseCommand implements CommandExecutor {

    private CondensePlugin cp;
    public CondenseCommand(CondensePlugin condensePlugin) {
        this.cp = condensePlugin;
    }

    // Method for /condense command
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (!sender.hasPermission("brocraft.condense")) player.sendMessage(ChatColor.RED + "You do not have permission to do this!");
                else {
                    cp.getCondenseUtil().condenseItems(player);
                }
                return true;
            }
            else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&l&m--&2&l[ &2Condense-able types&2&l ]&2&l&m--"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aCoal &2|&a Iron Ingot &2|&a Gold Ingot &2|&a Diamond &2|&a Emerald &2|&a Redstone"));
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Console usage for this command is not supported!");
            return true;
        }
    }
}
