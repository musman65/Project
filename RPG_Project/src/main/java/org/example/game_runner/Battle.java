package org.example.game_runner;

import org.example.Player;
import org.example.enemy_and_sub.Enemy;
import org.example.human_and_sub.Human;
import org.example.items.Item;
import org.example.items.Potion;
import org.example.moves.Move;

import java.util.List;
import java.util.Scanner;

public class Battle {
    private Human human;
    private Enemy enemy;

    public Battle(Human human, Enemy enemy) {
        this.human = human;
        this.enemy = enemy;
    }

    public boolean BattleLoop() {
        Scanner in = new Scanner(System.in);

        while (human.isAlive() && enemy.isAlive()) {
            System.out.println("You are battling: " + enemy.toString());
            System.out.println("\nYour Health: " + human.getHealth());
            System.out.println("""
                    What do you want to do first?
                    \n\t1.) Attack
                    \n\t2.) Use Potion
                    """);
            int whatToDo = in.nextInt();

            while (whatToDo != 1 && whatToDo != 2) { // input verification
                System.out.println("""
                    What do you want to do first?
                    \n\t1.) Attack
                    \n\t2.) Use Potion
                    """);
                whatToDo = in.nextInt();
            }

            if (whatToDo == 1) {
                List<Move> moves = human.getMoves();
                System.out.println("What move do you want to use?");
                for (int i= 0; i < moves.size(); i++) {
                    System.out.println("\n" + (i + 1) + " " + moves.get(i));
                }
                human.doDamage(moves.get(in.nextInt() - 1), enemy);
            } else {
                List<Potion> potions = human.getInventory().stream()
                        .filter(item -> item instanceof Potion)
                        .map(item -> (Potion) item)
                        .toList();

                if (potions.isEmpty()) {
                    System.out.println("no potions remaining");
                    continue;
                }
                System.out.println("Which potion do you want to use?");
                for (int i = 0; i < potions.size(); i++) {
                    System.out.println((i + 1) + " " + potions.get(i).getName() + ": " + potions.get(i).getBuff() + "\n");
                }
                human.addHealth(potions.get(in.nextInt() - 1));
            }

            enemy.doDamage(enemy.chooseMove(human), human);
        }

        if (!enemy.isAlive()) {
            System.out.println("The enemy is dead!");
        } else {
            System.out.println("You died!");
        }

        return human.isAlive();
    }
}
