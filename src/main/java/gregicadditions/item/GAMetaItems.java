package gregicadditions.item;

import java.util.List;

import gregicadditions.GAConfig;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.unification.ore.OrePrefix;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GAMetaItems {

	private static List<MetaItem<?>> ITEMS = MetaItem.getMetaItems();

	public static MetaItem<?>.MetaValueItem ELECTRODE_APATITE;
	public static MetaItem<?>.MetaValueItem ELECTRODE_BLAZE;
	public static MetaItem<?>.MetaValueItem ELECTRODE_BRONZE;
	public static MetaItem<?>.MetaValueItem ELECTRODE_COPPER;
	public static MetaItem<?>.MetaValueItem ELECTRODE_DIAMOND;
	public static MetaItem<?>.MetaValueItem ELECTRODE_EMERALD;
	public static MetaItem<?>.MetaValueItem ELECTRODE_ENDER;
	public static MetaItem<?>.MetaValueItem ELECTRODE_GOLD;
	public static MetaItem<?>.MetaValueItem ELECTRODE_IRON;
	public static MetaItem<?>.MetaValueItem ELECTRODE_LAPIS;
	public static MetaItem<?>.MetaValueItem ELECTRODE_OBSIDIAN;
	public static MetaItem<?>.MetaValueItem ELECTRODE_ORCHID;
	public static MetaItem<?>.MetaValueItem ELECTRODE_RUBBER;
	public static MetaItem<?>.MetaValueItem ELECTRODE_TIN;

	public static MetaItem<?>.MetaValueItem BENDING_CYLINDER;
	public static MetaItem<?>.MetaValueItem SMALL_BENDING_CYLINDER;

	public static MetaItem<?>.MetaValueItem SCHEMATIC;
	public static MetaItem<?>.MetaValueItem SCHEMATIC_2X2;
	public static MetaItem<?>.MetaValueItem SCHEMATIC_3X3;
	public static MetaItem<?>.MetaValueItem SCHEMATIC_DUST;

	public static void init() {
		GAMetaItem item = new GAMetaItem(gatherRegisteredPrefixes());
		item.setRegistryName("ga_meta_item");
		GAMetaTool tool = new GAMetaTool();
		tool.setRegistryName("ga_meta_tool");
	}

	public static OrePrefix[] gatherRegisteredPrefixes() {
		OrePrefix[] temp = new OrePrefix[32];

		if(GAConfig.GT6.addCurvedPlates) {
			temp[0] = OrePrefix.valueOf("plateCurved");
		}

		if(GAConfig.GT6.addDoubleIngots) {
			temp[1] = OrePrefix.valueOf("ingotDouble");
		}

		temp[2] = OrePrefix.valueOf("round");

		return temp;
	}

	public static void registerOreDict() {
		for (MetaItem<?> item : ITEMS) {
			if (item instanceof GAMetaItem) {
				((GAMetaItem) item).registerOreDict();
			}
		}
	}

	public static boolean hasPrefix(ItemStack stack, String prefix, String... ignore) {
		for (int i : OreDictionary.getOreIDs(stack)) {
			if (OreDictionary.getOreName(i).startsWith(prefix)) {
				boolean valid = true;
				for (String s : ignore) {
					if (OreDictionary.getOreName(i).startsWith(s)) valid = false;
				}
				if (!valid) continue;
				return true;
			}
		}
		return false;
	}
}
