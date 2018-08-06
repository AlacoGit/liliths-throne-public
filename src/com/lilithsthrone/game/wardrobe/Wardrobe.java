package com.lilithsthrone.game.wardrobe;

import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.weapon.AbstractWeapon;
import com.lilithsthrone.utils.XMLSaving;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @since 0.2.9
 * @version 0.2.9
 * @author Alaco
 */

public class Wardrobe implements XMLSaving {

    private static final String WARDROBE_PATH = "res/wardrobe/Wardrobe.xml";

    private LinkedHashMap<String,Outfit> Outfits;
	private List<AbstractClothing> clothingInventory;
	private List<AbstractWeapon> weaponInventory;

	public Wardrobe(){
	    this.Outfits = new LinkedHashMap<>();
    }

    @Override
    public Element saveAsXML(Element parentElement, Document doc) {
        return null;
    }

    public static Wardrobe loadFromXML(Element element, Document doc){

        return null;
    }
}