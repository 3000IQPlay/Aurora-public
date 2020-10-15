package me.memeszz.aurora.command;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public abstract class Command {
    public static String prefix = ".";
    public static boolean MsgWaterMark = true;
    public static ChatFormatting cf = ChatFormatting.AQUA;
    static Minecraft mc = Minecraft.getMinecraft();

    public static void sendClientMessage(String message) {
        if (MsgWaterMark)
            mc.player.sendMessage(new TextComponentString(ChatFormatting.DARK_AQUA + "[" + ChatFormatting.AQUA + "Aurora" + ChatFormatting.DARK_AQUA + "] " + message));
        else
            mc.player.sendMessage(new TextComponentString(cf + message));
    }

    public static char SECTIONSIGN() {
        return '§';
    }

    public static void sendRawMessage(String message) {
        mc.player.sendMessage(new TextComponentString(message));
    }

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String p) {
        prefix = p;
    }

    public abstract String[] getAlias();

    public abstract String getSyntax();

    public abstract void onCommand(String command, String[] args) throws Exception;

}
