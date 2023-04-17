package fr.kikyo.test;

import fr.kikyo.test.events.onJoin;
import fr.kikyo.test.gui.MenuPrincipal;
import fr.kikyo.test.utils.GuiBuilder;
import fr.kikyo.test.utils.GuiManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public final class TestGUI extends JavaPlugin {

    private Map<Class<? extends GuiBuilder>, GuiBuilder> registeredMenus;

    private GuiManager guiManager;
    private static TestGUI instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;

        guiManager = new GuiManager();
        registeredMenus = new HashMap<>();

        this.registerEvents();
        this.loadGui();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerEvents(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new GuiManager(), this);
        pm.registerEvents(new onJoin(this), this);
    }


    private void loadGui(){
        // Load all Gui
        getServer().getConsoleSender().sendMessage("§a[TestGUI] §eLoading GUI...");
        guiManager.addMenu(new MenuPrincipal());
    }






    //Getters

    public static TestGUI getInstance(){
        return instance;
    }

    public GuiManager getGuiManager() {
        return guiManager;
    }

    public Map<Class<? extends GuiBuilder>, GuiBuilder> getRegisteredMenus() {
        return registeredMenus;
    }
}
