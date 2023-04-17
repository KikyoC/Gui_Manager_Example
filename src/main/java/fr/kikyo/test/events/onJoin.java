package fr.kikyo.test.events;

import fr.kikyo.test.TestGUI;
import fr.kikyo.test.gui.MenuPrincipal;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    private final TestGUI main;

    public onJoin(TestGUI main){
        this.main = main;
    }


    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent e){
        main.getGuiManager().open(e.getPlayer(), MenuPrincipal.class);
    }
}
