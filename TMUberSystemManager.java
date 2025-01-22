//name:Vishv Raval
//Student Id:501262536
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.Map;
/*
 * 
 * This class contains the main logic of the system.
 * 
 *  It keeps track of all users, drivers and service requests (RIDE or DELIVERY)
 * 
 */
public class TMUberSystemManager
{
  private TreeMap<String,User> usrs;
  private ArrayList<Driver> drvs;
  private ArrayList<User> userList;
  private Queue<TMUberService>[] ListOfService; 

  public double TotalRev; // Total revenues accumulated via rides and deliveries
  
  // Rates per city block
  private static final double DELIVERYRATE = 1.2;
  private static final double RIDERATE = 1.5;
  // Portion of a ride/delivery cost paid to the driver
  private static final double PAYRATE = 0.1;

  //These variables are used to generate user account and driver ids
  int userAccountId = 900;
  int driverId = 700;

  @SuppressWarnings("unchecked")
  public TMUberSystemManager() 
  {
    usrs=new TreeMap<>();
    drvs=new ArrayList<>();
    ListOfService=(Queue<TMUberService>[])new Queue[4];
    for(int i=0;i<4;i++){
      ListOfService[i]=new LinkedList<TMUberService>();
    }
    TotalRev=0;

    //users   = TMUberRegistered.loadPreregisteredUsers(users);
    //drivers = TMUberRegistered.loadPreregisteredDrivers(drivers);
    //service = new ArrayList<TMUberService>(); 
    
    //TMUberRegistered.loadPreregisteredUsers(users);
    //TMUberRegistered.loadPreregisteredDrivers(drivers);
    userList=new ArrayList<>();

    for(User a:usrs.values()){

      userList.add(a);
    }
    //totalRevenue = 0;
  }

  // General string variable used to store an error message when something is invalid 
  // (e.g. user does not exist, invalid address etc.)  
  // The methods below will set this errMsg string and then return false
  String errorrMsg = null;

  public String getErrorMessage()
  {
    return errorrMsg;
  }
  
  // Given user account id, find user in list of users
  // Return null if not found
  public void setUserList(ArrayList<User> lst)
  {
    userList=lst;
  }
  public void setUsers(ArrayList<User> lst){
    for(User i:lst)
    {
      usrs.put(i.getAccountId(), i);
    }
  }
  
  public void setDrivers(ArrayList<Driver> drvList)
  {
    this.drvs=drvList;
  }
  public User getUser(String acc)
  {
    // Fill in the code
    // I used for each loop to iterate over every users until accountId is matched
    for(User i:usrs.values()){
      if(i.getAccountId().equals(acc)){
        return i;
      }
      else{
        continue;
      }
    }
    return null;
  }
  
  // Check for duplicate user
  private boolean userExists(User u)
  {
    // Fill in the code
    // created a flag here
    boolean flg=false;
    for(User i:usrs.values()){
      // this equals method is defined in user class
      if(u.equals(i)){
        flg=true;
      }
      continue;
    }
    // if user is found, then return true
    if(flg==true){
      return true;
    }
    // if user is not found, then return false
    return false;
  }
  
 // Check for duplicate driver
 private boolean driverExists(Driver d)
 {
   // Fill in the code
   // a flag is set here
   boolean flg=false;
   for(Driver i:drvs){
    // this equals method is defined in driver class
     if(d.equals(i)){
       flg=true;
     }
     continue;
   }
   //if(match==false){
    //throw new DriverNotFoundException("Driver is not found");
  //}
   // if driver is found,then return true
   if(flg==true){
    return true;
  }
   // if driver is not found, then return false
   return false;
 }
  
  // Given a user, check if user ride/delivery request already exists in service requests
  private boolean existingRequest(TMUberService req)
  {
    // Fill in the code
    //String address=req.getFrom();
    //int zone=CityMap.getCityZone(address);
    //boolean match=false;
    for(int i=0;i<4;i++){
      // this equals method is defined in TMUberService and its subclasses
      
      for(TMUberService a:ListOfService[i]){
      if(a.equals(req)){
        return true;
      }
      else{
        continue;
      }
    }
    }
    return false;
    //if(match==true){
      //throw new RequestAlreadyExistsException("Request already exists in the system");
    //}
    
  }

  // Calculate the cost of a ride or of a delivery based on distance 
  private double getDeliveryCost(int distance)
  {
    return distance * DELIVERYRATE;
  }

  private double getRideCost(int distance)
  {
    return distance * RIDERATE;
  }

  // Go through all drivers and see if one is available
  // Choose the first available driver
  // Return null if no available driver
  private Driver getAvailableDriver()
  {
    // Fill in the code
    for(Driver i:drvs)
    {
      // status is called from the enum 
      // check if driver is available or driving
      if (i.getStatus()==Driver.Status.AVAILABLE){
        return i;
      }
      continue;
    }
    return null;
  }

  // Print Information (printInfo()) about all registered users in the system
  public void listAllUsers()
  {
    System.out.println();

    int idx=0;
    for(User i:usrs.values()){
      idx++;
      System.out.printf("%-2s. ", idx);
      i.printInfo();
      System.out.println();
    }
  }

  public void listAllUsers(ArrayList<User> u){
    for (int i = 0; i < u.size(); i++)
    {
      int idx = i + 1;
      System.out.printf("%-2s. ", idx);
      u.get(i).printInfo();
      System.out.println(); 
    }
  }

  // Print Information (printInfo()) about all registered drivers in the system
  public void listAllDrivers()
  {
    System.out.println();
    
    for (int i = 0; i < drvs.size(); i++)
    {
      int idx = i + 1;
      System.out.printf("%-2s. ", idx);
      // use the printInfo() method defined in driver class
      
      drvs.get(i).printInfo();
      System.out.println(); 
    }
    // Fill in the code
  }

  // Print Information (printInfo()) about all current service requests
  public void listAllservice()
  {
    System.out.println();
    
    for (int i = 0; i < ListOfService.length; i++)
    {
     
      int idx=0;
      System.out.println("ZONE "+i);
      System.out.println("======");
      System.out.println();
      for(TMUberService j:ListOfService[i]){
        idx=idx+1;
        System.out.printf("%-2s. %s", idx,"-".repeat(50));
        j.printInfo();
        System.out.println();
      } 
    }
    // Fill in the code
  }

  // Add a new user to the system
  public void registerNewUser(String nm, String addrr, double wallet)
  {
    // Fill in the code. Before creating a new user, check paramters for validity
    // See the assignment document for list of possible erros that might apply
    // Write the code like (for example):
    // If all parameter checks pass then create and add new user to array list users
    // Make sure you check if this user doesn't already exist!

    //here errMsg is set as the error message to be displayed according to the word file given
    if(CityMap.validAddress(addrr)==false)
    {
      //checked if the address is valid
      //errMsg="Invalid User Address";
      //return false;
      throw new InvalidAddressException("Invalid Address");
    }
    else if(nm.trim().length()==0 || nm.equals(null))
    {
      //checked if name is empty or null
      //errMsg="Invalid User Address";
      //return false;
      throw new InvalidUserException("Invalid User Name");
    }
    else if(wallet<0)
    {
      //checked if wallet is valid or not
      throw new InvalidWalletException("Invalid Wallet");
    }
    else
    {
      String usrId=TMUberRegistered.generateUserAccountId(userList);
      User uNew=new User(usrId, nm, addrr, wallet);
      //checked if user is already in the system or not
      if(userExists(uNew)==true)
      {
        throw new UserExistsException("User Already Exists in System");
        //returns false;
      }
      else
      {
        //if everything is valid, the user is added to the system
        userList.add(uNew);
        usrs.put(usrId, uNew);
        //returns true;
      }
    }

  }

  // Add a new driver to the system
  public void registerNewDriver(String nm, String carMdl, String licensePlate, String addrr)
  {
    // Fill in the code - see the assignment document for error conditions
    // that might apply. See comments above in registerNewUser
    if(!CityMap.validAddress(addrr))
    {
      throw new InvalidAddressException("Invalid Address");
    }
    if(nm.trim().length()==0 || nm.equals(null))
    {
     
      throw new InvalidDriverNameException("Invalid Driver Name");
    }
    else if(carMdl.trim().length()==0 || carMdl.equals(null))
    {
      
      throw new InvalidCarModelException("Invalid Car Model");
    }
    else if(licensePlate.trim().length()==0 || licensePlate.equals(null))
    {
      
      throw new InvalidCarLicensePlateException("Invalid Car Licence Plate");
    }
    else
    {
      String drvId=TMUberRegistered.generateDriverId(drvs);
      Driver dNew=new Driver(drvId, nm, carMdl, licensePlate,addrr);
      if(driverExists(dNew)==true){
       
        throw new DriverAlreadyExistsException("Driver Already Exists in System");
      }
    else{
    drvs.add(dNew);
    }
  }
    //return true;
  }

  // Request a ride. User wallet will be reduced when drop off happens
  public void requestRide(String accId, String from, String to)
  {
    // Check for valid parameters
	// Use the account id to find the user object in the list of users
    // Get the distance for this ride
    // Note: distance must be > 1 city block!
    // Find an available driver
    // Create the TMUberRide object
    // Check if existing ride request for this user - only one ride request per user at a time!
    // Change driver status
    // Add the ride request to the list of requests
    // Increment the number of rides for this user
    // check if the accountId is valid or not
    if(getUser(accId)==null)
    {
      throw new InvalidUserException("User Account Not Found");
      //return false;
    }
    User currUser=getUser(accId);
    TMUberRide currRequest=new TMUberRide(from, to, currUser, CityMap.getDistance(from, to), getRideCost(CityMap.getDistance(from, to)));
   
    if(existingRequest(currRequest))
    {
      throw new UserHasRequestException("User Already Has Ride Request");
    }

    else if(currUser.getWallet()<getRideCost(CityMap.getDistance(from, to)))
    {
    
      throw new InsufficientFundsException("Insufficient Funds");
    }
     
    else if(CityMap.validAddress(from)==false || CityMap.validAddress(to)==false)
    {
      
      throw new InvalidAddressException("Invalid Address");
    }
    else if(CityMap.getDistance(from, to)<=1)
    {
      
      throw new InsufficientTravelDistanceException("Insufficient Travel Distance");
    }
    
    else
    {
      int ZONE=CityMap.getCityZone(from);
      ListOfService[ZONE].add(currRequest);
      currUser.addRide();
      
    }
    
  }

  // Request a food delivery. User wallet will be reduced when drop off happens
  public void requestDelivery(String accId, String from, String to, String restaurant, String orderId)
  {
    // See the comments above and use them as a guide
    // For deliveries, an existing delivery has the same user, restaurant and food order id
    // Increment the number of deliveries the user has had
    User currUser=null;
    if(getUser(accId)==null)
    {
      //check if the accountId is valid
      throw new InvalidUserException("User Account Not Found");
      
    }
    currUser=getUser(accId);
    // used CityMap class and its methods to verify the address and get the distance
    if(CityMap.validAddress(from)==false || CityMap.validAddress(to)==false)
    {
      throw new InvalidAddressException("Invalid Address");
      
    }
    int DST=CityMap.getDistance(from, to);
    if(DST<=1){
      throw new InsufficientTravelDistanceException("Insufficient Travel Distance");
      
    }
    // check if restaurant name is empty or null
    if((restaurant.trim().length()==0)|| restaurant.equals(null))
    {
      throw new InvalidRestaurantException("Restaurant name is not valid");
      
    }
    // check if foodOrderId is empty or null
    if(orderId.trim().length()==0||orderId.equals(null))
    {
      throw new InvalidOrderIDException("Food Order ID is not valid");
      
    }
    // check if the user has enough money for the ride
    // used the getDistance() method defined earlier
    if(currUser.getWallet()<getRideCost(CityMap.getDistance(from, to)))
    {
      throw new InsufficientFundsException("Insufficient Funds");
      
    }
    // checked if any driver is available or not
    // check if the request already exists
    //Driver availableDriver=getAvailableDriver();
    TMUberDelivery currRequest= new TMUberDelivery(from, to, currUser, DST, getDeliveryCost(DST), restaurant, orderId);
      if(existingRequest(currRequest)==true)
      {
        throw new UserHasRequestException("User Already Has Delivery Request at Restaurant with this Food Order");
      }
    // if everything is valid, the driver's status is set to driving and the request is added to the system
 
    int zn=CityMap.getCityZone(from);
    ListOfService[zn].add(currRequest);
    // the number of deliveries for the user is increased
    currUser.addDelivery();

    
  }


  // Cancel an existing service request. 
  // parameter int request is the index in the service array list
  public void cancelServiceRequest(int zn,int rqst)
  {
    // Check if valid request #
    // Remove request from list
    // Also decrement number of rides or number of deliveries for this user
    // since this ride/delivery wasn't completed

    // check if the request number is valid
    // 1<=request #<= size of the arraylist service
    // errMsg is set if the request number is out of bounds
    if(zn<0 || zn>3)
    {
      throw new InvalidZoneException("Invalid Zone");
    }
    if(rqst>(ListOfService[zn].size())||rqst<1){
      throw new InvalidRequestException("Invalid Request #");
      
    }
    // get the request to be cancelled from arraylist
    Queue<TMUberService> tmp=new LinkedList<TMUberService>(ListOfService[zn]);
    for(int i=0;i<rqst-1;i++){
      tmp.poll();
    }
    TMUberService t=tmp.peek();

    // get the specific user
    User usr=t.getUser();
    // the number of delivery or ride of the user is decremented depending on the type of service cancelled
    if (t.getServiceType().equals("RIDE"))
    {
      usr.decrementRide();
    }
    else{
      usr.decrementDelivery();
    }
    
    ListOfService[zn].remove(t);
   
  }
  public Driver getDriver(String drvId)
  {
    for(Driver i:drvs){
      if(i.getId().equals(drvId)){
        return i;
      }
    }
    return null;
  }
  // Drop off a ride or a delivery. This completes a service.
  // parameter request is the index in the service array list
  public void pickUp(String drvid)
  {
    Driver d=getDriver(drvid);
    if(d==null)
    {
      throw new DriverNotFoundException("Invalid Driver ID");
    }
    else if(d.getStatus()==Driver.Status.DRIVING)
    {
      throw new DrivingException("Driver is already driving");
    }
    int zn=d.getZone();
    if(ListOfService[zn].size()==0)
    {
      throw new NoRequestFound("No Service Request in Zone "+zn);
    }
    else
    {
    TMUberService S=ListOfService[zn].poll();
    String from=S.getFrom();
    d.updateService(S);
    d.setAddress(from);
    d.setStatus(Driver.Status.DRIVING);}
  }
  public void dropOff(String drvid)
  {
    // See above method for guidance
    // Get the cost for the service and add to total revenues
    // Pay the driver
    // Deduct driver fee from total revenues
    // Change driver status
    // Deduct cost of service from user
    Driver d=getDriver(drvid);
    if(d==null)
    {
      throw new DriverNotFoundException("Invalid Driver ID");
    }
    TMUberService s=d.getService();
    if(s==null)
    {
      throw new DropoffException("This driver has no dropoff");
    }
    //check if the request number is valid or not
    //the range of request number is from 1 to length of the arraylist service
    //get the specific service for dropoff
   // get the driver for the service
    // get the user for the service
    else
    {
    User usr=s.getUser();

    // get the cost for the service
    double cost=s.getCost();

    // cost is deducted from the wallet of user
    usr.payForService(cost);

    // the revenue is increased
    TotalRev=TotalRev+cost;

    // driver is paid according to the rate
    double drvEarnings=cost*PAYRATE;
    d.pay(drvEarnings);

    // deduct the driver payment from total revenue
    TotalRev=TotalRev-drvEarnings;

    // driver is made available again
    d.setAddress(s.getTo());
    d.setStatus(Driver.Status.AVAILABLE);
  }
    // the request is removed from the arraylist of service requests
    
  }
  public void driveTo(String drvid,String addrr){
    Driver d=getDriver(drvid);
    if(d==null)
    {
      throw new DriverNotFoundException("Invalid Driver ID");
    }
    else if(!CityMap.validAddress(addrr)){
      throw new InvalidAddressException("Invalid Address");
    }
    else if(d.getStatus()==Driver.Status.DRIVING){
      throw new DrivingException("Driver is not available");
    }
    else{
      d.setAddress(addrr);
    }
  }

  // Sort users by name
  // Then list all users
  // In both sort methods of users, I used the arrayList to sort
  public void sortByUserName()
  {
    // the arraylist is sorted here using the helper class
   Collections.sort(userList, new NameComparator());
   listAllUsers(userList); 
  }

  // Helper class for method sortByUserName
  //interface is used here to compare
  private class NameComparator implements Comparator<User>
  {
    public int compare(User a,User b){
      return a.getName().compareTo(b.getName());
    }
  }

  // Sort users by number amount in wallet
  // Then list all users
  
  public void sortByWallet()
  {
    // the arraylist is sorted here using the helper class
    Collections.sort(userList, new UserWalletComparator());
    listAllUsers(userList);
  }
  // Helper class for use by sortByWallet
  //interface is used here to compare
  private class UserWalletComparator implements Comparator<User>
  {
    public int compare(User a,User b){
      if(a.getWallet()<b.getWallet()){return -1;}
      if(a.getWallet()>b.getWallet()){return 1;}
      return 0;
    }
  }

  // Sort trips (rides or deliveries) by distance
  // Then list all current service requests
  public void sortByDistance()
  {
    //the arraylist is sorted here using the compareTo method defined in TMUberService
    for(Queue<TMUberService> i:ListOfService){
      //I made a temp arrayList to sort the queue by clearing the queue and adding in a sorted way
    List<TMUberService> tmp=new ArrayList<>(i);
    Collections.sort(tmp);
    i.clear();
    i.addAll(tmp);
    }
    listAllservice();
  }
}

// From here to the end, there are classes of custom exceptions
class DriverNotFoundException extends RuntimeException{
    public DriverNotFoundException(){}
    public DriverNotFoundException(String MESSAGES){
      super(MESSAGES);
    }
}
class RequestAlreadyExistsException extends RuntimeException{
  public RequestAlreadyExistsException(){};
  public RequestAlreadyExistsException(String MESSAGE){
    super(MESSAGE);
  }
}
class InvalidAddressException extends RuntimeException{
  public InvalidAddressException(){};
  public InvalidAddressException(String MESSAGE){
    super(MESSAGE);
  }
}
class InsufficientFundsException extends RuntimeException{
  public InsufficientFundsException(){};
  public InsufficientFundsException(String MESSAGE){
    super(MESSAGE);
  }
}
class DriverAlreadyExistsException extends RuntimeException{
  public DriverAlreadyExistsException(){};
  public DriverAlreadyExistsException(String MESSAGE){
    super(MESSAGE);
  }
} 
class IllegalUserNameException extends RuntimeException{
  public IllegalUserNameException(){};
  public IllegalUserNameException(String MESSAGE){
    super(MESSAGE);
  }
}
class InvalidMoneyException extends RuntimeException{
  public InvalidMoneyException(){};
  public InvalidMoneyException(String MESSAGE){
    super(MESSAGE);
  }
}
class UserExistsException extends RuntimeException{
  public UserExistsException(){};
  public UserExistsException(String MESSAGE){
    super(MESSAGE);
  }    
}
class InvalidDriverNameException extends RuntimeException{
  public InvalidDriverNameException(){};
  public InvalidDriverNameException(String MESSAGE){
    super(MESSAGE);
  }
}
class InvalidCarModelException extends RuntimeException{
  public InvalidCarModelException(){};
  public InvalidCarModelException(String MESSAGE){
    super(MESSAGE);
  }
}
class InvalidUserException extends RuntimeException{
  public InvalidUserException(){};
  public InvalidUserException(String MESSAGE){
    super(MESSAGE);
    }
}
class TravelDistanceException extends RuntimeException{
  public TravelDistanceException(){};
  public TravelDistanceException(String MESSAGE){
    super(MESSAGE);
  }
}
class InvalidWalletException extends RuntimeException{
  public InvalidWalletException(){};
  public InvalidWalletException(String MESSAGE){
    super(MESSAGE);
  }
}
class InvalidRequestException extends RuntimeException{
  public InvalidRequestException(){};
  public InvalidRequestException(String MESSAGE){
    super(MESSAGE);
  }
}
class UserHasRequestException extends RuntimeException{
  public UserHasRequestException(){};
  public UserHasRequestException(String MESSAGE){
    super(MESSAGE);
  }
}
class InvalidCarLicensePlateException extends RuntimeException{
  public InvalidCarLicensePlateException(){};
  public InvalidCarLicensePlateException(String MESSAGE){
    super(MESSAGE);
  }
}
class InvalidOrderIDException extends RuntimeException{
  public InvalidOrderIDException(){};
  public InvalidOrderIDException(String MESSAGE){
    super(MESSAGE);
  }
}
class InsufficientTravelDistanceException extends RuntimeException{
  public InsufficientTravelDistanceException(){};
  public InsufficientTravelDistanceException(String MESSAGE){
    super(MESSAGE);  
  }
}
class InvalidRestaurantException extends RuntimeException{
  public InvalidRestaurantException(){};
  public InvalidRestaurantException(String MESSAGE){
    super(MESSAGE);
  }
}
class DrivingException extends RuntimeException{
  public DrivingException(){};
  public DrivingException(String MESSAGE){
    super(MESSAGE);
  }
}
class NoRequestFound extends RuntimeException{
  public NoRequestFound(){};
  public NoRequestFound(String MESSAGE){
    super(MESSAGE);
}
}
class DropoffException extends RuntimeException{
  public DropoffException(){};
  public DropoffException(String MESSAGE){
    super(MESSAGE);
  }
}
class InvalidZoneException extends RuntimeException{
  public InvalidZoneException(){};
  public InvalidZoneException(String MESSAGE){
    super(MESSAGE);
  }
}