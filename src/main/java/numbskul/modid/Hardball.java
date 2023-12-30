package numbskul.modid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import numbskul.modid.item.custom.RockballItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hardball implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("hardball");

	// item(s)!
	public static final RockballItem ROCK_BALL = Registry.register(Registries.ITEM, new Identifier("hardball", "rockball"), new RockballItem(new FabricItemSettings()));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("hardball (snowball mod) says hello world!");

	}
}