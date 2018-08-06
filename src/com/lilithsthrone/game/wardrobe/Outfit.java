package com.lilithsthrone.game.wardrobe;


import com.lilithsthrone.game.character.CharacterUtils;
import com.lilithsthrone.game.inventory.InventorySlot;
import com.lilithsthrone.game.inventory.clothing.AbstractClothing;
import com.lilithsthrone.game.inventory.weapon.AbstractWeapon;
import com.lilithsthrone.utils.XMLSaving;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.EnumMap;
import java.util.List;

/**
 * @since 0.2.9
 * @version 0.2.9
 * @author Alaco
 */

class Outfit implements XMLSaving {
	private EnumMap<InventorySlot,WardrobeItem> equipmentMap;
//	private WardrobeItem mainWeapon = null;
//	private WardrobeItem offWeapon = null;
    private String name;
    private int weaponCount = 0;


	Outfit(String name, List<AbstractClothing> equippedClothes, AbstractWeapon mainWeapon, AbstractWeapon offhandWeapon) {
	    this.equipmentMap = new EnumMap<>(InventorySlot.class);
        this.name = name;

        equippedClothes.forEach(clothing -> this.equipmentMap.put(clothing.getClothingType().getSlot(),new WardrobeItem(clothing)));

        if(mainWeapon != null){
           this.equipmentMap.put(InventorySlot.WEAPON_MAIN,new WardrobeItem(mainWeapon));
           this.weaponCount++;
        }
        if(offhandWeapon != null){
            this.equipmentMap.put(InventorySlot.WEAPON_OFFHAND,new WardrobeItem(offhandWeapon));
            this.weaponCount++;
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
	    WardrobeItem removed = this.equipmentMap.remove(slot);
	    if(removed != null && (removed.getSlot() == InventorySlot.WEAPON_MAIN || removed.getSlot() == InventorySlot.WEAPON_OFFHAND)){
	        this.weaponCount--;
        }
    }


    void addEquipment(InventorySlot slot, AbstractClothing clothing){
	    this.equipmentMap.put(slot,new WardrobeItem(clothing));
    }

    void addEquipment(InventorySlot slot, AbstractWeapon weapon){
	    this.equipmentMap.put(slot,new WardrobeItem(weapon));
	    this.weaponCount++;
    }


    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    WardrobeItem[] toArray(){
	    return this.equipmentMap.values().toArray(new WardrobeItem[0]);
    }

    // Used during load from file
    private void addWardrobeItem(WardrobeItem item) {
	    this.equipmentMap.put(item.getSlot(),item);
	    if(item.getSlot() == InventorySlot.WEAPON_MAIN || item.getSlot() == InventorySlot.WEAPON_OFFHAND){
	        this.weaponCount++;
        }
    }

    @Override
    public Element saveAsXML(Element parentElement, Document doc) {
        Element outfit = doc.createElement("Outfit");
        parentElement.appendChild(outfit);

        CharacterUtils.createXMLElementWithValue(doc,outfit,"Name",this.name);
        CharacterUtils.createXMLElementWithValue(doc,outfit,"ItemCount",Integer.toString(this.equipmentMap.values().size() - this.weaponCount));
        CharacterUtils.createXMLElementWithValue(doc,outfit,"WeaponCount",Integer.toString(this.weaponCount));
        Element wardrobeItems = doc.createElement("WardrobeItems");
        outfit.appendChild(wardrobeItems);
        for(WardrobeItem item : this.equipmentMap.values()){
            item.saveAsXML(wardrobeItems,doc);
        }

        return outfit;
    }

    static Outfit loadFromXML(Element parentElement, Document doc) {
        Outfit imported;

        String name = parentElement.getAttribute("Name");
        int itemCount = Integer.valueOf(parentElement.getAttribute("ItemCount"));
        int weaponCount = Integer.valueOf(parentElement.getAttribute("WeaponCount"));

        imported = new Outfit(name);

        NodeList wardrobeItems = ((Element) parentElement.getElementsByTagName("WardrobeItems").item(0)).getElementsByTagName("WardrobeItem");

        for(int i = 0; i < itemCount + weaponCount;i++){
            Element item = ((Element) wardrobeItems.item(i));

            WardrobeItem wItem;

            if(i > itemCount) {
                wItem = WardrobeItem.loadFromXML(item,doc,false);
            } else {
                wItem = WardrobeItem.loadFromXML(item,doc,true);
            }

            imported.addWardrobeItem(wItem);
        }


	    return imported;
    }
}