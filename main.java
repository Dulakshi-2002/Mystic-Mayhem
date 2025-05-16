
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
public class main {/*

This is the main class all of the classes and objects control here,


*/
    // Add users to array list.

    static  ArrayList<player> Users=new ArrayList<player>();
    public static void  main(String[] args) {

        for(player i:Users) {
            System.out.println(i.getName());
        }
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println(" * WELCOME TO MYSTIC MAYHEM *  ");
        System.out.println("-----------------------------------");
        System.out.println();

        int play=1;
        player player2=new player();

        player2.setName("GeraltofRivia");
        player2.setUserName("whitewolf");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt",true))) {
            // Write data to the file
            writer.write(player2.getuserName());
            writer.newLine(); // Write a new line
            writer.write(player2.getName());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        player2.setHomeground("Marshland");
        player2.XP=32;
        player2.setGoldCoins(685);;
        player2.BuyArcher("Ranger");
        player2.BuyHealer("Medic");
        player2.BuyKnight("Squire");
        player2.BuyMages("Warlock");
        player2.BuyMythicalCreature("Dragon");

        player2.BuyArmour(26,"Ranger");
        player2.BuyArtefacts(30,"Medic");

        Users.add(player2);

        player player3=new player();

        player3.setName("Helga Battleborn");
        player3.setUserName("Thora Axebearer");
        player3.setHomeground("Hillcrest");
        player3.XP=30;
        player3.GoldCoins=1000;
        player3.BuyArcher("Sunfire");
        player3.BuyHealer("Alchemist");
        player3.BuyKnight("Cavalier");
        player3.BuyMages("Illusionist");
        player3.BuyMythicalCreature("Basilisk");

        player3.BuyArmour(27,"Cavalier");
        player3.BuyArtefacts(29,"Sunfire");

        Users.add(player3);

        player player4=new player();

        player4.setName("Olaf Thunderclaw");
        player4.setUserName("Astrid Firebrand");
        player4.setHomeground("Desert");
        player4.XP=27;
        player4.GoldCoins=950;
        player4.BuyArcher("Ranger");
        player4.BuyHealer("Medic");
        player4.BuyKnight("Templar");
        player4.BuyMages("Enchanter");
        player4.BuyMythicalCreature("Hydra");

        player4.BuyArmour(26,"Enchanter");

        Users.add(player4);

        System.out.println("Do you want to play game?If you want press 1");
        Scanner Obj00=new Scanner(System.in);
        play=Obj00.nextInt();
        player player1=new player();
        if(play==1) {

            System.out.println();

            System.out.println("Login");


            System.out.println();
            System.out.print("Enter Your Name : ");
            Scanner Obj1= new Scanner(System.in);
            player1.setName(Obj1.nextLine());

            System.out.println();
            System.out.print("Enter Your User Name : ");
            Scanner Obj2= new Scanner(System.in);
            player1.setUserName(Obj2.nextLine());
            List<String> lines = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {

                // Read each line from the file until the end
                String line;
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(lines.contains(player1.getuserName())) {
                System.out.println("This user name is already exist.");


                if(lines.get(lines.indexOf((player1.getuserName()))+1).equals(player1.getName()) ){
                    System.out.println("If you want to login, press 1");
                    Scanner log=new Scanner(System.in);
                    play = log.nextInt();}
                else {System.out.println("You have entered incorrect name or user name.");
                    play=0;}
            }else {


                try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt",true))) {
                    // Write data to the file
                    writer.write(player1.getuserName());
                    writer.newLine(); // Write a new line
                    writer.write(player1.getName());
                    writer.newLine();


                    writer.close();
                    File file = new File("users.txt");
                    player1.setUserId(file.length());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            //Users.add(player1);

        }

        while(play==1) {

            System.out.println("Select your homeground \n Hillcrest\n Marshland\n Desert\n Arcane\n");
            Scanner Obcj2= new Scanner(System.in);
            String home = Obcj2.nextLine();
            player1.setHomeground(home);


            System.out.println();
            System.out.println("You have "+player1.GoldCoins+" Gold Coins");
            System.out.println();

            System.out.println("Build your army with your gold coins!.You can have each one from 5 categories : Archer , Knights , Mages , Healers , Mythical creatures ");

            System.out.println();
            player1.show_shopArcher();

            System.out.println();
            player1.show_shopKnights();

            System.out.println();
            player1.show_shopMages();

            System.out.println();
            player1.show_shopHealers();

            System.out.println();
            player1.show_shopMythical_Creatures();



            int choise1=1;
            while(choise1==1) {
                System.out.print("Do you want to buy  equipment? \nPress 1 to buy\nPress 0 to skip.");
                Scanner Obj03= new Scanner(System.in);
                choise1=Obj03.nextInt();

                if (choise1!=1) {break;}

                System.out.println("Press 1 to buy armour.\nPress 2 to buy artefact");
                Scanner Obj001=new Scanner(System.in);
                int selector=Obj001.nextInt();

                if (selector==1) {
                    player1.show_Armour();
                    System.out.print("give the Armour number : ");
                    Scanner Obj01=new Scanner(System.in);
                    int eqp_list1=Obj01.nextInt();

                    while (eqp_list1 < 25 || eqp_list1 > 29) {
                        System.out.println("Enter a number in between 26 and 28 inclusive");
                        Scanner scanner = new Scanner(System.in);
                        eqp_list1 = Integer.parseInt(scanner.nextLine());
                    }
                    System.out.print("give the relevant character");
                    Scanner Obj011=new Scanner(System.in);
                    String eqp_list2=Obj011.nextLine();
                    player1.BuyArmour(eqp_list1, eqp_list2);}

                else if (selector == 2){
                    player1.show_Artefact();
                    System.out.print("give the Artefact number : ");
                    Scanner Obj011=new Scanner(System.in);

                    int eqp_list1=Obj011.nextInt();

                    while (eqp_list1 < 28 || eqp_list1 > 32) {
                        System.out.println("Enter a number in between 29 and 31 inclusive");
                        Scanner scanner = new Scanner(System.in);
                        eqp_list1 = Integer.parseInt(scanner.nextLine());
                    }
                    System.out.print("give the relevant character");
                    Scanner Obj0011=new Scanner(System.in);
                    String eqp_list2=Obj0011.nextLine();
                    player1.BuyArtefacts(eqp_list1, eqp_list2);
                }



            }
            System.out.println("#---------------------#");
            System.out.println("Select your opponent");
            //System.out.println("#---------------------#");
            int ran;
            while(true) {
                int min = 0; // Minimum value (inclusive)
                int max = 3; // Maximum value (exclusive)

                Random random = new Random();
                // Generate a random integer between min (inclusive) and max (exclusive)
                int randomNumber = random.nextInt(max - min) + min;
                System.out.println("#---------------------#");
                System.out.println("Opponent: " + Users.get(randomNumber).getuserName());
                System.out.println("Opponent's Army");
                System.out.println("  "+Users.get(randomNumber).Archer.getName());
                System.out.println("  "+Users.get(randomNumber).Knight.getName());
                System.out.println("  "+Users.get(randomNumber).Mage.getName());
                System.out.println("  "+Users.get(randomNumber).Healer.getName());
                System.out.println("  "+Users.get(randomNumber).Mythical_creature.getName());
                System.out.println("Opponent's XP");
                System.out.println("  "+Users.get(randomNumber).XP);
                System.out.println("#---------------------#");
                System.out.println("Battle or Skip\n Press 1 to Battle.Press 2 to Skip");

                Scanner sc =new Scanner(System.in);
                int n = sc.nextInt();
                if(n==1){
                    ran = randomNumber;
                    break;
                }
            }

            System.out.println();
            System.out.println("War Begins!!!");

            War newWar=new War();

//start new war.

            int result=newWar.start(player1.arr,Users.get(ran).arr,player1.getName(), Users.get(ran).getName(),player2.Homeground);

//Give xp , gold according to war result.
            if(result==0) {

                System.out.println(player1.getName()+"'s gold coins "+player1.update_goldCoins(0,Users.get(ran).GoldCoins));
                System.out.println(player1.getName()+"'s XP "+player1.update_XP(0));
                Users.get(ran).GoldCoins*=0.9;
                System.out.println(Users.get(ran).getName()+"'s gold coins "+Users.get(ran).update_goldCoins(1,player1.GoldCoins));
                System.out.println(Users.get(ran).getName()+"'s XP "+Users.get(ran).update_XP(1));

            }
            else if(result==1) {

                System.out.println(player1.getName()+"'s gold coins "+player1.update_goldCoins(1,Users.get(ran).GoldCoins));
                System.out.println(player1.getName()+"'s XP "+player1.update_XP(1));
                Users.get(ran).GoldCoins*=1.1;
                System.out.println(Users.get(ran).getName()+"'s gold coins "+Users.get(ran).update_goldCoins(0,player1.GoldCoins));
                System.out.println(Users.get(ran).getName()+"'s XP "+Users.get(ran).update_XP(0));
            }
            else {
                System.out.println(Users.get(ran).getName()+"'s gold coins "+Users.get(ran).update_goldCoins(2,player1.GoldCoins));
                System.out.println(Users.get(ran).getName()+"'s XP "+Users.get(ran).update_XP(2));
                System.out.println(player1.getName()+"'s gold coins "+player1.update_goldCoins(2,Users.get(ran).GoldCoins));
                System.out.println(player1.getName()+"'s XP "+player1.update_XP(2));
            }
            player1.arr=player1.reorderArray(player1.arr);
            System.out.println("Game over!!");
            System.out.println();

            System.out.println("Do you want to continue for the next round? Press 1 to continue else press 0");
            Scanner scan= new Scanner(System.in);
            int again=scan.nextInt();
            if(again==1){
                System.out.println("#+++++++++++++++++#");
                System.out.println("    NEXT ROUND");
                System.out.println("#+++++++++++++++++#");
            }
            else{
                break;
            }
        }

    }
}