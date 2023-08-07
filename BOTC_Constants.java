import java.util.Arrays;
import java.util.List;

public class BOTC_Constants {

	public static final String DEFAULT_SUFFIX_PROMPT = "[spell correctly and capitalized first letter] (type 'exit' to stop):";

	// Meta-Data related
	public static enum METADATA {
		JINX, TOWNFOLKS, OUTSIDERS, MINIONS, DEMONS;
	}

	public static enum TOWNFOLKS {
		ALCHEMIST("Alchemist"), AMNESIAC("Amnesiac"), ARTIST("Artist"), ATHIEST("Athiest"), BALLOONIST("Balloonist"),
		BOUNTYHUNTER("Bounty Hunter"), CANNIBAL("Cannibal"), CHAMBERMAID("Chambermaid"), CHEF("Chef"),
		CHOIRBOY("Choirboy"), CLOCKMAKER("Clockmaker"), COURTIER("Courtier"), CULTLEADER("Cult Leader"),
		DREAMER("Dreamer"), EMPATH("Empath"), ENGINEER("Engineer"), EXORCIST("Exorcist"), FARMER("Farmer"),
		FISHERMAN("Fisherman"), FLOWERGIRL("Flowergirl"), FOOL("Fool"), FORTUNETELLER("Fortune Teller"),
		GAMBLER("Gambler"), GENERAL("General"), GOSSIP("Gossip"), GRANDMOTHER("Grandmother"),
		HIGHPRIESTESS("High Priestess"), HUNTSMAN("Huntsman"), INNKEEPER("Innkeeper"), INVESTIGATOR("Investigator"),
		JUGGLER("Juggler"), KING("King"), KNIGHT("Knight"), LIBRIARAN("Libriaran"), LYCANTHROPE("Lycanthrope"),
		MAGICIAN("Magician"), MATHEMATICIAN("Mathematician"), MAYOR("Mayor"), MINSTREL("Minstrel"), MONK("Monk"),
		NIGHTWATCHMAN("Nightwatchman"), NOBLE("Noble"), ORACLE("Oracle"), PACIFIST("Pacifist"),
		PHILOSOPHER("Philosopher"), PIXIE("Pixie"), POPPYGROWER("Poppy Grower"), PREACHER("Preacher"),
		PROFESSOR("Professor"), RAVENKEEPER("Ravenkeeper"), SAGE("Sage"), SAILOR("Sailor"), SAVANT("Savant"),
		SEAMSTRESS("Seamstress"), SLAYER("Slayer"), SNAKECHARMER("Snake Charmer"), SOLDIER("Soldier"),
		STEWARD("Steward"), TEALADY("Tea Lady"), TOWNCRIER("Town Crier"), UNDERTAKER("Undertaker"), VIRGIN("Virgin"),
		WASHERWOMAN("Washerwoman");

		private String value;

		TOWNFOLKS(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public enum OUTSIDERS {
		ACROBAT("Acrobat"), BARBER("Barber"), BUTLER("Butler"), DAMSEL("Damsel"), DRUNK("Drunk"), GOLEM("Golem"),
		GOON("Goon"), HERETIC("Heretic"), KLUTZ("Klutz"), LUNATIC("Lunatic"), MOONCHILD("Moonchild"), MUTANT("Mutant"),
		POLITICIAN("Politician"), PUZZLEMASTER("Puzzlemaster"), RECLUSE("Recluse"), SAINT("Saint"), SNITCH("Snitch"),
		SWEETHEART("Sweetheart"), TINKER("Tinker");

		private String value;

		OUTSIDERS(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public static enum MINIONS {
		ASSASSIN("Assassin"), BARON("Baron"), BOOMDANDY("Boomdandy"), CERENOVUS("Cerenovus"),
		DEVILSADVOCATE("Devil's Advocate"), EVILTWIN("Evil Twin"), FEARMONGER("Fearmonger"), GOBLIN("Goblin"),
		GODFATHER("Godfather"), HARPY("Harpy"), MARIONETTE("Marionette"), MASTERMIND("Mastermind"),
		MEZEPHELES("Mezepheles"), ORGANGRINDER("Organ Grinder"), PITHAG("Pit-Hag"), POISONER("Poisoner"),
		PSYCHOPATH("Psychopath"), SCARLETTWOMAN("Scarlett Woman"), SPY("Spy"), VIZIER("Vizier"), WIDOW("Widow"),
		WITCH("Witch");

		private String value;

		MINIONS(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public static enum DEMONS {
		ALHADIKHIA("Al-Hadikhia"), FANGGU("Fang Gu"), IMP("Imp"), LEGION("Legion"), LEVIATHAN("Leviathan"),
		LILMONSTA("Lil' Monsta"), LLEECH("Lleech"), NODASHII("No Dashii"), PO("Po"), PUKKA("Pukka"), RIOT("Riot"),
		SHABALOTH("Shabaloth"), VIGORMORTIS("Vigormortis"), VORTOX("Vortox"), ZOMBUUL("Zombuul");

		private String value;

		DEMONS(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	public static List<TOWNFOLKS> getTownfolk() {
		return Arrays.asList(TOWNFOLKS.values());
	}

	public static List<OUTSIDERS> getOutsider() {
		return Arrays.asList(OUTSIDERS.values());
	}

	public static List<MINIONS> getMinion() {
		return Arrays.asList(MINIONS.values());
	}

	public static List<DEMONS> getDemon() {
		return Arrays.asList(DEMONS.values());
	}

	public static String[][] jinxCases = new String[][] { { "Fang Gu", "Scarlett Woman" },
			{ "Chambermaid", "Mathematician" }, { "Lunatic", "Mathematician" }, { "Godfather", "Heretic" },
			{ "Spy", "Damsel" }, { "Spy", "Heretic" }, { "Widow", "Damsel" }, { "Widow", "Heretic" },
			{ "Legion", "Preacher" }, { "Lil' Monsta", "Magician" }, { "Riot", "Exorcist" }, { "Riot", "Flowergirl" },
			{ "Riot", "Minstrel" }, { "Al-Hadikhia", "Mastermind" }, { "Pit-Hag", "Damsel" }, { "Pit-Hag", "Heretic" },
			{ "Pit-Hag", "Politician" }, { "Pit-Hag", "Riot" }, { "Engineer", "Legion" }, { "Engineer", "Riot" },
			{ "Alchemist", "Spy" }, { "Alchemist", "Widow" }, { "Magician", "Widow" }, { "Magician", "Spy" },
			{ "Poppy Grower", "Spy" }, { "Poppy Grower", "Widow" }, { "Lycanthrope", "Gambler" },
			{ "Cannibal", "Butler" }, { "Marionette", "Balloonist" }, { "Marionette", "Huntsman" },
			{ "Marionette", "Poppy Grower" }, { "Marionette", "Damsel" }, { "Marionette", "Snitch" },
			{ "Marionette", "Lil' Monsta" }, { "Organ Grinder", "Butler" }, { "Organ Grinder", "Flowergirl" },
			{ "Organ Grinder", "Minstrel" }, { "Organ Grinder", "Preacher" }, { "Vizier", "Alchemist" },
			{ "Vizier", "Courtier" }, { "Vizier", "Investigator" }, { "Vizier", "Magician" }, { "Vizier", "Preacher" },
			{ "Vizier", "Fearmonger" }, { "Baron", "Heretic" }, { "Cerenovus", "Goblin" },
			{ "Scarlett Woman", "Al-Hadikhia" }, { "Scarlett Woman", "Lil' Monsta" }, { "Mastermind", "Lleech" },
			{ "Lil' Monsta", "Poppy Grower" }, { "Lil' Monsta", "Organ Grinder" }, { "Lil' Monsta", "Vizier" },
			{ "Leviathan", "Farmer" }, { "Leviathan", "Innkeeper" }, { "Leviathan", "Mayor" }, { "Leviathan", "Monk" },
			{ "Leviathan", "Ravenkeeper" }, { "Leviathan", "Sage" }, { "Leviathan", "Soldier" }, { "Lleech", "Slayer" },
			{ "Lleech", "Heretic" }, { "Riot", "Clockmaker" }, { "Riot", "Investigator" }, { "Riot", "Preacher" },
			{ "Riot", "Town Crier" }, { "Riot", "Damsel" }, { "Riot", "Cannibal" }, { "Riot", "Pacifist" },
			{ "Riot", "Undertaker" }, { "Riot", "Devil's Advocate" }, { "Riot", "Farmer" }, { "Riot", "Grandmother" },
			{ "Riot", "King" }, { "Riot", "Ravenkeeper" }, { "Riot", "Sage" }, { "Riot", "Innkeeper" },
			{ "Riot", "Monk" }, { "Riot", "Soldier" }, { "Riot", "Mayor" }, { "Riot", "Butler" }, { "Riot", "Golem" },
			{ "Riot", "Saint" }, { "Riot", "Snitch" } };

}
