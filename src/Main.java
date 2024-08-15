import java.util.Random;
import java.util.Scanner;

public class Main extends Enemies {

    static int progress = 0;
    Enemies enemy;

    Enemies player;


    public Main(int hp, int dmg, int dfs, int speed, Equipment armor, Equipment weapon, int race) {
        super(hp, dmg, dfs, speed, armor, weapon, race);
    }


    public static void main(String[] args) {
        //the player is a type of enemy, that can be only a human, ghoul or mutant, their starting hp, gear etc. is fixed, but they can get the weapon of the enemy or the armor
        String[] enemyRace = {"human", "ghoul", "mutant", "deathclaw", "dragon"};
        Equipment playerArmor;
        Equipment playerWeapon;

        Main newMainInstance = new Main(0, 0, 0, 0, null, null, 0);
        Enemies newEnemy = newMainInstance.makeAnEnemy();


        System.out.println("Welcome to this game, please choose your race\nA, Human (HP:25 ATK:10 DFS:10 SPD:25)\nB, Ghoul (HP:15, ATK:10, DFS:20, SPD:35)\nC, Mutant (HP:35, ATK:25, DFS:5,SPD:20)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Enemies newPlayer = newMainInstance.CharacterCreator(input);


        int type = newEnemy.getRace();
        if (type <= 3) {
            System.out.println("Your enemy is a " + enemyRace[newEnemy.getRace() - 1] + " that has " + newEnemy.getHp() + "HP, their weapon is " + newEnemy.getWeapon().getName() + " their armor is " + newEnemy.getArmor().getName());
        } else {
            System.out.println("Your enemy is a " + enemyRace[newEnemy.getRace() - 1] + " that has " + newEnemy.getHp() + "HP");
        }
        boolean isGameover = newMainInstance.fight(newPlayer, newEnemy);
        if (isGameover) {
            System.out.println("game over");
        } else {
            System.out.println("You won, do you want to take their weapon or armor?\nA,Take Both\nB,Take the weapon\nC,Take the armor\nD,Take nothing");
            input = sc.nextLine();
            if (input.equalsIgnoreCase("a")) {
                if ((newPlayer.getRace() > 2 && newEnemy.getArmor().getName().contains("mutant")) || (newPlayer.getRace() == 3 && !newEnemy.getArmor().getName().contains("mutant"))) {
                    newPlayer.setWeapon(newEnemy.getWeapon());
                    System.out.println("You could not pick up the armor since it does not fit you, but you got the dead foe's " + newEnemy.getWeapon().getName());

                } else {
                    newPlayer.setArmor(newEnemy.getArmor());
                    newPlayer.getArmor().setCND(newEnemy.getArmor().getCND());
                    newPlayer.setWeapon(newEnemy.getWeapon());
                    System.out.println("You obtained a " + newPlayer.getWeapon().getName() + " and a" + newPlayer.getArmor().getName());
                }
            } else if (input.equalsIgnoreCase("b")) {
                newPlayer.setWeapon(newEnemy.getWeapon());
            } else if (input.equalsIgnoreCase("c")) {
                if ((newPlayer.getRace() > 2 && newEnemy.getArmor().getName().contains("mutant")) || (newPlayer.getRace() == 3 && !newEnemy.getArmor().getName().contains("mutant"))) {
                    System.out.println("You could not pick up the armor since it does not fit you");
                }
                newPlayer.setArmor(newEnemy.getArmor());
                newPlayer.getArmor().setCND(newEnemy.getArmor().getCND());
            }

        }
        progress++;
        while (!isGameover && progress >= 1) {
            if (progress >= 10) {
                Random rnd = new Random();
                boolean lucky = false;
                int number = rnd.nextInt((100 + 1) - 1) + 1;
                if (number >= 74) {
                    lucky = true;
                    System.out.println("Random event");
                } else {
                    System.out.println("nop");
                }
                newMainInstance.lootBox(lucky);
            }
            System.out.println("Your " + enemyRace[newPlayer.getRace() - 1] + " now has a " + newPlayer.getWeapon().getName() + " and their armor is a " + newPlayer.getArmor().getName());
            newEnemy = newMainInstance.makeAnEnemy();
            type = newEnemy.getRace();
            if (type <= 3) {
                System.out.println("Your enemy is a " + enemyRace[newEnemy.getRace() - 1] + " that has " + newEnemy.getHp() + "HP, their weapon is " + newEnemy.getWeapon().getName() + " their armor is " + newEnemy.getArmor().getName());
            } else {
                System.out.println("Your enemy is a " + enemyRace[newEnemy.getRace() - 1] + " that has " + newEnemy.getHp() + "HP");
            }
            System.out.println("Do you wish to fight this enemy? Y/N");
            {
                input = sc.nextLine();
                if (input.equalsIgnoreCase("Y")) {
                    isGameover = newMainInstance.fight(newPlayer, newEnemy);
                    if (isGameover) {
                        System.out.println("game over, you survived " + progress + " rounds");
                    } else {
                        System.out.println("You won, do you want to take their weapon or armor?\nA,Take Both\nB,Take the weapon\nC,Take the armor\nD,Take nothing");
                        input = sc.nextLine();
                        if (input.equalsIgnoreCase("a")) {
                            if ((newPlayer.getRace() > 2 && newEnemy.getArmor().getName().contains("mutant")) || (newPlayer.getRace() == 3 && !newEnemy.getArmor().getName().contains("mutant"))) {
                                newPlayer.setWeapon(newEnemy.getWeapon());
                                System.out.println("You could not pick up the armor since it does not fit you, but you got the dead foe's " + newEnemy.getWeapon().getName());

                            } else {
                                newPlayer.setArmor(newEnemy.getArmor());
                                newPlayer.getArmor().setCND(newEnemy.getArmor().getCND());
                                newPlayer.setWeapon(newEnemy.getWeapon());
                                System.out.println("You obtained a " + newPlayer.getWeapon().getName() + " and a " + newPlayer.getArmor().getName());
                            }
                        } else if (input.equalsIgnoreCase("b")) {
                            newPlayer.setWeapon(newEnemy.getWeapon());
                        } else if (input.equalsIgnoreCase("c")) {
                            if ((newPlayer.getRace() > 2 && newEnemy.getArmor().getName().contains("mutant")) || (newPlayer.getRace() == 3 && !newEnemy.getArmor().getName().contains("mutant"))) {
                                System.out.println("You could not pick up the armor since it does not fit you");
                            }
                            newPlayer.setArmor(newEnemy.getArmor());
                            newPlayer.getArmor().setCND(newEnemy.getArmor().getCND());
                        }

                    }
                    progress++;
                } else {
                    progress++;
                }
            }
        }
    }

    public Equipment playerWeapon(int type) {
        Equipment playerWeapon = new Equipment();
        if (type == 1 || type == 2) {
            System.out.println("Choose your weapon");
            System.out.println("Your options are \nA, a pipe\nB, a pistol");
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("A") || input.contains("pipe")) {
                playerWeapon.setSpeed(85);
                playerWeapon.setDMG(5);
                playerWeapon.setName("Pipe");
            } else {
                playerWeapon.setSpeed(75);
                playerWeapon.setDMG(15);
                playerWeapon.setName("Pistol");

            }

        } else {
            System.out.println("You will get a pipe, and you have to defeat an enemy to get their weapon");
            playerWeapon.setSpeed(85);
            playerWeapon.setDMG(5);
            playerWeapon.setName("Pipe");
        }
        return playerWeapon;
    }

    public Enemies CharacterCreator(String input) {
        int playerHp = 0;
        int playerDMG = 0;
        int playerDFS = 0;
        int playerSpeed = 0;
        Equipment playerArmor;
        Equipment playerWpn;
        int type = 0;
        if (input.equalsIgnoreCase("A") || input.equalsIgnoreCase("Human")) {
            playerHp = 25;
            playerDMG = 10;
            playerDFS = 10;
            playerSpeed = 25;
            type = 1;
        } else if (input.equalsIgnoreCase("B") || input.equalsIgnoreCase("Ghoul")) {
            playerHp = 15;
            playerDMG = 10;
            playerDFS = 20;
            playerSpeed = 35;
            type = 2;
        } else if (input.equalsIgnoreCase("C") || input.equalsIgnoreCase("Mutant")) {
            playerHp = 35;
            playerDMG = 25;
            playerDFS = 5;
            playerSpeed = 20;
            type = 3;
        }
        playerWpn = playerWeapon(type);
        playerArmor = makePlayerArmor(type);
        player = new Enemies(playerHp, playerDMG, playerDFS, playerSpeed, playerArmor, playerWpn, type);
        return player;
    }

    private Equipment makePlayerArmor(int type) {
        Equipment playerArmor = new Equipment();
        if (type == 1 || type == 2) {
            playerArmor.setCND(30);
            playerArmor.setDT(25);
            playerArmor.setSpeed(85);
            playerArmor.setName("LeatherArmor");
        } else {
            playerArmor.setCND(100);
            playerArmor.setDT(0);
            playerArmor.setSpeed(100);
            playerArmor.setName("none");
        }
        return playerArmor;
    }

    public Enemies makeAnEnemy() {
        int enemyHp = 0;
        int enemyDMG = 0;
        int enemyDFS = 0;
        int enemySpeed = 0;
        int type;

        Equipment enemyArmor;
        Equipment enemyWeapon;
        Random random = new Random();
        if (progress <= 20) {

            type = random.nextInt(3 - 1) + 1;
        } else {

            type = random.nextInt(6 - 1) + 1;
        }
        if (type == 1) {
            enemyHp = random.nextInt(26 - 10) + 10;
            enemyDMG = 10;
            enemyDFS = 10;
            enemySpeed = 25;

        } else if (type == 2) {
            enemyHp = random.nextInt(16 - 10) + 10;
            enemyDMG = 10;
            enemyDFS = 15;
            enemySpeed = 35;
        } else if (type == 3) {
            enemyHp = random.nextInt(36 - 26) + 10;
            enemyDMG = 25;
            enemyDFS = 5;
            enemySpeed = 20;
        } else if (type == 4) {
            enemyHp = random.nextInt(65 - 35) + 35;
            enemyDMG = 50;
            enemyDFS = 25;
            enemySpeed = 35;
        } else if (type == 5) {
            enemyHp = random.nextInt(85 - 55) + 55;
            enemyDMG = 50;
            enemyDFS = 40;
            enemySpeed = 40;
        }


        enemyArmor = makeAnArmor(type, progress);
        enemyWeapon = makeAWeapon(type, progress);

        enemy = new Enemies(enemyHp, enemyDMG, enemyDFS, enemySpeed, enemyArmor, enemyWeapon, type);
        return enemy;
    }


    protected Equipment makeAWeapon(int type, int progress) {
        Equipment enemyWeapon = new Equipment();
        int weaponName = 0;
        String[] name = {"Pistol", "MachineGun", "Pipe", "PlasmaRifle", "GatlingGun", "FatMan"};
        Random rnd = new Random();

        if (type == 1 || type == 2) {
            if (progress < 10 || progress == 0) {
                int tmp = rnd.nextInt(100 - 1) + 1;
                if (tmp >= 50) {
                    weaponName = 1;
                } else if (tmp < 50) {
                    weaponName = 3;
                }
            } else if (progress >= 10) {
                weaponName = rnd.nextInt(5 - 1) + 1;
            }
        } else if (type == 3) {
            if (progress < 10) {
                weaponName = 3;
            } else {
                int tmp = rnd.nextInt(100 - 1) + 1;
                if (tmp <= 33) {
                    weaponName = 4;
                } else if (33 < tmp && tmp <= 66) {
                    weaponName = 5;
                } else {
                    weaponName = 6;
                }
            }
        } else {
            enemyWeapon.setName("none");
            enemyWeapon.setSpeed(100);
            enemyWeapon.setDMG(50);
        }
        switch (weaponName) {
            case 1:
                enemyWeapon.setName(name[0]);
                enemyWeapon.setSpeed(75);
                enemyWeapon.setDMG(15);
                break;
            case 2:
                enemyWeapon.setName(name[1]);
                enemyWeapon.setSpeed(85);
                enemyWeapon.setDMG(10);
                break;
            case 3:
                enemyWeapon.setName(name[2]);
                enemyWeapon.setSpeed(85);
                enemyWeapon.setDMG(5);
            case 4:
                enemyWeapon.setName(name[3]);
                enemyWeapon.setSpeed(45);
                enemyWeapon.setDMG(30);
                break;
            case 5:
                enemyWeapon.setName(name[4]);
                enemyWeapon.setSpeed(95);
                enemyWeapon.setDMG(5);
                break;
            case 6:
                enemyWeapon.setName(name[5]);
                enemyWeapon.setSpeed(40);
                enemyWeapon.setDMG(60);
                break;

        }
        if (progress < 10 && enemyWeapon.getName().equalsIgnoreCase("plasmarifle")) {
            enemyWeapon.setName(name[2]);
            enemyWeapon.setSpeed(85);
            enemyWeapon.setDMG(5);
        }

        return enemyWeapon;
    }

    protected Equipment makeAnArmor(int type, int progress) {
        Equipment enemyArmor = new Equipment();
        int armorName = 0;
        String[] name = {"LeatherArmor", "MetalArmor", "CombatArmor", "HeavyCombatArmor", "MutantArmor", "HeavyMutantArmor"};
        Random rnd = new Random();
        if (type == 1 || type == 2) {

            if (progress <= 10) {
                armorName = rnd.nextInt(3 - 1) + 1;
            } else {
                armorName = rnd.nextInt(5 - 1) + 1;
            }
        } else if (type == 3) {

            armorName = rnd.nextInt(7 - 5) + 1;
        } else {
            enemyArmor.setCND(45);
            enemyArmor.setDT(0);
            enemyArmor.setSpeed(100);
            enemyArmor.setName("none");
        }
        if (armorName == 1) {
            enemyArmor.setCND(30);
            enemyArmor.setDT(25);
            enemyArmor.setSpeed(85);
            enemyArmor.setName(name[0]);
        } else if (armorName == 2) {
            enemyArmor.setCND(35);
            enemyArmor.setDT(35);
            enemyArmor.setSpeed(65);
            enemyArmor.setName(name[1]);
        } else if (armorName == 3) {
            enemyArmor.setCND(30);
            enemyArmor.setDT(45);
            enemyArmor.setSpeed(70);
            enemyArmor.setName(name[2]);
        } else if (armorName == 4) {
            enemyArmor.setCND(45);
            enemyArmor.setDT(60);
            enemyArmor.setSpeed(60);
            enemyArmor.setName(name[3]);
        } else if (armorName == 5) {
            enemyArmor.setCND(50);
            enemyArmor.setDT(45);
            enemyArmor.setSpeed(60);
            enemyArmor.setName(name[4]);
        } else if (armorName == 6) {
            enemyArmor.setCND(55);
            enemyArmor.setDT(75);
            enemyArmor.setSpeed(50);
            enemyArmor.setName(name[5]);

        }

        return enemyArmor;
    }

    protected boolean fight(Enemies player, Enemies op) {
        // 0 if the player wins, 1 if the enemy wins
        /* if a player attacks then if his attack (with his weapon) is smaller than the armor of the enemy then the armor's cnd will drop
        (it is a percentage, so it defines how sure is it to absorb the attack)
        if the attackers speed is higher than the defenders he will gain the spd difference as an attack modifier
        if the defenders speed is higher it will lower the attack dmg of the attacker

        */
        boolean result = false;
        int round = 1;
        Random rnd = new Random();
        double playerHp = player.getHp();
        double enemyHp = op.getHp();
        double playerArmorCND = player.getArmor().getCND();
        double enemyArmorCND = op.getArmor().getCND();
        double playerAttackSpeed = player.getSpeed() * ((double) player.getArmor().getSpeed() / 100) + player.getSpeed() * (1 + (double) player.getWeapon().getSpeed() / 100);
        double enemyAttackSpeed = op.getSpeed() * ((double) op.getArmor().getSpeed() / 100) + op.getSpeed() * (1 + (double) op.getWeapon().getSpeed() / 100);

        int playerArmorDFS = player.getArmor().getDT() + player.getDfs();
        int enemyArmorDFS = op.getArmor().getDT() + op.getDfs();
        double playerAttackOG;
        boolean done = false;

        if (playerAttackSpeed < enemyAttackSpeed) {
            round = 2;
        }

        while (playerHp > 0 && enemyHp > 0) {
            double ogAtk = 0;
            if (round % 2 == 1) {
                // Player's turn
                Random crit = new Random();
                int critmodifier;

                critmodifier = crit.nextInt(100 - 1) + 1;
                if (critmodifier <= 24) {
                    playerAttackOG = (int) Math.round(calculateDamage(player, op, rnd, true) * 1.3);
                    System.out.println("Critical hit!");
                } else {
                    playerAttackOG = calculateDamage(player, op, rnd, true) * ((playerAttackSpeed / 2000) + 1.0);
                }
                int playerAttack = Math.toIntExact(Math.round(playerAttackOG));
                //System.out.println("DEBUG: PLAYER DMG: " + playerAttack + "  " + playerAttackOG);
                if (enemyArmorCND > 0) {
                    if (playerAttack < enemyArmorDFS || playerAttack == enemyArmorDFS) {
                        // Player attack is less than or equal to armor defense
                        enemyArmorCND -= (double) playerAttack ;
                        if (enemyArmorCND <= 0) {
                            enemyHp-=playerAttack;
                            enemyArmorCND = 0;
                            //System.out.println("pa");
                        } else if (enemyArmorCND > 0) {

                            playerAttack = 0; // No damage to HP if armor is not breached
                            System.out.println("\nYou did not breach the enemy's armor, so no DMG for you, however their armor's CND is lowered :/ \n");


                             //System.out.println("pb");
                        }
                    } else {
                        // Player attack is greater than armor defense
                        enemyArmorCND = 0;
                        int res = playerAttack - enemyArmorDFS;

                         //System.out.println("pc");
                        System.out.println(res);
                        enemyHp = enemyHp - res;
                        done = true;
                    }
                }

                // Apply remaining player attack to enemy HP
                else if (playerAttack > 0 && (!done || enemyArmorCND == 0)) {
                    enemyHp -= playerAttack;
                      //System.out.println("pe");
                }


                double biggerNumber = Math.max(playerAttack, ogAtk);
                System.out.println("Player attacks for " + biggerNumber + " damage. Enemy HP: " + enemyHp + " Enemy armor CND: " + enemyArmorCND + " Enemy's DFS: " + enemyArmorDFS);
            } else {
                // Enemy's turn
                double enemyAttackOG = calculateDamage(op, player, rnd, false) * ((enemyAttackSpeed / 2000) + 1.0);
                int enemyAttack = Math.toIntExact(Math.round(enemyAttackOG));
                //System.out.println("DEBUG: ENEMY DMG: " + enemyAttack + " " + enemyAttackOG);
                if (playerArmorCND > 0) {
                    if (enemyAttack < playerArmorDFS || enemyAttack == playerArmorDFS) {
                        // Enemy attack is less than or equal to player's armor defense
                        playerArmorCND -= (double) enemyAttack ;
                        if (playerArmorCND <= 0) {
                            playerArmorCND = 0;
                            playerHp-=enemyAttack;
                            //System.out.println("ea");

                        } else if (playerArmorCND > 0) {

                            enemyAttack = 0; // No damage to HP if armor is not breached
                            System.out.println("\nThe enemy did not damage you, since they could not penetrate your armor.\n");

                           // System.out.println("eb");
                        }
                    } else {
                        // Enemy attack is greater than armor defense
                        playerArmorCND = 0;
                        int res = enemyAttack - playerArmorDFS;
                        playerHp = playerHp - res;
                       // System.out.println("ec");
                        done = true;
                    }
                }

                // Apply remaining enemy attack to player HP
                else if (enemyAttack > 0 && (!done || enemyArmorCND == 0)) {
                    playerHp -= enemyAttack;
                    //System.out.println("ee");
                }
                double biggerNumber = Math.max(enemyAttack, ogAtk);
                System.out.println("Enemy attacks for " + biggerNumber + " damage. Player HP: " + playerHp + ", armor CND is " + playerArmorCND + " and your DFS is: " + playerArmorDFS);


            }

            round++;


        }
        if (playerHp <= 0 && enemyHp > 0) {
            result = true;
        } else if (enemyHp <= 0 && playerHp > 0) {
            result = false;
        }
        return result;
    }

    private int calculateDamage(Enemies attacker, Enemies defender, Random rnd, boolean isPlayer) {
        int basedmg = attacker.getDmg() + attacker.getWeapon().getDMG();
        int randomnumber = rnd.nextInt(5 + 1) - 1;
        int dmg = basedmg + randomnumber;
        double attackerAttackSpeed = attacker.getSpeed() * ((double) attacker.getArmor().getSpeed() / 100) + attacker.getSpeed() * (1 + (double) attacker.getWeapon().getSpeed() / 100);
        double defenderAttackSpeed = defender.getSpeed() * ((double) defender.getArmor().getSpeed() / 100) + defender.getSpeed() * (1 + (double) defender.getWeapon().getSpeed() / 100);

        //this makes speed way more prominent
        double speedImpact = (attackerAttackSpeed - defenderAttackSpeed) * 0.05;
        dmg += speedImpact;


        return Math.max(dmg, 0);
    }

    private void lootBox(boolean winning) {
        if (winning) {
            String wpn = player.getWeapon().getName();
            String armor = player.getArmor().getName();
            Equipment PowerArmor = new Equipment();
            PowerArmor.setCND(200);
            PowerArmor.setSpeed(45);
            PowerArmor.setDT(100);
            PowerArmor.setName("Power Armor");

            Equipment alphaMutantArmor = new Equipment();
            alphaMutantArmor.setCND(60);
            alphaMutantArmor.setSpeed(55);
            alphaMutantArmor.setDT(65);
            alphaMutantArmor.setName("Mutant Alpha Armor");
            Equipment deathclawGauntlet = new Equipment();
            deathclawGauntlet.setDMG(45);
            deathclawGauntlet.setSpeed(65);
            deathclawGauntlet.setName("Deathclaw Gauntlet");

            if (wpn.equalsIgnoreCase("Deathclaw Gauntlet") && armor.equalsIgnoreCase("power armor")) {
                player.setDMG(player.getDmg() + 10);
                System.out.println("Sadly you have all the exclusive items, however you get a +10 DMG bonus");
            } else if (wpn.equalsIgnoreCase("Deathclaw Gauntlet") && !armor.equalsIgnoreCase("power armor") && player.getRace() != 3) {
                player.setArmor(PowerArmor);
                System.out.println("You found an operational suit of T-82 Power Armor, now nothing can stop you!");
            } else if (!wpn.equalsIgnoreCase("Deathclaw Gauntlet") && (armor.equalsIgnoreCase("power armor") || armor.equalsIgnoreCase("mutant alpha armor"))) {
                player.setWeapon(deathclawGauntlet);
                System.out.println("You found a Deathclaw Gauntlet, which is made from the claws of the animal. Wolverine would be jealous.");
            } else if (!armor.equalsIgnoreCase("Mutant Alpha Armor") && player.getRace() == 3) {
                player.setArmor(alphaMutantArmor);
                System.out.println("Your mutant beat the pack leader and got their armor, wear it with pride!");
            } else if (player.getRace() != 3 && !wpn.equalsIgnoreCase("Deathclaw Gauntlet") && !armor.equalsIgnoreCase("power armor")) {
                player.setWeapon(deathclawGauntlet);
                System.out.println("You found a Deathclaw Gauntlet, which is made from the claws of the animal. Wolverine would be jealous.");
            }
        }

    }


}