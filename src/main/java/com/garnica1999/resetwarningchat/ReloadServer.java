/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garnica1999.resetwarningchat;

import org.bukkit.Bukkit;

/**
 *
 * @author wcarl
 */
public class ReloadServer {
    private ResetWarningChat resetWarningChat;

    public ReloadServer(ResetWarningChat resetWarningChat) {
        this.resetWarningChat = resetWarningChat;
    }
    
    public void applyReload(Long seconds){
        Bukkit.getScheduler().scheduleSyncDelayedTask(resetWarningChat, new Runnable() {
            @Override
            public void run() {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "reload");
            }
        }, seconds * 20L);
    }
}
