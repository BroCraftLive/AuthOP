package net.brocraftlive.authop;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.Yaml;

public class authOPCMD implements CommandExecutor {
    private AuthOP mc;
    public authOPCMD(AuthOP mc) {
        this.mc = mc;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (mc.players.contains(player.getName()) && !player.isOp()) {
                    player.setOp(true);
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', mc.prefix + " &aYou have been OPPED!"));
                }
                else if (mc.players.contains(player.getName()) && player.isOp()) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', mc.prefix + " &cYou are already OPPED!"));
                }
                else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', mc.prefix + " &cYou are not authorised!"));
                }
            }
            else if (args.length == 1 && args[0].equals("help")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&'," &2&m---&2&l[ &aAuthOP &2&l]&2&m---"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a► &2&l/authop &a- OPs you without permissions"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a► &2&l/authop list &a- Displays the authorised users"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a► &2&l/authop help &a- Displays this message"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c► &4&l/authop reload &c- Currently unsupported"));
            }
            else if (args.length == 1 && args[0].equals("list")) {
                int i = 0;
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&m---&2&l[ &2Authorised Users &2&l]&2&m---"));
                for(String message: mc.players) {
                    ++i;
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&2&l" + i + ". " + "&a" + message));
                }
            }
            else if (args.length == 1 && args[0].equals("reload")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', mc.prefix + " &cConfig reloading is not yet supported!"));
            }
        }
        return true;
    }
}