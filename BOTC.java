import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


import javax.swing.JOptionPane;

public class BOTC{
        public static void main(String[] args) {
                String[] townfolk = {"Alchemist", "Alsaahir", "Amnesiac", "Artist", "Athiest", "Balloonist", "Banshee", "Bounty Hunter", "Cannibal", "Chambermaid", "Chef", "Choirboy", "Clockmaker", "Courtier", "Cult Leader", "Dreamer", "Empath", "Engineer", "Exorcist", "Farmer", "Fisherman", "Flowergirl", "Fool", "Fortune Teller", "Gambler", "General", "Gossip", "Grandmother", "High Priestess", "Huntsman", "Innkeeper", "Investigator", "Juggler", "King", "Knight", "Libriaran", "Lycanthrope", "Magician", "Mathematician", "Mayor", "Minstrel", "Monk", "Nightwatchman", "Noble", "Oracle", "Pacifist", "Philosopher", "Pixie", "Poppy Grower", "Preacher", "Professor", "Ravenkeeper", "Sage", "Sailor", "Savant", "Shugenja", "Seamstress", "Slayer", "Snake Charmer", "Soldier", "Steward", "Tea Lady", "Town Crier", "Undertaker", "Village Idiot", "Virgin", "Washerwoman"};
                String[] outsider = {"Acrobat", "Barber", "Butler", "Damsel", "Drunk", "Golem", "Goon", "Hatter", "Heretic", "Klutz", "Lunatic", "Moonchild", "Mutant", "Ogre", "Plague Doctor", "Politician", "Puzzlemaster", "Recluse", "Saint", "Snitch", "Sweetheart", "Tinker", "Zealot"};
                String[] minion = {"Assassin", "Baron", "Boomdandy", "Cerenovus", "Devil's Advocate", "Evil Twin", "Fearmonger", "Goblin", "Godfather", "Harpy", "Marionette", "Mastermind", "Mezepheles", "Organ Grinder", "Pit-Hag", "Poisoner", "Psychopath", "Scarlett Woman", "Spy", "Summoner", "Vizier", "Widow", "Witch"};
                String[] demon = {"Al-Hadikhia", "Fang Gu", "Imp", "Kazali", "Legion", "Leviathan", "Lil' Monsta", "Lleech", "Lord Of Typhon", "No Dashii", "Ojo", "Po", "Pukka", "Riot", "Shabaloth", "Vigormortis", "Vortox", "Yaggababble", "Zombuul"};
                int jinx_num = jinx_max("What is the max number of jinxes you want?[-1 if you don't care about number of jinxes]");
                ArrayList<String> TF_pref = getTFPref();
                ArrayList<String> O_pref = getOPref();
                ArrayList<String> M_pref = getMPref();
                ArrayList<String> D_pref = getDPref();
                String[] rolelist = choosing(townfolk, outsider, minion, demon, jinx_num, TF_pref, O_pref, M_pref, D_pref);
        
                for(String list:rolelist) {
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
                if (checkList.contains("Lleech") || checkList.contains("Devil's Advocate") || checkList.contains("Harpy") || checkList.contains("Organ Grinder")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Harpy requires Lleech and vice versa
            if (checkList.contains("Lleech")) {
                if (checkList.contains("Harpy")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Harpy")) {
                if (checkList.contains("Lleech")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Organ Grinder requires Courtier
            if (checkList.contains("Organ Grinder")) {
                if (checkList.contains("Courtier")){
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
            //At least 1 of {Riot, Al-Hadikhia, Leviathan, Legion} requires an Engineer
            if (checkList.contains("Riot") || checkList.contains("Al-Hadikhia") || checkList.contains("Leviathan") || checkList.contains("Legion")) {
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
            //At least 1 of {Mastermind, Po, Zombuul, Ojo, Summoner} requires at least 1 of {Soldier, Exorcist, Minstrel, Pit-Hag, Evil Twin} and vice versa
            if (checkList.contains("Mastermind") || checkList.contains("Po") || checkList.contains("Zombuul") || checkList.contains("Ojo") || checkList.contains("Summoner")) {
                if (checkList.contains("Soldier") || checkList.contains("Exorcist") || checkList.contains("Monk") || checkList.contains("Minstrel") || checkList.contains("Pit-Hag") || checkList.contains("Evil Twin")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if ((checkList.contains("Soldier") || checkList.contains("Exorcist") || checkList.contains("Monk") || checkList.contains("Minstrel")) || checkList.contains("Pit-Hag") || checkList.contains("Evil Twin")) {
                if (checkList.contains("Mastermind") || checkList.contains("Po")|| checkList.contains("Zombuul") || checkList.contains("Ojo") || checkList.contains("Summoner")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Can't have both Spy and Widow
            if (checkList.contains("Spy") && checkList.contains("Widow")) {
                continue;
            }
            //Can't have both Summoner and Magician
            if (checkList.contains("Summoner") && checkList.contains("Magician")) {
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
            //Mastermind, Po, Ojo, Zombuul, Summoner require at least 1 of the others
            if (checkList.contains("Mastermind")) {
                if (checkList.contains("Po") || checkList.contains("Zombuul") || checkList.contains("Ojo") || checkList.contains("Summoner")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Po")) {
                if (checkList.contains("Zombuul") || checkList.contains("Ojo") || checkList.contains("Mastermind") || checkList.contains("Summoner")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Zombuul")) {
                if (checkList.contains("Ojo") || checkList.contains("Mastermind") || checkList.contains("Po") || checkList.contains("Summoner")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Ojo")) {
                if (checkList.contains("Mastermind") || checkList.contains("Po") || checkList.contains("Zombuul")  || checkList.contains("Summoner")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Summoner")) {
                if (checkList.contains("Mastermind") || checkList.contains("Po") || checkList.contains("Zombuul")  || checkList.contains("Ojo")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //{Lil' Monsta, Legion, Ojo} require at least 1 of the other
            if (checkList.contains("Lil' Monsta")) {
                if (checkList.contains("Legion") || checkList.contains("Ojo")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Legion")) {
                if (checkList.contains("Ojo")|| checkList.contains("Lil' Monsta")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Ojo")) {
                if (checkList.contains("Lil' Monsta")|| checkList.contains("Legion")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //If Pit-Hag or Engineer or Hatter is with at least 1 of {Organ Grinder, Fearmonger}, it requires the other
            if (!((checkList.contains("Pit-Hag") || checkList.contains("Engineer") || checkList.contains("Hatter")) && (checkList.contains("Organ Grinder") || checkList.contains("Fearmonger")))) {
                it_works = true; 
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
            if (checkList.contains("Magician") && (checkList.contains("Fang Gu") || checkList.contains("Imp"))) {
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
            //Leviathan and {Cerenovus, Grandmother} can't be together
            if (checkList.contains("Leviathan") && (checkList.contains("Cerenovus") || checkList.contains("Grandmother"))) {
                continue;
            }
            //Snitch requires at least 1 of {Poppy Grower, Lil' Monsta}
            if (checkList.contains("Snitch")) {
                if (checkList.contains("Poppy Grower") || checkList.contains("Lil' Monsta")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Poppy Grower requires at least 1 of {Legion, Fearmonger, Riot, Organ Grinder, Vizier, Harpy, Fearmonger, Summoner}
            if (checkList.contains("Poppy Grower")) {
                if (checkList.contains("Legion") || checkList.contains("Fearmonger") || checkList.contains("Riot") || checkList.contains("Organ Grinder") || checkList.contains("Vizier") || checkList.contains("Harpy") || checkList.contains("Fearmonger")  || checkList.contains("Summoner")) {
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
            //At least 1 of {Mezepheles, Cult Leader, Fang Gu, Goon, Summoner, Ogre} requires at least 1 of {Empath, Oracle, Seamstress, Village Idiot}
            if (checkList.contains("Mezepheles") || checkList.contains("Cult Leader") || checkList.contains("Fang Gu") || checkList.contains("Goon") || checkList.contains("Summoner") || checkList.contains("Ogre")) {
                if (checkList.contains("Empath") || checkList.contains("Oracle") || checkList.contains("Seamstress") || checkList.contains("Seamstress")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            // At least 1 of {Po, Shabaloth, Ojo} requires at least 1 {Tinker, Gossip, Gambler, Acrobat, Grandmother, Moonchild}
            if (checkList.contains("Po") || checkList.contains("Shabaloth") || checkList.contains("Ojo")) {
                if (checkList.contains("Tinker") || checkList.contains("Gossip") || checkList.contains("Pit-Hag") || checkList.contains("Gambler") || checkList.contains("Acrobat") || checkList.contains("Grandmother") || checkList.contains("Moonchild")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Poppy Grower and at least 1 of {Al-Hadikhia, Fang Gu, Imp, Leviathan, Lil' Monsta, Lleech, Lord Of Typhon, No Dashii, Po, Pukka, Shabaloth, Vigormortis, Yaggababble} needs a Scarlett Woman
            if (checkList.contains("Poppy Grower") && (checkList.contains("Al-Hadikhia") || checkList.contains("Fang Gu") || checkList.contains("Imp") || checkList.contains("Leviathan") || checkList.contains("Lil' Monsta") || checkList.contains("Lleech") || checkList.contains("Lord Of Typhon") || checkList.contains("No Dashii") || checkList.contains("Po") || checkList.contains("Pukka") || checkList.contains("Shabaloth") || checkList.contains("Vigormortis") || checkList.contains("Yaggababble"))) {
                if (checkList.contains("Scarlett Woman")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Politician requires at least 1 of {Goblin, Fearmonger}
            if (checkList.contains("Politician")) {
                if (checkList.contains("Goblin") || checkList.contains("Fearmonger")) {
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
            //At least 1 {Balloonist, Fang Gu, Godfather, Kazali, Lord Of Typhon} requires at least 1 of {Damsel, Drunk, Goon, Lunatic, Ogre, Plague Doctor, Politician, Recluse, Snitch, Zealot}
            if (checkList.contains("Balloonist") || checkList.contains("Fang Gu") || checkList.contains("Godfather") || checkList.contains("Kazali") || checkList.contains("Lord Of Typhon")){
                if (checkList.contains("Damsel") || checkList.contains("Drunk") || checkList.contains("Goon") || checkList.contains("Lunatic") || checkList.contains("Ogre")  || checkList.contains("Plague Doctor") || checkList.contains("Politician") || checkList.contains("Recluse") || checkList.contains("Snitch") || checkList.contains("Hatter") || checkList.contains("Zealot")){
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
            //Can't have all or any pair of {Virgin, Golem, Banshee}
            if (checkList.contains("Virgin") && checkList.contains("Golem") && checkList.contains("Banshee")){
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
            //Can't have both Cult Leader and Heretic
            if (checkList.contains("Cult Leader") && checkList.contains("Heretic")){
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
            // At least 1 of {Mathematican, Acrobat} requires at least 1 of {Courtier, Innkeeper, Minstrel, Philosopher, Sailor, Snake Charmer, Goon, Lunatic, Puzzlemaster, Sweetheart, Widow, Poisoner, Lleech, No Dashii, Pukka, Vigormortis, Vortox, Village Idiot}
            if (checkList.contains("Mathematican") || checkList.contains("Acrobat")){
                if (checkList.contains("Courtier") || checkList.contains("Innkeeper") || checkList.contains("Minstrel") || checkList.contains("Philosopher") || checkList.contains("Sailor") || checkList.contains("Snake Charmer") || checkList.contains("Goon") || checkList.contains("Lunatic") || checkList.contains("Puzzlemaster") || checkList.contains("Sweetheart") || checkList.contains("Widow") || checkList.contains("Poisoner") || checkList.contains("Lleech") || checkList.contains("No Dashii") || checkList.contains("Pukka") || checkList.contains("Vigormortis") || checkList.contains("Vortox") || checkList.contains("Village Idiot")) {
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
            //Harpy requires at least 1 of {Bounty Hunter, Cult Leader, Dreamer, Empath, Flowergirl, Fortune Teller, Gambler, Investigator, Juggler, Noble, Pixie, Sage, Seamstress, Shugenja, Town Crier, Tea Lady, Undertaker, Virgin, Moonchild, Puzzlemaster, Village Idiot}
            if (checkList.contains("Harpy")) {
                if (checkList.contains("Bounty Hunter") || checkList.contains("Cult Leader") || checkList.contains("Dreamer") || checkList.contains("Empath") || checkList.contains("Flowergirl") || checkList.contains("Fortune Teller") || checkList.contains("Gambler") || checkList.contains("Investigator") || checkList.contains("Juggler") || checkList.contains("Noble") || checkList.contains("Pixie") || checkList.contains("Sage") || checkList.contains("Seamstress") || checkList.contains("Shugenja") || checkList.contains("Town Crier") || checkList.contains("Tea Lady") || checkList.contains("Undertaker") || checkList.contains("Virgin") || checkList.contains("Moonchild") || checkList.contains("Puzzlemaster") || checkList.contains("Village Idiot")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Plague Doctor requires at least 1 of {Lil' Monsta, Legion, Lord Of Typhon, Riot, Alchemist, Atheist, Engineer, Pit-Hag}
            if (checkList.contains("Plague Doctor")) {
                if (checkList.contains("Lil' Monsta") || checkList.contains("Legion") || checkList.contains("Lord Of Typhon") || checkList.contains("Riot") || checkList.contains("Alchemist") || checkList.contains("Atheist") || checkList.contains("Engineer") || checkList.contains("Pit-Hag")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Plague Doctor requires at least 1 of {Marionette, at least 1 of {Bounty Hunter, Mezepheles, Cult Leader, Goon, Ogre} but not both
            if (checkList.contains("Plague Doctor") && (checkList.contains("Bounty Hunter") || checkList.contains("Mezepheles") || checkList.contains("Cult Leader") || checkList.contains("Goon") || checkList.contains("Ogre"))) {
                if (checkList.contains("Marionette")){
                    continue;
                } else {
                    it_works = true;
                }
            }
            if (checkList.contains("Plague Doctor") && checkList.contains("Marionette")) {
                if (checkList.contains("Bounty Hunter") || checkList.contains("Mezepheles") || checkList.contains("Cult Leader") || checkList.contains("Goon")) {
                    continue;
                } else {
                    it_works = true;
                }
            }
            //If both Plague Doctor and Baron are in the set up, Pit-Hag must be in there
            if (checkList.contains("Plague Doctor") && checkList.contains("Baron")) {
                if (checkList.contains("Pit-Hag")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Lycanthrope requires at least 1 of {Empath, Farmer, Fool, King, Mayor, Oracle, Pixie, Poppy Grower, Ravenkeeper, Sailor, Tea Lady, Innkeeper, Acrobat, Barber, Goon, Moonchild, Sweetheart, Plague Doctor}
            if (checkList.contains("Lycanthrope")) {
                if (checkList.contains("Empath") || checkList.contains("Farmer") || checkList.contains("Fool") || checkList.contains("King") || checkList.contains("Mayor") || checkList.contains("Oracle") || checkList.contains("Pixie") || checkList.contains("Poppy Grower") || checkList.contains("Ravenkeeper") || checkList.contains("Sailor") || checkList.contains("Tea Lady") || checkList.contains("Innkeeper") || checkList.contains("Acrobat") || checkList.contains("Barber") || checkList.contains("Goon") || checkList.contains("Moonchild") || checkList.contains("Sweetheart") || checkList.contains("Plague Doctor")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Vizier can't have {Evil Twin, Goblin, Leviathan, Mastermind, Saint}
            if (checkList.contains("Vizier")) {
                if (checkList.contains("Evil Twin") || checkList.contains("Goblin") || checkList.contains("Leviathan") || checkList.contains("Mastermind") || checkList.contains("Saint")) {
                    continue;
                } else {
                    it_works = true;
                }
            }
            //Vortox requires at least 1 of {Goblin, Fearmonger} and vice versa
            if (checkList.contains("Vortox")) {
                if (checkList.contains("Goblin") || checkList.contains("Fearmonger")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Goblin") || checkList.contains("Fearmonger")) {
                if (checkList.contains("Vortox")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Shugenja requires at least 1 of {Cannibal, Philosopher, Pixie}
            if (checkList.contains("Shugenja")) {
                if (checkList.contains("Cannibal") || checkList.contains("Philosopher") || checkList.contains("Pixie")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Shugenja requires at least 1 of {Spy, Recluse}
            if (checkList.contains("Shugenja")) {
                if (checkList.contains("Spy") || checkList.contains("Recluse")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Shugenja requires Legion
            if (checkList.contains("Shugenja")) {
                if (checkList.contains("Legion")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Shugenja requires Marionette or Ogre
            if (checkList.contains("Shugenja")) {
                if (checkList.contains("Marionette") || checkList.contains("Ogre")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Shugenja")) {
                if (checkList.contains("Mezepheles") || checkList.contains("Summoner")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Vizier requires Scarlet Woman
            if (checkList.contains("Vizier")) {
                if (checkList.contains("Scarlet Woman")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Ojo requires at least 1 of {Spy, Recluse, Mayor}
            if (checkList.contains("Ojo")) {
                if (checkList.contains("Spy") || checkList.contains("Recluse") || checkList.contains("Mayor")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Ojo requires at least 1 of {Artist, Courtier, Engineer, Huntsman, Nightwatchman, Philosopher, Professor, Seamstress, Slayer, Golem, Puzzlemaster}
            if (checkList.contains("Ojo")) {
                if (checkList.contains("Artist") || checkList.contains("Courtier") || checkList.contains("Engineer") || checkList.contains("Huntsman") || checkList.contains("Nightwatchman") || checkList.contains("Philosopher") || checkList.contains("Professor") || checkList.contains("Seamstress") || checkList.contains("Slayer") || checkList.contains("Golem") || checkList.contains("Puzzlemaster")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //If Ojo and Oracle together, it requires at least 1 of {Assassin, Baron, Godfather, Marionette, Mezepheles, Spy}
            if (checkList.contains("Ojo")) {
                if (checkList.contains("Assassin") || checkList.contains("Baron") || checkList.contains("Godfather") || checkList.contains("Marionette") || checkList.contains("Mezepheles") || checkList.contains("Spy")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Ojo can not be with {Choirboy, Poppy Grower, Magician}
            if (checkList.contains("Ojo")) {
                if (checkList.contains("Choirboy") || checkList.contains("Poppy Grower") || checkList.contains("Magician")) {
                    continue;
                } else {
                    it_works = true;
                }
            }
            //Ojo requires Juggler
            if (checkList.contains("Ojo")) {
                if (checkList.contains("Juggler")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Ojo requires at least 1 of {Pixie, Mutant, Cerenovus, Village Idiot}
            if (checkList.contains("Ojo")) {
                if (checkList.contains("Pixie") || checkList.contains("Mutant") || checkList.contains("Cerenovus") || checkList.contains("Village Idiot")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Hatter requires at least 1 of {Athiest, Plague Doctor, Engineer, Pit-Hag, Barber}
            if (checkList.contains("Hatter")) {
                if (checkList.contains("Athiest") || checkList.contains("Plague Doctor") || checkList.contains("Engineer") || checkList.contains("Pit-Hag") || checkList.contains("Barber") ) {
                    it_works = true;
                } else {
                    continue;
                } 
            }
            //Hatter requires Alchemist
            if (checkList.contains("Hatter")) {
                if (checkList.contains("Alchemist")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //If Hatter and Vortox are together, it requires at least 1 of {Fang Gu, Imp, Legion, Lil' Monsta, Lleech, No Dashii, Ojo, Pukka, Vigormortis, Kazali}
            if (checkList.contains("Hatter") && checkList.contains("Vortox")) {
                if (checkList.contains("Fang Gu") || checkList.contains("Imp") || checkList.contains("Legion") || checkList.contains("Lil' Monsta") || checkList.contains("Lleech") || checkList.contains("No Dashii") || checkList.contains("Ojo") || checkList.contains("Pukka") || checkList.contains("Vigormortis")  || checkList.contains("Kazali")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Hatter requires at least 1 of {Fang Gu, Imp, Lil' Monsta}
            if (checkList.contains("Hatter")) {
                if (checkList.contains("Fang Gu") || checkList.contains("Imp") || checkList.contains("Lil' Monsta")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //If {Baron, Godfather, Balloonist, Lord Of Typhon} is not the there and at least 1 of {Vigormortis, Fang Gu} is, it requires at least 1 of the other or {Legion, Lil' Monsta}
            if (checkList.contains("Vigormortis") && !(checkList.contains("Baron") || checkList.contains("Godfather") || checkList.contains("Balloonist") || checkList.contains("Lord Of Typhon"))) {
                if (checkList.contains("Fang Gu") || checkList.contains("Legion") || checkList.contains("Lil' Monsta")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Fang Gu") && !(checkList.contains("Baron") || checkList.contains("Godfather") || checkList.contains("Balloonist") || checkList.contains("Lord Of Typhon"))) {
                if (checkList.contains("Vigormortis") || checkList.contains("Legion") || checkList.contains("Lil' Monsta")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Kazali needs at least 1 of {Fang Gu, Baron, Godfather, Ballonist, Vigormortis, Lord Of Typhon}
            if (checkList.contains("Kazali")) {
                if (checkList.contains("Fang Gu") || checkList.contains("Baron") || checkList.contains("Godfather") || checkList.contains("Balloonist") || checkList.contains("Vigormortis") || checkList.contains("Lord Of Typhon")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Kazali needs at least 1 of {Kazali, Hatter}
            if (checkList.contains("Kazali")) {
                if (checkList.contains("Barber") || checkList.contains("Hatter")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Kazali needs at least 1 of {Alchemist, Plague Doctor}
            if (checkList.contains("Kazali")) {
                if (checkList.contains("Alchemist") || checkList.contains("Plague Doctor")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Kazali needs at least 1 of {Chef, Clockmaker}
            if (checkList.contains("Kazali")) {
                if (checkList.contains("Chef") || checkList.contains("Clockmaker")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Kazali can't have {Poppy Grower, Magician}
            if (checkList.contains("Kazali")) {
                if (!(checkList.contains("Poppy Grower") || checkList.contains("Magician"))) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Village Idiot requires at least 1 of {Pixie, Cerenovus}
            if (checkList.contains("Village Idiot")) {
                if (checkList.contains("Pixie") || checkList.contains("Cerenovus")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Village Idiot requires at least 1 of {Legion, Riot}
            if (checkList.contains("Village Idiot")) {
                if (checkList.contains("Legion") || checkList.contains("Riot")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //If at least 2 of {Evil Twin, Snake Charmer, Snitch} is on it, it requires the 3rd
            if (checkList.contains("Evil Twin") && checkList.contains("Snake Charmer")) {
                if (checkList.contains("Snitch")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Snake Charmer") && checkList.contains("Snitch")) {
                if (checkList.contains("Evil Twin")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Snitch") && checkList.contains("Evil Twin")) {
                if (checkList.contains("Snake Charmer")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //If there's Lleech, then there has to be {Tinker, Scarlett Woman} and vice versa
            if (checkList.contains("Tinker") && checkList.contains("Scarlett Woman")) {
                if (checkList.contains("Lleech")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Lleech")) {
                if (checkList.contains("Tinker") && checkList.contains("Scarlett Woman")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Yaggababble requires at least 1 of {Shabaloth, Po, Ojo}
            if (checkList.contains("Yaggababble")) {
                if (checkList.contains("Shabaloth") || checkList.contains("Po") || checkList.contains("Ojo")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Yaggababble requires at least 1 of {Zombuul, Legion, Lil' Monsta}
            if (checkList.contains("Yaggababble")) {
                if (checkList.contains("Zombuul") || checkList.contains("Legion") || checkList.contains("Lil' Monsta") || checkList.contains("Mastermind")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Yaggababble requires at least 1 of {Harpy, Witch, Slayer}
            if (checkList.contains("Yaggababble")) {
                if (checkList.contains("Harpy") || checkList.contains("Witch") || checkList.contains("Slayer")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Yaggababble requires at least 1 of {Tinker, Acrobat}
            if (checkList.contains("Yaggababble")) {
                if (checkList.contains("Tinker") || checkList.contains("Acrobat")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Yaggababble requires both or neither of {{At least 1 of Golem and Tinker}, Scarlett Woman}
            if (checkList.contains("Yaggababble") || (checkList.contains("Golem") || checkList.contains("Tinker"))) {
                if (checkList.contains("Scarlett Woman")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            if (checkList.contains("Yaggababble") || checkList.contains("Scarlett Woman")) {
                if (checkList.contains("Golem") || checkList.contains("Tinker")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Yaggababble requires at least 1 of {Courtier, Fool, Exorcist, Minstrel, Sailor, Tea Lady) {
            if (checkList.contains("Yaggababble")) {
                if (checkList.contains("Courtier") || checkList.contains("Fool") || checkList.contains("Exorcist") || checkList.contains("Monk") || checkList.contains("Minstrel") || checkList.contains("Sailor") || checkList.contains("Tea Lady")) {
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Yaggababble requires at least 1 of {Gossip, Gamber, Gofather}
            if (checkList.contains("Yaggababble")) {
                if (checkList.contains("Gossip") || checkList.contains("Gambler") || checkList.contains("Godfather")) {
                    it_works = true; 
                } else {
                    continue;
                }
            }
            //Yaggababble requires Mezepheles
            if (checkList.contains("Yaggababble")) {
                if (checkList.contains("Mezepheles")) {
                    it_works = true; 
                } else {
                    continue;
                }
            }
            //Banshee or Zealot or Golem requires at least 1 of {Vortox, Mastermind, Evil Twin, Fearmonger, Saint, Goblin}
            if (checkList.contains("Banshee") || checkList.contains("Zealot") || checkList.contains("Golem")) {
                if (checkList.contains("Vortox") || checkList.contains("Mastermind") || checkList.contains("Evil Twin") || checkList.contains("Fearmonger") || checkList.contains("Saint") || checkList.contains("Goblin")) {
                    it_works = true; 
                } else {
                    continue;
                }
            }
            //If {Virgin, Golem, Banshee} require at least 1 of {Bounty Hunter[only if Virgin or Banshee], Summoner, Mezepheles, Fang Gu[only if there's Golem]}
            if (checkList.contains("Golem") || checkList.contains("Virgin") || checkList.contains("Banshee")) {
                if (checkList.contains("Fang Gu")) {
                    if (checkList.contains("Golem")) {
                        it_works = true;
                    } else {
                        continue;
                    }
                } else if (checkList.contains("Bounty Hunter")) {
                    if (checkList.contains("Virgin") || checkList.contains("Banshee")) {
                        it_works = true;
                    } else {
                        continue;
                    }
                } else if (checkList.contains("Summoner") || checkList.contains("Mezepheles")){
                    it_works = true;
                } else {
                    continue;
                }
            }
            //Ogre requires at least 1 of {Drunk, Marionette, Lunatic}
            if (checkList.contains("Ogre")) {
                if (checkList.contains("Drunk") || checkList.contains("Marionette") || checkList.contains("Lunatic")) {
                    it_works = true; 
                } else {
                    continue;
                }
            }
            //Ogre requires at least 1 of {Widow, Snitch, Magician, Poppy Grower, Damsel, King}
            if (checkList.contains("Ogre")) {
                if (checkList.contains("Widow") || checkList.contains("Snitch") || checkList.contains("Magician") || checkList.contains("Poppy Grower") || checkList.contains("Damsel") || checkList.contains("King")) {
                    it_works = true; 
                } else {
                    continue;
                }
            }
            //Alsaahir requires at least 1 of {Recluse, Spy}
            if (checkList.contains("Alsaahir")) {
                if (checkList.contains("Recluse") || checkList.contains("Spy")) {
                    it_works = true; 
                } else {
                    continue;
                }
            }
            //Alsaahir requires at least 1 of {Snake Charmer, Summoner, Barber, Hatter, Pit-Hag}
            if (checkList.contains("Alsaahir")) {
                if (checkList.contains("Snake Charmer") || checkList.contains("Summoner") || checkList.contains("Barber") || checkList.contains("Hatter") || checkList.contains("Pit-Hag")) {
                    it_works = true; 
                } else {
                    continue;
                }
            }
            //Alsaahir requires at least 1 of {Cannibal, Dreamer, Farmer, Grandmother, High Priestess, Knight, Librarian, Nightwatchman, Pixie, Ravenkeeper, Steward, Undertaker, Washerwoman, Marionette}
            if (checkList.contains("Alsaahir")) {
                if (checkList.contains("Cannibal") || checkList.contains("Dreamer") || checkList.contains("Farmer") || checkList.contains("Grandmother") || checkList.contains("High Priestess") || checkList.contains("Knight") || checkList.contains("Librarian") || checkList.contains("Nightwatchman") || checkList.contains("Pixie") || checkList.contains("Ravenkeeper") || checkList.contains("Steward") || checkList.contains("Undertaker") || checkList.contains("Washerwoman") || checkList.contains("Marionette")) {
                    it_works = true; 
                } else {
                    continue;
                }
            }
            //Alsaahir requires at least 1 of {Fang Gu, Imp, Lord Of Typhon, Lil' Monsta}
            if (checkList.contains("Alsaahir")) {
                if (checkList.contains("Fang Gu") || checkList.contains("Imp") || checkList.contains("Lord Of Typhon") || checkList.contains("Lil' Monsta")) {
                    it_works = true; 
                } else {
                    continue;
                }
            }
            // Lord Of Typhon requires Marionette
            if (checkList.contains("Lord Of Typhon")) {
                if (checkList.contains("Marionette")) {
                    it_works = true;
                } else {
                    continue;
                }

            }
            // Lord Of Typhon and Lil' Monsta requires Engineer
            if (checkList.contains("Lord Of Typhon") || checkList.contains("Lil' Monsta")) {
                if (checkList.contains("Engineer")) {
                    it_works = true;
                } else {
                    continue;
                }

            }
            // Lord Of Typhon requires Bounty Hunter
            if (checkList.contains("Lord Of Typhon")) {
                if (checkList.contains("Bounty Hunter")) {
                    it_works = true;
                } else {
                    continue;
                }

            }
            // If there's both Lord Of Typhon and Devil's Advocate, there must be a Tea Lady
            if (checkList.contains("Lord Of Typhon") && checkList.contains("Devil's Advocate")) {
                if (checkList.contains("Tea Lady")) {
                    it_works = true;
                } else {
                    continue;
                }

            }
            //If there's both Flowergirl and Organ Grinder, requires at least 1 of {Minstrel, Preacher}
            if (checkList.contains("Flowergirl") && checkList.contains("Organ Grinder")) {
                if (checkList.contains("Minstrel") || checkList.contains("Preacher")) {
                    it_works = true; 
                } else {
                    continue;
                }
            }
            //Chef requires at least 1 of {Legion(if there's also Vortox), Kazali, Marionette, Ogre, Lord Of Typhon}
            if (checkList.contains("Chef")) {
                if (checkList.contains("Legion") || checkList.contains("Kazali") || checkList.contains("Marionette") || checkList.contains("Ogre") || checkList.contains("Lord Of Typhon")) {
                    if (checkList.contains("Legion")){
                        if (checkList.contains("Vortox")) {
                            it_works = true;
                        } else {
                            continue;
                        }
                    }
                    if (checkList.contains("Kazali") || checkList.contains("Marionette") || checkList.contains("Ogre")) {
                        it_works = true; 
                    } else {
                        continue;
                    }
                }
            }
            //Heretic requires at least 1 of {Alsaahir, Damsel, Klutz, Evil Twin, Fearmonger, Goblin, Mastermind, Leviathan, Riot, Vortox}
            if ((checkList.contains("Heretic")) && (checkList.contains("Alsaahir") || (checkList.contains("Damsel") || checkList.contains("Klutz") || checkList.contains("Evil Twin") || checkList.contains("Fearmonger") || checkList.contains("Goblin") || checkList.contains("Mastermind") || checkList.contains("Leviathan") || checkList.contains("Riot") || checkList.contains("Vortox")))) {
                it_works = true;
            }
            //If there's Legion, at least 2 of {Bounty Hunter, Cult Leader, Goon, Mezepheles, Summoner}
            int GoodtoEvil = 0;
            if (checkList.contains("Legion")) {
                List<String> temp = checkList;
                String[] GoodtoEvils = {"Bounty Hunter", "Cult Leader", "Goon", "Mezepheles", "Summoner"};
                for(int j = 0; j < GoodtoEvils.length; j = j + 1){
                    if (temp.contains(GoodtoEvils[j])) {
                        GoodtoEvil = GoodtoEvil + 1;
                    }
                }
            
                if ((GoodtoEvil == 1) || (GoodtoEvil == 0)){
                    continue;
                }
            }
            //If there's at least 1 loud demon, there needs to be at least 2 quiet demons. Alternatively, 1 loud Demon with no quiet demons.
            int NonLoudDemon = 0;
            if ((checkList.contains("Al-Hadikhia") || checkList.contains("Legion") || checkList.contains("Leviathan") || checkList.contains("Riot")) && !(random == 1)) {
                List<String> temp = checkList;
                String[] NotLoudDemon = {"Fang Gu", "Imp", "Kazali", "Lil' Monsta", "Lleech", "Lord Of Typhon", "No Dashii", "Ojo", "Po", "Pukka", "Shabaloth", "Vigormortis", "Vortox", "Yaggababble", "Zombuul"};
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
        String[][] jinxcases = new String[][] {
        {"Alchemist", "Spy"},
        {"Alchemist", "Widow"},
        {"Al-Hadikhia", "Mastermind"},
        {"Alsaahir", "Vizier"},
        {"Banshee", "Leviathan"},
        {"Banshee", "Riot"},
        {"Banshee", "Vortox"},
        {"Baron", "Heretic"},
        {"Cannibal", "Butler"},
        {"Cannibal", "Juggler"},
        {"Cannibal", "Zealot"},
        {"Cerenovus", "Goblin"},
        {"Chambermaid", "Mathematician"},
        {"Engineer", "Legion"},
        {"Engineer", "Riot"},
        {"Fang Gu", "Scarlett Woman"},
        {"Godfather", "Heretic"},
        {"Hatter", "Legion"},
        {"Hatter", "Leviathan"},
        {"Hatter", "Lil’ Monsta"},
        {"Hatter", "Riot"},
        {"Kazali", "Bounty Hunter"},
        {"Kazali", "Choirboy"},
        {"Kazali", "Huntsman"},
        {"Kazali", "Goon"},
        {"Kazali", "Marionette"},
        {"Kazali", "Soldier"},
        {"Legion", "Minstrel"},
        {"Legion", "Preacher"},
        {"Legion", "Zealot"},
        {"Leviathan", "Farmer"},
        {"Leviathan", "Innkeeper"},
        {"Leviathan", "Mayor"},
        {"Leviathan", "Monk"},
        {"Leviathan", "Ravenkeeper"},
        {"Leviathan", "Sage"},
        {"Leviathan", "Soldier"},
        {"Lil' Monsta", "Magician"},
        {"Lil' Monsta", "Organ Grinder"},
        {"Lil' Monsta", "Poppy Grower"},
        {"Lil' Monsta", "Vizier"},
        {"Lleech", "Heretic"},
        {"Lleech", "Slayer"},
        {"Lunatic", "Mathematician"},
        {"Lycanthrope", "Gambler"},
        {"Magician", "Widow"},
        {"Magician", "Spy"},
        {"Marionette", "Balloonist"},
        {"Marionette", "Damsel"},
        {"Marionette", "Huntsman"},
        {"Marionette", "Lil' Monsta"},
        {"Marionette", "Poppy Grower"},
        {"Marionette", "Snitch"},
        {"Mastermind", "Lleech"},
        {"Organ Grinder", "Butler"},
        {"Organ Grinder", "Minstrel"},
        {"Organ Grinder", "Preacher"},
        {"Ogre", "Pit-Hag"},
        {"Ogre", "Recluse"},
        {"Ogre", "Spy"},
        {"Philosopher", "Bounty Hunter"},
        {"Pit-Hag", "Damsel"},
        {"Pit-Hag", "Heretic"},
        {"Pit-Hag", "Leviathan"},
        {"Pit-Hag", "Politician"},
        {"Pit-Hag", "Riot"},
        {"Poppy Grower", "Widow"},
        {"Poppy Grower", "Spy"},
        {"Plague Doctor", "Baron"},
        {"Plague Doctor", "Boomdandy"},
        {"Plague Doctor", "Evil Twin"},
        {"Plague Doctor", "Fearmonger"},
        {"Plague Doctor", "Goblin"},
        {"Plague Doctor", "Marionette"},
        {"Plague Doctor", "Scarlet Woman"},
        {"Plague Doctor", "Spy"},
        {"Riot", "Butler"},
        {"Riot", "Cannibal"},
        {"Riot", "Clockmaker"},
        {"Riot", "Damsel"},
        {"Riot", "Devil's Advocate"},
        {"Riot", "Exorcist"},
        {"Riot", "Farmer"},
        {"Riot", "Flowergirl"},
        {"Riot", "Golem"},
        {"Riot", "Grandmother"},
        {"Riot", "Innkeeper"},
        {"Riot", "Investigator"},
        {"Riot", "King"},
        {"Riot", "Mayor"},
        {"Riot", "Minstrel"},
        {"Riot", "Monk"},
        {"Riot", "Pacifist"},
        {"Riot", "Preacher"},
        {"Riot", "Ravenkeeper"},
        {"Riot", "Sage"},
        {"Riot", "Saint"},
        {"Riot", "Snitch"},
        {"Riot", "Soldier"},
        {"Riot", "Town Crier"},
        {"Riot", "Undertaker"},
        {"Riot", "Zealot"},
        {"Scarlett Woman", "Al-Hadikhia"},
        {"Scarlett Woman", "Lil' Monsta"},
        {"Spy", "Damsel"},
        {"Spy", "Heretic"},
        {"Summoner", "Alchemist"},
        {"Summoner", "Barber"},
        {"Summoner", "Clockmaker"},
        {"Summoner", "Courtier"},
        {"Summoner", "Engineer"},
        {"Summoner", "Goon"},
        {"Summoner", "Hatter"},
        {"Summoner", "Legion"},
        {"Summoner", "Marionette"},
        {"Summoner", "Kazali"},
        {"Summoner", "Lord Of Typhon"},
        {"Summoner", "Pit-Hag"},
        {"Summoner", "Preacher"},
        {"Summoner", "Pukka"},
        {"Summoner", "Summoner"},
        {"Summoner", "Kazali"},
        {"Summoner", "Riot"},
        {"Village Idiot", "Pit-Hag"},
        {"Vizier", "Alchemist"},
        {"Vizier", "Courtier"},
        {"Vizier", "Fearmonger"},
        {"Vizier", "Investigator"},
        {"Vizier", "Magician"},
        {"Vizier", "Politican"},
        {"Vizier", "Preacher"},
        {"Vizier", "Zealot"},
        {"Widow", "Damsel"},
        {"Widow", "Heretic"},
        {"Yaggababble", "Exorcist"}
        };

        return jinxcases;
    
    }
}
    

//A great thank you to Karah, Zoe, Pi, Chris W, gredelston, codetriangle, nyhilo, pokesvorlds, !Adrian, and Le Codex for helping me out with the code
