/*
* 
* LICENSED UNDER APACHE LICENSE 2.0
* COPYRIGHT 2018 615283 (James Conway) & lewis2470(Lewis Hitching)
* DO NOT REMOVE THIS NOTICE FROM THIS FILE OR ANY OTHER FILE WITHIN THIS REPOSITORY CONTAINING THIS NOTICE
* 
*/

package net.brocraftlive.condenser;

import net.brocraftlive.condenser.commands.CondenseCommand;
import net.brocraftlive.condenser.utils.CondenseUtil;
import org.bukkit.plugin.java.JavaPlugin;

public class CondensePlugin extends JavaPlugin {

    //Class getters
    private CondenseCommand condenseCommand = new CondenseCommand(this);
    private CondenseUtil condenseUtil = new CondenseUtil(this);

    public CondenseCommand getCondenseCommand() {
        return condenseCommand;
    }
    public CondenseUtil getCondenseUtil() {
        return condenseUtil;
    }

    //Called by Bukkit/Spigot on plugin enable
    @Override
    public void onEnable() {
        this.getCommand("condense").setExecutor(new CondenseCommand(this));
    }
}
