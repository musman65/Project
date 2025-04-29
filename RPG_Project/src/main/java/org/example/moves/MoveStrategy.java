package org.example.moves;

import org.example.enemy_and_sub.Enemy;
import org.example.human_and_sub.Human;

public interface MoveStrategy {
    Move selectMoveStrategy(Enemy enemy, Human human);
}
