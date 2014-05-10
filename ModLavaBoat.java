package LavaBoat;

import LavaBoat.entity.*;
import LavaBoat.item.ItemLavaBoat;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/*
 * LavaBoat mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION)
public class ModLavaBoat {

    @Instance("LavaBoat")
    public static ModLavaBoat instance;
    @SidedProxy(clientSide = "LavaBoat.client.ClientProxy", serverSide = "LavaBoat.CommonProxy")
    public static CommonProxy proxy;
    // lava boat
    public static int lavaBoatId;
    public static Item lavaBoat;

    public ModLavaBoat() {
        instance = this;
    }

    @Mod.EventHandler
    public void load(FMLInitializationEvent event) {
        lavaBoat = new ItemLavaBoat();
        GameRegistry.registerItem(lavaBoat, "Lava boat");
        for (byte i = 0; i < ItemLavaBoat.NAMES.length; i++) {
            if (i == 0 || i == 3) { //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                ItemStack boatStack = new ItemStack(lavaBoat, 1, i);
                LanguageRegistry.addName(boatStack, ItemLavaBoat.NAMES[i]);
            }
        }

        // recipe
        GameRegistry.addRecipe(new ItemStack(lavaBoat, 1, 0), "xyx", "xxx", 'x', Items.iron_ingot, 'y', Items.boat);
        //GameRegistry.addRecipe(new ItemStack(lavaBoat, 1, 1), "xx", 'x', new ItemStack(lavaBoat, 1, 0));
        GameRegistry.addRecipe(new ItemStack(lavaBoat, 1, 3), "xyx", "xxx", 'x', Blocks.obsidian, 'y', new ItemStack(lavaBoat, 1, 0));
        //GameRegistry.addRecipe(new ItemStack(lavaBoat, 1, 4), "xx", 'x', new ItemStack(lavaBoat, 1, 2));


        EntityRegistry.registerGlobalEntityID(EntityReinforcedBoat.class, "ReinforcedBoat", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityReinforcedBoat.class, "ReinforcedBoat", 0, this, 40, 1, true);
        LanguageRegistry.instance().addStringLocalization("entity.ReinforcedBoat.name", "Reinforced boat");

        EntityRegistry.registerGlobalEntityID(EntityDoubleReinforcedBoat.class, "DoubleReinforcedBoat", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityDoubleReinforcedBoat.class, "DoubleReinforcedBoat", 1, this, 40, 1, true);
        LanguageRegistry.instance().addStringLocalization("entity.DoubleReinforcedBoat.name", "Reinforced double boat");

        EntityRegistry.registerGlobalEntityID(EntityLavaBoat.class, "LavaBoat", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityLavaBoat.class, "LavaBoat", 3, this, 40, 1, true);
        LanguageRegistry.instance().addStringLocalization("entity.LavaBoat.name", "Lava boat");

        EntityRegistry.registerGlobalEntityID(EntityDoubleLavaBoat.class, "DoubleLavaBoat", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityDoubleLavaBoat.class, "DoubleLavaBoat", 4, this, 40, 1, true);
        LanguageRegistry.instance().addStringLocalization("entity.DoubleLavaBoat.name", "Double lava boat");

        EntityRegistry.registerGlobalEntityID(EntityPetBoat.class, "PetBoat", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityPetBoat.class, "PetBoat", 6, this, 40, 1, true);
        LanguageRegistry.instance().addStringLocalization("entity.PetBoat.name", "Pet boat");

        proxy.registerRenderers();
    }
}
