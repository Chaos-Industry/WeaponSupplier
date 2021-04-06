package com.giithub.chaosindustory.weaponsupplier;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public final class WeaponSupplier extends JavaPlugin {

    private static final String TEAM_RED_NAME = "team_red";
    private static final String TEAM_BLUE_NAME = "team_blue";
    private static final String STRANGER = "Stranger";

    static Team teamRed;
    static Team teamBlue;
    static Team Stranger;

    @Override
    public void onEnable() {
        getCommand("team_division").setExecutor(new Supplier(this));
        Bukkit.getLogger().info("The Plugin becomes valid.");

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getMainScoreboard();

        teamRed = board.getTeam(TEAM_RED_NAME);
        if (teamRed == null) {
            teamRed = board.registerNewTeam(TEAM_RED_NAME);
            teamRed.setPrefix(ChatColor.RED.toString());
            teamRed.setSuffix(ChatColor.RESET.toString());
            teamRed.setDisplayName("team red");
            teamRed.setAllowFriendlyFire(false);
        }
        teamBlue = board.getTeam(TEAM_BLUE_NAME);
        if (teamBlue == null) {
            teamBlue = board.registerNewTeam(TEAM_BLUE_NAME);
            teamBlue.setPrefix(ChatColor.BLUE.toString());
            teamBlue.setSuffix(ChatColor.RESET.toString());
            teamBlue.setDisplayName("team blue");
            teamBlue.setAllowFriendlyFire(false);
        }
        Stranger = board.getTeam(STRANGER);
        if (Stranger == null) {
            Stranger = board.registerNewTeam(STRANGER);
            Stranger.setPrefix(ChatColor.YELLOW.toString());
            Stranger.setSuffix(ChatColor.RESET.toString());
            Stranger.setDisplayName("Stranger");
            Stranger.setAllowFriendlyFire(false);
        }
    }
}