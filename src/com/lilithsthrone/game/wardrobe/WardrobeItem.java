package com.lilithsthrone.game.wardrobe;


import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.game.inventory.enchanting.ItemEffect;
import com.lilithsthrone.game.inventory.weapon.AbstractWeapon;
import com.lilithsthrone.game.inventory.weapon.WeaponType;
import com.lilithsthrone.utils.XMLSaving;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @since 0.2.9
 * @version 0.2.9
 * @author Alaco
 */

class WardrobeItem implements Serializable, XMLSaving {

    private static final long serialVersionUID = 1L;

	private AbstractClothing clothing;
	private AbstractWeapon weapon;
   	private boolean ignoreEnchantments;
    private boolean ignoreName;

    WardrobeItem(AbstractClothing clothing) {
        this.clothing = this.copyOf(clothing);
    }

    WardrobeItem(AbstractWeapon weapon) {
        this.weapon = this.copyOf(weapon);
    }

    // TODO
    public AbstractClothing copyOf(AbstractClothing toCopy) {
        return null;
    }
    // TODO
    public AbstractWeapon copyOf(AbstractWeapon toCopy) {
        return null;
    }
    public boolean compareTo(AbstractClothing clothing) {
        return this.compareTo(clothing, this.ignoreEnchantments, this.ignoreName);
    }
    public boolean compareTo(AbstractClothing clothing, boolean ignoreEnchantments, boolean ignoreName) {
        if(!ignoreName && this.clothing.getName().compareTo(clothing.getName()) != 0){
            return false;
        }
        if(!ignoreEnchantments){
            ArrayList<ItemEffect> effectList = new ArrayList<ItemEffect>(this.clothing.getEffects());
            for(ItemEffect effect : clothing.getEffects()){
                if(!effectList.contains(effect)){
                    return false;
                }
            }
        }
        return (this.clothing.getClothingType().equals(clothing.getClothingType()) &&
                (this.clothing.getColour() == clothing.getColour()) &&
                (this.clothing.getSecondaryColour() == clothing.getSecondaryColour()) &&
                (this.clothing.getTertiaryColour() == clothing.getTertiaryColour()) &&
                (this.clothing.getPattern().equals(clothing.getPattern())));
    }

    public boolean compareTo(AbstractWeapon weapon) {
        return this.compareTo(weapon, this.ignoreEnchantments, this.ignoreName);
    }
    public boolean compareTo(AbstractWeapon weapon, boolean ignoreEnchantments, boolean ignoreName) {
        if(!ignoreName && this.weapon.getName().compareTo(weapon.getName()) != 0){
            return false;
        }
        if(!ignoreEnchantments){
            ArrayList<ItemEffect> effectList = new ArrayList<ItemEffect>(this.clothing.getEffects());
            for(ItemEffect effect : clothing.getEffects()){
                if(!effectList.contains(effect)){
                    return false;
                }
            }
        }
        return (this.clothing.getClothingType().equals(clothing.getClothingType()) &&
                (this.clothing.getColour() == clothing.getColour()) &&
                (this.clothing.getSecondaryColour() == clothing.getSecondaryColour()) &&
                (this.clothing.getTertiaryColour() == clothing.getTertiaryColour()) &&
                (this.clothing.getPattern().equals(clothing.getPattern())));
    }

    public String getSVGString() {
        // WardrobeItem can be either AbstractClothing or AbstractWeapon but not both at the same time
        if(this.clothing != null) {
            return this.clothing.getSVGString();
        } else {
            return this.weapon.getSVGString();
        }
    }

    public String getSVGEquippedString(GameCharacter character) {
        // Only clothing has an equipped SVG String
        if(this.clothing != null) {
            return this.clothing.getSVGEquippedString(character);
        } else {
            return null;
        }
    }

    public boolean isIgnoreEnchantments() {
        return ignoreEnchantments;
    }

    public void setIgnoreEnchantments(boolean ignoreEnchantments) {
        this.ignoreEnchantments = ignoreEnchantments;
    }

    public boolean isIgnoreName() {
        return ignoreName;
    }

    public void setIgnoreName(boolean ignoreName) {
        this.ignoreName = ignoreName;
    }


    @Override
    public Element saveAsXML(Element parentElement, Document doc) {
        return null;
    }
}