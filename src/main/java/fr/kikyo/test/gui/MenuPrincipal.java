package fr.kikyo.test.gui;

import fr.kikyo.test.utils.GuiBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class MenuPrincipal implements GuiBuilder {
    @Override
    public String name() {
        return "Menu Principal";
    }

    @Override
    public int getSize() {
        return 6 * 9;
    }

    @Override
    public void contents(Player player, Inventory inv) {
        inv.setItem(0, new ItemStack(Material.DIAMOND));
        inv.setItem(53, new ItemStack(Material.DIAMOND));
    }

    @Override
    public void onClick(Player player, Inventory inv, ItemStack current, int slot) {
        if (Objects.requireNonNull(current.getType()) == Material.DIAMOND) {
            player.sendMessage("§a[TestGUI] §eDiamond");
        } else {
            player.sendMessage("§a[TestGUI] §eDefault");
        }
        switch (slot){
            case 0:
                player.sendMessage("§a[TestGUI] §eSlot 0");
                break;
            case 53:
                player.sendMessage("§a[TestGUI] §eSlot 53");
                break;
            default:
                player.sendMessage("§a[TestGUI] §eDefault");
                break;
        }

    }
}
