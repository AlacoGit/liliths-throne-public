package com.lilithsthrone.game.sex.sexActions.baseActionsPartner;

import com.lilithsthrone.game.character.attributes.CorruptionLevel;
import com.lilithsthrone.game.character.body.CoverableArea;
import com.lilithsthrone.game.dialogue.utils.UtilText;
import com.lilithsthrone.game.sex.ArousalIncrease;
import com.lilithsthrone.game.sex.OrificeType;
import com.lilithsthrone.game.sex.PenetrationType;
import com.lilithsthrone.game.sex.Sex;
import com.lilithsthrone.game.sex.SexPace;
import com.lilithsthrone.game.sex.SexParticipantType;
import com.lilithsthrone.game.sex.SexPositionType;
import com.lilithsthrone.game.sex.SexPositionSlot;
import com.lilithsthrone.game.sex.sexActions.SexAction;
import com.lilithsthrone.game.sex.sexActions.SexActionType;
import com.lilithsthrone.main.Main;

/**
 * @since 0.1.79
 * @version 0.1.84
 * @author Innoxia
 */
public class PartnerFingerUrethra {

	//TODO grope cock
	
	public static final SexAction PARTNER_MASTURBATE_PARTNERS_COCK = new SexAction(
			SexActionType.PARTNER_REQUIRES_NO_PENETRATION_AND_EXPOSED,
			ArousalIncrease.TWO_LOW,
			ArousalIncrease.TWO_LOW,
			CorruptionLevel.ONE_VANILLA,
			PenetrationType.FINGER,
			OrificeType.URETHRA,
			SexParticipantType.PITCHER) {

		@Override
		public boolean isBaseRequirementsMet() {
			return Sex.getSexPace(Sex.getActivePartner())!=SexPace.SUB_RESISTING;
		}
		
		@Override
		public String getActionTitle() {
			return "Stroke [pc.her] cock";
		}

		@Override
		public String getActionDescription() {
			return "Reach down and start masturbating [pc.name]'s [pc.cock+].";
		}

		@Override
		public String getDescription() {
			
			UtilText.nodeContentSB.setLength(0);
			
			switch(Sex.getSexPace(Sex.getActivePartner())) {
				case DOM_GENTLE:
					UtilText.nodeContentSB.append(UtilText.returnStringAtRandom(
							"Reaching down between your [pc.legs], [npc.name] wraps [npc.her] [npc.fingers] around your [pc.cock+], letting out a soft [npc.moan] as [npc.she] starts slowly stroking up and down its length.",
							"[npc.Name] drops one of [npc.her] [npc.hands] down between your [pc.legs], and, taking hold of your [pc.cock+], [npc.she] starts slowly jerking you off.",
							"Teasing [npc.her] [npc.fingers] over your [pc.cock+], [npc.name] lets out a soft [npc.moan] as [npc.she] starts gently stroking up and down its throbbing length."));
					break;
				case DOM_NORMAL:
					UtilText.nodeContentSB.append(UtilText.returnStringAtRandom(
							"Reaching down between your [pc.legs], [npc.name] eagerly wraps [npc.her] [npc.fingers] around your [pc.cock+], letting out [npc.a_moan+] as [npc.she] starts rapidly stroking up and down its length.",
							"[npc.Name] drops one of [npc.her] [npc.hands] down between your [pc.legs], and, taking hold of your [pc.cock+], [npc.she] starts eagerly jerking you off.",
							"Teasing [npc.her] [npc.fingers] over your [pc.cock+], [npc.name] lets out [npc.a_moan+] as [npc.she] starts rapidly stroking up and down its throbbing length."));
					break;
				case DOM_ROUGH:
					UtilText.nodeContentSB.append(UtilText.returnStringAtRandom(
							"Reaching down between your [pc.legs], [npc.name] forcefully wraps [npc.her] [npc.fingers] around your [pc.cock+], letting out [npc.a_moan+] as [npc.she] starts frantically stroking up and down its length.",
							"[npc.Name] drops one of [npc.her] [npc.hands] down between your [pc.legs], and, roughly taking hold of your [pc.cock+], [npc.she] starts forcefully jerking you off.",
							"Forcefully wrapping [npc.her] [npc.fingers] around your [pc.cock+], [npc.name] lets out [npc.a_moan+] as [npc.she] starts frantically stroking up and down its throbbing length."));
					break;
				case SUB_EAGER:
					UtilText.nodeContentSB.append(UtilText.returnStringAtRandom(
							"Reaching down between your [pc.legs], [npc.name] eagerly wraps [npc.her] [npc.fingers] around your [pc.cock+], letting out [npc.a_moan+] as [npc.she] starts rapidly stroking up and down its length.",
							"[npc.Name] drops one of [npc.her] [npc.hands] down between your [pc.legs], and, taking hold of your [pc.cock+], [npc.she] starts eagerly jerking you off.",
							"Teasing [npc.her] [npc.fingers] over your [pc.cock+], [npc.name] lets out [npc.a_moan+] as [npc.she] starts rapidly stroking up and down its throbbing length."));
					break;
				case SUB_NORMAL:
					UtilText.nodeContentSB.append(UtilText.returnStringAtRandom(
							"Reaching down between your [pc.legs], [npc.name] wraps [npc.her] [npc.fingers] around your [pc.cock+], letting out [npc.a_moan+] as [npc.she] starts stroking up and down its length.",
							"[npc.Name] drops one of [npc.her] [npc.hands] down between your [pc.legs], and, taking hold of your [pc.cock+], [npc.she] starts jerking you off.",
							"Teasing [npc.her] [npc.fingers] over your [pc.cock+], [npc.name] lets out [npc.a_moan+] as [npc.she] starts stroking up and down its throbbing length."));
					break;
				default:
					break;
			}
			switch(Sex.getSexPace(Main.game.getPlayer())) {
				case DOM_GENTLE:
					UtilText.nodeContentSB.append(UtilText.returnStringAtRandom(
							" Letting out a soft [pc.moan], you start gently bucking your [pc.hips] against [npc.her] [npc.hand], focusing on the feeling of your [pc.cock+] as it throbs in response to [npc.her] touch.",
							" With a soft [pc.moan], you start slowly thrusting your [pc.hips] against [npc.her] touch, enjoying the feeling of [npc.her] [npc.fingers+] sliding up and down your [pc.cock+].",
							" You start slowly bucking your [pc.hips] against [npc.her] [npc.hand], [pc.moaning] softly as you focus on the feeling of [npc.her] [npc.fingers+] sliding up and down your [pc.cock+]."));
					break;
				case DOM_NORMAL:
					UtilText.nodeContentSB.append(UtilText.returnStringAtRandom(
							" Letting out [pc.a_moan+], you start eagerly bucking your [pc.hips] against [npc.her] [npc.hand], focusing on the feeling of your [pc.cock+] as it throbs in response to [npc.her] touch.",
							" With [pc.a_moan+], you start eagerly thrusting your [pc.hips] against [npc.her] touch, enjoying the feeling of [npc.her] [npc.fingers+] sliding up and down your [pc.cock+].",
							" You start eagerly bucking your [pc.hips] against [npc.her] [npc.hand], [pc.moaning+] as you focus on the feeling of [npc.her] [npc.fingers+] sliding up and down your [pc.cock+]."));
					break;
				case DOM_ROUGH:
					UtilText.nodeContentSB.append(UtilText.returnStringAtRandom(
							" Letting out [pc.a_moan+], you start violently bucking your [pc.hips] against [npc.her] [npc.hand], growling out as you order [npc.herHim] to continue pleasuring your [pc.cock+].",
							" With [pc.a_moan+], you start roughly thrusting your [pc.hips] against [npc.her] touch, filling [npc.her] [npc.hand] with your [pc.cock+] as you order [npc.herHim] not to stop.",
							" You start forcefully bucking your [pc.hips] against [npc.her] [npc.hand], [pc.moaning+] as you order [npc.herHim] to continue servicing your [pc.cock+]."));
					break;
				case SUB_EAGER:
					UtilText.nodeContentSB.append(UtilText.returnStringAtRandom(
							" Letting out [pc.a_moan+], you start eagerly bucking your [pc.hips] against [npc.her] [npc.hand], focusing on the feeling of your [pc.cock+] as it throbs in response to [npc.her] touch.",
							" With [pc.a_moan+], you start eagerly thrusting your [pc.hips] against [npc.her] touch, enjoying the feeling of [npc.her] [npc.fingers+] sliding up and down your [pc.cock+].",
							" You start eagerly bucking your [pc.hips] against [npc.her] [npc.hand], [pc.moaning+] as you focus on the feeling of [npc.her] [npc.fingers+] sliding up and down your [pc.cock+]."));
					break;
				case SUB_NORMAL:
					UtilText.nodeContentSB.append(UtilText.returnStringAtRandom(
							" Letting out [pc.a_moan+], you start bucking your [pc.hips] against [npc.her] [npc.hand], focusing on the feeling of your [pc.cock+] as it throbs in response to [npc.her] touch.",
							" With [pc.a_moan+], you start thrusting your [pc.hips] against [npc.her] touch, enjoying the feeling of [npc.her] [npc.fingers+] sliding up and down your [pc.cock+].",
							" You start bucking your [pc.hips] against [npc.her] [npc.hand], [pc.moaning+] as you focus on the feeling of [npc.her] [npc.fingers+] sliding up and down your [pc.cock+]."));
					break;
				case SUB_RESISTING:
					UtilText.nodeContentSB.append(UtilText.returnStringAtRandom(
							" You try to pull your [pc.hips] back from [npc.her] unwanted touch, [pc.sobbing] and struggling as your throbbing [pc.cock] betrays your arousal.",
							" With [pc.a_sob+], you try to pull away from [npc.herHim], struggling and protesting as your hard [pc.cock] betrays your arousal.",
							" [pc.A_sob+] bursts out from between your [pc.lips+] as you struggle back against [npc.her] unwanted touch."));
					break;
				default:
					break;
			}
	
			return UtilText.nodeContentSB.toString();
		}

		@Override
		public void applyEffects() {
			if(Main.game.getPlayer().isCoverableAreaExposed(CoverableArea.PENIS)) {
				Sex.transferLubrication(Sex.getActivePartner(), PenetrationType.FINGER, Main.game.getPlayer(), PenetrationType.PENIS);
			}
		}
	};
	
	public static final SexAction PARTNER_FONDLE_BALLS = new SexAction(
			SexActionType.PARTNER_REQUIRES_NO_PENETRATION_AND_EXPOSED,
			ArousalIncrease.ONE_MINIMUM,
			ArousalIncrease.THREE_NORMAL,
			CorruptionLevel.ONE_VANILLA,
			PenetrationType.FINGER,
			OrificeType.URETHRA,
			SexParticipantType.PITCHER) {

		@Override
		public boolean isBaseRequirementsMet() {
			return !Main.game.getPlayer().isInternalTesticles() && Sex.getSexPace(Sex.getActivePartner())!=SexPace.SUB_RESISTING;
		}
		
		@Override
		public String getActionTitle() {
			return "Fondle balls";
		}

		@Override
		public String getActionDescription() {
			return "Start playing with [pc.name]'s [pc.balls+].";
		}

		@Override
		public String getDescription() {
			if(Sex.getPosition()==SexPositionType.SIXTY_NINE && Sex.getSexPositionSlot(Main.game.getPlayer())==SexPositionSlot.SIXTY_NINE_BOTTOM) {
				return UtilText.returnStringAtRandom(
						"[npc.Name] props [npc.herself] up on one [npc.arm], before using [npc.her] free [npc.hand] to stroke and squeeze your [pc.balls+].",
						"[npc.Name] lets out [npc.a_moan+] as [npc.she] props [npc.herself] up on one [npc.arm], before reaching down and starting to stroke and play with your [pc.balls+].",
						"Propping [npc.herself] up on one [npc.arm], [npc.name] runs [npc.her] [npc.fingers+] over your ballsack, grinning as [npc.she] starts to stroke and cup your [pc.balls+].",
						"Propping [npc.herself] up on one [npc.arm], [npc.name] uses [npc.her] free [npc.hand] to cup and stroke your [pc.balls+], moaning happily to [npc.herself] as your [pc.cock+] twitches in response.");
				
			} else {
				return UtilText.returnStringAtRandom(
							"[npc.Name] reaches between your [pc.legs] with one [npc.hand] and starts to stroke and squeeze your [pc.balls+].",
							"You find yourself letting out [pc.a_moan+] as [npc.name] reaches up with one [npc.hand] and starts to stroke and play with your [pc.balls+].",
							"Running [npc.her] [npc.fingers+] over your [pc.balls+], [npc.name] starts to stroke and cup them, letting out [npc.a_moan+] as your [pc.cock+] twitches in response.");
			}
		}
	};
	
}
