package net.brocraftlive.condenser.utils;

import net.brocraftlive.condenser.CondensePlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CondenseUtil {

    private CondensePlugin cp;
    public CondenseUtil(CondensePlugin condensePlugin) {
        this.cp = condensePlugin;
    }

    //Method called upon command from CondenseCommand.java
    public void condenseItems(Player p) {

        Inventory i = p.getInventory();

        //Defining variables to count materials
        int coal = 0;
        int iron = 0;
        int gold = 0;
        int diamond = 0;

        int bypass = 0;
        int belowMin = 0;

        //Cycling through inv
        for (ItemStack item : i.getContents()) {
            if (item == null) continue;
            if (item.getType().equals(Material.AIR)) continue;

            else if (item.getType().equals(Material.COAL)) {
                coal = coal + item.getAmount();
            }
            else if (item.getType().equals(Material.IRON_INGOT)) {
                iron = iron + item.getAmount();
            }
            else if (item.getType().equals(Material.GOLD_INGOT)) {
                gold = gold + item.getAmount();
            }
            else if (item.getType().equals(Material.DIAMOND)) {
                diamond = diamond + item.getAmount();
            }
        }

        //Coal condense
        if (coal==0) bypass+=1;
        else if (coal<9) belowMin+=1;
        else {
            while (coal >= 9) {
                coal = coal-9;
                p.getInventory().removeItem(new ItemStack(Material.COAL, 9));
                p.getInventory().addItem(new ItemStack(Material.COAL_BLOCK, 1));
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully condensed COAL"));
        }

        //Iron condense
        if (iron==0) bypass+=1;
        else if (iron<9) belowMin+=1;
        else {
            while (iron >= 9) {
                iron = iron - 9;
                p.getInventory().removeItem(new ItemStack(Material.IRON_INGOT, 9));
                p.getInventory().addItem(new ItemStack(Material.IRON_BLOCK, 1));
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully condensed IRON INGOT"));
        }

        //Gold condense
        if (gold==0) bypass+=1;
        else if (gold<9) belowMin+=1;
        else {
            while (gold >= 9) {
                gold = gold - 9;
                p.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, 9));
                p.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK, 1));
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully condensed GOLD INGOT"));
        }

        //Diamond condense
        if (diamond==0) bypass += 1;
        else if (diamond<9) belowMin+=1;
        else {
            while (diamond >= 9) {
                diamond = diamond - 9;
                p.getInventory().removeItem(new ItemStack(Material.DIAMOND, 9));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK, 1));
            }
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSuccessfully condensed DIAMOND"));
        }

        //If no ingots were found see help for ingots
        if (bypass==4) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cUse &l/condense help &cto view ingots you can condense"));

        //If not enough ingots/coal were found
        //TODO @lewis2470 change this message to what you want V
        else if (belowMin+bypass==4) p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou don't have enough of anything to condense into blocks"));
    }

}
