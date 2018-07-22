package net.brocraftlive.authop;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.util.List;

public final class AuthOP extends JavaPlugin implements Listener {
    FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("authop").setExecutor(new net.brocraftlive.authop.authOPCMD(this));
        if (!new File(getDataFolder() + File.separator + "config.yml").exists()) {
            saveResource("config.yml", true);
        }
        this.players = getConfig().getStringList("Players");
    }

    public List<String> players = getConfig().getStringList("Players");
    public String prefix = getConfig().getString("Prefix");

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
