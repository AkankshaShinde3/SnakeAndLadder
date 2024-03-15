package player;

import java.util.*;

public class Player {
    
    String name;
    String email;
    int age;
    long contact;
    String address;

    public void setInfo(String name, String email, int age, long contact, String address)
    {
        this.name = name;
        this.email = email;
        this.age = age;
        this.contact = contact;
        this.address = address;
    }

    public void getInfo()
    {
        System.out.println("Player : " + this.name);
        System.out.println("Email id of player : " + this.email);
        System.out.println("age : " + this.age);
        System.out.println("Contact : " + this.contact);
        System.out.println("Adress : " + this.address);
    }

     public void setPlayerDetailsFromUserInput (Player p) 
     {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the player details ");
        System.out.println("Enter the player name: ");
        String name = sc.nextLine();

        // System.out.println("Enter the player contact number: ");
        // String contactNo = scn.nextLine();
        // System.out.println("Eneter the player address: ");
        // String address = scn.nextLine();
        // System.out.println("Enter the player Email Id: ");
        // String emailID = scn.nextLine();

        System.out.println("Enter the player age ");
        int age = sc.nextInt();

        p.setPlayerDetails(name, age);
    }

    public void setPlayerDetails(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getPlayerName()
    {
        return this.name;
    }
}