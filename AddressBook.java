import java.util.*;
class AdderssBook
{
    public static void main(String args[])
   {
        ArrayList<String> firstName = new ArrayList<String>();
        ArrayList<String> lastName = new ArrayList<String>();
        Map<String, String> cityState = new HashMap<String, String>();
        ArrayList<String> address = new ArrayList<String>();
        ArrayList<Integer> zipCode = new ArrayList<Integer>();
        ArrayList<String> phoneNumber = new ArrayList<String>();
        System.out.println("Welcome to Address Book Creation");
        System.out.println("Enter How many person address you want to store");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        for (int i = 1; i <= number; i++)
	{
        	System.out.println("Enter details of person" + i);
            	input.nextLine();
            	System.out.println("Enter First Name");
            	firstName.add(input.nextLine());
            	input.nextLine();
            	System.out.println("Enter Last Name");
            	lastName.add(input.nextLine());
            	System.out.println("Enter Address ");
            	address.add(input.nextLine());
            	System.out.println("Enter City and State");
            	cityState.put(input.nextLine(), input.nextLine());
            	System.out.println("Enter zip code");
            	zipCode.add(input.nextInt());
            	input.nextLine();
            	System.out.println("Enter PhoneNumber");
            	phoneNumber.add(input.nextLine());
    	}
        AddressBookOperation object=new AddressBookOperation();
        object.displayAddressBook(firstName);
        object.displayAddressBook(lastName);
        object.displayAddressBook(address);
        object.displayCityState(cityState);
        System.out.println(zipCode);
        object.displayAddressBook(phoneNumber);
        System.out.println("press 1 to sort by lastName or press 2 sort by zipcode");
        switch(input.nextInt())
        {
           	case 1:object.sortByLastName(lastName);
           	break;
           	case 2:object.sortByzipCode(zipCode);
           	break;
            	default:System.out.println("Invalid input");
            	break;
        }
        System.out.println("visit again to store more address");
   }
}
class AddressBookOperation implements AddressBuilder
{
    public  void displayCityState( Map<String, String>cityState)
    {
        for(Map.Entry entry:cityState.entrySet())
        {
          	System.out.println(entry.getKey()+"   "+entry.getValue()+" ");

        }

    }
    public void displayAddressBook(ArrayList<String> list)
    {
        System.out.println(list);
    }
    public  void sortByLastName(ArrayList<String> list)
    {
        Collections.sort(list);
        System.out.println(list);
    }
    public static void sortByzipCode(ArrayList<Integer> list)
    {
        Collections.sort(list);
        System.out.println(list);
    }

}
interface AddressBuilder
{
    abstract void displayCityState(Map<String, String>cityState);
}
