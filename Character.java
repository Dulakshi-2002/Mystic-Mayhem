public abstract class Character {
    /*
    ## this is Character class,
       all of the character attribues and function related to them are happen here.

     there are several getters and setters ,
      also here we have beingattack and healing functions to heal and reduce health when they under attack.

     */
    protected boolean hasArmour;
    protected boolean hasArtefacts;
    protected String name;
    protected double health;
    protected double warHealth;

    protected double attack;
    protected double OriginalAttack;
    protected int defense;

    protected int originalDefecne;
    protected int speed;
    protected int originalSpeed;
    protected String type;
    protected boolean isDead = false;
    protected String tribe;
    protected int prize;
    protected boolean isgroundhelp = false;

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTribe() {
        return tribe;
    }

    public void setTribe(String tribe) {
        this.tribe = tribe;
    }

    public String getName() {
        return name;
    }

    public double getHealth() {

        return this.health;
    }

    public double getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character setHealth(double health) {
        this.setwarHealth(health) ;
        this.health = health;
        return this;
    }
    public Character setwarHealth(double health) {
        this.warHealth = health;
        return this;
    }
    public void setAttack(double attack) {
        this.OriginalAttack = attack;
        this.attack = attack;
    }
    public void setwarAttack(double attack) {

        this.attack = attack;
    }
    public void setDefense(int defense) {
        this.originalDefecne = defense;
        this.defense = defense;
    }
    public void setwarDefense(int defense) {

        this.defense = defense;
    }
    public void setSpeed(int speed) {
        this.originalSpeed = speed;
        this.speed = speed;
    }
    public void setwarSpeed(int speed) {

        this.speed = speed;
    }

    public Character beingAttacked(Character enemy) {

        double currHealth = this.warHealth;

        currHealth -= (0.5 * enemy.getAttack() - 0.1 * this.getDefense());
        if (currHealth <= 0) {
            this.warHealth = 0;
            this.isDead = true;
            this.speed = 0;

            return this;
        } else {
            this.setwarHealth(currHealth);
            this.isDead = false;
            return this;
        }
    }

    public Character healing(Character healer) {

        double newHealth = this.warHealth + 0.1 * healer.getAttack();

        if (newHealth >= this.health) {
            this.warHealth = this.health;

        } else {
            this.setwarHealth(newHealth) ;

    }
        return this;
}

}