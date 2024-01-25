package name.modid;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.registry.*;
import net.minecraft.text.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Dreamy implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("dreamy");

	// Block Initialization

	public static final Block DREAMSTONE_BRICKS = new Block(FabricBlockSettings.create().strength(2.0f).requiresTool());
	public static final Block DREAMSTONE = new Block(FabricBlockSettings.create().strength(2.0f).requiresTool());

	// Item Initalization

	public static final ToolItem DREAMSTONE_PICKAXE = new PickaxeItem(DreamyToolMaterial.INSTANCE, 1, -2.8F, new FabricItemSettings());
	public static final ToolItem DREAMSTONE_AXE = new AxeItem(DreamyToolMaterial.INSTANCE, 7.0F, -3.2F, new FabricItemSettings());

	// Item Group Initialization

	public static final ItemGroup DREAMY = FabricItemGroup.builder()
			.icon(() -> new ItemStack(DREAMSTONE))
			.displayName(Text.translatable("itemGroup.dreamy.dreamy_group"))
			.entries((context, entries) -> {
				entries.add(DREAMSTONE);
			})
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		// Block registering
		Registry.register(Registries.BLOCK, new Identifier("dreamy", "dreamstone_bricks"), DREAMSTONE_BRICKS);
		Registry.register(Registries.BLOCK, new Identifier("dreamy", "dreamstone"), DREAMSTONE);

		// Item Registering
		Registry.register(Registries.ITEM, new Identifier("dreamy", "dreamstone_bricks"), new BlockItem(DREAMSTONE_BRICKS, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier("dreamy", "dreamstone"), new BlockItem(DREAMSTONE, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier("dreamy", "dreamstone_pickaxe"), DREAMSTONE_PICKAXE);
		Registry.register(Registries.ITEM, new Identifier("dreamy", "dreamstone_axe"), DREAMSTONE_AXE);

		// Item Group Registering
		Registry.register(Registries.ITEM_GROUP, new Identifier("dreamy", "dreamy_group"), DREAMY);

		// Misc Stuff

		LOGGER.info("Hello Fabric world!");
	}
}