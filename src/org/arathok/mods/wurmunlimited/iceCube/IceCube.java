package org.arathok.mods.wurmunlimited.iceCube;

import com.wurmonline.server.creatures.Communicator;
import com.wurmonline.server.players.Player;
import org.gotti.wurmunlimited.modloader.interfaces.*;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IceCube implements WurmServerMod, PreInitable, Initable, Configurable, PlayerMessageListener,PlayerLoginListener,ServerPollListener,ServerStartedListener,ItemTemplatesCreatedListener {

    public static final Logger logger = Logger.getLogger("IceCube");

    @Override
    public void configure(Properties properties) {
        //Code is called in the phase where server reads .properties files
    }

    @Override
    public void onItemTemplatesCreated() {
        //Code is called in the phase where items are generated
        logger.log(Level.INFO,"creating IceCube Item!");
        try {

            IceCubeItem.registerIceCube();



        } catch (IOException e) {
            logger.log(Level.WARNING,"Something went wrong creating the Item!"+e.getMessage(),e);
            //with this logging you can remove printStacktrace
            throw new RuntimeException(e);
        }
        logger.log(Level.INFO,"Done creating IceCube Item!");
    }

    @Override
    public void onPlayerLogin(Player player) {
        //Code is called when ANY player logs in
        if (player.getName().equals("Arathisgm"))
        {
            player.getCommunicator().sendSafeServerMessage("Hello Master!");
        }
        else
        {
            player.getCommunicator().sendAlertServerMessage("Welcome back, scum!");
        }

    }

    @Override
    public boolean onPlayerMessage(Communicator communicator, String s) {
        //Code is called when ANY player types a message (in local)

        if (s.equals("/joke"))
        {
            communicator.sendNormalServerMessage("Why did the Chicken cross the road? Because it wanted to switch sides!");
        }

        return false;
    }

    @Override
    public void onServerPoll() {
        //Code is called EVERY Server tick (10 ms)
    }

    @Override
    public void onServerStarted() {
        //Code is called ONCE when the server has booted
    }

    @Override
    public void init() {
        //Code is called ONCE when the server initializes
        WurmServerMod.super.init();
    }

    @Override
    public void preInit() {
        //Code is called ONCE before the server initializes
        WurmServerMod.super.preInit();
    }
}
