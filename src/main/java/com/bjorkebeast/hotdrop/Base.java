package com.bjorkebeast.hotdrop;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("hotdrop")
public class Base {

    public static final Logger LOGGER = LogManager.getLogger();

    public Base(){

        // Register the event class
        MinecraftForge.EVENT_BUS.register( ModEventHandler.class );
    }
}
