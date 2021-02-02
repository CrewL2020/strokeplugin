package net.kunmc.lab.stroke.strokeplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

public class MotionCommandExecutor implements CommandExecutor{

    private final StrokePlugin plugin;
    int cautionTitle[] = {5,30,5};

    public MotionCommandExecutor(StrokePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){

        if (cmd.getName().equalsIgnoreCase("Stroke"))
        {
            if (!(sender instanceof Player)) {
                sender.sendMessage("プレーヤーのみが実行できます");
                return false;
            }
            for(Player p : Bukkit.getOnlinePlayers()){
                p.sendTitle("Stroke Plugin","制作 CrewL2020",cautionTitle[0],cautionTitle[1],cautionTitle[2]);
            }
        }

        return false;

    }
}
