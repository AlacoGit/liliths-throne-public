package com.lilithsthrone.game.wardrobe;


import com.lilithsthrone.game.inventory.InventorySlot;
import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.clothing.ClothingType;

import java.util.EnumMap;
import java.util.List;


public class Outfit {
    private boolean ignoreEnchantments;
	private EnumMap<InventorySlot,String> equipmentMap;
    private String name;


	public Outfit(String name, List<AbstractClothing> equipedClothes, boolean ignoreEnchantments) {
	    this.ignoreEnchantments = ignoreEnchantments;
        this.name = name;
    }

    public boolean isIgnoreEnchantments() {
        return ignoreEnchantments;
    }

    public void setIgnoreEnchantments(boolean ignoreEnchantments) {
        this.ignoreEnchantments = ignoreEnchantments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static String getClothingString(AbstractClothing clothing, boolean ignoreEnchantments) {
	    StringBuilder clothingString = new StringBuilder();

	    clothingString.append(ClothingType.getIdFromClothingType(clothing.getClothingType()));
	    clothingString.append(clothing.getName());

	    if(ignoreEnchantments) {

        }
    }
}