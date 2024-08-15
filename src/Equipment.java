public class Equipment {
    int DT;
    int CND;
    int DMG;
    int speed;
    String name;

    public void Equipment (int DMG, int speed, String name){
        this.DMG = DMG;

        this.speed=speed;
        this.name=name;


    }

    public void Equipment(int DT, int CND, int speed, String name) {
        this.DT = DT;
        this.CND = CND;
        this.speed = speed;
        this.name=name;

    }
    public void Equipment(){}

    public int getDT() {
        return DT;
    }

    public void setDT(int DT) {
        this.DT = DT;
    }

    public int getCND() {
        return CND;
    }

    public void setCND(int CND) {
        this.CND = CND;
    }

    public int getDMG() {
        return DMG;
    }

    public void setDMG(int DMG) {
        this.DMG = DMG;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "DT=" + DT +
                ", CND=" + CND +
                ", DMG=" + DMG +
                ", speed=" + speed +
                ", name='" + name + '\'' +
                '}';
    }
}
