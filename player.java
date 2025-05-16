import java.util.ArrayList;
import java.util.Scanner;
public class player implements Player_Interface{
/*
this is the player class,

all of the player attributes, functions are  here,
we have several getters and settters here ,
also all the bying and selling happen here,

it is easy to find functionalityes by their methord signiture,

 */




    protected static int count=0;
    // protected static  ArrayList<String> user_names=new ArrayList<>();
    private String user_name;
    public boolean registerd=false;
    private boolean preDefinedUserName=false;
    private long UserId = count;
    protected int XP;
    protected  int GoldCoins=500;
    protected  Character[] arr= new Army[5];
    private String name;
    protected Character Archer;
    protected Character Knight;
    protected Character Mage;
    protected Character Healer;
    protected Character Mythical_creature;
    protected String Homeground;


    public player() {}


    //public void setArcher("")
    public void setName( String name) {
        this.name=name;

    }
    public String getName() {
        return name;
    }
    public void setUserName( String UserName) {
        this.user_name=UserName;

    }
    public String  getuserName() {
        return user_name;
    }


    public void show_UderID() {
        if(!(preDefinedUserName)) {
            System.out.println("User ID : "+UserId);}
    }
    public void show_goldCoins() {
        if(!(preDefinedUserName)) {
            System.out.println("Remaining Gold Coins : "+GoldCoins);}
    }
    public void show_XP() {
        if(!(preDefinedUserName)) {
            System.out.println("XP : "+XP);}
    }


    public int findPrice(int num){
        switch(num){
            case 1: return 80 ;
            case 2: return 115 ;
            case 3:  return 160 ;
            case 4:  return 200 ;
            case 5:  return 230 ;
            case 6: return 85 ;
            case 7:  return 110 ;
            case 8:  return 155 ;
            case 9:  return 180 ;
            case 10:  return 250 ;
            case 11:  return 100 ;
            case 12:  return 120 ;
            case 13:  return 160 ;
            case 14:  return 195 ;
            case 15:  return 270 ;
            case 16:  return 95 ;
            case 17:  return 125 ;
            case 18:  return 150 ;
            case 19:  return 200 ;
            case 20:  return 260 ;
            case 21:  return 120 ;
            case 22:  return 165;
            case 23:  return 205 ;
            case 24:  return 275 ;
            case 25:  return 340 ;
            case 26:  return 70;
            case 27:  return 105;
            case 28:  return 150;
            case 29:  return 150;
            case 30:  return 200;
            case 31:  return 210;
            default:return -1;
        }
    }

    public Character[] reorderArray(Character[] arr){
        Character[] newA = new Character[5];
        for(Character armi:arr){
            if(armi.getType()=="Archer"){
                newA[0]=armi;
            }
            if(armi.getType()=="Knight"){
                newA[1]=armi;
            }
            if(armi.getType()=="Mage"){
                newA[2]=armi;
            }
            if(armi.getType()=="Healer"){
                newA[3]=armi;
            }
            if(armi.getType()=="Mythical Creature"){
                newA[4]=armi;
            }
        }
        return newA;
    }

    public void sellArmy(String soldier) {
        for(int i=0 ; i < 5 ; i++) {
            if(arr[i]!=null && arr[i].getName().equals(soldier)) {
                GoldCoins+= arr[i].prize*0.9;
                arr[i]=null;
                System.out.println( soldier + " done selling");
                break;
            }
        }

    }

    public boolean IsEnoughCoins(int num){
        Boolean enough = true;
        int price= findPrice(num);
        if(GoldCoins>= price) {
            GoldCoins -= price;
        }
        else {
            System.out.println("Gold coins are not enough.");
            enough = false;
        }
        return enough;
    }

    public void BuyArmy(int armer)
    {
        switch (armer) {
            case 1:
                BuyArcher("Shooter");
                break;
            case 2:
                BuyArcher("Ranger");
                break;
            case 3:
                BuyArcher("Sunfire");
                break;
            case 4:
                BuyArcher("Zing");
                break;
            case 5:
                BuyArcher("Saggitarius");
                break;
            case 6:
                BuyKnight("Squire");
                break;
            case 7:
                BuyKnight("Cavalier");
                break;
            case 8:
                BuyKnight("Templar");
                break;
            case 9:
                BuyKnight("Zoro");
                break;
            case 10:
                BuyKnight("Swiftblade");
                break;
            case 11:
                BuyMages("Warlock");
                break;
            case 12:
                BuyMages("Illusionist");
                break;
            case 13:
                BuyMages("Enchanter");
                break;
            case 14:
                BuyMages("Conjurer");
                break;
            case 15:
                BuyMages("Eldritch");
                break;
            case 16:
                BuyHealer("Soother");
                break;
            case 17:
                BuyHealer("Medic");
                break;
            case 18:
                BuyHealer("Alchemist");
                break;
            case 19:
                BuyHealer("Saint");
                break;
            case 20:
                BuyHealer("Lightbringer");
                break;
            case 21:
                BuyMythicalCreature("Dragon");
                break;
            case 22:
                BuyMythicalCreature("Basilisk");
                break;
            case 23:
                BuyMythicalCreature("Hydra");
                break;
            case 24:
                BuyMythicalCreature("Phoenix");
                break;
            case 25:
                BuyMythicalCreature("Pegasus");
                break;

        }
    }

    public boolean AllNull(Character[] Array){
        for(int i=0 ; i < 5 ; i++) {
            if(Array[i]!=null){
                return false;
            }
        }
        return true;
    }

    public void selling(){
        while (!AllNull(arr)) {
            System.out.println("Do you want to sell your armer? (yes/no)");
            Scanner object1 = new Scanner(System.in);
            String sell = object1.nextLine();
            if (sell.equals("yes")) {
                System.out.println("Whom do you want to sell? Enter name");
                Scanner object2 = new Scanner(System.in);
                String who = object2.nextLine();
                sellArmy(who);

            } else if(sell.equals("no")) {
                break;
            }

        }
        Checkarray(arr);
    }

    public void Checkarray(Character[] array){
        if(array[0]==null) {
            show_shopArcher();
        }
        if(array[1]==null) {
            show_shopKnights();
        }
        if(array[2]==null) {
            show_shopMages();
        }
        if(array[3]==null) {
            show_shopHealers();
        }
        if(array[4]==null) {
            show_shopMythical_Creatures();
        }
    }

    public void show_shopArcher() {
        if(arr[0]==null) {
            System.out.print("(1)\n Type : Archer \nName: Shooter\nPrice: 80 gc\nAttack: 11\nDefence: 4\nHealth: 6\nSpeed: 9\n");
            System.out.println();
            System.out.print("(2)\n Type : Archer\r\n" + "Name: Ranger\r\n"
                    + "Price: 115 gc\r\n"
                    + "Attack: 14\r\n"
                    + "Defence: 5\r\n"
                    + "Health: 8\r\n"
                    + "Speed: 10\n");
            System.out.println();
            System.out.print("(3)\n Type : Archer\r\n"
                    + "Name: Sunfire\r\n"
                    + "Price: 160 gc\r\n"
                    + "Attack: 15\r\n"
                    + "Defence: 5\r\n"
                    + "Health: 7\r\n"
                    + "Speed: 14\r\n"
            );
            System.out.println();
            System.out.print("(4)\n Type : Archer\r\n"
                    + "Name: Zing\r\n"
                    + "Price: 200 gc\r\n"
                    + "Attack: 16\r\n"
                    + "Defence: 9\r\n"
                    + "Health: 11\r\n"
                    + "Speed: 14\r\n"
            );
            System.out.println();
            System.out.print("(5)\n Type : Archer\r\n"
                    + "Name: Saggitarius\r\n"
                    + "Price: 230 gc\r\n"
                    + "Attack: 18\r\n"
                    + "Defence: 7\r\n"
                    + "Health: 12\r\n"
                    + "Speed: 17\n");
            System.out.println();
            System.out.println("*Select one from Archers.Give the relevant number");
            Scanner O1 = new Scanner(System.in);
            int num = O1.nextInt();
            while (num < 1 || num > 5) {
                System.out.println("Enter a number in between 1 and 5 inclusive");
                Scanner scanner = new Scanner(System.in);
                num =scanner.nextInt();
            }
            if (IsEnoughCoins(num)) {
                BuyArmy(num);
                show_goldCoins();
            } else {
                selling();
            }
        }
        else {
            System.out.println("Do you want to sell your Archer? (yes/no)");
            Scanner object1 = new Scanner(System.in);
            String sell = object1.nextLine();
            if (sell.equals("yes")) {
                sellArmy(arr[0].getName());
            }
            Checkarray(arr);
        }
    }

    public void show_shopKnights() {
        if(arr[1]==null) {
            System.out.print("(6)\n Type : Knights\r\n" + "Name: Squire\r\n"
                    + "Price: 85 gc\r\n"
                    + "Attack: 8\r\n"
                    + "Defence: 9\r\n"
                    + "Health: 7\r\n"
                    + "Speed: 8\r\n"
            );
            System.out.println();
            System.out.print("(7)\n Type : Knights\r\n" + "Name: Cavalier\r\n"
                    + "Price: 110 gc\r\n"
                    + "Attack: 10\r\n"
                    + "Defence: 12\r\n"
                    + "Health: 7\r\n"
                    + "Speed: 10\n");
            System.out.println();
            System.out.print("(8)\n Type : Knights\r\n" + "Name: Templar\r\n"
                    + "Price: 155 gc\r\n"
                    + "Attack: 14\r\n"
                    + "Defence: 16\r\n"
                    + "Health: 12\r\n"
                    + "Speed: 12\r\n"
            );
            System.out.println();
            System.out.print("(9)\n Type : Knights\r\n" + "Name: Zoro\r\n"
                    + "Price: 180 gc\r\n"
                    + "Attack: 17\r\n"
                    + "Defence: 16\r\n"
                    + "Health: 13\r\n"
                    + "Speed: 14\n");
            System.out.println();
            System.out.print("(10)\n Type : Knights\r\n" + "Name: Swiftblade\r\n"
                    + "Price: 250 gc\r\n"
                    + "Attack: 18\r\n"
                    + "Defence: 20\r\n"
                    + "Health: 17\r\n"
                    + "Speed: 13\r\n"
            );
            System.out.println();
            System.out.println("*Select one from Knights.Give the relevant number");
            Scanner O1 = new Scanner(System.in);
            int num = O1.nextInt();
            while (num < 6 || num > 10) {
                System.out.println("Enter a number in between 6 and 10 inclusive");
                Scanner scanner = new Scanner(System.in);
                num = scanner.nextInt();
            }
            if (IsEnoughCoins(num)) {
                BuyArmy(num);
                show_goldCoins();
            } else {
                selling();
            }
        }
        else{
            System.out.println("Do you want to sell your Knight? (yes/no)");
            Scanner object1 = new Scanner(System.in);
            String sell = object1.nextLine();
            if (sell.equals("yes")) {
                sellArmy(arr[1].getName());
            }
            Checkarray(arr);}
    }

    public void show_shopMages() {
        if(arr[2]==null) {
            System.out.print("(11)\n Type : Mages\r\n" + "Name: Warlock\r\n"
                    + "Price: 100 gc\r\n"
                    + "Attack: 12\r\n"
                    + "Defence: 7\r\n"
                    + "Health: 10\r\n"
                    + "Speed: 12\n");
            System.out.println();
            System.out.print("(12)\n Type : Mages\r\n" + "Name: Illusionist\r\n"
                    + "Price: 120 gc\r\n"
                    + "Attack: 13\r\n"
                    + "Defence: 8\r\n"
                    + "Health: 12\r\n"
                    + "Speed: 14\n");
            System.out.println();
            System.out.print("(13)\n Type : Mages\r\n" + "Name: Enchanter\r\n"
                    + "Price: 160 gc\r\n"
                    + "Attack: 16\r\n"
                    + "Defence: 10\r\n"
                    + "Health: 13\r\n"
                    + "Speed: 16\n");
            System.out.println();
            System.out.print("(14)\n Type : Mages\r\n" + "Name: Conjurer\r\n"
                    + "Price: 195 gc\r\n"
                    + "Attack: 18\r\n"
                    + "Defence: 15\r\n"
                    + "Health: 14\r\n"
                    + "Speed: 12\n");
            System.out.println();
            System.out.print("(15)\n Type : Mages\r\n" + "Name: Eldritch\r\n"
                    + "Price: 270 gc\r\n"
                    + "Attack: 19\r\n"
                    + "Defence: 17\r\n"
                    + "Health: 18\r\n"
                    + "Speed: 14\n");

            System.out.println();
            System.out.println("*Select one from Mages.Give the relevant number");
            Scanner O1 = new Scanner(System.in);
            int num = O1.nextInt();
            while (num < 11 || num > 15) {
                System.out.println("Enter a number in between 11 and 15 inclusive");
                Scanner scanner = new Scanner(System.in);
                num = scanner.nextInt();
            }
            if (IsEnoughCoins(num)) {
                BuyArmy(num);
                show_goldCoins();
            } else {
                selling();
            }
        }else {
            System.out.println("Do you want to sell your Mage? (yes/no)");
            Scanner object1 = new Scanner(System.in);
            String sell = object1.nextLine();
            if (sell.equals("yes")) {
                sellArmy(arr[2].getName());
            }
            Checkarray(arr);
        }
    }

    public void show_shopHealers() {
        if(arr[3]==null) {
            System.out.print("(16)\n Type : Healers\r\n" + "Name: Soother\r\n"
                    + "Price: 95 gc\r\n"
                    + "Attack: 10\r\n"
                    + "Defence: 8\r\n"
                    + "Health: 9\r\n"
                    + "Speed: 6\n");
            System.out.println();
            System.out.print("(17)\n Type : Healers\r\n" + "Name: Medic\r\n"
                    + "Price: 125 gc\r\n"
                    + "Attack: 12\r\n"
                    + "Defence: 9\r\n"
                    + "Health: 10\r\n"
                    + "Speed: 7\r\n"
            );
            System.out.println();
            System.out.print("(18)\n Type : Healers\r\n" + "Name: Alchemist\r\n"
                    + "Price: 150 gc\r\n"
                    + "Attack: 13\r\n"
                    + "Defence: 13\r\n"
                    + "Health: 13\r\n"
                    + "Speed: 13\r\n"
            );
            System.out.println();
            System.out.print("(19)\n Type : Healers\r\n" + "Name: Saint\r\n"
                    + "Price: 200 gc\r\n"
                    + "Attack: 16\r\n"
                    + "Defence: 14\r\n"
                    + "Health: 17\r\n"
                    + "Speed: 9\n");
            System.out.println();
            System.out.print("(20)\n Type : Healers\r\n" + "Name: Lightbringer\r\n"
                    + "Price: 260 gc\r\n"
                    + "Attack: 17\r\n"
                    + "Defence: 15\r\n"
                    + "Health: 19\r\n"
                    + "Speed: 12\n");
            System.out.println();
            System.out.println("*Select one from Healers.Give the relevant number");
            Scanner O1 = new Scanner(System.in);
            int num = O1.nextInt();
            while (num < 16 || num > 20) {
                System.out.println("Enter a number in between 16 and 20 inclusive");
                Scanner scanner = new Scanner(System.in);
                num = scanner.nextInt();
            }
            if (IsEnoughCoins(num)) {
                BuyArmy(num);
                show_goldCoins();
            } else {
                selling();
            }
        }else {
            System.out.println("Do you want to sell your Healer? (yes/no)");
            Scanner object1 = new Scanner(System.in);
            String sell = object1.nextLine();
            if (sell.equals("yes")) {
                sellArmy(arr[3].getName());
            }
            Checkarray(arr);
        }
    }

    public void show_shopMythical_Creatures() {
        if(arr[4]==null) {
            System.out.print("(21)\n Type : Mythical_Creatures\r\n" +"Name: Dragon\r\n"
                    + "Price: 120 gc\r\n"
                    + "Attack: 12\r\n"
                    + "Defence: 14\r\n"
                    + "Health: 15\r\n"
                    + "Speed: 8\r\n"
            );
            System.out.println();
            System.out.print("(22)\n Type : Mythical_Creatures\r\n" +"Name: Basilisk\r\n"
                    + "Price: 165 gc\r\n"
                    + "Attack: 15\r\n"
                    + "Defence: 11\r\n"
                    + "Health: 10\r\n"
                    + "Speed: 12\n");
            System.out.println();
            System.out.print("(23)\n Type : Mythical_Creatures\r\n" +"Name: Hydra\r\n"
                    + "Price: 205 gc\r\n"
                    + "Attack: 12\r\n"
                    + "Defence: 16\r\n"
                    + "Health: 15\r\n"
                    + "Speed: 11\r\n"
            );
            System.out.println();
            System.out.print("(24)\n Type : Mythical_Creatures\r\n" +"Name: Phoenix\r\n"
                    + "Price: 275 gc\r\n"
                    + "Attack: 17\r\n"
                    + "Defence: 13\r\n"
                    + "Health: 17\r\n"
                    + "Speed: 19\r\n"
            );
            System.out.println();
            System.out.print("(25)\n Type : Mythical_Creatures\r\n" +"Name: Pegasus\r\n"
                    + "Price: 340 gc\r\n"
                    + "Attack: 14\r\n"
                    + "Defence: 18\r\n"
                    + "Health: 20\r\n"
                    + "Speed: 20\n");
            System.out.println();
            System.out.println("*Select one from Mythical Creatures.Give the relevant number");
            Scanner O1 = new Scanner(System.in);
            int num = O1.nextInt();
            while (num < 21 || num > 25) {
                System.out.println("Enter a number in between 21 and 25 inclusive");
                Scanner scanner = new Scanner(System.in);
                num = scanner.nextInt();
            }
            if (IsEnoughCoins(num)) {
                BuyArmy(num);
                show_goldCoins();
            } else {
                selling();
            }
        }else {
            System.out.println("Do you want to sell your Mythical Creature? (yes/no)");
            Scanner object1 = new Scanner(System.in);
            String sell = object1.nextLine();
            if (sell.equals("yes")) {
                sellArmy(arr[4].getName());
            }
            Checkarray(arr);
        }
    }

    public void BuyArcher(String name) {
        if(!(preDefinedUserName)) {
            if(arr[0]==null) {


                switch (name) {
                    case "Shooter":
                        Character Shooter=new Army();


                        Shooter.setName(name);
                        Shooter.setPrize(80);
                        Shooter.setAttack(11);
                        Shooter.setDefense(4);
                        Shooter.setHealth(6);
                        Shooter.setSpeed(9);
                        Shooter.setTribe("Highlanders");
                        Shooter.setType("Archer");
                        Shooter.hasArmour=false;
                        Shooter.hasArtefacts=false;
                        arr[0]=Shooter;
                        Archer=Shooter;

                        break;
                    case "Ranger":
                        Character Ranger=new Army();

                        Ranger.setName(name);
                        Ranger.setPrize(115);
                        Ranger.setAttack(14);
                        Ranger.setDefense(5);
                        Ranger.setHealth(8);
                        Ranger.setHealth(10);
                        Ranger.setTribe("Highlanders");
                        Ranger.setType("Archer");
                        Ranger.hasArmour=false;
                        Ranger.hasArtefacts=false;
                        arr[0]=Ranger;
                        Archer=Ranger;

                        break;
                    case "Sunfire":
                        Character Sunfire=new Army();

                        Sunfire.setName(name);
                        Sunfire.setPrize(160);
                        Sunfire.setAttack(15);
                        Sunfire.setDefense(5);
                        Sunfire.setHealth(7);
                        Sunfire.setSpeed(14);
                        Sunfire.setTribe("Sunchildren");
                        Sunfire.setType("Archer");
                        Sunfire.hasArmour=false;
                        Sunfire.hasArtefacts=false;
                        arr[0]=Sunfire;
                        Archer=Sunfire;


                        break;
                    case "Zing":
                        Character Zing=new Army();

                        Zing.setName(name);
                        Zing.setPrize(200);
                        Zing.setAttack(16);
                        Zing.setDefense(9);
                        Zing.setHealth(11);
                        Zing.setSpeed(14);
                        Zing.setTribe("Sunchildren");
                        Zing.setType("Archer");
                        Zing.hasArmour=false;
                        Zing.hasArtefacts=false;
                        arr[0]=Zing;
                        Archer=Zing;

                        break;
                    case "Saggitarius":

                        Character Saggitarius=new Army();

                        Saggitarius.setName(name);
                        Saggitarius.setPrize(230);
                        Saggitarius.setAttack(18);
                        Saggitarius.setDefense(17);
                        Saggitarius.setHealth(12);
                        Saggitarius.setSpeed(17);
                        Saggitarius.setTribe("Mystics");
                        Saggitarius.setType("Archer");
                        Saggitarius.hasArmour=false;
                        Saggitarius.hasArtefacts=false;
                        arr[0]=Saggitarius;
                        Archer=Saggitarius;

                        break;
                }}
            else{System.out.println("You have already bought an Archer.Do you want to sell him");}
        }}


    public void BuyKnight(String name) {
        if(!(preDefinedUserName)) {
            if(arr[1]==null) {


                switch (name) {
                    case "Squire":
                        Character Squire= new Army();

                        Squire.setName(name);
                        Squire.setPrize(85);
                        Squire.setAttack(12);
                        Squire.setDefense(9);
                        Squire.setHealth(7);
                        Squire.setSpeed(8);
                        Squire.setTribe("Marshlanders");
                        Squire.setType("Knight");
                        Squire.hasArmour=false;
                        Squire.hasArtefacts=false;
                        arr[1]=Squire;
                        Knight=Squire;

                        break;
                    case "Cavalier":
                        Character Cavalier=new Army();

                        Cavalier.setName(name);
                        Cavalier.setPrize(110);
                        Cavalier.setAttack(10);
                        Cavalier.setDefense(12);
                        Cavalier.setHealth(7);
                        Cavalier.setSpeed(10);
                        Cavalier.setTribe("Highlanders");
                        Cavalier.setType("Knight");
                        Cavalier.hasArmour=false;
                        Cavalier.hasArtefacts=false;
                        arr[1]=Cavalier;
                        Knight=Cavalier;

                        break;
                    case "Templar":
                        Character Templar=new Army();

                        Templar.setName(name);
                        Templar.setPrize(155);
                        Templar.setAttack(14);
                        Templar.setDefense(16);
                        Templar.setHealth(12);
                        Templar.setSpeed(12);
                        Templar.setTribe("Sunchildren");
                        Templar.setType("Knight");
                        Templar.hasArmour=false;
                        Templar.hasArtefacts=false;
                        arr[1]=Templar;
                        Knight=Templar;

                        break;
                    case "Zoro":
                        Character Zoro =new Army();

                        Zoro.setName(name);
                        Zoro.setPrize(180);
                        Zoro.setAttack(17);
                        Zoro.setDefense(16);
                        Zoro.setHealth(13);
                        Zoro.setSpeed(14);
                        Zoro.setTribe("Highlanders");
                        Zoro.setType("Knight");
                        Zoro.hasArmour=false;
                        Zoro.hasArtefacts=false;
                        arr[1]=Zoro;
                        Knight=Zoro;

                        break;
                    case "Swiftblade":
                        Character Swiftblade=new Army();

                        Swiftblade.setName(name);
                        Swiftblade.setPrize(250);
                        Swiftblade.setAttack(18);
                        Swiftblade.setDefense(20);
                        Swiftblade.setSpeed(13);
                        Swiftblade.setHealth(17);
                        Swiftblade.setTribe("Marshlanders");
                        Swiftblade.setType("Knight");
                        Swiftblade.hasArmour=false;
                        Swiftblade.hasArtefacts=false;
                        arr[1]=Swiftblade;
                        Knight=Swiftblade;

                        break;
                }}else {System.out.println("You have already bought a Knight.Do you want to sell him");}
        }
    }

    public void BuyMages(String name) {
        if(!(preDefinedUserName)) {
            if(arr[2]==null) {


                switch (name) {
                    case "Warlock":
                        Character Warlock=new Army();

                        Warlock.setName(name);
                        Warlock.setPrize(100);
                        Warlock.setAttack(12);
                        Warlock.setDefense(7);
                        Warlock.setHealth(10);
                        Warlock.setSpeed(12);
                        Warlock.setTribe("Marshlanders");
                        Warlock.setType("Mage");
                        Warlock.hasArmour=false;
                        Warlock.hasArtefacts=false;
                        arr[2]=Warlock;
                        Mage=Warlock;

                        break;
                    case "Illusionist":
                        Character Illusionist=new Army();

                        Illusionist.setName(name);
                        Illusionist.setPrize(120);
                        Illusionist.setAttack(13);
                        Illusionist.setDefense(8);
                        Illusionist.setHealth(12);
                        Illusionist.setSpeed(14);
                        Illusionist.setTribe("Mystics");
                        Illusionist.setType("Mage");
                        Illusionist.hasArmour=false;
                        Illusionist.hasArtefacts=false;
                        arr[2]=Illusionist;
                        Mage=Illusionist;


                        break;
                    case "Enchanter":
                        Character Enchanter=new Army();

                        Enchanter.setName(name);
                        Enchanter.setPrize(160);
                        Enchanter.setAttack(16);
                        Enchanter.setDefense(10);
                        Enchanter.setHealth(13);
                        Enchanter.setSpeed(16);
                        Enchanter.setTribe("Highlanders");
                        Enchanter.setType("Mage");
                        Enchanter.hasArmour=false;
                        Enchanter.hasArtefacts=false;
                        arr[2]=Enchanter;
                        Mage=Enchanter;


                        break;
                    case "Conjurer":
                        Character Conjurer=new Army();

                        Conjurer.setName(name);
                        Conjurer.setPrize(195);
                        Conjurer.setAttack(18);
                        Conjurer.setDefense(15);
                        Conjurer.setHealth(14);
                        Conjurer.setSpeed(12);
                        Conjurer.setTribe("Highlanders");
                        Conjurer.setType("Mage");
                        Conjurer.hasArmour=false;
                        Conjurer.hasArtefacts=false;
                        arr[2]=Conjurer;
                        Mage=Conjurer;

                        break;
                    case "Eldritch":

                        Character Eldritch=new Army();

                        Eldritch.setName(name);
                        Eldritch.setPrize(180);
                        Eldritch.setAttack(17);
                        Eldritch.setDefense(16);
                        Eldritch.setHealth(18);
                        Eldritch.setSpeed(14);
                        Eldritch.setTribe("Mystics");
                        Eldritch.setType("Mage");
                        Eldritch.hasArmour=false;
                        Eldritch.hasArtefacts=false;
                        arr[2]=Eldritch;
                        Mage=Eldritch;

                        break;
                }}
            else{System.out.println("You have already bought an Healer.Do you want to sell him");}
        }}

    public void BuyHealer(String name) {
        if(!(preDefinedUserName)) {
            if(arr[3]==null) {


                switch (name) {
                    case "Soother":
                        Character Soother=new Army();

                        Soother.setName(name);
                        Soother.setPrize(95);
                        Soother.setAttack(10);
                        Soother.setDefense(8);
                        Soother.setHealth(9);
                        Soother.setSpeed(6);
                        Soother.setTribe("Sunchildren");
                        Soother.setType("Healer");
                        Soother.hasArmour=false;
                        Soother.hasArtefacts=false;
                        arr[3]=Soother;
                        Healer=Soother;

                        break;
                    case "Medic":
                        Character Medic=new Army();
                        Medic.setName(name);
                        Medic.setPrize(125);
                        Medic.setAttack(12);
                        Medic.setDefense(9);
                        Medic.setHealth(10);
                        Medic.setSpeed(7);
                        Medic.setTribe("Highlanders");
                        Medic.setType("Healer");
                        Medic.hasArmour=false;
                        Medic.hasArtefacts=false;
                        arr[3]=Medic;
                        Healer=Medic;

                        break;
                    case "Alchemist":
                        Character Alchemist=new Army();

                        Alchemist.setName(name);
                        Alchemist.setPrize(150);
                        Alchemist.setAttack(13);
                        Alchemist.setDefense(13);
                        Alchemist.setHealth(13);
                        Alchemist.setSpeed(13);
                        Alchemist.setTribe("Marshlanders");
                        Alchemist.setType("Healer");
                        Alchemist.hasArmour=false;
                        Alchemist.hasArtefacts=false;
                        arr[3]=Alchemist;
                        Healer=Alchemist;

                        break;
                    case "Saint":
                        Character Saint=new Army();

                        Saint.setName(name);
                        Saint.setPrize(200);
                        Saint.setAttack(16);
                        Saint.setDefense(14);
                        Saint.setHealth(17);
                        Saint.setSpeed(9);
                        Saint.setTribe("Mystics");
                        Saint.setType("Healer");
                        Saint.hasArmour=false;
                        Saint.hasArtefacts=false;
                        arr[3]=Saint;
                        Healer=Saint;

                        break;
                    case "Lightbringer":

                        Character Lightbringer=new Army();

                        Lightbringer.setName(name);
                        Lightbringer.setPrize(260);
                        Lightbringer.setAttack(17);
                        Lightbringer.setDefense(15);
                        Lightbringer.setHealth(19);
                        Lightbringer.setSpeed(12);
                        Lightbringer.setTribe("Sunchildren");
                        Lightbringer.setType("Healer");
                        Lightbringer.hasArmour=false;
                        Lightbringer.hasArtefacts=false;
                        arr[3]=Lightbringer;
                        Healer=Lightbringer;

                        break;
                }}
            else{System.out.println("You have already bought an Healer.Do you want to sell him");}
        }}

    public void BuyMythicalCreature(String name) {
        if(!(preDefinedUserName)) {
            if(arr[4]==null) {


                switch (name) {
                    case "Dragon":
                        Character Dragon=new Army();

                        Dragon.setName(name);
                        Dragon.setPrize(120);
                        Dragon.setAttack(12);
                        Dragon.setDefense(14);
                        Dragon.setHealth(15);
                        Dragon.setSpeed(8);
                        Dragon.setTribe("Sunchildren");
                        Dragon.setType("Mythical Creature");
                        arr[4]=Dragon;
                        Mythical_creature=Dragon;

                        break;
                    case "Basilisk":
                        Character Basilisk =new Army();

                        Basilisk.setName(name);
                        Basilisk.setPrize(165);
                        Basilisk.setAttack(15);
                        Basilisk.setDefense(11);
                        Basilisk.setHealth(10);
                        Basilisk.setSpeed(12);
                        arr[4]=Basilisk;
                        Mythical_creature=Basilisk;

                        break;
                    case "Hydra":
                        Character Hydra=new Army();

                        Hydra.setName(name);
                        Hydra.setPrize(205);
                        Hydra.setAttack(12);
                        Hydra.setDefense(16);
                        Hydra.setHealth(15);
                        Hydra.setSpeed(11);
                        arr[4]=Hydra;
                        Mythical_creature=Hydra;

                        break;
                    case "Phoenix":
                        Character Phoenix=new Army();

                        Phoenix.setName(name);
                        Phoenix.setPrize(275);
                        Phoenix.setAttack(17);
                        Phoenix.setDefense(13);
                        Phoenix.setHealth(17);
                        Phoenix.setSpeed(19);
                        arr[4]=Phoenix;
                        Mythical_creature=Phoenix;

                        break;
                    case "Pegasus":

                        Character Pegasus=new Army();

                        Pegasus.setName(name);
                        Pegasus.setPrize(340);
                        Pegasus.setAttack(14);
                        Pegasus.setDefense(18);
                        Pegasus.setHealth(20);
                        Pegasus.setSpeed(20);
                        arr[4]=Pegasus;
                        Mythical_creature=Pegasus;

                        break;
                }}
            else{System.out.println("You have already bought an Mythical_creature.Do you want to sell him");}
        }}
    public void BuyArmour(int Armour,String chara) {
        for(Character a:arr)
        {if(a.getName().equals(chara)) {
            if(!a.hasArmour) {
                switch(Armour) {
                    case 26:
                        Equipment Chainmail=new Equipment();
                        Chainmail.Eqname="Armour";
                        Chainmail.price=70;
                        if(IsEnoughCoins(Armour)) {
                            Chainmail.ChangeAttack(0, a);
                            Chainmail.ChangeDefence(1, a);
                            Chainmail.ChangeHealth(0, a);
                            Chainmail.ChangeHealth(-1, a);
                            Chainmail.changePrice(a);
                            a.hasArmour=true;


                            break;}
                        else {System.out.println("your gold coins are not enough to buy Chainmail");
                            break;}

                    case 27:
                        Equipment Regalia=new Equipment();
                        Regalia.Eqname="Armour";
                        Regalia.price=105;
                        if(IsEnoughCoins(Armour)) {
                            Regalia.ChangeAttack(0, a);
                            Regalia.ChangeDefence(1, a);
                            Regalia.ChangeHealth(0, a);
                            Regalia.ChangeHealth(0, a);
                            Regalia.changePrice(a);
                            a.hasArmour=true;
                            GoldCoins-=Regalia.price;
                            break;}
                        else {System.out.println("your gold coins are not enough to buy Regalia");
                            break;}

                    case 28:
                        Equipment Fleece=new Equipment();
                        Fleece.Eqname="Armour";
                        Fleece.price=150;
                        if(IsEnoughCoins(Armour)) {
                            Fleece.ChangeAttack(0, a);
                            Fleece.ChangeDefence(2, a);
                            Fleece.ChangeHealth(1, a);
                            Fleece.ChangeHealth(-1, a);
                            Fleece.changePrice(a);
                            a.hasArmour=true;
                            GoldCoins-=Fleece.price;
                            break;}
                        else {System.out.println("your gold coins are not enough to buy Fleece");
                            break;}
                }

            }}}
    }

    public void BuyArtefacts(int Artefacts,String chara) {

        for(Character a:arr)
        {

            if(a.getName().equals(chara)) {

                if(!a.hasArtefacts) {

                    switch(Artefacts) {
                        case 29:
                            Equipment Excalibur=new Equipment();
                            Excalibur.Eqname="Artefacts";
                            Excalibur.price=150;
                            if(IsEnoughCoins(Artefacts)) {
                                Excalibur.ChangeAttack(2, a);
                                Excalibur.ChangeDefence(0, a);
                                Excalibur.ChangeHealth(0, a);
                                Excalibur.ChangeHealth(0, a);
                                Excalibur.changePrice(a);
                                a.hasArtefacts=true;
                                GoldCoins-=Excalibur.price;
                                break;}
                            else {System.out.println("your gold coins are not enough to buy Excalibur");
                                break;}

                        case 30 :
                            Equipment  Amulet=new Equipment();
                            Amulet.Eqname="Artefacts";
                            Amulet.price=200;
                            if(IsEnoughCoins(Artefacts)) {
                                Amulet.ChangeAttack(1, a);
                                Amulet.ChangeDefence(-1, a);
                                Amulet.ChangeHealth(1, a);
                                Amulet.ChangeHealth(1, a);
                                Amulet.changePrice(a);
                                a.hasArtefacts=true;
                                GoldCoins-=Amulet.price;
                                break;}
                            else {System.out.println("your gold coins are not enough to buy  Amulet");
                                break;}

                        case 31 :
                            Equipment Crystal=new Equipment();
                            Crystal.Eqname="Artefacts";
                            Crystal.price=210;
                            if(IsEnoughCoins(Artefacts)) {
                                Crystal.ChangeAttack(2, a);
                                Crystal.ChangeDefence(1, a);
                                Crystal.ChangeHealth(-1, a);
                                Crystal.ChangeHealth(-1, a);
                                Crystal.changePrice(a);
                                a.hasArtefacts=true;
                                GoldCoins-=Crystal.price;
                                break;}
                            else {System.out.println("your gold coins are not enough to buy Crystal");
                                break;}


                    }

                }}}
    }


    public void show_Armour() {

        System.out.print("(26)\nType : Armour\n Name: Chainmail\n Price: 70 gc\n Attack: no change\n Defence: +1\n Health: no change\n Speed: -1\n");
        System.out.println();
        System.out.println("(27)\nType : Armour\n Name: Regalia\n Price: 105 gc\n Attack: no change\n Defence: +1\n Health: no change\n Speed: no change\n");
        System.out.println();
        System.out.println("(28)\nType : Armour\n Name: Fleece\n Price: 150 gc\n Attack: no change\n Defence: +2\n Health: +1\n Speed: -1\n");
        System.out.println();
    }
    public void show_Artefact() {
        System.out.print("(29)\nType : Artefacts\n Name: Excalibur\n Price: 150 gc\n Attack: +2\n Defence: no change\n Health: no change\n Speed: no change\n");
        System.out.println();
        System.out.println("(30)\nType : Artefacts\n Name: Amulet\n Price: 200 gc\n Attack: +1\n Defence: -1\n Health: +1\n Speed: +1\n");
        System.out.println();
        System.out.println("(31)\nType : Artefacts\n Name: Crystal\n Price: 210 gc\n Attack: +2\n Defence: +1\n Health: -1\n Speed: -1\n");
        System.out.println();
    }
    public int update_goldCoins(int win,int coins) {
        if (win==0) {
            GoldCoins+=0.1*coins;
        }
        return GoldCoins;
    }
    public int update_XP(int win) {
        if (win==0) {
            XP++;
        }
        return XP;
    }


    @Override
    public void setGoldCoins(int value) {
        this.GoldCoins=value;

    }


    @Override
    public int getGold() {

        return GoldCoins;
    }


    @Override
    public int getxp() {
        // TODO Auto-generated method stub
        return XP;
    }


    @Override
    public Character[] getArmy() {
        // TODO Auto-generated method stub
        return arr;
    }


    @Override
    public void setxp(int value) {
        // TODO Auto-generated method stub
        this.XP=value;
    }


    public void setHomeground(String ground) {
        // TODO Auto-generated method stub
        Homeground = ground;

    }


    public void setUserId(long count2) {
        // TODO Auto-generated method stub
        this.UserId= count2;
    }






}