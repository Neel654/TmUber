//name:Vishv Raval
//Student Id:501262536
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;
// Simulation of a Simple Command-line based Uber App 

// This system supports "ride sharing" service and a delivery service

public class TMUberUI 
{
  public static void main(String[] args)
  {
    // Create the System Manager - the main system code is in here 

    TMUberSystemManager tmuber = new TMUberSystemManager();
    
    Scanner sc = new Scanner(System.in);
    System.out.print(">");

    // Process keyboard actions
    while (sc.hasNextLine())
    {
      String actn = sc.nextLine();

      if (actn == null || actn.equals("")) 
      {
        System.out.print("\n>");
        continue;
      }
      // Quit the App
      else if (actn.equalsIgnoreCase("Q") || actn.equalsIgnoreCase("QUIT"))
        return;
      // Print all the registered drivers
      else if (actn.equalsIgnoreCase("DRIVERS"))  // List all drivers
      {
        tmuber.listAllDrivers(); 
      }
      // Print all the registered users
      else if (actn.equalsIgnoreCase("USERS"))  // List all users
      {
        tmuber.listAllUsers(); 
      }
      // Print all current ride requests or delivery requests
      else if (actn.equalsIgnoreCase("REQUESTS"))  // List all requests
      {
        tmuber.listAllservice(); 
      }
      // Register a new driver
      else if (actn.equalsIgnoreCase("REGDRIVER")) 
      {
        String name = "";
        System.out.print("Name: ");
        if (sc.hasNextLine())
        {
          name = sc.nextLine();
        }
        String carModel = "";
        System.out.print("Car Model: ");
        if (sc.hasNextLine())
        {
          carModel = sc.nextLine();
        }
        String license = "";
        System.out.print("Car License: ");
        if (sc.hasNextLine())
        {
          license = sc.nextLine();
        }
        String address ="";
        System.out.print("Address :");
        if(sc.hasNextLine()){
          address=sc.nextLine();
        }
        try{
          tmuber.registerNewDriver(name, carModel, license, address);
          System.out.printf("Driver: %-15s Car Model: %-15s License Plate: %-10s Address %-20s", name, carModel, license, address);
        }catch(RuntimeException expt){
          System.out.println(expt.getMessage());
        }
      }
      // Register a new user
      else if (actn.equalsIgnoreCase("REGUSER")) 
      {
        String name = "";
        System.out.print("Name: ");
        if (sc.hasNextLine())
        {
          name = sc.nextLine();
        }
        String address = "";
        System.out.print("Address: ");
        if (sc.hasNextLine())
        {
          address = sc.nextLine();
        }
        double wallet = 0.0;
        System.out.print("Wallet: ");
        if (sc.hasNextDouble())
        {
          wallet = sc.nextDouble();
          sc.nextLine(); // consume nl!! Only needed when mixing strings and int/double
        }
        try{
          tmuber.registerNewUser(name, address, wallet);
          System.out.printf("User: %-15s Address: %-15s Wallet: %2.2f", name, address, wallet);
        }
        catch(RuntimeException e){
          System.out.println(e.getMessage());
        }
      }
      // Request a ride
      else if (actn.equalsIgnoreCase("REQRIDE")) 
      {
        // Get the following information from the user (on separate lines)
        // Then use the TMUberSystemManager requestRide() method properly to make a ride request
        // "User Account Id: "      (string)
        // "From Address: "         (string)
        // "To Address: "           (string)
        String accountID="";
        String fromAddress="";
        String toAddress="";
        // I used scanner to read input from the user
        System.out.print("User Account Id: ");
        if(sc.hasNextLine())
        {
        accountID=sc.nextLine();
        }
        System.out.print("From Address: ");
        if(sc.hasNextLine())
        {
        fromAddress=sc.nextLine();

        }
        System.out.print("To Address: ");
        if(sc.hasNextLine())
        {
        toAddress=sc.nextLine();
        }
        try
        {
          String name=tmuber.getUser(accountID).getName();
          tmuber.requestRide(accountID, fromAddress, toAddress);
          System.out.println();
          System.out.printf("RIDE for: %-9s From: %-15s To: %-15s", name, fromAddress, toAddress);
        }
        catch(RuntimeException excpt)
        {
          System.out.println(excpt.getMessage());
        }
        //if input is notvalid, error message will show up

      }
      // Request a food delivery
      else if (actn.equalsIgnoreCase("REQDLVY")) 
      {
        // Get the following information from the user (on separate lines)
        // Then use the TMUberSystemManager requestDelivery() method properly to make a ride request
        // "User Account Id: "      (string)
        // "From Address: "         (string)
        // "To Address: "           (string)
        // "Restaurant: "           (string)
        // "Food Order #: "         (string)
        String accountID="";
        String fromAddress="";
        String toAddress="";
        String Restaurant="";
        String orderId="";
        // I used scanner to take input from the user
        System.out.print("User Account Id: ");
        if(sc.hasNextLine())
        {
        accountID=sc.nextLine();
        }
        System.out.print("From Address: ");
        if(sc.hasNextLine())
        {
        fromAddress=sc.nextLine();
        }
        System.out.print("To Address: ");
        if(sc.hasNextLine())
        {
        toAddress=sc.nextLine();
        }
        System.out.print("Restaurant: ");
        if(sc.hasNextLine())
        {
        Restaurant=sc.nextLine();
        }
        System.out.print("Food Order #: ");
        if(sc.hasNextLine())
        {
        orderId=sc.nextLine();
        }
        // if the request is not valid, error message shows up

        try{
          // if the request is valid, the request is accepted and request is printed
          String name=tmuber.getUser(accountID).getName();
          tmuber.requestDelivery(accountID, fromAddress, toAddress, Restaurant, orderId);
          System.out.println();
          System.out.printf("DELIVERY for: %-9s From: %-15s To: %-15s", name, fromAddress, toAddress);
        }
        catch(RuntimeException exept)
        {
          System.out.println(exept.getMessage());
        }
      }
      // Sort users by name
      else if (actn.equalsIgnoreCase("SORTBYNAME")) 
      {
        tmuber.sortByUserName();
      }
      // Sort users by number of ride they have had
      else if (actn.equalsIgnoreCase("SORTBYWALLET")) 
      {
        tmuber.sortByWallet();
      }
      // Sort current service requests (ride or delivery) by distance
      else if (actn.equalsIgnoreCase("SORTBYDIST")) 
      {
        tmuber.sortByDistance();
      }
      // Cancel a current service (ride or delivery) request
      else if (actn.equalsIgnoreCase("CANCELREQ")) 
      {
        int zone=-1;
        int request = -1;
        System.out.print("Zone: ");
        if(sc.hasNextInt())
        {
          zone=sc.nextInt();
          sc.nextLine();
        }
        System.out.print("Request #: ");
        if (sc.hasNextInt())
        {
          request = sc.nextInt();
          sc.nextLine(); // consume nl character
        }
        try
        {
          tmuber.cancelServiceRequest(zone, request);
          System.out.println("Zone :"+zone+" Service request #"+request+" cancelled");
        }
        catch(RuntimeException exept)
        {
          System.out.println(exept.getMessage());
        }
      }
      // Drop-off the user or the food delivery to the destination address
      else if (actn.equalsIgnoreCase("DROPOFF")) 
      {
        String id="";
        System.out.print("Driver ID: ");
        if (sc.hasNextLine())
        {
          id = sc.nextLine();
        }
        try
        {
          tmuber.dropOff(id);
          System.out.println("Driver "+id+" Dropping Off");
        }
        catch(RuntimeException exept)
        {
          System.out.println(exept.getMessage());
        } 
      }
      // Get the Current Total Revenues
      else if (actn.equalsIgnoreCase("REVENUES")) 
      {
        System.out.println("Total Revenue: " + tmuber.TotalRev);
      }
      // Unit Test of Valid City Address 
      else if (actn.equalsIgnoreCase("ADDR")) 
      {
        String address = "";
        System.out.print("Address: ");
        if (sc.hasNextLine())
        {
          address = sc.nextLine();
        }
        System.out.print(address);
        if (CityMap.validAddress(address))
          System.out.println("\nValid Address"); 
        else
          System.out.println("\nBad Address"); 
      }
      // Unit Test of CityMap Distance Method
      else if (actn.equalsIgnoreCase("DIST")) 
      {
        String from = "";
        System.out.print("From: ");
        if (sc.hasNextLine())
        {
          from = sc.nextLine();
        }
        String to = "";
        System.out.print("To: ");
        if (sc.hasNextLine())
        {
          to = sc.nextLine();
        }
        System.out.print("\nFrom: " + from + " To: " + to);
        System.out.println("\nDistance: " + CityMap.getDistance(from, to) + " City Blocks");
      }
      else if (actn.equalsIgnoreCase("PICKUP")){
        System.out.print("Driver ID: ");
        String Driverid="";
        int zone=-1;
        if(sc.hasNextLine())
        {
          Driverid=sc.nextLine();
        }
        try
        {
          Driver driver=tmuber.getDriver(Driverid);
          tmuber.pickUp(Driverid);
          zone=driver.getZone();
          System.out.println("Driver "+Driverid+" Picking Up in Zone "+zone);
        }
        catch(RuntimeException exept)
        {
          System.out.println(exept.getMessage());
        }
      }
      // Loadusers is run here
      // it catches IOException
      // if error is FileNotFoundException, it prints a method
      // else it prints "Error" and the program shuts down
      else if(actn.equalsIgnoreCase("LOADUSERS")){
        System.out.print("User File :");
        String file="";
        if(sc.hasNextLine()){
        file=sc.nextLine();}
        try{
          ArrayList<User> userList=TMUberRegistered.loadPreregisteredUsers(file);
          tmuber.setUsers(userList);
          System.out.println("users loaded");
          tmuber.setUserList(userList);
        }
        catch(IOException exept){
          if(exept instanceof FileNotFoundException){
          System.out.println("Users File :"+file+" Not Found");
          }
          else{
            System.out.println("Error");
            System.exit(1);
          }
        }
        
      }
      // Here the loaddrivers is run
      // it catches IOException
      // if error is FileNotFoundException, it prints a method
      // else it prints "Error" and the program shuts down      
      else if(actn.equalsIgnoreCase("LOADDRIVERS")){
        System.out.print("Driver File :");
        String file="";
        if(sc.hasNextLine()){
        file=sc.nextLine();}
        try{
          ArrayList<Driver> driverList=TMUberRegistered.loadPreregisteredDrivers(file);
          tmuber.setDrivers(driverList);
          System.out.println("Drivers Loaded"); 
        }
        catch(IOException exept){
          if(exept instanceof FileNotFoundException){
          System.out.println("Users File :"+file+" Not Found");
          }
          else{
            System.out.println("Error");
            System.exit(1);
          }
        }  
             
      }
      // here the new DriveTo method is run
      else if(actn.equalsIgnoreCase("DRIVETO")){
        String id="";
        String address="";
        System.out.print("Driver ID: ");
        if(sc.hasNextLine()){
          id=sc.nextLine();
        }
        System.out.println("Address: ");
        if(sc.hasNextLine()){
          address=sc.nextLine();
        }
        try{
          tmuber.driveTo(id, address);
        }
        catch(RuntimeException ex){
          System.out.println(ex.getMessage());
        } 
      }
      System.out.print("\n>");
    }
  }
}

