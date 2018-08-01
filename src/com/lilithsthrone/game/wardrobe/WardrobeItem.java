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

    private AbstractClothing clothing = null;
    private AbstractWeapon weapon = null;

    WardrobeItem(AbstractClothing clothing) {
        this(clothing,false);
    }

    WardrobeItem(AbstractWeapon weapon) {
        this(weapon,false);
    }

    WardrobeItem(AbstractClothing clothing, boolean imported) {
        if(imported){
            this.clothing = clothing;
        } else {
            this.clothing = copyOf(clothing);
        }
    }

    WardrobeItem(AbstractWeapon weapon, boolean imported) {
        if(imported){
            this.weapon = weapon;
        } else {
            this.weapon = copyOf(weapon);
        }
    }

    private void importItem(AbstractClothing clothing){
        this.clothing = clothing;
    }

    private void importItem(AbstractWeapon weapon) {
        this.weapon = weapon;
    }

    // TODO
    private AbstractClothing copyOf(AbstractClothing clothing){
        return null;
    }

    //TODO
    private AbstractWeapon copyOf(AbstractWeapon weapon) {
        return null;
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
        return this.clothing.equals(clothing);
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
        return this.weapon.equals(weapon);
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



    @Override
    public Element saveAsXML(Element parentElement, Document doc) {
        Element wardrobeItem = doc.createElement("WardrobeItem");
        parentElement.appendChild(wardrobeItem);
        if(this.clothing != null){
            CharacterUtils.createXMLElementWithValue(doc,wardrobeItem,"isClothing", "true");
        } else {
            CharacterUtils.createXMLElementWithValue(doc,wardrobeItem,"isClothing", "false");
        }

        if(this.clothing != null) {
            clothing.saveAsXML(wardrobeItem, doc);
        } else {
            weapon.saveAsXML(wardrobeItem, doc);
        }

        return wardrobeItem;
    }

    static WardrobeItem loadFromXML(Element parentElement, Document doc) {
        WardrobeItem importedItem;

        Element wardrobeItemElement = (Element) parentElement.getElementsByTagName("WardrobeItem").item(0);

        boolean isClothing = Boolean.valueOf(wardrobeItemElement.getAttribute("isClothing"));

        if(isClothing){
            importedItem = new WardrobeItem(AbstractClothing.loadFromXML(wardrobeItemElement,doc),true);
        } else {
            importedItem = new WardrobeItem(AbstractWeapon.loadFromXML(wardrobeItemElement,doc),true);
        }

        return importedItem;
    }
}