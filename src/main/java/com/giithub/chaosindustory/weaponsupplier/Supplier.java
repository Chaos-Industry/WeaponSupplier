package com.giithub.chaosindustory.weaponsupplier;

import org.bukkit.Bukkit;
import org.bukkit.scoreboard.Team;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Supplier implements CommandExecutor {

    private final WeaponSupplier plugin;
    public Supplier(WeaponSupplier plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if ( args.length <= 1 ) {
            sender.sendMessage("'/" + label + " (team_name) (player_name)' You must write a command like this.");
            return true;
        }

        if ( !args[0].equalsIgnoreCase("red") && !args[0].equalsIgnoreCase("blue") && !args[0].equalsIgnoreCase("stranger")) {
            sender.sendMessage("Team_" + args[0] + " doesnt exists.");
            sender.sendMessage("Choose red, blue, or stranger");
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[1]);
        if ( target == null ) {
            sender.sendMessage("Player " + args[1] + " doesnt exists.");
            return true;
        }

        PlayerInventory inventory = target.getInventory();
        inventory.clear();
        Team team;

        Bukkit.getLogger().info(args[0]);
        Bukkit.getLogger().info(args[1]);

        if (args[0].equalsIgnoreCase("red") ) {
            team = WeaponSupplier.teamRed;

            Bukkit.getLogger().info("red");

            //Armors
            ItemStack PlayerHelmet = new ItemStack(Material.GOLDEN_HELMET);
            inventory.setHelmet(PlayerHelmet);
            ItemStack PlayerChestPlate = new ItemStack(Material.GOLDEN_CHESTPLATE);
            inventory.setChestplate(PlayerChestPlate);
            ItemStack PlayerBoots = new ItemStack(Material.GOLDEN_BOOTS);
            inventory.setBoots(PlayerBoots);
            ItemStack PlayerLeggings = new ItemStack(Material.GOLDEN_LEGGINGS);
            inventory.setLeggings(PlayerLeggings);

            //Bow
            ItemStack PlayerBow = new ItemStack(Material.BOW);
            inventory.setItemInMainHand(PlayerBow);

            //Arrows
            ItemStack PlayerArrow = new ItemStack(Material.ARROW, 64);
            inventory.addItem(PlayerArrow);

            //Landmine
            ItemStack PlayerMine = new ItemStack(Material.OAK_PRESSURE_PLATE);
            inventory.addItem(PlayerMine);

            //Healing potion
            ItemStack potion = new ItemStack(Material.POTION, 2);
            PotionMeta meta = (PotionMeta) potion.getItemMeta();
            meta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1000, 1),true);
            meta.setDisplayName("Healing Medicine");
            potion.setItemMeta(meta);
            inventory.addItem(potion);

            team.addEntry(args[1]);
            sender.sendMessage(args[1] + " have joined in " + args[0]);
            return true;

        } else if(args[0].equalsIgnoreCase("blue")) {
            team = WeaponSupplier.teamBlue;

            Bukkit.getLogger().info("blue");

            //Armors
            ItemStack PlayerHelmet = new ItemStack(Material.CHAINMAIL_HELMET);
            inventory.setHelmet(PlayerHelmet);
            ItemStack PlayerChestPlate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
            inventory.setChestplate(PlayerChestPlate);
            ItemStack PlayerBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
            inventory.setBoots(PlayerBoots);
            ItemStack PlayerLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
            inventory.setLeggings(PlayerLeggings);

            //Bow
            ItemStack PlayerBow = new ItemStack(Material.BOW);
            inventory.setItemInMainHand(PlayerBow);

            //Arrows
            ItemStack PlayerArrow = new ItemStack(Material.ARROW, 64);
            inventory.addItem(PlayerArrow);

            //Landmine
            ItemStack PlayerMine = new ItemStack(Material.OAK_PRESSURE_PLATE);
            inventory.addItem(PlayerMine);

            //Healing potion
            ItemStack potion = new ItemStack(Material.POTION, 2);
            PotionMeta meta = (PotionMeta) potion.getItemMeta();
            meta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1000, 1),true);
            meta.setDisplayName("Healing Medicine");
            potion.setItemMeta(meta);
            inventory.addItem(potion);

            team.addEntry(args[1]);
            sender.sendMessage(args[1] + " have joined in " + args[0]);
            return true;

        }else {
            team = WeaponSupplier.Stranger;

            Bukkit.getLogger().info("stranger");

            //Armors
            ItemStack PlayerHelmet = new ItemStack(Material.DIAMOND_HELMET);
            inventory.setHelmet(PlayerHelmet);
            ItemStack PlayerChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
            inventory.setChestplate(PlayerChestPlate);
            ItemStack PlayerBoots = new ItemStack(Material.DIAMOND_BOOTS);
            inventory.setBoots(PlayerBoots);
            ItemStack PlayerLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
            inventory.setLeggings(PlayerLeggings);

            //Invisibility potion
            ItemStack potion = new ItemStack(Material.POTION, 3);
            PotionMeta meta = (PotionMeta) potion.getItemMeta();
            meta.addCustomEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 3500, 1),true);
            meta.setDisplayName("Invisibility Medicine");
            potion.setItemMeta(meta);
            inventory.addItem(potion);

            //Night Vision potion
            ItemStack potion2 = new ItemStack(Material.POTION, 3);
            PotionMeta meta2 = (PotionMeta) potion2.getItemMeta();
            meta2.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 3500, 8),true);
            meta2.setDisplayName("Night Vision Medicine");
            potion2.setItemMeta(meta2);
            inventory.addItem(potion2);

            //Landmine
            ItemStack PlayerMine = new ItemStack(Material.OAK_PRESSURE_PLATE,64);
            inventory.addItem(PlayerMine);

            //Bomb Arrow
            ItemStack PlayerArrow = new ItemStack(Material.SPECTRAL_ARROW, 10);
            inventory.addItem(PlayerArrow);

            //Ender Pearl
            ItemStack EnderPearl = new ItemStack(Material.ENDER_PEARL, 3);
            inventory.addItem(EnderPearl);

            team.addEntry(args[1]);
            sender.sendMessage(args[1] + " have joined in " + args[0]);
            return true;
        }
    }
}

