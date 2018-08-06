package com.lilithsthrone.game.wardrobe;

import com.lilithsthrone.game.dialogue.DialogueNodeOld;
import com.lilithsthrone.game.dialogue.DialogueNodeType;
import com.lilithsthrone.game.dialogue.responses.Response;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.utils.Colour;

/**
 * @since 0.2.9
 * @version 0.2.9
 * @author Alaco
 */

public class WardrobeDialogue {

    public static DialogueNodeOld getWardrobeOverview(){
        return OUTFIT_LIST;
    }

    private static final DialogueNodeOld OUTFIT_LIST = new DialogueNodeOld("Wardrobe Management",".",true) {

        @Override
        public DialogueNodeType getDialogueNodeType() {
            return DialogueNodeType.WARDROBE;
        }

        @Override
        public String getContent() {
            UtilText.nodeContentSB.setLength(0);
            UtilText.nodeContentSB.append("<div class='container-full-width' style='text-align:center;'>"
						+ "<h6 style='color:"+Colour.CURRENCY_GOLD.toWebHexString()+"; text-align:center;'>Your wardrobe</h6>"
						+ getWardrobeHeader());


            UtilText.nodeContentSB.append("</div>");
            return null;
        }

        @Override
        public Response getResponse(int responseTab, int index) {
            return null;
        }
    };

    private static String getWardrobeHeader() {
		return "<div class='container-full-width' style='margin-bottom:0;'>"
					+ "<div style='width:20%; float:left; font-weight:bold; margin:0; padding:0;'>"
					+ "Outfit"
				+ "</div>"
				+ "<div style='float:left; width:15%; font-weight:bold; margin:0; padding:0;'>"
					+ "Actions"
				+"</div>"
			+ "</div>";
	}
}
