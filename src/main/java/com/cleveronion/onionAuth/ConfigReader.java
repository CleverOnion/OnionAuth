package com.cleveronion.onionAuth;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigReader {
    public static FileConfiguration config = OnionAuth.INSTANCE.getConfig();

    // 判断config里是否已经有了
    public static boolean isPlayerRegistered(String data)
    {
        return config.contains(data.toLowerCase());
    }

    public static boolean verifyPassword(String playerName, String password) {
        return password.equals(config.getString(playerName.toLowerCase()));
        // 三步合成一行：转换小写，读取字符串，返回是否相等
    }

    public static void addPlayer(String playerName, String password) {
        config.set(playerName.toLowerCase(), password);
        OnionAuth.INSTANCE.saveConfig();
    }
}
