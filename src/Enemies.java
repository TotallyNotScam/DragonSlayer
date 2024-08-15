public class Enemies extends Equipment {
    int hp;
    int dmg;
    int dfs;
    int speed;

    Equipment armor;

    Equipment weapon;
    int race; //1- human, 2- ghoul, 3-mutant, 4-deathclaw, 5-dragon

    public Enemies(int hp, int dmg, int dfs, int speed, Equipment armor, Equipment weapon, int race) {
        this.hp = hp;
        this.dmg = dmg;
        this.dfs = dfs;
        this.speed = speed;
        this.armor = armor;
        this.weapon = weapon;
        this.race = race;
    }

    public Enemies() {
    }

    public String toString() {
        return "Enemies{" +
                "hp=" + hp +
                ", dmg=" + dmg +
                ", dfs=" + dfs +
                ", speed=" + speed +
                ", armor=" + armor +
                ", weapon=" + weapon +
                ", race=" + race +
                '}';
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getDfs() {
        return dfs;
    }

    public void setDfs(int dfs) {
        this.dfs = dfs;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Equipment getArmor() {
        return armor;
    }

    public void setArmor(Equipment armor) {
        this.armor = armor;
    }

    public Equipment getWeapon() {
        return weapon;
    }

    public void setWeapon(Equipment weapon) {
        this.weapon = weapon;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }
}
