public class Equipment {
    /*
    This is the Equipment class,

    all of the equipment attributes and related functions are here,

    we use changeAttack,ChangeDefense and ChangeHealth functions are used to change character's Attakc ,
    health and defence values accurding to equipment.

     */

    protected String Eqname;
    protected int price;
    public double ChangeAttack(int val,Character soldier) {
        soldier.setAttack(soldier.attack+=val);

        return soldier.attack;
    }
    public double ChangeDefence(int val,Character soldier) {
        soldier.setDefense(soldier.defense+=val);

        return soldier.defense;
    }
    public double ChangeHealth(int val,Character soldier) {
        soldier.setHealth(soldier.health+=val);

        return soldier.health;
    }
    public double ChangeSpeed(int val,Character soldier) {
        soldier.setSpeed(soldier.speed+=val);

        return soldier.speed;
    }
    public double changePrice(Character soldier) {
        soldier.prize*=1.2;
        return soldier.prize;
    }

}