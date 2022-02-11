/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.garnica1999.resetwarningchat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author wcarl
 */
public class ResetWarningChat extends JavaPlugin {
    
    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
        // Insertar aquí la lógica para llevar a cabo cuando el plugin está deshabilitado.
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = null;
        if (cmd.getName().equalsIgnoreCase("rw")) {
            
            if (!(sender instanceof Player)) {
                sender.sendMessage("Este comando puede ser utilizado solamente por un jugador");
                return false;
            } else{
                player = (Player)sender;
            }
            
            if (Bukkit.getServer().getPlayer(player.getUniqueId()) == null) {
                sender.sendMessage("Jugador no está en línea");
                return false;
            }
            
            if (args.length == 0) {
                sender.sendMessage("Comando inválido. Falta los minutos de reinicio.");
                return false;
            }

            if (args.length < 1 || args.length > 1) {
                sender.sendMessage("Número de argumentos inválido.");
                return false;
            }
            String min = (Integer.parseInt(args[0]) == 1) ? "minuto" : "minutos";
            Bukkit.broadcastMessage("El servidor se reiniciará en " + args[0] + " " + min);

            ReloadServer reloadServer = new ReloadServer(this);
            reloadServer.applyReload(Long.parseLong(args[0]));
            return true;
        }
        return false;
    }

}
