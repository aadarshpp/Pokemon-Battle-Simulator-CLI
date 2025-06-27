package mechanics;


import java.util.Random;

public class Stats{

    int HP;
    public int physical_attack;
    public int physical_defence;
    public int special_attack;
    public int special_defence;
    int speed;
    int IV;

    int calcHP(int level){
        return ((2 * HP + IV) * level/100) + level + 10;
    }

    int calcStat(int level, int baseStat){
        return ((2 * baseStat + IV) * level/100) + 5;
    }

    public float calcCriticalHitValue(){
        float probability = (float) speed /512;
        probability = 6.12f/100;
        if(new Random().nextFloat() <=probability)
        {return 1.5f;}
        return 1;
    }

    void setCurrentStats(int level){
        HP = calcHP(level);
        physical_attack = calcStat(level, physical_attack);
        physical_defence = calcStat(level, physical_defence);
        special_attack = calcStat(level, special_attack);
        special_defence = calcStat(level, special_defence);
        speed = calcStat(level, speed);
    }

    void setAttributes(int[] stats) {
        HP = stats[0];
        physical_attack = stats[1];
        physical_defence = stats[2];
        special_attack = stats[3];
        special_defence = stats[4];
        speed = stats[5];
    }

    public void display(){
        System.out.println("IV:"+IV);
        System.out.println("HP:"+HP);
        System.out.println("ATT:"+physical_attack);
        System.out.println("DEF:"+physical_defence);
        System.out.println("S.ATT:"+special_attack);
        System.out.println("S.DEF:"+special_defence);
        System.out.println("SPD:"+speed);
        System.out.println("TOT:"+(HP+physical_attack+physical_defence+special_attack+special_defence+speed));
    }

    public Stats(int[] stats) {
        setAttributes(stats);
    }

}


