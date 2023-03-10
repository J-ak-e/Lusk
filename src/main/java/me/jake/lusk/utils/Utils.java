package me.jake.lusk.utils;

import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.util.SkriptColor;
import me.jake.lusk.classes.Version;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {

    // Main method
    public static void setEverything() {
        setServerVersion();
        setSmallCapsLetters();
        setVersions();
        setRarityColors();
        setTillables();
        setPathables();
        setStrippables();
        setWaxables();
        setAxeables();
        setHoes();
        setAxes();
        setShovels();
        setSaplings();
        setLeaves();
        setFlowers();
        setCompostablesWithChances();
        setCompostables();
    }

    // Fields
    private static Version serverVersion;
    private static String smallCapsLetters;
    private static HashMap<Integer, Version> versions;
    private static HashMap<String, SkriptColor> rarityColors;
    private static ArrayList<Material> tillables;
    private static ArrayList<Material> pathables;
    private static ArrayList<Material> axes;
    private static ArrayList<Material> hoes;
    private static ArrayList<Material> shovels;
    private static ArrayList<Material> strippables;
    private static ArrayList<Material> waxables;
    private static ArrayList<Material> axeables;
    private static ArrayList<Material> saplings;
    private static ArrayList<Material> leaves;
    private static ArrayList<Material> flowers;
    private static HashMap<Material, Integer> compostablesWithChances;
    private static ArrayList<Material> compostables;

    // Set
    public static void setServerVersion() {
        serverVersion = Version.parse(Bukkit.getMinecraftVersion());
    }
    public static void setSmallCapsLetters() {
        smallCapsLetters = "ᴀʙᴄᴅᴇғɢʜɪᴊᴋʟᴍɴᴏᴘǫʀsᴛᴜᴠᴡxʏᴢ";
    }
    public static void setVersions() {
        versions = new HashMap<>() {{
            put(4, new Version(1,7,5));
            put(5,new Version(1,7,10));
            put(47,new Version(1,8,9));
            put(107,new Version(1,9));
            put(108,new Version(1,9,1));
            put(109,new Version(1,9,2));
            put(110,new Version(1,9,4));
            put(210,new Version(1,10,2));
            put(315,new Version(1,11));
            put(316,new Version(1,11,2));
            put(335,new Version(1,12));
            put(338,new Version(1,12,1));
            put(340,new Version(1,12,2));
            put(393,new Version(1,13));
            put(401,new Version(1,13,1));
            put(404,new Version(1,13,2));
            put(477,new Version(1,14));
            put(480,new Version(1,14,1));
            put(485,new Version(1,14,2));
            put(490,new Version(1,14,3));
            put(498,new Version(1,14,4));
            put(573,new Version(1,15));
            put(575,new Version(1,15,1));
            put(577,new Version(1,15,2));
            put(735,new Version(1,16));
            put(736,new Version(1,16,1));
            put(751,new Version(1,16,2));
            put(753,new Version(1,16,3));
            put(754,new Version(1,16,5));
            put(755,new Version(1,17));
            put(756,new Version(1,17,1));
            put(757,new Version(1,18,1));
            put(758,new Version(1,18,2));
            put(759,new Version(1,19));
            put(760,new Version(1,19,2));
            put(761,new Version(1,19,3));
        }};
    }

    public static void setRarityColors() {
        rarityColors = new HashMap<>() {{
            put("COMMON", SkriptColor.WHITE);
            put("UNCOMMON", SkriptColor.YELLOW);
            put("RARE", SkriptColor.LIGHT_CYAN);
            put("EPIC", SkriptColor.LIGHT_PURPLE);
        }};
    }

    public static void setPathables() {
        pathables = new ArrayList<>() {{
            add(Material.DIRT);
            add(Material.COARSE_DIRT);
            add(Material.GRASS_BLOCK);
            add(Material.ROOTED_DIRT);
            add(Material.MYCELIUM);
            add(Material.PODZOL);
        }};
    }

    public static void setTillables() {
        tillables = new ArrayList<>() {{
            add(Material.DIRT);
            add(Material.COARSE_DIRT);
            add(Material.DIRT_PATH);
            add(Material.GRASS_BLOCK);
            add(Material.ROOTED_DIRT);
        }};
    }
    public static void setStrippables() {
        strippables = new ArrayList<>() {{
            add(Material.OAK_LOG);
            add(Material.OAK_WOOD);
            add(Material.SPRUCE_LOG);
            add(Material.SPRUCE_WOOD);
            add(Material.BIRCH_LOG);
            add(Material.BIRCH_WOOD);
            add(Material.JUNGLE_LOG);
            add(Material.JUNGLE_WOOD);
            add(Material.DARK_OAK_LOG);
            add(Material.DARK_OAK_WOOD);
            add(Material.ACACIA_LOG);
            add(Material.ACACIA_WOOD);
            if (getServerVersion().isNewerThanOrEqualTo(new Version(1, 19))) {
                add(Material.MANGROVE_LOG);
                add(Material.MANGROVE_WOOD);
            }
            if (getServerVersion().isNewerThanOrEqualTo(new Version(1, 16))) {
                add(Material.CRIMSON_HYPHAE);
                add(Material.CRIMSON_STEM);
                add(Material.WARPED_HYPHAE);
                add(Material.WARPED_STEM);
            }
        }};
    }
    public static void setWaxables() {
        waxables = new ArrayList<>() {{
            if (getServerVersion().isNewerThanOrEqualTo(new Version(1, 17))) {
                add(Material.OXIDIZED_COPPER);
                add(Material.OXIDIZED_CUT_COPPER);
                add(Material.OXIDIZED_CUT_COPPER_SLAB);
                add(Material.OXIDIZED_CUT_COPPER_STAIRS);
                add(Material.WAXED_OXIDIZED_COPPER);
                add(Material.WAXED_OXIDIZED_CUT_COPPER);
                add(Material.WAXED_OXIDIZED_CUT_COPPER_SLAB);
                add(Material.WAXED_OXIDIZED_CUT_COPPER_STAIRS);
                add(Material.WEATHERED_COPPER);
                add(Material.WEATHERED_CUT_COPPER);
                add(Material.WEATHERED_CUT_COPPER_SLAB);
                add(Material.WEATHERED_CUT_COPPER_STAIRS);
                add(Material.WAXED_WEATHERED_COPPER);
                add(Material.WAXED_WEATHERED_CUT_COPPER);
                add(Material.WAXED_WEATHERED_CUT_COPPER_SLAB);
                add(Material.WAXED_WEATHERED_CUT_COPPER_STAIRS);
                add(Material.EXPOSED_COPPER);
                add(Material.EXPOSED_CUT_COPPER);
                add(Material.EXPOSED_CUT_COPPER_SLAB);
                add(Material.EXPOSED_CUT_COPPER_STAIRS);
                add(Material.WAXED_EXPOSED_COPPER);
                add(Material.WAXED_EXPOSED_CUT_COPPER);
                add(Material.WAXED_EXPOSED_CUT_COPPER_SLAB);
                add(Material.WAXED_EXPOSED_CUT_COPPER_STAIRS);
            }
        }};
    }
    public static void setAxeables() {
        axeables = new ArrayList<>() {{
            addAll(getWaxables());
            addAll(getStrippables());
        }};
    }
    public static void setSaplings() {
        saplings = new ArrayList<>() {{
            add(Material.OAK_SAPLING);
            add(Material.BIRCH_SAPLING);
            add(Material.SPRUCE_SAPLING);
            add(Material.JUNGLE_SAPLING);
            add(Material.DARK_OAK_SAPLING);
            add(Material.ACACIA_SAPLING);
            if (getServerVersion().isNewerThanOrEqualTo(new Version(1, 19))) {
                add(Material.MANGROVE_PROPAGULE);
            }
        }};
    }
    public static void setLeaves() {
        leaves = new ArrayList<>() {{
            add(Material.OAK_LEAVES);
            add(Material.BIRCH_LEAVES);
            add(Material.SPRUCE_LEAVES);
            add(Material.JUNGLE_LEAVES);
            add(Material.DARK_OAK_LEAVES);
            add(Material.ACACIA_LEAVES);
            add(Material.AZALEA_LEAVES);
            if (getServerVersion().isNewerThanOrEqualTo(new Version(1, 19))) {
                add(Material.MANGROVE_LEAVES);
            }
        }};
    }
    public static void setFlowers() {
        flowers = new ArrayList<>() {{
            add(Material.DANDELION);
            add(Material.POPPY);
            add(Material.BLUE_ORCHID);
            add(Material.ALLIUM);
            add(Material.AZURE_BLUET);
            add(Material.ORANGE_TULIP);
            add(Material.PINK_TULIP);
            add(Material.RED_TULIP);
            add(Material.WHITE_TULIP);
            add(Material.OXEYE_DAISY);
            add(Material.LILY_OF_THE_VALLEY);
            add(Material.SUNFLOWER);
            add(Material.LILAC);
            add(Material.ROSE_BUSH);
            add(Material.PEONY);
        }};
    }
    public static void setCompostablesWithChances() {
        compostablesWithChances = new HashMap<>() {{
            put(Material.BEETROOT_SEEDS,30);
            put(Material.DRIED_KELP,30);
            put(Material.GLOW_BERRIES,30);
            put(Material.GRASS,30);
            put(Material.HANGING_ROOTS,30);
            if (getServerVersion().isNewerThanOrEqualTo(new Version(1, 19))) {
                put(Material.MANGROVE_ROOTS,30);
            }
            put(Material.KELP,30);
            put(Material.MELON_SEEDS,30);
            put(Material.PUMPKIN_SEEDS,30);
            put(Material.MOSS_CARPET,30);
            put(Material.SEAGRASS,30);
            put(Material.SMALL_DRIPLEAF,30);
            put(Material.SWEET_BERRIES,30);
            put(Material.WHEAT_SEEDS,30);
            for (Material material : getSaplings()) {
                put(material,30);
            }
            for (Material material : getLeaves()) {
                put(material,30);
            }
            put(Material.CACTUS,50);
            put(Material.DRIED_KELP_BLOCK,50);
            put(Material.FLOWERING_AZALEA_LEAVES,50);
            put(Material.GLOW_LICHEN,50);
            put(Material.MELON_SLICE,50);
            put(Material.NETHER_SPROUTS,50);
            put(Material.SUGAR_CANE,50);
            put(Material.TALL_GRASS,50);
            put(Material.TWISTING_VINES,50);
            put(Material.VINE,50);
            put(Material.WEEPING_VINES,50);
            put(Material.APPLE,65);
            put(Material.AZALEA,65);
            put(Material.BEETROOT,65);
            put(Material.BIG_DRIPLEAF,65);
            put(Material.CARROT,65);
            put(Material.COCOA_BEANS,65);
            put(Material.FERN,65);
            put(Material.LARGE_FERN,65);
            for (Material material : getFlowers()) {
                put(material,65);
            }
            put(Material.CRIMSON_FUNGUS,65);
            put(Material.WARPED_FUNGUS,65);
            put(Material.LILY_PAD,65);
            put(Material.MELON,65);
            put(Material.MOSS_BLOCK,65);
            put(Material.BROWN_MUSHROOM,65);
            put(Material.RED_MUSHROOM,65);
            put(Material.MUSHROOM_STEM,65);
            put(Material.NETHER_WART,65);
            put(Material.POTATO,65);
            put(Material.PUMPKIN,65);
            put(Material.CARVED_PUMPKIN,65);
            put(Material.CRIMSON_ROOTS,65);
            put(Material.WARPED_ROOTS,65);
            put(Material.SEA_PICKLE,65);
            put(Material.SHROOMLIGHT,65);
            put(Material.SPORE_BLOSSOM,65);
            put(Material.WHEAT,65);
            put(Material.BAKED_POTATO,85);
            put(Material.BREAD,85);
            put(Material.COOKIE,85);
            put(Material.FLOWERING_AZALEA,85);
            put(Material.HAY_BLOCK,85);
            put(Material.RED_MUSHROOM_BLOCK,85);
            put(Material.BROWN_MUSHROOM_BLOCK,85);
            put(Material.NETHER_WART_BLOCK,85);
            put(Material.WARPED_WART_BLOCK,85);
            put(Material.CAKE,100);
            put(Material.PUMPKIN_PIE,100);

        }};
    }
    public static void setCompostables() {
        compostables = new ArrayList<>(getCompostablesWithChances().keySet().stream().toList());
    }
    public static void setAxes() {
        axes = new ArrayList<>() {{
            add(Material.WOODEN_AXE);
            add(Material.GOLDEN_AXE);
            add(Material.STONE_AXE);
            add(Material.IRON_AXE);
            add(Material.DIAMOND_AXE);
            add(Material.NETHERITE_AXE);
        }};
    }
    public static void setHoes() {
        hoes = new ArrayList<>() {{
            add(Material.WOODEN_HOE);
            add(Material.GOLDEN_HOE);
            add(Material.STONE_HOE);
            add(Material.IRON_HOE);
            add(Material.DIAMOND_HOE);
            add(Material.NETHERITE_HOE);
        }};
    }
    public static void setShovels() {
        shovels = new ArrayList<>() {{
            add(Material.WOODEN_SHOVEL);
            add(Material.GOLDEN_SHOVEL);
            add(Material.STONE_SHOVEL);
            add(Material.IRON_SHOVEL);
            add(Material.DIAMOND_SHOVEL);
            add(Material.NETHERITE_SHOVEL);
        }};
    }

    // Get
    public static Version getServerVersion() {
        return serverVersion;
    }
    public static HashMap<Integer, Version> getVersions() {
        return versions;
    }
    public static Version getPlayerVersion(int protocolNumber) {
        return getVersions().get(protocolNumber);
    }
    public static String getSmallCapsLetters() {
        return smallCapsLetters;
    }
    public static HashMap<String, SkriptColor> getRarityColors() {
        return rarityColors;
    }
    public static ArrayList<Material> getPathables() {
        return pathables;
    }
    public static ArrayList<Material> getTillables() {
        return tillables;
    }
    public static ArrayList<Material> getStrippables() {
        return strippables;
    }
    public static ArrayList<Material> getWaxables() {
        return waxables;
    }
    public static ArrayList<Material> getAxeables() {
        return axeables;
    }
    public static ArrayList<Material> getAxes() {
        return axes;
    }
    public static ArrayList<Material> getHoes() {
        return hoes;
    }
    public static ArrayList<Material> getShovels() {
        return shovels;
    }
    public static ArrayList<Material> getSaplings() {
        return saplings;
    }
    public static ArrayList<Material> getLeaves() {
        return leaves;
    }
    public static ArrayList<Material> getFlowers() {
        return flowers;
    }
    public static HashMap<Material, Integer> getCompostablesWithChances() {
        return compostablesWithChances;
    }
    public static ArrayList<Material> getCompostables() {
        return compostables;
    }
    public static int getCompostChance(Material material) {
        return getCompostablesWithChances().get(material) != null ? getCompostablesWithChances().get(material) : 0;
    }

    // Conditions
    public static boolean isCrawling(Player player) {
        if (!player.isSwimming() && !player.isGliding()) {
            return Math.round(player.getHeight() * 10) == 6;
        }
        return false;
    }
    public static boolean isNPC(Entity entity) {
        return entity.hasMetadata("NPC");
    }
    public static boolean isInteger(String string) {
        return string.matches("\\d+");
    }
    public static boolean isBoolean(String string) {
        return string.equalsIgnoreCase("true") || string.equalsIgnoreCase("false");
    }
    public static boolean isAxe(Material material) {
        return getAxes().contains(material);
    }
    public static boolean isHoe(Material material) {
        return getHoes().contains(material);
    }
    public static boolean isShovel(Material material) {
        return getShovels().contains(material);
    }
    public static boolean isPathable(Material material) {
        return getPathables().contains(material);
    }
    public static boolean isTillable(Material material) {
        return getTillables().contains(material);
    }
    public static boolean isAxeable(Material material) {
        return getAxeables().contains(material);
    }
    public static boolean isStrippable(Material material) {
        return getStrippables().contains(material);
    }
    public static boolean isWaxable(Material material) {
        return getWaxables().contains(material);
    }
    public static boolean isCompostable(Material material) {
        return getCompostablesWithChances().containsKey(material);
    }

    // Other

    public static ItemType[] toItemTypes(List<Material> materials) {
        ItemType[] itemTypes = new ItemType[materials.size()-1];
        for (int index = 0; index < itemTypes.length; index++) {
            itemTypes[index] = new ItemType(materials.get(index));
        }
        return itemTypes;
    }

    public static Object getBlockDataTag(BlockData blockData, String tag) {
        String fullData = blockData.getAsString();
        if (fullData.contains("[")) {
            String data = fullData.replaceAll("(minecraft:[a-z0-9_]+\\[|])", "");
            String splitDelimiter = null;
            if (data.contains(";"+tag+"=")) {
                splitDelimiter = ";"+tag+"=";
            } else if (data.startsWith(tag+"=")) {
                splitDelimiter = tag + "=";
            }
            if (splitDelimiter != null) {
                String[] split = data.split(splitDelimiter);
                String value = split[1].split(";")[0];
                if (isInteger(value)) {
                    return Integer.valueOf(value);
                } else if (isBoolean(value)) {
                    return Boolean.getBoolean(value);
                }
            }

        }
        return null;
    }

    public static double roundToDecimal(double number, double index, int round) {
        double pow = Math.pow(10.0, index);
        double num = pow*number;
        Number result;
        switch (round) {
            case -1 -> result = Math.floor(num) / pow;
            case 1 -> result = Math.ceil(num) / pow;
            default -> result = Math.round(num) / pow;
        }
        return result.doubleValue();
    }

    public static String toSmallFont(String string, boolean fully) {
        if (fully) {
            string =  string.toLowerCase();
        }
        for (String letter: string.split("")) {
            if (letter.matches("[a-z]")) {
                string = string.replaceAll(letter, String.valueOf(getSmallCapsLetters().charAt(Character.getNumericValue(letter.charAt(0)) - 10)));
            }
        }
        return string;
    }
}
