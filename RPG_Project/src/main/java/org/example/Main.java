package org.example;

import org.example.enemy_and_sub.Goblin;
import org.example.enemy_and_sub.MutatedWolf;
import org.example.enemy_and_sub.Spectre;
import org.example.enemy_and_sub.ThePhantomKing;
import org.example.game_runner.Battle;
import org.example.human_and_sub.Human;
import org.example.human_and_sub.Warrior;
import org.example.human_and_sub.Wizard;
import org.example.levels.Level;
import org.example.moves.Move;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main { // Yeah, I took on way more than I could handle unfortunately...
    public static void main(String[] args) {
        //ALL MOVE INITIALIZATIONS. Yes, I know this is an awful way of doing things. I also don't know how else to do it so forgive me
        //todo: |||||||||||||
        List<Move> wizardMoves = new ArrayList<>();
        //DAMAGE
        wizardMoves.add(new Move("Fireball", Move.Type.Ghost, 10, Move.Effect.Damage, Move.Status.Burn));
        wizardMoves.add(new Move("Vine Slap", Move.Type.Ghost, 15, Move.Effect.Damage, Move.Status.None));
        wizardMoves.add(new Move("Mana Strike", Move.Type.Ghost, 5, Move.Effect.Damage, Move.Status.Hypnotize));
        wizardMoves.add(new Move("Frost Shard", Move.Type.Ghost, 10, Move.Effect.Damage, Move.Status.Stun));
        //HEAL
        wizardMoves.add(new Move("Heal", Move.Type.Physical, 50, Move.Effect.Heal, Move.Status.None));
        //STATUS
        wizardMoves.add(new Move("Regen", Move.Type.Ghost, 0, Move.Effect.Status, Move.Status.Regen));
        //todo: |||||||||||||
        List<Move> warriorMoves = new ArrayList<>();
        //DAMAGE
        warriorMoves.add(new Move("Slash", Move.Type.Physical, 20, Move.Effect.Damage, Move.Status.None));
        warriorMoves.add(new Move("Stab", Move.Type.Physical, 15, Move.Effect.Damage, Move.Status.None));
        warriorMoves.add(new Move("Strike", Move.Type.Physical, 2, Move.Effect.Damage, Move.Status.Hypnotize));
        warriorMoves.add(new Move("Pommel", Move.Type.Physical, 5, Move.Effect.Damage, Move.Status.Stun));
        //HEAL
        warriorMoves.add(new Move("Heal", Move.Type.Physical, 50, Move.Effect.Heal, Move.Status.None));
        //STATUS
        warriorMoves.add(new Move("Regen", Move.Type.Ghost, 0, Move.Effect.Status, Move.Status.Regen));
        //todo: |||||||||||||
        List<Move> kingMoves = new ArrayList<>();
        // DAMAGE
        kingMoves.add(new Move("Shadow Slice", Move.Type.Ghost, 35, Move.Effect.Damage, Move.Status.None));
        kingMoves.add(new Move("Soul Lash", Move.Type.Ghost, 30, Move.Effect.Damage, Move.Status.Hypnotize));
        kingMoves.add(new Move("Spectral Thrust", Move.Type.Ghost, 25, Move.Effect.Damage, Move.Status.Stun));
        kingMoves.add(new Move("Grave Rend", Move.Type.Physical, 40, Move.Effect.Damage, Move.Status.ArmorBreak));
        // HEAL
        kingMoves.add(new Move("Phantom Recovery", Move.Type.Ghost, 50, Move.Effect.Heal, Move.Status.None));
        kingMoves.add(new Move("Soul Feast", Move.Type.Ghost, 30, Move.Effect.Heal, Move.Status.None));
        // STATUS
        kingMoves.add(new Move("Dread Aura", Move.Type.Ghost, 0, Move.Effect.Status, Move.Status.Spook));
        kingMoves.add(new Move("Royal Will", Move.Type.Ghost, 0, Move.Effect.Status, Move.Status.ArmorUp));
        //todo: /////////////////
        List<Move> wolfMoves = new ArrayList<>();
        // DAMAGE
        wolfMoves.add(new Move("Fang Tear", Move.Type.Physical, 25, Move.Effect.Damage, Move.Status.Burn));
        wolfMoves.add(new Move("Razor Swipe", Move.Type.Physical, 30, Move.Effect.Damage, Move.Status.None));
        wolfMoves.add(new Move("Savage Pounce", Move.Type.Physical, 20, Move.Effect.Damage, Move.Status.Stun));
        wolfMoves.add(new Move("Lunging Maul", Move.Type.Physical, 35, Move.Effect.Damage, Move.Status.None));
        // HEAL
        wolfMoves.add(new Move("Blood Heal", Move.Type.Physical, 40, Move.Effect.Heal, Move.Status.None));
        wolfMoves.add(new Move("Feast Flesh", Move.Type.Physical, 25, Move.Effect.Heal, Move.Status.None));
        // STATUS
        wolfMoves.add(new Move("Feral Howl", Move.Type.Ghost, 0, Move.Effect.Status, Move.Status.DamageBuff));
        wolfMoves.add(new Move("Resilient Hide", Move.Type.Ghost, 0, Move.Effect.Status, Move.Status.Regen));
        //todo: /////////////////
        List<Move> goblinMoves = new ArrayList<>();
        // DAMAGE
        goblinMoves.add(new Move("Sneaky Stab", Move.Type.Physical, 15, Move.Effect.Damage, Move.Status.Hypnotize));
        goblinMoves.add(new Move("Head Bonk", Move.Type.Physical, 20, Move.Effect.Damage, Move.Status.Stun));
        goblinMoves.add(new Move("Wild Jab", Move.Type.Physical, 10, Move.Effect.Damage, Move.Status.None));
        goblinMoves.add(new Move("Gremlin Slash", Move.Type.Physical, 25, Move.Effect.Damage, Move.Status.ArmorBreak));
        // HEAL
        goblinMoves.add(new Move("Goblin Brew", Move.Type.Physical, 30, Move.Effect.Heal, Move.Status.None));
        goblinMoves.add(new Move("Mystery Elixir", Move.Type.Physical, 15, Move.Effect.Heal, Move.Status.None));
        // STATUS
        goblinMoves.add(new Move("Laughing Curse", Move.Type.Ghost, 0, Move.Effect.Status, Move.Status.Sleep));
        goblinMoves.add(new Move("Itchy Bomb", Move.Type.Physical, 0, Move.Effect.Status, Move.Status.Burn));
        //todo: /////////////////
        List<Move> spectreMoves = new ArrayList<>();
        // DAMAGE
        spectreMoves.add(new Move("Haunting Touch", Move.Type.Ghost, 30, Move.Effect.Damage, Move.Status.Sleep));
        spectreMoves.add(new Move("Void Claw", Move.Type.Ghost, 25, Move.Effect.Damage, Move.Status.None));
        spectreMoves.add(new Move("Eclipse Screech", Move.Type.Ghost, 20, Move.Effect.Damage, Move.Status.Hypnotize));
        spectreMoves.add(new Move("Chilling Wail", Move.Type.Ghost, 35, Move.Effect.Damage, Move.Status.None));
        // HEAL
        spectreMoves.add(new Move("Soul Mend", Move.Type.Ghost, 40, Move.Effect.Heal, Move.Status.None));
        spectreMoves.add(new Move("Ghastly Renewal", Move.Type.Ghost, 20, Move.Effect.Heal, Move.Status.None));
        // STATUS
        spectreMoves.add(new Move("Phantom Veil", Move.Type.Ghost, 0, Move.Effect.Status, Move.Status.ArmorUp));
        spectreMoves.add(new Move("Ethereal Curse", Move.Type.Ghost, 0, Move.Effect.Status, Move.Status.Burn));

        Scanner in = new Scanner(System.in);

        System.out.println("What is your name? or do you want to import? (123 for import)");
        String name = in.next();

        if (name.equals("123")) {

        }

        System.out.println("""
                What class do you want to be?
                1.)Wizard
                2.)Warrior""");

        int classPick = in.nextInt();

        while (classPick != 1 && classPick != 2) { // input verification
            System.out.println("""
                What class do you want to be?
                1.)Wizard
                2.)Warrior""");
            classPick = in.nextInt();
        }

        List<List<Move>> moveSets = new ArrayList<>();
        moveSets.add(goblinMoves);
        moveSets.add(wolfMoves);
        moveSets.add(spectreMoves);
        moveSets.add(kingMoves);

        if (classPick == 1) {
            Wizard user = new Wizard(name, wizardMoves);
            battleStart(user, moveSets);
        } else {
            Warrior user = new Warrior(name, warriorMoves);
            battleStart(user, moveSets);
        }
    }


    /**
     * Starts the battle throughout every level
     * @param user the user playing the game
     * @param moveSets the move sets of every enemy
     */
    public static void battleStart(Human user, List<List<Move>> moveSets) {
        Scanner in = new Scanner(System.in);
        Level<Goblin> l1 = new Level<>("Goblin Level", 1);
        l1.initializeLevel(new Goblin("Goblin", 150, 150, new HashMap<>(), moveSets.get(0)));
        Level<Spectre> l2 = new Level<>("Spectre Level", 2);
        l2.initializeLevel(new Spectre("Spectre", 150, 150, new HashMap<>(), moveSets.get(2)));
        Level<MutatedWolf> l3 = new Level<>("Wolf Level", 1);
        l3.initializeLevel(new MutatedWolf("Wolf", 150, 150, new HashMap<>(), moveSets.get(1)));
        Level<ThePhantomKing> l4 = new Level<>("Boss Room", 2);
        l4.initializeLevel(new ThePhantomKing("The Phantom King", 200, 200, new HashMap<>(), moveSets.get(3)));

        for (int i = 0; i < l1.getEnemyList().size(); i++) {
            Battle battle = new Battle(user, l1.getEnemyList().get(i));
            boolean dead = battle.BattleLoop();
            if (!dead) {
                break;
            }
            user.setHealth(user.getMaxHealth());
        }

        if (!user.isAlive()) {
            System.out.println("Game over");
            return;
        }

        System.out.println("Do you want to save before y//n");
        String yesOrNO1 = in.next();

        if (yesOrNO1.equals("y")) {
            String str = user.easyExportHuman();
            File f = new File("src/main/resources/saves");
            try (FileWriter fw = new FileWriter(f)) {
                fw.write(str);
            } catch (IOException e) {
                System.out.println("ERROR");
            }
        }else { // considered as no
            System.out.println("Ok");
        }

        for (int i = 0; i < l2.getEnemyList().size(); i++) {
            Battle battle = new Battle(user, l2.getEnemyList().get(i));
            boolean dead = battle.BattleLoop();
            if (!dead) {
                break;
            }
            user.setHealth(user.getMaxHealth());
        }

        if (!user.isAlive()) {
            System.out.println("Game over");
            return;
        }

        System.out.println("Do you want to save before y//n");
        String yesOrNO2 = in.next();

        if (yesOrNO2.equals("y")) {
            String str = user.easyExportHuman();
            File f = new File("src/main/resources/saves");
            try (FileWriter fw = new FileWriter(f)) {
                fw.write(str);
            } catch (IOException e) {
                System.out.println("ERROR");
            }
        }else { // considered as no
            System.out.println("Ok");
        }

        for (int i = 0; i < l3.getEnemyList().size(); i++) {
            Battle battle = new Battle(user, l3.getEnemyList().get(i));
            boolean dead = battle.BattleLoop();
            if (!dead) {
                break;
            }
            user.setHealth(user.getMaxHealth());
        }

        if (!user.isAlive()) {
            System.out.println("Game over");
            return;
        }

        System.out.println("Do you want to save before y//n");
        String yesOrNO3 = in.next();

        if (yesOrNO3.equals("y")) {
            String str = user.easyExportHuman();
            File f = new File("src/main/resources/saves");
            try (FileWriter fw = new FileWriter(f)) {
                fw.write(str);
            } catch (IOException e) {
                System.out.println("ERROR");
            }
        }else { // considered as no
            System.out.println("Ok");
        }

        for (int i = 0; i < l4.getEnemyList().size(); i++) {
            Battle battle = new Battle(user, l4.getEnemyList().get(i));
            boolean dead = battle.BattleLoop();
            if (!dead) {
                break;
            }
            user.setHealth(user.getMaxHealth());
        }

        System.out.println("Hooray you win");
    }
}