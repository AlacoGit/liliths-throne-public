package com.lilithsthrone.game.wardrobe;


import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.game.inventory.enchanting.ItemEffect;
import com.lilithsthrone.game.inventory.weapon.AbstractWeapon;
import com.lilithsthrone.game.inventory.weapon.WeaponType;

import java.util.ArrayList;

public class WardrobeItem {

//    private String type;
//    private String itemID;
//    private String name;
    private String SVGString;
    private int itemHashCode;
//    private String colour;
//    private String colourSecondary;
//    private String colourTeritary;
//    private String pattern;
//    private String patternColour;
//    private String patternColourSecondary;
//    private String patternColourTeritary;
//    private ArrayList<String> effectList;
//    private boolean ignoreEnchantments;

    public WardrobeItem(AbstractClothing clothing) {
/*        this.itemID = ClothingType.getIdFromClothingType(clothing.getClothingType());
        this.name = clothing.getName();
        this.colour = clothing.getColour().getName();
        this.colourSecondary = clothing.getSecondaryColour().getName();
        this.colourTeritary = clothing.getTertiaryColour().getName();
        this.pattern = clothing.getPattern();
        this.patternColour = clothing.getPatternColour().getName();
        this.patternColourSecondary = clothing.getPatternSecondaryColour().getName();
        this.patternColourTeritary = clothing.getPatternTertiaryColour().getName();
        this.effectList = new ArrayList<>();
        for(ItemEffect effect : clothing.getEffects()) {
            this.effectList.add(effect.toString());
        }
        */
        this.SVGString = clothing.getSVGString();
        this.itemHashCode = clothing.hashCode();
    }

    public WardrobeItem(AbstractWeapon weapon) {
/*        this.itemID = WeaponType.weaponToIdMap.get(weapon.getWeaponType());
        this.name = weapon.getName();
        this.colour = weapon.getColour().getName();
        this.colourSecondary = weapon.getSecondaryColour().getName();

        this.effectList = new ArrayList<>();
        for(ItemEffect effect : weapon.getEffects()) {
            this.effectList.add(effect.toString());
        }*/
        this.SVGString = weapon.getSVGString();
        this.itemHashCode = weapon.hashCode();
    }

    public boolean compareTo(AbstractClothing clothing, boolean ignoreEnchantments) {
/*        if(this.itemID.compareTo(ClothingType.getIdFromClothingType(clothing.getClothingType()))!=0){
            return false;
        }
        if(this.name.compareTo(clothing.getName())!=0){
            return false;
        }
        if(this.colour.compareTo(clothing.getColour().getName())!=0){
            return false;
        }
        if(this.colourSecondary.compareTo(clothing.getSecondaryColour().getName())!=0){
            return false;
        }
        if(this.colourTeritary.compareTo(clothing.getTertiaryColour().getName())!=0){
            return false;
        }
        if(this.pattern.compareTo(clothing.getPattern())!=0){
            return false;
        }
        if(this.patternColour.compareTo(clothing.getPatternColour().getName())!=0){
            return false;
        }
        if(this.patternColourSecondary.compareTo(clothing.getPatternSecondaryColour().getName())!=0){
            return false;
        }
        if(this.patternColourTeritary.compareTo(clothing.getPatternTertiaryColour().getName())!=0){
            return false;
        }
        if(!ignoreEnchantments){
            for(ItemEffect effect : clothing.getEffects()){
                if(!effectList.contains(effect.toString())){
                    return false;
                }
            }
        }
        return true;*/
        return clothing.hashCode() == this.itemHashCode;
    }

    public boolean compareTo(AbstractWeapon weapon, boolean ignoreEnchantments) {
        return weapon.hashCode() == this.itemHashCode;
    }

    public String getSVGString() {
        return this.SVGString;
    }


}