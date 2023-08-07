
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;

import javax.swing.JOptionPane;

public class BOTC_Game {

	private List<String> townFolkPreferences;
	private List<String> outsiderPreferences;
	private List<String> minionPreferences;
	private List<String> demonPreferences;

	private List<BOTC_Constants.TOWNFOLKS> townFolks;
	private List<BOTC_Constants.OUTSIDERS> outsiders;
	private List<BOTC_Constants.MINIONS> minions;
	private List<BOTC_Constants.DEMONS> demons;
	private int jinx_number = 0;
	private Map<BOTC_Constants.METADATA, String> gamePrompts;

	public BOTC_Game() {
		preload();
	}

	public void run() {
		promptUserBeforeChoosing();
		String[] roles = generateRoles();
		for (String s : roles) {
			System.out.println(s);
		}
	}

	private void preload() {
		gamePrompts = new HashMap<>();
		gamePrompts.put(BOTC_Constants.METADATA.JINX,
				"What is the max number of jinxes you want?[-1 if you don't care about number of jinxes]");
		gamePrompts.put(BOTC_Constants.METADATA.TOWNFOLKS,
				"Enter preferred Townfolks" + BOTC_Constants.DEFAULT_SUFFIX_PROMPT);
		gamePrompts.put(BOTC_Constants.METADATA.OUTSIDERS,
				"Enter preferred Outsiders" + BOTC_Constants.DEFAULT_SUFFIX_PROMPT);
		gamePrompts.put(BOTC_Constants.METADATA.MINIONS,
				"Enter preferred Minions" + BOTC_Constants.DEFAULT_SUFFIX_PROMPT);
		gamePrompts.put(BOTC_Constants.METADATA.DEMONS,
				"Enter preferred Demons" + BOTC_Constants.DEFAULT_SUFFIX_PROMPT);

		townFolks = BOTC_Constants.getTownfolk();
		outsiders = BOTC_Constants.getOutsider();
		minions = BOTC_Constants.getMinion();
		demons = BOTC_Constants.getDemon();

	}

	private int jinx_max(String prompt) {
		String nss = JOptionPane.showInputDialog(null, prompt + "?");
		int jinx = -1;
		try (Scanner z = new Scanner(nss)) {
			jinx = z.nextInt();
		}
		return jinx;
	}

	public void promptUserBeforeChoosing() {
		jinx_number = jinx_max(gamePrompts.get(BOTC_Constants.METADATA.JINX));
		setPreference(BOTC_Constants.METADATA.TOWNFOLKS);
		setPreference(BOTC_Constants.METADATA.OUTSIDERS);
		setPreference(BOTC_Constants.METADATA.MINIONS);
		setPreference(BOTC_Constants.METADATA.DEMONS);
	}

	public void setPreference(BOTC_Constants.METADATA category) {
		promptAndToList(category, instantiateList(category));
	}

	private void promptAndToList(BOTC_Constants.METADATA category, List<String> list) {
		String input = JOptionPane.showInputDialog(gamePrompts.get(category));
		while (input != null && !input.equalsIgnoreCase("exit")) {
			list.add(input);
			input = JOptionPane.showInputDialog(gamePrompts.get(category));
		}
	}

	private List<String> instantiateList(BOTC_Constants.METADATA category) {
		switch (category) {
		case TOWNFOLKS:
			return townFolkPreferences = new ArrayList<>();
		case OUTSIDERS:
			return outsiderPreferences = new ArrayList<>();
		case MINIONS:
			return minionPreferences = new ArrayList<>();
		case DEMONS:
			return demonPreferences = new ArrayList<>();
		default:
			throw new NullPointerException("Category doesn't exist");
		}
	}

	public int getJinxNumer() {
		return jinx_number;
	}

	public List<String> getTownFolkPreferences() {
		return townFolkPreferences;
	}

	public List<String> getOutsiderPreferences() {
		return outsiderPreferences;
	}

	public List<String> getMinionPreferences() {
		return minionPreferences;
	}

	public List<String> getDemonPreferences() {
		return demonPreferences;
	}

	private String[] generateRoles() {
		boolean it_works = false;
		int random = (int) (Math.random() * 4 + 1);
		String[] makeList = new String[21 + random];
		String[] townfolk_temp = new String[13];
		String[] outsider_temp = new String[4];
		String[] minion_temp = new String[4];
		String[] demon_temp = new String[random];

		while (!it_works) {
			print("Generating the list...");
			Collections.shuffle(townFolks);
			Collections.shuffle(outsiders);
			Collections.shuffle(minions);
			Collections.shuffle(demons);
			for (int a = 0; a < 13; a = a + 1) {
				townfolk_temp[a] = townFolks.get(a).getValue();
			}
			for (int b = 0; b < 4; b = b + 1) {
				outsider_temp[b] = outsiders.get(b).getValue();
			}
			for (int c = 0; c < 4; c = c + 1) {
				minion_temp[c] = minions.get(c).getValue();
			}
			for (int d = 0; d < random; d = d + 1) {
				demon_temp[d] = demons.get(d).getValue();
			}
////////////////// What is the purpose of below for loops?? //////////////////////
			for (int i = 0; i < townFolks.size(); i = i + 1) {
				if (townFolkPreferences.contains(townFolks.get(i).getValue())) {
					continue;
				}
			}
			for (int i = 0; i < outsiders.size(); i = i + 1) {
				if (outsiderPreferences.contains(outsiders.get(i).getValue())) {
					continue;
				}
			}
			for (int i = 0; i < minions.size(); i = i + 1) {
				if (minionPreferences.contains(minions.get(i).getValue())) {
					continue;
				}
			}
			for (int i = 0; i < demons.size(); i = i + 1) {
				if (demonPreferences.contains(demons.get(i).getValue())) {
					continue;
				}
			}
//////////////////// What is the purpose of above for loops?? //////////////////////

			for (int i = 0; i < townFolkPreferences.size(); i = i + 1) {
				townfolk_temp[i] = townFolkPreferences.get(i);
			}
			for (int i = 0; i < outsiderPreferences.size(); i = i + 1) {
				outsider_temp[i] = outsiderPreferences.get(i);
			}
			for (int i = 0; i < minionPreferences.size(); i = i + 1) {
				minion_temp[i] = minionPreferences.get(i);
			}
			for (int i = 0; i < demonPreferences.size(); i = i + 1) {
				demon_temp[i] = demonPreferences.get(i);
			}
			String[] organizedtownfolk = new String[13];
			String[] organizedoutsider = new String[4];
			String[] organizedminion = new String[4];
			String[] organizeddemon = new String[random];
			for (int a = 0; a < 13; a = a + 1) {
				organizedtownfolk[a] = townfolk_temp[a];
			}
			for (int b = 0; b < 4; b = b + 1) {
				organizedoutsider[b] = outsider_temp[b];
			}
			for (int c = 0; c < 4; c = c + 1) {
				organizedminion[c] = minion_temp[c];
			}
			for (int d = 0; d < random; d = d + 1) {
				organizeddemon[d] = demon_temp[d];
			}
			Arrays.sort(organizedtownfolk);
			Arrays.sort(organizedoutsider);
			Arrays.sort(organizedminion);
			Arrays.sort(organizeddemon);
			for (int a = 0; a < 13; a = a + 1) {
				makeList[a] = organizedtownfolk[a];
			}
			for (int b = 13; b < 17; b = b + 1) {
				makeList[b] = organizedoutsider[b - 13];
			}
			for (int c = 17; c < 21; c = c + 1) {
				makeList[c] = organizedminion[c - 17];
			}
			for (int d = 21; d < 21 + random; d = d + 1) {
				makeList[d] = organizeddemon[d - 21];
			}
			List<String> checkList = new ArrayList<>(Arrays.asList(makeList));
			// King and Choirboy require each other
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.KING.getValue())
					&& checkList.contains(BOTC_Constants.TOWNFOLKS.CHOIRBOY.getValue())) {
				it_works = true;
			} else {
				continue;
			}
//			// Huntsman requires Damsel
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.HUNTSMAN.getValue())
					&& checkList.contains(BOTC_Constants.OUTSIDERS.DAMSEL.getValue())) {
				it_works = true;
			} else {
				continue;
			}
//			// At least 1 of {Lleech, Devil's Advocate, Harpy} requires at least 1 of
//			// {Sailor, Tea Lady, Fool, Pacifist} and vice versa
			if (checkList.contains(BOTC_Constants.DEMONS.LLEECH.getValue())
					|| checkList.contains(BOTC_Constants.MINIONS.DEVILSADVOCATE.getValue())
					|| checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())) {
				if (checkList.contains(BOTC_Constants.TOWNFOLKS.SAILOR.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.TEALADY.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.FOOL.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.PACIFIST.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.SAILOR.getValue())
					|| checkList.contains(BOTC_Constants.TOWNFOLKS.TEALADY.getValue())
					|| checkList.contains(BOTC_Constants.TOWNFOLKS.FOOL.getValue())
					|| checkList.contains(BOTC_Constants.TOWNFOLKS.PACIFIST.getValue())) {
				if (checkList.contains(BOTC_Constants.DEMONS.LLEECH.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.DEVILSADVOCATE.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Harpy requires at least 1 of {Lleech, Devil's Advocate} and vice versa
			if (checkList.contains(BOTC_Constants.DEMONS.LLEECH.getValue())
					|| checkList.contains(BOTC_Constants.MINIONS.DEVILSADVOCATE.getValue())) {
				if (checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
			if (checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())) {
				if (checkList.contains(BOTC_Constants.DEMONS.LLEECH.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.DEVILSADVOCATE.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Cerenovus requires at least 1 of {Pixie, Mutant, Harpy} and vice versa
			if (checkList.contains(BOTC_Constants.MINIONS.CERENOVUS.getValue())) {
				if (checkList.contains(BOTC_Constants.TOWNFOLKS.PIXIE.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.MUTANT.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.PIXIE.getValue())
					|| checkList.contains(BOTC_Constants.OUTSIDERS.MUTANT.getValue())
					|| checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())) {
				if (checkList.contains(BOTC_Constants.MINIONS.CERENOVUS.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Harpy requires at least 1 of {Pixie, Mutant} and vice versa
			if (checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())) {
				if (checkList.contains(BOTC_Constants.TOWNFOLKS.PIXIE.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.MUTANT.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.PIXIE.getValue())
					|| checkList.contains(BOTC_Constants.OUTSIDERS.MUTANT.getValue())) {
				if (checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Professor and Shabaloth require each other
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.PROFESSOR.getValue())
					&& checkList.contains(BOTC_Constants.DEMONS.SHABALOTH.getValue())) {
				it_works = true;
			} else {
				continue;
			}
//			// Vigormortis can't be with {Goblin, Evil Twin, Boomdandy, Pyschopath, Scarlett
//			// Woman}
			if (checkList.contains(BOTC_Constants.DEMONS.VIGORMORTIS.getValue())
					&& (checkList.contains(BOTC_Constants.MINIONS.GOBLIN.getValue())
							|| checkList.contains(BOTC_Constants.MINIONS.EVILTWIN.getValue())
							|| checkList.contains(BOTC_Constants.MINIONS.BOOMDANDY.getValue())
							|| checkList.contains(BOTC_Constants.MINIONS.PSYCHOPATH.getValue())
							|| checkList.contains(BOTC_Constants.MINIONS.SCARLETTWOMAN.getValue()))) {
				continue;
			}
//			// At least 1 of {Riot, Al-Hadikhia, Leviathan} requires an Engineer
			if (checkList.contains(BOTC_Constants.DEMONS.RIOT.getValue())
					|| checkList.contains(BOTC_Constants.DEMONS.ALHADIKHIA.getValue())
					|| checkList.contains(BOTC_Constants.DEMONS.LEVIATHAN.getValue())) {
				if (checkList.contains(BOTC_Constants.TOWNFOLKS.ENGINEER.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Oracle requires at least 1 of {Vigormortis, Zombuul, Fang Gu, Imp}
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.ORACLE.getValue())) {
				if (checkList.contains(BOTC_Constants.DEMONS.VIGORMORTIS.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.ZOMBUUL.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.FANGGU.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.IMP.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// At least 1 of {Mastermind, Po, Zombuul} requires at least 1 of {Soldier,
//			// Exorcist, Minstrel, Pit-Hag} and vice versa
			if (checkList.contains(BOTC_Constants.MINIONS.MASTERMIND.getValue())
					|| checkList.contains(BOTC_Constants.DEMONS.PO.getValue())
					|| checkList.contains(BOTC_Constants.DEMONS.ZOMBUUL.getValue())) {
				if (checkList.contains(BOTC_Constants.TOWNFOLKS.SOLDIER.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.EXORCIST.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.MONK.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.MINSTREL.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.PITHAG.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.SOLDIER.getValue())
					|| checkList.contains(BOTC_Constants.TOWNFOLKS.EXORCIST.getValue())
					|| checkList.contains(BOTC_Constants.TOWNFOLKS.MONK.getValue())
					|| checkList.contains(BOTC_Constants.TOWNFOLKS.MINSTREL.getValue())
					|| checkList.contains(BOTC_Constants.MINIONS.PITHAG.getValue())) {
				if (checkList.contains(BOTC_Constants.MINIONS.MASTERMIND.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.PO.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.ZOMBUUL.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Can't have both Spy and Widow
			if (checkList.contains(BOTC_Constants.MINIONS.SPY.getValue())
					&& checkList.contains(BOTC_Constants.MINIONS.WIDOW.getValue())) {
				continue;
			}
//			// Spy nor Widow can't be with {King, Choirboy, Exorcist, Puzzlemaster, Heretic}
			if ((checkList.contains(BOTC_Constants.MINIONS.SPY.getValue())
					|| checkList.contains(BOTC_Constants.MINIONS.WIDOW.getValue()))
					&& (checkList.contains(BOTC_Constants.TOWNFOLKS.KING.getValue())
							|| checkList.contains(BOTC_Constants.TOWNFOLKS.CHOIRBOY.getValue())
							|| checkList.contains(BOTC_Constants.TOWNFOLKS.EXORCIST.getValue())
							|| checkList.contains(BOTC_Constants.OUTSIDERS.PUZZLEMASTER.getValue())
							|| checkList.contains(BOTC_Constants.OUTSIDERS.HERETIC.getValue()))) {
				continue;
			}
//			// Lunatic can't be with {Fang Gu, Imp}
			if (checkList.contains(BOTC_Constants.OUTSIDERS.LUNATIC.getValue())
					&& (checkList.contains(BOTC_Constants.DEMONS.FANGGU.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.IMP.getValue()))) {
				continue;
			}
//			// Mastermind, Po, and Zombuul require each other
			if (checkList.contains(BOTC_Constants.MINIONS.MASTERMIND.getValue())
					&& (checkList.contains(BOTC_Constants.DEMONS.PO.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.ZOMBUUL.getValue()))) {
				it_works = true;
			} else {
				continue;
			}
			if (checkList.contains(BOTC_Constants.DEMONS.PO.getValue())) {
				if (checkList.contains(BOTC_Constants.MINIONS.MASTERMIND.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.ZOMBUUL.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
			if (checkList.contains(BOTC_Constants.DEMONS.ZOMBUUL.getValue())) {
				if (checkList.contains(BOTC_Constants.MINIONS.MASTERMIND.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.PO.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Lil' Monsta requires at least 1 of {Imp, Barber, Snake Charmer, Fang Gu}
			if (checkList.contains(BOTC_Constants.DEMONS.LILMONSTA.getValue())) {
				if (checkList.contains(BOTC_Constants.DEMONS.IMP.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.BARBER.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.SNAKECHARMER.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.FANGGU.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Magician can't be with {Fang Gu, Imp, Vortox}
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.MAGICIAN.getValue())
					&& (checkList.contains(BOTC_Constants.DEMONS.FANGGU.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.IMP.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.VORTOX.getValue()))) {
				continue;
			}
//			// If Leviathan is with at least one of {Assassin, Godfather}, then it requires
//			// at least 1 of {Tinker, Gambler, Lycanthrope, Acrobat, Grandmother}
			if (checkList.contains(BOTC_Constants.DEMONS.LEVIATHAN.getValue())
					&& (checkList.contains(BOTC_Constants.MINIONS.ASSASSIN.getValue())
							|| checkList.contains(BOTC_Constants.MINIONS.GODFATHER.getValue()))) {
				if (checkList.contains(BOTC_Constants.OUTSIDERS.TINKER.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.GAMBLER.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.LYCANTHROPE.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.ACROBAT.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.GRANDMOTHER.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Snitch requires at least 1 of {Poppy Grower, Lil' Monsta}
			if (checkList.contains(BOTC_Constants.OUTSIDERS.SNITCH.getValue())) {
				if (checkList.contains(BOTC_Constants.TOWNFOLKS.POPPYGROWER.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.LILMONSTA.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Poppy Grower requires at least 1 of {Legion, Riot, Organ Grinder, Vizier,
//			// Harpy, Fearmonger}
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.POPPYGROWER.getValue())) {
				if (checkList.contains(BOTC_Constants.DEMONS.LEGION.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.RIOT.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.ORGANGRINDER.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.VIZIER.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.FEARMONGER.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Pit-Hag and Goon can't be together
			if (checkList.contains(BOTC_Constants.MINIONS.PITHAG.getValue())
					&& checkList.contains(BOTC_Constants.OUTSIDERS.GOON.getValue())) {
				continue;
			}
//			// At least 1 of {Imp, Fang Gu} reuires at least 1 of {Sage, Ravenkeeper,
//			// Farmer} and vice versa
			if (checkList.contains(BOTC_Constants.DEMONS.IMP.getValue())
					|| checkList.contains(BOTC_Constants.DEMONS.FANGGU.getValue())
							&& (checkList.contains(BOTC_Constants.TOWNFOLKS.SAGE.getValue())
									|| checkList.contains(BOTC_Constants.TOWNFOLKS.RAVENKEEPER.getValue())
									|| checkList.contains(BOTC_Constants.TOWNFOLKS.FARMER.getValue()))) {
				it_works = true;
			} else {
				continue;
			}
//			// At least 1 of {Po, Shabaloth} requires at least 1 {Tinker, Gossip, Gambler,
//			// Acrobat, Grandmother}
			if (checkList.contains(BOTC_Constants.DEMONS.PO.getValue())
					|| checkList.contains(BOTC_Constants.DEMONS.SHABALOTH.getValue())) {
				if (checkList.contains(BOTC_Constants.OUTSIDERS.TINKER.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.GOSSIP.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.PITHAG.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.GAMBLER.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.ACROBAT.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.GRANDMOTHER.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Poppy Grower and at least 1 of {Al-Hadikhia, Fang Gu, Imp, Leviathan, Lil'
//			// Monsta, Lleech, No Dashii, Po, Pukka, Shabaloth, Vigormortis, Vortox}
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.POPPYGROWER.getValue())
					&& (checkList.contains(BOTC_Constants.DEMONS.ALHADIKHIA.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.FANGGU.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.IMP.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.LEVIATHAN.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.LILMONSTA.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.LLEECH.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.NODASHII.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.PO.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.PUKKA.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.SHABALOTH.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.VIGORMORTIS.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.VORTOX.getValue()))) {
				if (checkList.contains(BOTC_Constants.MINIONS.SCARLETTWOMAN.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Can't have both Legion and Clockmaker
			if (checkList.contains(BOTC_Constants.DEMONS.LEGION.getValue())
					&& checkList.contains(BOTC_Constants.TOWNFOLKS.CLOCKMAKER.getValue())) {
				continue;
			}
//			// Can't have both Lil' Monsta and Fortune Teller
			if (checkList.contains(BOTC_Constants.DEMONS.LILMONSTA.getValue())
					&& checkList.contains(BOTC_Constants.TOWNFOLKS.FORTUNETELLER.getValue())) {
				continue;
			}
//			// Legion requires at least 1 of {Recluse, Vortox}
			if (checkList.contains(BOTC_Constants.DEMONS.LEGION.getValue())) {
				if (checkList.contains(BOTC_Constants.OUTSIDERS.RECLUSE.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.VORTOX.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// If there's 1 demon there can't be at least 1 of {Riot, Pit-Hag, Engineer,
//			// Legion, Courtier, Heretic, Vortox}
			if ((checkList.contains(BOTC_Constants.DEMONS.RIOT.getValue())
					|| checkList.contains(BOTC_Constants.MINIONS.PITHAG.getValue())
					|| checkList.contains(BOTC_Constants.TOWNFOLKS.ENGINEER.getValue())
					|| checkList.contains(BOTC_Constants.DEMONS.LEGION.getValue())
					|| checkList.contains(BOTC_Constants.TOWNFOLKS.COURTIER.getValue())
					|| checkList.contains(BOTC_Constants.OUTSIDERS.HERETIC.getValue())
					|| checkList.contains(BOTC_Constants.DEMONS.VORTOX.getValue())) && (random == 1)) {
				continue;
			}
//			// Undertaker requires at least 1 of {Spy, Widow} and vice versa
			if (checkList.contains(BOTC_Constants.MINIONS.SPY.getValue())
					|| checkList.contains(BOTC_Constants.MINIONS.WIDOW.getValue())) {
				if (checkList.contains(BOTC_Constants.TOWNFOLKS.UNDERTAKER.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.UNDERTAKER.getValue())) {
				if (checkList.contains(BOTC_Constants.MINIONS.SPY.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.WIDOW.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Balloonist requires at least 1 of {Damsel, Drunk, Goon, Lunatic, Politician,
//			// Recluse, Snitch}
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.BALLOONIST.getValue())) {
				if (checkList.contains(BOTC_Constants.OUTSIDERS.DAMSEL.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.DRUNK.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.GOON.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.LUNATIC.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.POLITICIAN.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.RECLUSE.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.SNITCH.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Athiest requires Drunk
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.ATHIEST.getValue())) {
				if (checkList.contains(BOTC_Constants.OUTSIDERS.DRUNK.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Can't have both Undertaker and Cannibal
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.UNDERTAKER.getValue())
					&& checkList.contains(BOTC_Constants.TOWNFOLKS.CANNIBAL.getValue())) {
				continue;
			}
//			// Can't have both Virgin and Golem
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.VIRGIN.getValue())
					&& checkList.contains(BOTC_Constants.OUTSIDERS.GOLEM.getValue())) {
				continue;
			}
//			// Can't have Harpy with at least 1 of {Witch, Pychopath}
			if (checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())
					&& (checkList.contains(BOTC_Constants.MINIONS.WITCH.getValue())
							|| checkList.contains(BOTC_Constants.MINIONS.PSYCHOPATH.getValue()))) {
				continue;
			}
//			// Can't have any combination of {Fang Gu, Balloonist, Baron}
			if ((checkList.contains(BOTC_Constants.DEMONS.FANGGU.getValue())
					&& checkList.contains(BOTC_Constants.TOWNFOLKS.BALLOONIST.getValue()))
					|| (checkList.contains(BOTC_Constants.TOWNFOLKS.BALLOONIST.getValue())
							&& checkList.contains(BOTC_Constants.MINIONS.BARON.getValue()))
					|| (checkList.contains(BOTC_Constants.MINIONS.BARON.getValue())
							|| checkList.contains(BOTC_Constants.DEMONS.FANGGU.getValue()))) {
				continue;
			}
//			// Can't have at least 1 of {King, Exorcist} with at least 1 of {Spy, Widow}
			if ((checkList.contains(BOTC_Constants.TOWNFOLKS.KING.getValue())
					|| checkList.contains(BOTC_Constants.TOWNFOLKS.EXORCIST.getValue()))
					&& (checkList.contains(BOTC_Constants.MINIONS.SPY.getValue())
							|| checkList.contains(BOTC_Constants.MINIONS.WIDOW.getValue()))) {
				continue;
			}
//			// Can't have both Alchemist and Marionette
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.ALCHEMIST.getValue())
					&& checkList.contains(BOTC_Constants.MINIONS.MARIONETTE.getValue())) {
				continue;
			}
//			// Can't have both Bounty Hunter and Mezepheles
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.BOUNTYHUNTER.getValue())
					&& checkList.contains(BOTC_Constants.MINIONS.MEZEPHELES.getValue())) {
				continue;
			}
//			// Can't have both Steward and Grandmother
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.STEWARD.getValue())
					&& checkList.contains(BOTC_Constants.TOWNFOLKS.GRANDMOTHER.getValue())) {
				continue;
			}
//			// Can't have both Cult Leader and Goon
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.CULTLEADER.getValue())
					&& checkList.contains(BOTC_Constants.OUTSIDERS.GOON.getValue())) {
				continue;
			}
//			// At least 1 of {Mathematican, Acrobat} requires at least 1 of {Courtier,
//			// Innkeeper, Minstrel, Philosopher, Sailor, Snake Charmer, Goon, Lunatic,
//			// Puzzlemaster, Sweetheart, Widow, Poisoner, Lleech, No Dashii, Pukka,
//			// Vigormortis, Vortox}
			if (checkList.contains(BOTC_Constants.TOWNFOLKS.MATHEMATICIAN.getValue())
					|| checkList.contains(BOTC_Constants.OUTSIDERS.ACROBAT.getValue())) {
				if (checkList.contains(BOTC_Constants.TOWNFOLKS.COURTIER.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.INNKEEPER.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.MINSTREL.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.PHILOSOPHER.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.SAILOR.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.SNAKECHARMER.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.GOON.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.LUNATIC.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.PUZZLEMASTER.getValue())
						|| checkList.contains(BOTC_Constants.OUTSIDERS.SWEETHEART.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.WIDOW.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.POISONER.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.LLEECH.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.NODASHII.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.PUKKA.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.VIGORMORTIS.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.VORTOX.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// At least 1 of {Vizier, Harpy, Psychopath, Zombuul, Tea Lady}
			if (checkList.contains(BOTC_Constants.MINIONS.VIZIER.getValue())
					|| checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())
					|| checkList.contains(BOTC_Constants.MINIONS.PSYCHOPATH.getValue())) {
				if (checkList.contains(BOTC_Constants.TOWNFOLKS.FOOL.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.SAILOR.getValue())
						|| checkList.contains(BOTC_Constants.MINIONS.DEVILSADVOCATE.getValue())
						|| checkList.contains(BOTC_Constants.DEMONS.ZOMBUUL.getValue())
						|| checkList.contains(BOTC_Constants.TOWNFOLKS.TEALADY.getValue())) {
					it_works = true;
				} else {
					continue;
				}
			}
//			// Harpy and High Priestess require each other
			if (checkList.contains(BOTC_Constants.MINIONS.HARPY.getValue())
					&& checkList.contains(BOTC_Constants.TOWNFOLKS.HIGHPRIESTESS.getValue())) {

				it_works = true;
			} else {
				continue;
			}
			// If there's at least 1 loud demon, there needs to be at least 2 quiet demons
			int NonLoudDemon = 0;
			if (checkList.contains(BOTC_Constants.DEMONS.ALHADIKHIA.getValue())
					|| checkList.contains(BOTC_Constants.DEMONS.LEGION.getValue())
					|| checkList.contains(BOTC_Constants.DEMONS.LEVIATHAN.getValue())
					|| checkList.contains(BOTC_Constants.DEMONS.RIOT.getValue())) {
				List<String> temp = checkList;
				String[] NotLoudDemon = { BOTC_Constants.DEMONS.FANGGU.getValue(), BOTC_Constants.DEMONS.IMP.getValue(),
						BOTC_Constants.DEMONS.LILMONSTA.getValue(), BOTC_Constants.DEMONS.LLEECH.getValue(),
						BOTC_Constants.DEMONS.NODASHII.getValue(), BOTC_Constants.DEMONS.PO.getValue(),
						BOTC_Constants.DEMONS.PUKKA.getValue(), BOTC_Constants.DEMONS.SHABALOTH.getValue(),
						BOTC_Constants.DEMONS.VIGORMORTIS.getValue(), BOTC_Constants.DEMONS.VORTOX.getValue(),
						BOTC_Constants.DEMONS.ZOMBUUL.getValue() };
				for (int j = 0; j < NotLoudDemon.length; j = j + 1) {
					if (temp.contains(NotLoudDemon[j])) {
						NonLoudDemon = NonLoudDemon + 1;
					}
				}

				if (NonLoudDemon == 1) {
					continue;
				}
			}
			int foundedjinxes = 0;
			String[][] jinxes = BOTC_Constants.jinxCases;
			for (int i = 0; i < jinxes.length; i = i + 1) {
				if (checkList.contains(jinxes[i][0]) && checkList.contains(jinxes[i][1])) {
					foundedjinxes = foundedjinxes + 1;
				}
			}
			if (jinx_number == -1) {
				it_works = true;
			}
			if (!(jinx_number == -1)) {
				if (foundedjinxes <= jinx_number) {
					it_works = true;
				} else if (foundedjinxes > jinx_number) {
					continue;
				}
			}
			break;
		}
		return makeList;
	}

	private void print(String text) {
		System.out.printf("%s ---- %s\n", Level.INFO, text);
	}

}
