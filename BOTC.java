import java.util.*;

import javax.swing.JOptionPane;

public class BOTC{
public static void main(String[] args) {
        String[] townfolk = {"Alchemist", "Amnesiac", "Artist", "Athiest", "Balloonist", "Bounty Hunter", "Cannibal", "Chambermaid", "Chef", "Choirboy", "Clockmaker", "Courtier", "Cult Leader", "Dreamer", "Empath", "Engineer", "Exorcist", "Farmer", "Fisherman", "Flowergirl", "Fool", "Fortune Teller", "Gambler", "General", "Gossip", "Grandmother", "High Priestess", "Huntsman", "Innkeeper", "Investigator", "Juggler", "King", "Knight", "Libriaran", "Lycanthrope", "Magician", "Mathematician", "Mayor", "Minstrel", "Monk", "Nightwatchman", "Noble", "Oracle", "Pacifist", "Philosopher", "Pixie", "Poppy Grower", "Preacher", "Professor", "Ravenkeeper", "Sage", "Sailor", "Savant", "Seamstress", "Slayer", "Snake Charmer", "Soldier", "Steward", "Tea Lady", "Town Crier", "Undertaker", "Virgin", "Washerwoman"};
        String[] outsider = {"Acrobat", "Barber", "Butler", "Damsel", "Drunk", "Golem", "Goon", "Heretic", "Klutz", "Lunatic", "Moonchild", "Mutant", "Politician", "Puzzlemaster", "Recluse", "Saint", "Snitch", "Sweetheart", "Tinker"};
        String[] minion = {"Assassin", "Baron", "Boomdandy", "Cerenovus", "Devil's Advocate", "Evil Twin", "Fearmonger", "Goblin", "Godfather", "Harpy", "Marionette", "Mastermind", "Mezepheles", "Organ Grinder", "Pit-Hag", "Poisoner", "Psychopath", "Scarlett Woman", "Spy", "Vizier", "Widow", "Witch"};
        String[] demon = {"Al-Hadikhia", "Fang Gu", "Imp", "Legion", "Leviathan", "Lil' Monsta", "Lleech", "No Dashii", "Po", "Pukka", "Riot", "Shabaloth", "Vigormortis", "Vortox", "Zombuul"};
        int jinx_num = jinx_max("What is the max number of jinxes you want?[-1 if you don't care about number of jinxes]");
        ArrayList<String> TF_pref = getTFPref();
        ArrayList<String> O_pref = getOPref();
        ArrayList<String> M_pref = getMPref();
        ArrayList<String> D_pref = getDPref();
        String[] rolelist = choosing(townfolk, outsider, minion, demon, jinx_num, TF_pref, O_pref, M_pref, D_pref);
        
        for(String list:rolelist ) {
            System.out.println(list);
        }
    }

    public static ArrayList<String> getTFPref() {
        ArrayList<String> arrayList = new ArrayList<>();

        while (true) {
            String input = JOptionPane.showInputDialog("Enter preferred Townfolks[spell correctly and capitalized first letter] (type 'exit' to stop):");
            if (input == null || input.equalsIgnoreCase("exit")) {
                break;
            }
            arrayList.add(input);
        }

        return arrayList;
    }

    public static ArrayList<String> getOPref() {
        ArrayList<String> arrayList = new ArrayList<>();

        while (true) {
            String input = JOptionPane.showInputDialog("Enter preferred Outsiders[spell correctly and capitalized first letter] (type 'exit' to stop):");
            if (input == null || input.equalsIgnoreCase("exit")) {
                break;
            }
            arrayList.add(input);
        }

        return arrayList;
    }

    public static ArrayList<String> getMPref() {
        ArrayList<String> arrayList = new ArrayList<>();

        while (true) {
            String input = JOptionPane.showInputDialog("Enter preferred Minions[spell correctly and capitalized first letter] (type 'exit' to stop):");
            if (input == null || input.equalsIgnoreCase("exit")) {
                break;
            }
            arrayList.add(input);
        }

        return arrayList;
    }

    public static ArrayList<String> getDPref() {
        ArrayList<String> arrayList = new ArrayList<>();

        while (true) {
            String input = JOptionPane.showInputDialog("Enter preferred Demons[spell correctly and capitalized first letter] (type 'exit' to stop):");
            if (input == null || input.equalsIgnoreCase("exit")) {
                break;
            }
            arrayList.add(input);
        }

        return arrayList;
    }


    private static int jinx_max(String prompt) {
        String nss = JOptionPane.showInputDialog(null,prompt+"?");
        Scanner scanner = new Scanner(nss);
        return scanner.nextInt();
    }



    private static String[] choosing(String[] townfolk, String[] outsider, String[] minion, String[] demon, int jinx_num, ArrayList<String> TF_pref, ArrayList<String> O_pref, ArrayList<String> M_pref, ArrayList<String> D_pref) {
        boolean it_works;
        int random = ( int ) (Math.random()*4 + 1);
        String[] makeList = new String[21 + random];
        String[] townfolk_temp = new String[13];
        String[] outsider_temp = new String[4];
        String[] minion_temp = new String[4];
        String[] demon_temp = new String[random];
        while (it_works = true){
            Collections.shuffle(Arrays.asList(townfolk));
            Collections.shuffle(Arrays.asList(outsider));
            Collections.shuffle(Arrays.asList(minion));
            Collections.shuffle(Arrays.asList(demon));
            for (int a = 0; a < 13; a = a + 1){
                townfolk_temp[a] = townfolk[a];
            }
            for (int b = 0; b < 4; b = b + 1){
                outsider_temp[b] = outsider[b];
            }
            for (int c = 0; c < 4; c = c + 1){
                minion_temp[c] = minion[c];
            }
            for (int d = 0; d < random; d = d + 1){
                demon_temp[d] = demon[d];
            }
            for (int i = 0; i < TF_pref.size(); i = i + 1){
                if (Arrays.asList(townfolk_temp).contains(TF_pref.get(i))){
                    continue;
                }
            }
            for (int i = 0; i < O_pref.size(); i = i + 1){
                if (Arrays.asList(outsider_temp).contains(O_pref.get(i))){
                    continue;
                }
            }
            for (int i = 0; i < M_pref.size(); i = i + 1){
                if (Arrays.asList(minion_temp).contains(M_pref.get(i))){
                    continue;
                }
            }
            for (int i = 0; i < D_pref.size(); i = i + 1){
                if (Arrays.asList(demon_temp).contains(D_pref.get(i))){
                    continue;
                }
            }
            for (int i = 0; i < TF_pref.size(); i = i + 1){
                townfolk_temp[i] = TF_pref.get(i);
            }
            for (int i = 0; i < O_pref.size(); i = i + 1){
                outsider_temp[i] = O_pref.get(i);
            }
            for (int i = 0; i < M_pref.size(); i = i + 1){
                minion_temp[i] = M_pref.get(i);
            }
            for (int i = 0; i < D_pref.size(); i = i + 1){
                demon_temp[i] = D_pref.get(i);
            }
            String[] organizedtownfolk = new String[13];
            String[] organizedoutsider = new String[4];
            String[] organizedminion = new String[4];
            String[] organizeddemon = new String[random];
            for (int a = 0; a < 13; a = a + 1){
                organizedtownfolk[a] = townfolk_temp[a];
            }
            for (int b = 0; b < 4; b = b + 1){
                organizedoutsider[b] = outsider_temp[b];
            }
            for (int c = 0; c < 4; c = c + 1){
                organizedminion[c] = minion_temp[c];
            }
            for (int d = 0; d < random; d = d + 1){
                organizeddemon[d] = demon_temp[d];
            }
            Arrays.sort(organizedtownfolk);
            Arrays.sort(organizedoutsider);
            Arrays.sort(organizedminion);
            Arrays.sort(organizeddemon);
            for (int a = 0; a < 13; a = a + 1){
                makeList[a] = organizedtownfolk[a];
            }
            for (int b = 13; b < 17; b = b + 1){
                makeList[b] = organizedoutsider[b - 13];
            }
            for (int c = 17; c < 21; c = c + 1){
                makeList[c] = organizedminion[c - 17];
            }
            for (int d = 21; d < 21 + random; d = d + 1){
                makeList[d] = organizeddemon[d - 21];
            }
            List<String> checkList = new ArrayList<>(Arrays.asList(makeList));
            //King and Choirboy require each other
            if (checkList.contains("Choirboy")){
                if (checkList.contains("King")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("King")){
                if (checkList.contains("Choirboy")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Huntsman requires Damsel
            if (checkList.contains("Huntsman")) {
                if (checkList.contains("Damsel")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //At least 1 of {Lleech, Devil's Advocate, Harpy} requires at least 1 of {Sailor, Tea Lady, Fool, Pacifist} and vice versa
            if (checkList.contains("Lleech") || checkList.contains("Devil's Advocate") || checkList.contains("Harpy")) {
                if (checkList.contains("Sailor") || checkList.contains("Tea Lady") || checkList.contains("Fool") || checkList.contains("Pacifist")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Sailor") || checkList.contains("Tea Lady") || checkList.contains("Fool") || checkList.contains("Pacifist")) {
                if (checkList.contains("Lleech") || checkList.contains("Devil's Advocate") || checkList.contains("Harpy")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Harpy requires at least 1 of {Lleech, Devil's Advocate} and vice versa
            if (checkList.contains("Lleech") || checkList.contains("Devil's Advocate")) {
                if (checkList.contains("Harpy")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Harpy")) {
                if (checkList.contains("Lleech") || checkList.contains("Devil's Advocate")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Cerenovus requires at least 1 of {Pixie, Mutant, Harpy} and vice versa
            if (checkList.contains("Cerenovus")) {
                if (checkList.contains("Pixie") || checkList.contains("Mutant") || checkList.contains("Harpy")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Pixie") || checkList.contains("Mutant") || checkList.contains("Harpy")) {
                if (checkList.contains("Cerenovus")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Harpy requires at least 1 of {Pixie, Mutant} and vice versa
            if (checkList.contains("Harpy")) {
                if (checkList.contains("Pixie") || checkList.contains("Mutant")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Pixie") || checkList.contains("Mutant")) {
                if (checkList.contains("Harpy")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Professor and Shabaloth require each other
            if (checkList.contains("Professor")) {
                if (checkList.contains("Shabaloth")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Shabaloth")) {
                if (checkList.contains("Professor")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Vigormortis can't be with {Goblin, Evil Twin, Boomdandy, Pyschopath, Scarlett Woman}
            if (checkList.contains("Vigormortis") && (checkList.contains("Goblin") || checkList.contains("Evil Twin") || checkList.contains("Boomdandy") || checkList.contains("Psychopath") || checkList.contains("Scarlett Woman"))) {
                continue;    
            }
            //At least 1 of {Riot, Al-Hadikhia, Leviathan} requires an Engineer
            if (checkList.contains("Riot") || checkList.contains("Al-Hadikhia") || checkList.contains("Leviathan")) {
                if (checkList.contains("Engineer")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Oracle requires at least 1 of {Vigormortis, Zombuul, Fang Gu, Imp}
            if (checkList.contains("Oracle")) {
                if (checkList.contains("Vigormortis") || checkList.contains("Zombuul") || checkList.contains("Fang Gu") || checkList.contains("Imp")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //At least 1 of {Mastermind, Po, Zombuul} requires at least 1 of {Soldier, Exorcist, Minstrel, Pit-Hag} and vice versa
            if (checkList.contains("Mastermind") || checkList.contains("Po") || checkList.contains("Zombuul")) {
                if (checkList.contains("Soldier") || checkList.contains("Exorcist") || checkList.contains("Monk") || checkList.contains("Minstrel") || checkList.contains("Pit-Hag")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if ((checkList.contains("Soldier") || checkList.contains("Exorcist") || checkList.contains("Monk") || checkList.contains("Minstrel")) || checkList.contains("Pit-Hag")) {
                if (checkList.contains("Mastermind") || checkList.contains("Po")|| checkList.contains("Zombuul")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Can't have both Spy and Widow
            if (checkList.contains("Spy") && checkList.contains("Widow")) {
                continue;
            }
            //Spy nor Widow can't be with {King, Choirboy, Exorcist, Puzzlemaster, Heretic} 
            if ((checkList.contains("Spy") || checkList.contains("Widow")) && (checkList.contains("King") || checkList.contains("Choirboy") || checkList.contains("Exorcist") || checkList.contains("Puzzlemaster") || checkList.contains("Heretic"))) {
                continue;
            }
            //Lunatic can't be with {Fang Gu, Imp}
            if (checkList.contains("Lunatic") && (checkList.contains("Fang Gu") || checkList.contains("Imp"))) {
                continue;
            }
            //Mastermind, Po, and Zombuul require each other
            if (checkList.contains("Mastermind")) {
                if (checkList.contains("Po") || checkList.contains("Zombuul")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Po")) {
                if (checkList.contains("Mastermind") || checkList.contains("Zombuul")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Zombuul")) {
                if (checkList.contains("Mastermind") || checkList.contains("Po")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Lil' Monsta requires Legion and vice versa
            if (checkList.contains("Lil' Monsta")) {
                if (checkList.contains("Legion")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Legion")) {
                if (checkList.contains("Lil' Monsta")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Lil' Monsta requires at least 1 of {Imp, Barber, Snake Charmer, Fang Gu}
            if (checkList.contains("Lil' Monsta")) {
                if (checkList.contains("Imp") || checkList.contains("Barber")  || checkList.contains("Snake Charmer") || checkList.contains("Fang Gu")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Magician can't be with {Fang Gu, Imp, Vortox}
            if (checkList.contains("Magician") && (checkList.contains("Fang Gu") || checkList.contains("Imp") || checkList.contains("Vortox"))) {
                continue;
            }
            //If Leviathan is with at least one of {Assassin, Godfather}, then it requires at least 1 of {Tinker, Gambler, Lycanthrope, Acrobat, Grandmother, Moonchild}
            if (checkList.contains("Leviathan") && (checkList.contains("Assassin") || checkList.contains("Godfather"))) {
                if (checkList.contains("Tinker") || checkList.contains("Gambler") || checkList.contains("Lycanthrope") || checkList.contains("Acrobat") || checkList.contains("Grandmother") || checkList.contains("Moonchild")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Snitch requires at least 1 of {Poppy Grower, Lil' Monsta}
            if (checkList.contains("Snitch")) {
                if (checkList.contains("Poppy Grower") || checkList.contains("Lil' Monsta")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Poppy Grower requires at least 1 of {Legion, Fearmonger, Riot, Organ Grinder, Vizier, Harpy, Fearmonger}
            if (checkList.contains("Poppy Grower")) {
                if (checkList.contains("Legion") || checkList.contains("Fearmonger") || checkList.contains("Riot") || checkList.contains("Organ Grinder") || checkList.contains("Vizier") || checkList.contains("Harpy") || checkList.contains("Fearmonger")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Pit-Hag and Goon can't be together
            if (checkList.contains("Pit-Hag") && checkList.contains("Goon")) {
                continue;
            }
            //At least 1 of {Imp, Fang Gu} reuires at least 1 of {Sage, Ravenkeeper, Farmer} and vice versa
            if (checkList.contains("Imp") || checkList.contains("Fang Gu")) {
                if (checkList.contains("Sage") || checkList.contains("Ravenkeeper") || checkList.contains("Farmer")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Sage") || checkList.contains("Ravenkeeper") || checkList.contains("Farmer")) {
                if (checkList.contains("Imp") || checkList.contains("Fang Gu")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //At least 1 of {Mezepheles, Cult Leader, Fang Gu, Goon} reuires at least 1 of {Empath, Oracle, Seamstress}
            if (checkList.contains("Mezepheles") || checkList.contains("Cult Leader") || checkList.contains("Fang Gu") || checkList.contains("Goon")) {
                if (checkList.contains("Empath") || checkList.contains("Oracle") || checkList.contains("Seamstress")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            // At least 1 of {Po, Shabaloth} requires at least 1 {Tinker, Gossip, Gambler, Acrobat, Grandmother, Moonchild}
            if (checkList.contains("Po") || checkList.contains("Shabaloth")) {
                if (checkList.contains("Tinker") || checkList.contains("Gossip") || checkList.contains("Pit-Hag") || checkList.contains("Gambler") || checkList.contains("Acrobat") || checkList.contains("Grandmother") || checkList.contains("Moonchild")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Poppy Grower and at least 1 of {Al-Hadikhia, Fang Gu, Imp, Leviathan, Lil' Monsta, Lleech, No Dashii, Po, Pukka, Shabaloth, Vigormortis}
            if (checkList.contains("Poppy Grower") && (checkList.contains("Al-Hadikhia") || checkList.contains("Fang Gu") || checkList.contains("Imp") || checkList.contains("Leviathan") || checkList.contains("Lil' Monsta") || checkList.contains("Lleech") || checkList.contains("No Dashii") || checkList.contains("Po") || checkList.contains("Pukka") || checkList.contains("Shabaloth") || checkList.contains("Vigormortis"))) {
                if (checkList.contains("Scarlett Woman")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Can't have both Legion and Clockmaker
            if (checkList.contains("Legion") && checkList.contains("Clockmaker")){
                continue;
            }
            //Can't have both Lil' Monsta and Fortune Teller
            if (checkList.contains("Lil' Monsta") && checkList.contains("Fortune Teller")){
                continue;
            }
            //Legion requires at least 1 of {Recluse, Vortox}
            if (checkList.contains("Legion")){
                if (checkList.contains("Recluse") || checkList.contains("Vortox")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //If there's 1 demon there can't be at least 1 of {Riot, Pit-Hag, Engineer, Legion, Courtier, Heretic, Vortox}
            if ((checkList.contains("Riot") || checkList.contains("Pit-Hag") || checkList.contains("Engineer") || checkList.contains("Legion") || checkList.contains("Courtier") || checkList.contains("Heretic") || checkList.contains("Vortox")) && (random == 1)) {
                continue;
            }
            //Undertaker requires at least 1 of {Spy, Widow} and vice versa
            if (checkList.contains("Spy") || checkList.contains("Widow")){
                if (checkList.contains("Undertaker")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Undertaker")){
                if (checkList.contains("Spy") || checkList.contains("Widow")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Balloonist requires at least 1 of {Damsel, Drunk, Goon, Lunatic, Politician, Recluse, Snitch}
            if (checkList.contains("Balloonist")){
                if (checkList.contains("Damsel") || checkList.contains("Drunk") || checkList.contains("Goon") || checkList.contains("Lunatic") || checkList.contains("Politician") || checkList.contains("Recluse") || checkList.contains("Snitch")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Al-Hadikhia requires Professor and at least 1 of {Fool, Monk, Sailor, Soldier, Tea Lady, Goon} and at least 1 of {Gambler, Gossip, Mayor, Moonchild, Tinker, Assassin and Godfather}
            if(checkList.contains("Al-Hadikhia")){
                if (checkList.contains("Professor") && (checkList.contains("Fool") || checkList.contains("Monk") || checkList.contains("Sailor") || checkList.contains("Soldier") || checkList.contains("Tea Lady") || checkList.contains("Goon")) && (checkList.contains("Gambler") || checkList.contains("Gossip") || checkList.contains("Mayor") || checkList.contains("Moonchild") || checkList.contains("Tinker") || checkList.contains("Assassin") || checkList.contains("Godfather"))){
                } else {
                    continue;
                }
            }
            //Athiest requires Drunk
            if (checkList.contains("Athiest")) {
                if (checkList.contains("Drunk")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Can't have both Undertaker and Cannibal
            if (checkList.contains("Undertaker") && checkList.contains("Cannibal")){
                continue;
            }
            //Can't have both Virgin and Golem
            if (checkList.contains("Virgin") && checkList.contains("Golem")){
                continue;
            }
            //Can't have Harpy with at least 1 of {Witch, Pychopath}
            if (checkList.contains("Harpy") && (checkList.contains("Witch") || checkList.contains("Psychopath"))){
                continue;
            }
            //Can't have any combination of {Fang Gu, Balloonist, Baron}
            if ((checkList.contains("Fang Gu") && checkList.contains("Balloonist")) || (checkList.contains("Balloonist") && checkList.contains("Baron")) || (checkList.contains("Baron") || checkList.contains("Fang Gu"))){
                continue;
            }
            //Can't have at least 1 of {King, Exorcist} with at least 1 of {Spy, Widow}
            if ((checkList.contains("King") || checkList.contains("Exorcist")) && (checkList.contains("Spy") || checkList.contains("Widow"))){
                continue;
            }
            //Can't have both Alchemist and Marionette
            if (checkList.contains("Alchemist") && checkList.contains("Marionette")){
                continue;
            }
            //Can't have both Bounty Hunter and Mezepheles
            if (checkList.contains("Bounty Hunter") && checkList.contains("Mezepheles")){
                continue;
            }
            //Can't have both Steward and Grandmother
            if (checkList.contains("Steward") && checkList.contains("Grandmother")){
                continue;
            }
            //Can't have both Cult Leader and Goon
            if (checkList.contains("Cult Leader") && checkList.contains("Goon")){
                continue;
            }
            // At least 1 of {Mathematican, Acrobat} requires at least 1 of {Courtier, Innkeeper, Minstrel, Philosopher, Sailor, Snake Charmer, Goon, Lunatic, Puzzlemaster, Sweetheart, Widow, Poisoner, Lleech, No Dashii, Pukka, Vigormortis, Vortox}
            if (checkList.contains("Mathematican") || checkList.contains("Acrobat")){
                if (checkList.contains("Courtier") || checkList.contains("Innkeeper") || checkList.contains("Minstrel") || checkList.contains("Philosopher") || checkList.contains("Sailor") || checkList.contains("Snake Charmer") || checkList.contains("Goon") || checkList.contains("Lunatic") || checkList.contains("Puzzlemaster") || checkList.contains("Sweetheart") || checkList.contains("Widow") || checkList.contains("Poisoner") || checkList.contains("Lleech") || checkList.contains("No Dashii") || checkList.contains("Pukka") || checkList.contains("Vigormortis") || checkList.contains("Vortox")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            // At least 1 of {Vizier, Harpy, Psychopath, Riot}  requires at least 1 of {Fool, Sailor, Devil's Advocate, Zombuul, Tea Lady}
            if (checkList.contains("Vizier") || checkList.contains("Harpy") || checkList.contains("Psychopath") || checkList.contains("Riot")) {
                if (checkList.contains("Fool") || checkList.contains("Sailor") || checkList.contains("Devil's Advocate") || checkList.contains("Zombuul") || checkList.contains("Tea Lady")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Harpy and High Priestess require each other
            if (checkList.contains("Harpy")) {
                if (checkList.contains("High Priestess")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("High Priestess")) {
                if (checkList.contains("Harpy")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Harpy requires Al-Hadikhia
            if (checkList.contains("Harpy")) {
                if (checkList.contains("Al-Hadikhia")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Harpy requires at least 1 of {Bounty Hunter, Cult Leader, Dreamer, Empath, Flowergirl, Fortune Teller, Gambler, Investigator, Juggler, Noble, Pixie, Sage, Seamstress, Town Crier, Tea Lady, Undertaker, Virgin, Moonchild, Puzzlemaster}
            if (checkList.contains("Harpy")) {
                if (checkList.contains("Bounty Hunter") || checkList.contains("Cult Leader") || checkList.contains("Dreamer") || checkList.contains("Empath") || checkList.contains("Flowergirl") || checkList.contains("Fortune Teller") || checkList.contains("Gambler") || checkList.contains("Investigator") || checkList.contains("Juggler") || checkList.contains("Noble") || checkList.contains("Pixie") || checkList.contains("Sage") || checkList.contains("Seamstress") || checkList.contains("Town Crier") || checkList.contains("Tea Lady") || checkList.contains("Undertaker") || checkList.contains("Virgin") || checkList.contains("Moonchild") || checkList.contains("Puzzlemasterer")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //If there's at least 1 loud demon, there needs to be at least 2 quiet demons. Alternatively, 1 loud Demon with no quiet demons.
            int NonLoudDemon = 0;
            if ((checkList.contains("Al-Hadikhia") || checkList.contains("Legion") || checkList.contains("Leviathan") || checkList.contains("Riot")) && !(random == 1)) {
                List<String> temp = checkList;
                String[] NotLoudDemon = {"Fang Gu", "Imp", "Lil' Monsta", "Lleech", "No Dashii", "Po", "Pukka", "Shabaloth", "Vigormortis", "Vortox", "Zombuul"};
                for(int j = 0; j < NotLoudDemon.length; j = j + 1){
                    if (temp.contains(NotLoudDemon[j])) {
                        NonLoudDemon = NonLoudDemon + 1;
                    }
                }
            
                if (NonLoudDemon == 1){
                    continue;
                }
            }
            //Jinx Cases
            int foundedjinxes = 0;
            String[][] jinxes = jinxlist();
            for(int i = 0; i < jinxes.length; i = i + 1) {
                if(checkList.contains(jinxes[i][0]) && checkList.contains(jinxes[i][1])){
                    foundedjinxes = foundedjinxes + 1;
                }
            }
            if (jinx_num == -1) {
                it_works = true;
            }
            if (!(jinx_num == -1)) {
                if (foundedjinxes <= jinx_num) {
                    it_works = true;
                }
                else if (foundedjinxes > jinx_num){
                    continue;
                }
            }
        break;  
        }
        return makeList;
    }




    private static String[][] jinxlist() {
        String[][] jinxcases = new String[][] {{"Fang Gu", "Scarlett Woman"},
        {"Chambermaid", "Mathematician"},
        {"Lunatic", "Mathematician"},
        {"Godfather", "Heretic"},
        {"Spy", "Damsel"},
        {"Spy", "Heretic"},
        {"Widow", "Damsel"},
        {"Widow", "Heretic"},
        {"Legion", "Preacher"},
        {"Lil' Monsta", "Magician"},
        {"Riot", "Exorcist"},
        {"Riot", "Flowergirl"},
        {"Riot", "Minstrel"},
        {"Al-Hadikhia", "Mastermind"},
        {"Pit-Hag", "Damsel"},
        {"Pit-Hag", "Heretic"},
        {"Pit-Hag", "Politician"},
        {"Pit-Hag", "Riot"},
        {"Engineer", "Legion"},
        {"Engineer", "Riot"},
        {"Alchemist", "Spy"},
        {"Alchemist", "Widow"},
        {"Magician", "Widow"},
        {"Magician", "Spy"},
        {"Poppy Grower", "Spy"},
        {"Poppy Grower", "Widow"},
        {"Lycanthrope", "Gambler"},
        {"Cannibal", "Butler"},
        {"Marionette", "Balloonist"},
        {"Marionette", "Huntsman"},
        {"Marionette", "Poppy Grower"},
        {"Marionette", "Damsel"},
        {"Marionette", "Snitch"},
        {"Marionette", "Lil' Monsta"},
        {"Organ Grinder", "Butler"},
        {"Organ Grinder", "Flowergirl"},
        {"Organ Grinder", "Minstrel"},
        {"Organ Grinder", "Preacher"},
        {"Vizier", "Alchemist"},
        {"Vizier", "Courtier"},
        {"Vizier", "Investigator"},
        {"Vizier", "Magician"},
        {"Vizier", "Preacher"},
        {"Vizier", "Fearmonger"},
        {"Baron", "Heretic"},
        {"Cerenovus", "Goblin"},
        {"Scarlett Woman", "Al-Hadikhia"},
        {"Scarlett Woman", "Lil' Monsta"},
        {"Mastermind", "Lleech"},
        {"Lil' Monsta", "Poppy Grower"},
        {"Lil' Monsta", "Organ Grinder"},
        {"Lil' Monsta", "Vizier"},
        {"Leviathan", "Farmer"},
        {"Leviathan", "Innkeeper"},
        {"Leviathan", "Mayor"},
        {"Leviathan", "Monk"},
        {"Leviathan", "Ravenkeeper"},
        {"Leviathan", "Sage"},
        {"Leviathan", "Soldier"},
        {"Lleech", "Slayer"},
        {"Lleech", "Heretic"},
        {"Riot", "Clockmaker"},
        {"Riot", "Investigator"},
        {"Riot", "Preacher"},
        {"Riot", "Town Crier"},
        {"Riot", "Damsel"},
        {"Riot", "Cannibal"},
        {"Riot", "Pacifist"},
        {"Riot", "Undertaker"},
        {"Riot", "Devil's Advocate"},
        {"Riot", "Farmer"},
        {"Riot", "Grandmother"},
        {"Riot", "King"},
        {"Riot", "Ravenkeeper"},
        {"Riot", "Sage"},
        {"Riot", "Innkeeper"},
        {"Riot", "Monk"},
        {"Riot", "Soldier"},
        {"Riot", "Mayor"},
        {"Riot", "Butler"},
        {"Riot", "Golem"},
        {"Riot", "Saint"},
        {"Riot", "Snitch"}};

        return jinxcases;
    
    }
}
    

//A great thank you to Karah, Zoe, Pi, Chris W, gredelston, codetriangle, nyhilo and pokesvorlds for helping me out with the code
