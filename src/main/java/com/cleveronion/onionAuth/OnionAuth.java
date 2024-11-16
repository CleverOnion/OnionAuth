package com.cleveronion.onionAuth;

import org.bukkit.plugin.java.JavaPlugin;

public final class OnionAuth extends JavaPlugin {

    public static OnionAuth INSTANCE;

    @Override
    public void onEnable() {
        // Plugin startup logic
        INSTANCE = this;
        log("OnionAuth has been enabled!");

        getCommand("login").setExecutor(new CommandHandler());
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log("OnionAuth has been disabled!");
        saveConfig();
    }

    public static void log(String message) {
        INSTANCE.getLogger().info(message);
    }
}
