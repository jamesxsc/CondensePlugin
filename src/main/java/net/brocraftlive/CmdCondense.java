package net.brocraftlive;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CmdCondense implements CommandExecutor {

    // This method is called, when somebody uses our command
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (!sender.hasPermission("brocraft.condense")) player.sendMessage(ChatColor.RED + "You do not have permission to do this!");
                else {
                    Inventory i = player.getInventory();
                    int coal = 0;
                    int iron = 0;
                    int gold = 0;
                    int diamond = 0;
                    int succeed = 0;
                    for (ItemStack item : i.getContents()) {
                        if (item == null) continue;
                        if (item.getType().equals(Material.AIR)) continue;
                        else if (item.getType().equals(Material.COAL)) {
                            coal = coal + item.getAmount();
                        }
                        if (item.getType().equals(Material.IRON_INGOT)) {
                            iron = iron + item.getAmount();
                        }
                        else if (item.getType().equals(Material.GOLD_INGOT)) {
                            gold = gold + item.getAmount();
                        }
                        else if (item.getType().equals(Material.DIAMOND)) {
                            diamond = diamond + item.getAmount();
                        }
                    }
                    // v== COAL INGOT SECTION ==v
                    if (coal < 9) {
                        succeed += 1;
                    }
                    else {
                        while (coal >= 9) {
                            coal = coal - 9;
                            player.getInventory().removeItem(new ItemStack(Material.COAL, 9));
                            player.getInventory().addItem(new ItemStack(Material.COAL_BLOCK, 1));
                        }
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully condensed COAL"));
                    }
                    // v== IRON INGOT SECTION ==v
                    if (iron < 9) {
                        succeed += 1;
                    }
                    else {
                        while (iron >= 9) {
                            iron = iron - 9;
                            player.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 9));
                            player.getInventory().addItem(new ItemStack(Material.IRON_BLOCK, 1));
                        }
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully condensed IRON INGOT"));
                    }
                    // v== GOLD INGOT SECTION ==v
                    if (gold < 9) {
                        succeed += 1;
                    }
                    else {
                        while (gold >= 9) {
                            gold = gold - 9;
                            player.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 9));
                            player.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK, 1));
                        }
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully condensed GOLD INGOT"));
                    }
                    // v== DIAMOND INGOT SECTION ==v
                    if (diamond < 9) {
                        succeed += 1;
                    }
                    else {
                        while (diamond >= 9) {
                            diamond = diamond - 9;
                            player.getInventory().removeItem(new ItemStack(Material.DIAMOND, 9));
                            player.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK, 1));
                        }
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully condensed DIAMOND"));
                    }
                    if (succeed == 4) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUse &l/condense help &cto view ingots you can condense"));
                    }
                }
            }
            else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&l&m--&2&l[ &2Condense-able types&2&l ]&2&l&m--"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aCoal &2|&a Iron Ingot &2|&a Gold Ingot &2|&a Diamond"));
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Console usage for this command is not supported!");
        }
        return true;
    }
}