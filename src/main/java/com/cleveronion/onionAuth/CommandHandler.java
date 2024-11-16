package com.cleveronion.onionAuth;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        // 判断命令执行者是不是玩家
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§c[OnionAuth] 命令只能由玩家执行");
            return false;
        }
        // 判断是否已经登录
        if (!LoginData.contains(((Player) commandSender).getName().toLowerCase())) {
            commandSender.sendMessage("§c[OnionAuth] 你已经登录了哦~");
            return true;
        }
        // 判断是否输入了密码
        if (strings.length == 0) {
            commandSender.sendMessage("§c[OnionAuth] 请输入密码");
            return false;
        }
        String pwdConcat = String.join("<space>", strings);
        // 判断是否已经注册了
        if (ConfigReader.isPlayerRegistered(commandSender.getName().toLowerCase())) {
            if (ConfigReader.verifyPassword(commandSender.getName(), pwdConcat)) {
                LoginData.removeLoginData(commandSender.getName().toLowerCase());
                commandSender.sendMessage("§a[OnionAuth] 登录成功");
                return true;
            } else {
                commandSender.sendMessage("§c[OnionAuth] 密码错误");
                return true;
            }
        } else {
            ConfigReader.addPlayer(commandSender.getName(), pwdConcat);
            commandSender.sendMessage("§a[OnionAuth] 注册成功");
            LoginData.removeLoginData(commandSender.getName().toLowerCase());
            return true;
        }
    }
}
