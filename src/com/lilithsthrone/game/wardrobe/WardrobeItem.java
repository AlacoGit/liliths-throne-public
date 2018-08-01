package com.lilithsthrone.game.wardrobe;


import com.lilithsthrone.game.character.CharacterUtils;
import com.lilithsthrone.game.character.GameCharacter;
import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.weapon.AbstractWeapon;
import com.lilithsthrone.utils.XMLSaving;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.Serializable;


/**
 * @since 0.2.9
 * @version 0.2.9
 * @author Alaco
 */

class WardrobeItem implements Serializable, XMLSaving {

    private static final long serialVersionUID = 1L;

    private int hashCode;

    WardrobeItem(AbstractClothing clothing) {
        this.hashCode = clothing.hashCode();
    }

    WardrobeItem(AbstractWeapon weapon) {
        this.hashCode = weapon.hashCode();
    }

    private WardrobeItem(int hashCode) {
        this.hashCode = hashCode;
    }

    boolean compareTo(AbstractClothing clothing) {
/*        if(!ignoreName && this.clothing.getName().compareTo(clothing.getName()) != 0){
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
                (this.clothing.getPattern().equals(clothing.getPattern())));*/
        return this.hashCode == clothing.hashCode();
    }

    boolean compareTo(AbstractWeapon weapon) {
/*        if(!ignoreName && this.weapon.getName().compareTo(weapon.getName()) != 0){
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
                (this.clothing.getPattern().equals(clothing.getPattern())));*/
        return this.hashCode == weapon.hashCode();
    }

 /*   public boolean isIgnoreEnchantments() {
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
    }*/

    int getHashCode() {
        return hashCode;
    }


    @Override
    public Element saveAsXML(Element parentElement, Document doc) {
        Element wardrobeItem = doc.createElement("WardrobeItem");
        parentElement.appendChild(wardrobeItem);

        CharacterUtils.createXMLElementWithValue(doc,parentElement,"hashCode",String.valueOf(this.hashCode));

        return wardrobeItem;
    }

    static WardrobeItem loadFromXML(Element parentElement, Document doc) {
        Element wardrobeItemElement = (Element) parentElement.getElementsByTagName("WardrobeItem").item(0);

        int ImportedhashCode = (Integer.valueOf(wardrobeItemElement.getAttribute("hashCode")));

        return new WardrobeItem(ImportedhashCode);
    }
}