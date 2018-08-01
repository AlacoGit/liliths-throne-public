package com.lilithsthrone.game.wardrobe;


import com.lilithsthrone.game.inventory.InventorySlot;
import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.weapon.AbstractWeapon;

import java.util.EnumMap;
import java.util.List;

class Outfit {
	private EnumMap<InventorySlot,WardrobeItem> equipmentMap;
    private String name;


	Outfit(String name, List<AbstractClothing> equippedClothes, AbstractWeapon mainWeapon, AbstractWeapon offhandWeapon) {
	    this.equipmentMap = new EnumMap<>(InventorySlot.class);
        this.name = name;

        equippedClothes.forEach(clothing -> equipmentMap.put(clothing.getClothingType().getSlot(),new WardrobeItem(clothing)));

        if(mainWeapon != null){
            equipmentMap.put(mainWeapon.getWeaponType().getSlot(),new WardrobeItem(mainWeapon));
        }
        if(offhandWeapon != null){
            equipmentMap.put(offhandWeapon.getWeaponType().getSlot(),new WardrobeItem(offhandWeapon));
        }
    }

    Outfit(String name, List<AbstractClothing> equippedClothes) {
	    this(name,equippedClothes,null,null);
    }

    // Used for empty Outfit
    Outfit(String name){
        this.equipmentMap = new EnumMap<>(InventorySlot.class);
        this.name = name;
    }

    void removeEquipment(InventorySlot slot){
	    equipmentMap.remove(slot);
    }

    void addEquipment(InventorySlot slot, AbstractClothing clothing){
	    equipmentMap.put(slot,new WardrobeItem(clothing));
    }

    void addEquipment(InventorySlot slot, AbstractWeapon weapon){
	    equipmentMap.put(slot,new WardrobeItem(weapon));
    }


    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    WardrobeItem[] toArray(){
	    return equipmentMap.values().toArray(new WardrobeItem[0]);
    }

}