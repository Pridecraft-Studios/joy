package gay.pridecraft.pridemod.item;


import gay.pridecraft.pridemod.PrideMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item TEST = registerItem("test", new Item(new FabricItemSettings()));
    public static final Item TEST2 = registerItem("test2", new Item(new FabricItemSettings()));
    public static final Item TEST3 = registerItem("test3", new Item(new FabricItemSettings()));
    public static final Item TEST4 = registerItem("test4", new Item(new FabricItemSettings()));
    public static final Item TEST5 = registerItem("test5", new Item(new FabricItemSettings()));


    private static void addToIgredientGroup(FabricItemGroupEntries entries) {
        entries.add(TEST);
        entries.add(TEST2);
        entries.add(TEST3);
        entries.add(TEST4);
        entries.add(TEST5);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(PrideMod.MOD_ID, name), item);
    }


    public static void registerModItems() {

        PrideMod.LOGGER.info("Making the gay items from" + PrideMod.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addToIgredientGroup);

    }
}
