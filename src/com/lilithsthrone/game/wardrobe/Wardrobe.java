package com.lilithsthrone.game.wardrobe;

import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.weapon.AbstractWeapon;

import java.util.LinkedHashMap;
import java.util.List;

public class Wardrobe {

    private static final String WARDROBE_PATH = "res/wardrobe";

    private LinkedHashMap<String,Outfit> Outfits;
	private List<AbstractClothing> clothingInventory;
	private List<AbstractWeapon> weaponInventory;

}