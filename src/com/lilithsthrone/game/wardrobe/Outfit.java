package com.lilithsthrone.game.wardrobe;


import com.lilithsthrone.game.inventory.InventorySlot;
import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.clothing.ClothingType;
import com.lilithsthrone.game.inventory.enchanting.ItemEffect;
import com.lilithsthrone.game.inventory.weapon.AbstractWeapon;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Consumer;


public class Outfit {
    private boolean ignoreEnchantments;
	private EnumMap<InventorySlot,WardrobeItem> equipmentMap;
    private String name;


	public Outfit(String name, List<AbstractClothing> equippedClothes, AbstractWeapon mainWeapon, AbstractWeapon offhandWeapon, boolean ignoreEnchantments) {
	    this.equipmentMap = new EnumMap<>(InventorySlot.class);
	    this.ignoreEnchantments = ignoreEnchantments;
        this.name = name;
        equippedClothes.forEach(new Consumer<AbstractClothing>() {
            @Override
            public void accept(AbstractClothing clothing) {
                equipmentMap.put(clothing.getClothingType().getSlot(),new WardrobeItem(clothing));
            }
        });
        if(mainWeapon != null){
            equipmentMap.put(mainWeapon.getWeaponType().getSlot(),new WardrobeItem(mainWeapon));
        }
        if(offhandWeapon != null){
            equipmentMap.put(offhandWeapon.getWeaponType().getSlot(),new WardrobeItem(offhandWeapon));
        }
    }

    public Outfit(String name, List<AbstractClothing> equippedClothes, boolean ignoreEnchantments) {
	    this(name,equippedClothes,null,null,ignoreEnchantments);
    }

    public void removeEquipment(InventorySlot slot){
	    equipmentMap.remove(slot);
    }

    public void addEquipment(InventorySlot slot, AbstractClothing clothing){
	    equipmentMap.put(slot,new WardrobeItem(clothing));
    }

    public void addEquipment(InventorySlot slot, AbstractWeapon weapon){
	    equipmentMap.put(slot,new WardrobeItem(weapon));
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

}