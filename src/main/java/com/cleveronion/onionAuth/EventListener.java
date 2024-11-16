package com.cleveronion.onionAuth;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.*;

public class EventListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getName();
        LoginData.addLoginData(playerName.toLowerCase());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getName();
        LoginData.removeLoginData(playerName.toLowerCase());
    }

    public static void cancelIfNotLoggedIn(Cancellable e) {
        if (e instanceof PlayerEvent) {
            if (LoginData.contains(((PlayerEvent) e).getPlayer().getName().toLowerCase())) {
                e.setCancelled(true);
            }
        } else if (e instanceof InventoryOpenEvent) {
            if (LoginData.contains(((InventoryOpenEvent) e).getPlayer().getName().toLowerCase())) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void restrictMove(PlayerMoveEvent e) {
        // 移动
        cancelIfNotLoggedIn(e);
    }

    @EventHandler
    public void restrictInteract(PlayerInteractEvent e) {
        // 交互
        cancelIfNotLoggedIn(e);
    }

    @EventHandler
    public void restrictInteractAtEntity(PlayerInteractAtEntityEvent e) {
        // 实体交互
        cancelIfNotLoggedIn(e);
    }

    @EventHandler
    public void restrictPortal(PlayerPortalEvent e) {
        // 传送门
        cancelIfNotLoggedIn(e);
    }

    @EventHandler
    public void restrictTeleport(PlayerTeleportEvent e) {
        // 传送
        cancelIfNotLoggedIn(e);
    }

    @EventHandler
    public void restrictOpenInventory(InventoryOpenEvent e) {
        // 打开物品栏
        cancelIfNotLoggedIn(e);
    }
}
