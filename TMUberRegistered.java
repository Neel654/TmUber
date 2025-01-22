//name:Vishv Raval
//Student Id:501262536
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TMUberRegistered
{
    // These variables are used to generate user account and driver ids
    private static int firstUserAccountID = 900;
    private static int firstDriverId = 700;

    // Generate a new user account id
    public static String generateUserAccountId(ArrayList<User> currUsr)
    {
        return "" + firstUserAccountID + currUsr.size();
    }

    // Generate a new driver id
    public static String generateDriverId(ArrayList<Driver> curr)
    {
        return "" + firstDriverId + curr.size();
    }

    // Database of Preregistered users
    // In Assignment 2 these will be loaded from a file
    // The test scripts and test outputs included with the skeleton code use these
    // users and drivers below. You may want to work with these to test your code (i.e. check your output with the
    // sample output provided). 

    // For both methods, a filename is used to load the file
    // A scanner is used to iterate inside the files
    // generateId methods are used to generate respective account ids
    // new User/Driver is created
    // new User/Driver is added to the respective arraylists
    public static ArrayList<User> loadPreregisteredUsers(String filename) throws IOException
    {
        ArrayList<User> userList=new ArrayList<>();
        File fn=new File(filename);
        Scanner sc=new Scanner(fn);
        while (sc.hasNextLine()) {
            String name=sc.nextLine();
            String address=sc.nextLine();
            double wallet=Double.parseDouble(sc.nextLine());
            User newusr=new User(generateUserAccountId(userList), name, address, wallet);
            userList.add(newusr);
        }
        sc.close();
        return userList;
    }

    // Database of Preregistered users
    // In Assignment 2 these will be loaded from a file
    public static ArrayList<Driver> loadPreregisteredDrivers(String filename) throws FileNotFoundException
    {
        ArrayList<Driver> Drv=new ArrayList<>();
        File fn=new File(filename);
        Scanner sc=new Scanner(fn);
        while (sc.hasNextLine()) {
            String name=sc.nextLine();
            String carModel=sc.nextLine();
            String licensePlate=sc.nextLine();
            String address=sc.nextLine();
            Driver drv=new Driver(generateDriverId(Drv), name, carModel, licensePlate, address);
            Drv.add(drv);
        }
        sc.close();
        return Drv;
    }
}

