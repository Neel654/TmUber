//name:Vishv Raval
//Student Id:501262536
/*
 * 
 * This class simulates a car driver in a simple uber app 
 * 
 * Everything has been done for you except the equals() method
 */

 // three new variables which are service,address and zone are added
public class Driver
{
  private String id;
  private String name;
  private String carModel;
  private String licensePlate;
  private double wallet;
  private String type;
  private TMUberService service;
  private String address;
  private int zone;
  
  public static enum Status {AVAILABLE, DRIVING};
  private Status status;
    
  
  public Driver(String id, String name, String carModel, String licensePlate, String address)
  {
    this.id = id;
    this.name = name;
    this.carModel = carModel;
    this.licensePlate = licensePlate;
    this.status = Status.AVAILABLE;
    this.wallet = 0;
    this.type = "";
    this.service=null;
    this.zone=CityMap.getCityZone(address);
    this.address=address;
  }
  // Print Information about a driver
  //Print info has been edited
  // The from and to are only printed when driver is driving
  public void printInfo()
  {
    System.out.printf("Id: %-3s Name: %-15s Car Model: %-15s License Plate: %-10s Wallet: %2.2f", id, name, carModel, licensePlate, wallet);

    System.out.println();

    System.out.printf( "Status: %-15s Address: %-20s Zone: %1d",status.toString(),address,zone);

    if(this.status==Status.DRIVING){
      System.out.println();
      System.out.printf("From: %-20s To: %-20s",this.service.getFrom(),this.service.getTo());
    }
  }
  // Getters and Setters
  public String getType()
  {
    return type;
  }
  public void setType(String type)
  {
    this.type = type;
  }
  public String getId()
  {
    return id;
  }
  public void setId(String id)
  {
    this.id = id;
  }
  public String getName()
  {
    return name;
  }
  public void setName(String name)
  {
    this.name = name;
  }
  public String getCarModel()
  {
    return carModel;
  }
  public void setCarModel(String carModel)
  {
    this.carModel = carModel;
  }
  public String getLicensePlate()
  {
    return licensePlate;
  }
  public void setLicensePlate(String licensePlate)
  {
    this.licensePlate = licensePlate;
  }
  public Status getStatus()
  {
    return status;
  }
  public void setStatus(Status status)
  {
    this.status = status;
  }
  public double getWallet()
  {
    return wallet;
  }
  public void setWallet(double wallet)
  {
    this.wallet = wallet;
  }
  /*
   * Two drivers are equal if they have the same name and license plates.
   * This method is overriding the inherited method in superclass Object
   * 
   * Fill in the code 
   */
  public boolean equals(Object other)
  {
    //cast the object other to a driver
    Driver o=(Driver) other;
    //check for it to be equal 
    if(this.name.equals(o.name) && this.licensePlate.equals(o.licensePlate))
    {
      return true;
    }
    return false;
  }
  
  // A driver earns a fee for every ride or delivery
  public TMUberService getService(){
    return this.service;
  }
  public String getAddress(){
    return this.address;
  }
  public int getZone(){
    return this.zone;
  }
  public void pay(double fee)
  {
    wallet += fee;
  }
  // this method sets the service
  public void updateService(TMUberService s){
    
    this.service=s;
  }
  // this method updates the address and the zone
  public void setAddress(String address){
    
    this.address=address;
    this.zone=CityMap.getCityZone(address);
  }
}
