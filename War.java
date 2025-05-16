import java.text.DecimalFormat;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
public  class War {

   /*
   ### This is war class .Here all of the war functions happen.
   Here that functions and Functionality ,

   # groundeffects:- when war happen in each turn som characters have paricular  bonuses,
                     it calculated here.

   # findweak:- find weakest enemy.

   # findLH:-   find soldier who has lawest value(for healer to heal them).

   # sortoffence and priority:- they are for sort army accourding to soldier's speed.

   # setGround :- when armys came to particular war ground some characters are affected,this function
                  for add them.
   # isalive :- to check all of the army is not dead.

   # turn :- when army attack to another army each army have 10 turns,
             when a army have a turn one of the soldiers attack to other army accourding to their speed,
             this function is used to do one turn.

    # start :- all of the main things happen here.
                assign armys to war for their turn,
                setGround before they go to war,
                restore army,
                check armys are alive and
                return war status.

   */
    public static void groundeffects(Character [] army){
        for(Character soldier:army){
            if(soldier.tribe=="Highlanders" && soldier.isgroundhelp){
                soldier.attack*=1.2;
            }if(soldier.tribe=="Mystics" && soldier.isgroundhelp){
                soldier.warHealth*=1.1;
            }}
    }
    public static Character findweak(Character [] Defence) {
        //find the weakest soldier
        double lowDef=Defence[0].warHealth;
        Character weak=Defence[0];
        for (Character soldier : Defence) {
            if(soldier.warHealth>0){
                lowDef = soldier.defense;
                weak = soldier;
            }}



        for (Character soldier : Defence) {
            if(soldier.warHealth>0){

                int currdef = soldier.defense;
                if (currdef < lowDef) {
                    lowDef = currdef;
                    weak = soldier;
                }else if (currdef==lowDef){
                    //when defence values are equal, find weakest
                    if((soldier.getType()=="Healer" )){
                        weak=soldier;
                    } else if (weak.getType()=="Mythical Creature" && !(soldier.getType()=="Knight" || soldier.getType()=="Mage" ||soldier.getType()=="Archer"  )) {
                        weak=soldier;
                    }
                    else if(weak.getType()=="Archer" && !(soldier.getType()=="Knight" || soldier.getType()=="Mage" ) ){
                        weak=soldier;
                    }else if(weak.getType()=="Knight" && !(soldier.getType()=="Mage")){
                        weak=soldier;
                    }else if(soldier.getType() !="Mage" && weak.getType()== "Mage"){
                        weak=soldier;
                    }
                }
            }

        }

        return weak;
    }
    public static   Character findLH(Character[] offence) {

        double lowH = offence[0].warHealth;
        Character weak = offence[0];

        for (Character soldier : offence) {
            if(soldier.warHealth>0){
                double hlt = soldier.warHealth;
                if (hlt < lowH) {
                    lowH = hlt;
                    weak = soldier;
                }}

        }return weak;
    }
    public static Character[] sortOffence(Character[] offence) {
        for (Character i : offence) {

        }

        for (int i = 0; i < 4; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < 5; j++) {
                // Compare speeds
                if (offence[j].getSpeed() > offence[maxIndex].getSpeed()) {
                    maxIndex = j;
                } else if (offence[j].getSpeed() == offence[maxIndex].getSpeed()) {
                    // If speeds are equal, apply additional conditions
                    // Swap if the current offence is a higher priority
                    if (priority(offence[j]) < priority(offence[maxIndex])) {
                        maxIndex = j;
                    }
                }
            }
            // Swap elements
            Character temp = offence[i];
            offence[i] = offence[maxIndex];
            offence[maxIndex] = temp;
        }

        return offence;
    }

    // Additional method to determine priority based on type
    private static int priority(Character character) {
        String type = character.getType();
        if (type.equals("Archer")) {
            return 4;
        } else if (type.equals("Knight")) {
            return 3;
        } else if (type.equals("Mythical Creature")) {
            return 2;
        } else if (type.equals("Mage")) {
            return 1;
        } else {
            return 0; // Default priority for other types
        }
    }

    public static Character [] setGround(Character []army,String ground){
        for(Character soldier:army){
            if(ground=="Hillcrest"){

                if(soldier.tribe=="Highlanders"){
                    soldier.setDefense(soldier.getDefense()+1);
                    soldier.setAttack(soldier.getAttack()+1);
                    soldier.isgroundhelp=true;
                } else if (soldier.tribe=="Marshlanders" || soldier.tribe=="Sunchildren") {
                    soldier.setSpeed(soldier.getSpeed()-1);

                }

            } else if (ground=="Marshland") {

                if(soldier.tribe=="Marshlanders"){
                    soldier.setDefense(soldier.getDefense()+2);
                } else if (soldier.tribe=="Sunchildren") {
                    soldier.setAttack(soldier.getAttack()-1);
                } else if (soldier.tribe=="Mystics") {
                    soldier.setSpeed(soldier.getSpeed()-1);
                }

            } else if (ground=="Desert") {

                if (soldier.tribe=="Sunchildren"){
                    soldier.setAttack(soldier.getAttack()+1);
                } else if (soldier.tribe=="Marshlanders") {
                    soldier.setwarHealth(soldier.getHealth()-1);
                }

            }else if (ground=="Arcane"){

                if (soldier.tribe =="Mystics"){
                    soldier.setAttack(soldier.getAttack()+2);
                    soldier.isgroundhelp=true;
                } else if (soldier.tribe=="Highlanders" ||soldier.tribe=="Marshlanders") {
                    soldier.setSpeed(soldier.getSpeed()-1);
                }
            }
        }return army;
    }
    public static boolean isallalive(Character [] army){
        //boolean alive=false;
        for(Character soldier:army){

            if(soldier.warHealth>0){
                //alive=true;
                return true;
            }
        }return false;
    }

    public static void turn (Character[]offence, Character [] Defence,BufferedWriter writer,Character soldier){
        try{
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            //sort according to speed
            offence=sortOffence(offence);

            //for (Character soldier : offence) {

                if(soldier.type!="Healer" && soldier.warHealth>0){
                    //find weakest
                    Character enemy=findweak(Defence);
//                    if(enemy.warHealth<=0){
//
//                        continue;
//                    }
                    System.out.println(soldier.getName()+" attackes "+enemy.getName());
                    writer.write(soldier.getName()+" attackes "+enemy.getName()+"\n");
                    double health;

                    enemy.beingAttacked(soldier);

                    health=enemy.warHealth;
                    String formatted_enemyHealth = decimalFormat.format(enemy.warHealth);
                    String formatted_soldierhealth = decimalFormat.format(soldier.warHealth);


                    System.out.println(enemy.getName()+"'s health "+formatted_enemyHealth);
                    writer.write(enemy.getName()+"'s health "+formatted_enemyHealth+"\n");

                    if(enemy.warHealth==0){
                        System.out.println(enemy.getName()+"is Dead !");

                        writer.write(enemy.getName()+"is Dead !");
                    }
                    System.out.println(soldier.getName()+"'s health "+formatted_soldierhealth);
                    writer.write(soldier.getName()+"'s health "+formatted_soldierhealth+"\n");

                    enemy.setwarHealth(health);
                }
                else if(soldier.type=="Healer" && soldier.warHealth>0 ){
                    //find fellow with lowest health
                    Character friend=findLH( offence) ;
                    if(friend.type!="Healer"){
                        friend=friend.healing(soldier);



                        System.out.println(soldier.getName()+" heals "+friend.getName());
                        writer.write(soldier.getName()+" heals "+friend.getName()+"\n");

                        System.out.println(friend.getName()+"'s health "+ friend.warHealth);
                        writer.write(friend.getName()+"'s health "+ friend.warHealth+"\n");

                        System.out.println(soldier.getName()+"'s health "+ soldier.warHealth);
                        writer.write(soldier.getName()+"'s health "+ soldier.warHealth+"\n");
                    }}
            }
        catch (Exception e){

        }
    }

    public static int start(Character[]offence, Character [] Defence,String ofName,String deName,String HomeGround) {



        offence = setGround(offence, HomeGround);
        Defence = setGround(Defence, HomeGround);
        boolean allaliveOffence = true;
        boolean allaliveDefence = true;



        try {
            File battle = new File("game_war_result.txt");
            FileOutputStream fos = new FileOutputStream(battle,true);

            // Create a BufferedWriter to write characters to the FileOutputStream
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

            // Write the content to the file
            writer.write("\nWar begins !!!"+ "\n");
            writer.write("-------------------------\n");
            System.out.println("-------------------------");
            System.out.println("   ___    ");
            System.out.println("  [ _ ] ");
            System.out.println("   | |   ");
            System.out.println("   | |   ");
            System.out.println("   | |   ");
            System.out.println(" {=====}             ");
            System.out.println("  |   |               ");
            System.out.println("  | | |               ");
            System.out.println("  | | |               ");
            System.out.println("  | | |               ");
            System.out.println("  | | |               ");
            System.out.println("  | | |               ");
            System.out.println("  | | |               ");
            System.out.println("  |   |               ");
            System.out.println("   \\ /                 ");
            System.out.println("    '             ");

            writer.write("   ___   \n");
            writer.write("  [ _ ] \n");
            writer.write("   | |  \n");
            writer.write("   | |  \n");
            writer.write("   | |  \n");
            writer.write(" {=====}     \n");
            writer.write("  |   |      \n");
            writer.write("  | | |       \n");
            writer.write("  | | |       \n");
            writer.write("  | | |       \n");
            writer.write("  | | |       \n");
            writer.write("  | | |       \n");
            writer.write("  | | |       \n");
            writer.write("  |   |        \n");
            writer.write("   \\ /        \n");
            writer.write("    '        \n");
            // Close the BufferedWriter to flush and close the stream


            for (int i = 0; i < 10; i++) {

                // boolean end=false;
                System.out.println("============================================");
                writer.write("============================================");
                System.out.println("\n" + "#---Turn" + (i + 1)+"---#" + "\n-----------------\n\t" + ofName + "\n-----------------\n");

                writer.write("\n" + "#---Turn" + (i + 1)+"---#"+ "\n-----------------\n\t" + ofName + "\n-----------------\n");

                offence=sortOffence(offence);
                Defence=sortOffence(Defence);
                allaliveOffence = isallalive(offence);
                allaliveDefence = isallalive(Defence);
                if (allaliveOffence && allaliveDefence) {

                    turn(offence, Defence, writer,offence[0]);

                    System.out.println("\n-----------------\n" + deName + "\n-----------------\n");
                    writer.write("\n-----------------\n" + deName + "\n-----------------\n");


                    turn(Defence, offence, writer,Defence[0]);
                    groundeffects(offence);
                    groundeffects(Defence);

                } else {
                    break;
                }

            }


            for (Character soldier : offence) {

                soldier.setwarHealth(soldier.getHealth()) ;
                soldier.isDead = false;
              //  System.out.println(soldier.getHealth()+"  war");
                soldier.setAttack(soldier.OriginalAttack);
                soldier.setDefense(soldier.originalDefecne);
                soldier.setSpeed(soldier.originalSpeed);

            }
            for (Character soldier : Defence) {

                soldier.setwarHealth(soldier.getHealth()) ;

                soldier.isDead = false;
                soldier.setAttack(soldier.OriginalAttack);
                soldier.setDefense(soldier.originalDefecne);
                soldier.setSpeed(soldier.originalSpeed);

            }
            //if player do not win
            if ((allaliveDefence && allaliveOffence)) {
                System.out.println(ofName + " and " + deName + " draw !");
                writer.write(ofName + " and " + deName + " draw !");
                writer.close();
                return 2;
            } else if (allaliveDefence) {
                System.out.println(deName + "Wins !");
                writer.write(deName + "Wins !");
                writer.close();
                return 1;
            }
            //if player win
            else {
                System.out.println(ofName + "Wins !");
                writer.write(ofName + "Wins !\n\n");
                writer.write("============================================");
                System.out.println("============================================");
                writer.close();
                return 0;
            }


        } catch (IOException e) {

        }return 0;
    }
}