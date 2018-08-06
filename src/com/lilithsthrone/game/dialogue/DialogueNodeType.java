package com.lilithsthrone.game.dialogue;

/**
 * @since 0.1.0
 * @version 0.2.5
 * @author Innoxia
 */
public enum DialogueNodeType {
	
	NORMAL("normal"),
	
	STATUS_EFFECT_MESSAGE("statusEffectMessage"),
	
	INVENTORY("inventory"),
	
	PHONE("phone"),
	
	CHARACTERS_PRESENT("characters present"),

	SLAVERY_MANAGEMENT("slavery management"),
	
	OPTIONS("options"),

	WARDROBE("wardrobe");

	private String name;

	private DialogueNodeType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
