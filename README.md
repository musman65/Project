## **Project Scenario:**

My project operates in a video game. It runs a turn based video game and lets the user play in the output displaying all the information needed.

---

## **Design Paradigm:**

- Turn by turn based style  
- Different types of enemies, all with unique abilities and weaknesses  
- Different classes for the player to chose  
- Items  
  - Weapons  
  - Potions

---

## **Expected Results:**

When the application is running the user can:

- Make a player and select a class  
  - Wizard  
  - Warrior  
- View their stats and their available moves  
- Battle opponents such (e.g. Goblin, Spectre)  
  - The battle is turn based  
    - The player choses a move each round  
    - The enemy answers with a move based its strategy  
- After each turn, the output displays:  
  - What moves were used  
  - The health points remaining of both combatants  
- The battle is won or lost when either the player or the enemy reaches 0 health points

---

## **Hierarchies:**

There are two super classes at the top and one regular class: *(Italics : abstract class)*

- **Player** class  
  - *Human* class  
    - Warrior class  
    - Wizard class  
  - *Enemy* class  
    - Goblin class  
    - Spectre class  
    - Mutated Wolf class  
    - Ghost Knight  
- **Item** class  
  - Weapon class  
  - Potion class  
  - Armor class  
- **Move** class
