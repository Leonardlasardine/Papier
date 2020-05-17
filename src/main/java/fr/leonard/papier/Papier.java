package fr.leonard.papier;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;


@Mod("papier")
public class Papier {
    //Loger
    public static final Logger LOGGER = LogManager.getLogger();

    public Papier(){
        //Setup
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        //Envoyer des données à un autre mod
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        //Recevoir des données des autres mods.
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        //Que le client
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    }

    private void setup(final FMLCommonSetupEvent e) {
        LOGGER.info("Papier version ");
    }

    private void enqueueIMC(final InterModEnqueueEvent e) {
        InterModComms.sendTo("minecraft", "Hello world!", () -> {LOGGER.info("Hello world from Papier"); return "Hello world!";});
    }

    private void processIMC(final InterModEnqueueEvent e) {
        LOGGER.info("Got IMC {}", e.getIMCStream().map(m->m.getMessageSupplier().get()).collect(Collectors.toList()));
    }

    private void doClientStuff(final FMLClientSetupEvent e) {
        LOGGER.info("Got game settings {}", e.getMinecraftSupplier().get().gameSettings);
    }

    //Au lancement du serveur
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    //Événements de registration
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
}
