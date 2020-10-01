package com.company;
import java.util.*;
import java.lang.*;
 class AddressBook
{
    public static void main(String args[])
    {
        System.out.println("Welcome to Address Book");
        Driver object=new Driver();
        Scanner input = new Scanner(System.in);
        while (true)
	 {
            System.out.println("Enter 1 to create address");
            System.out.println("Enter 2 to edit details of person ");
            System.out.println("Enter 3 to delete person");
            System.out.println("Enter 4 to sort by First Name");

            switch (input.nextInt())
	    {
                case 1:
                    object.createAddress();
                    break;
                case 2:
                    object.editAddress();
                    break;
                case 3:
                    object.deleteAddress();
                    break;
                case 4:
                    object.sortByFirstName();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }

    }
}
class Driver implements ManagerDAO
{
    HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
    Scanner input=new Scanner(System.in);
    String firstName,lastName,address,city,state,zipCode,phoneNumber;
    public void createAddress()
    {
        ArrayList<String> list = new ArrayList<String>();
        System.out.println("Enter First Name");
        firstName=(input.nextLine());
        System.out.println("Enter Last Name");
        list.add(input.nextLine());
        System.out.println("Enter Address ");
        list.add(input.nextLine());
        System.out.println("Enter City");
        list.add(input.nextLine());
        System.out.println("Enter state");
        list.add(input.nextLine());
        System.out.println("Enter zip code");
        list.add(input.nextLine());
        System.out.println("Enter phoneNumber code");
        list.add(input.nextLine());
        map.put(firstName,list);
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet())
        {
		System.out.println(entry);
        }

    }
    public void editAddress()
    {
        System.out.println("Enter name whose address you want to edit");
        String name=input.nextLine();
	System.out.println("enter what you want to edit");
	String edit=input.nextLine();
	System.out.println("Enter final change you want");
	String finalValue=input.nextLine();
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet())
        {
            if(entry.getKey().equals(name))
            {
		 ArrayList<String> list=entry.getValue();
		if(list.contains(edit))
		{
			list.remove(edit);
			list.add(finalValue);
	        }
             map.put(name,list);System.out.println(map);break;
            }
            else
            {
                System.out.println("sorry Name do not exist in AddressBook");
            }
        }
    }
    public void deleteAddress()
    {
	try
	{
        	System.out.println("Enter name whose address you want to delete");
       		String name=input.nextLine();
        	for(Map.Entry entry:map.entrySet())
        	{
            		if(map.containsKey(name))
            		{
                		map.remove(name);
                		System.out.println(map);
            		}
           		 else
          		 {
                 		System.out.println("sorry Name do not exist in AddressBook");
            		 }
        	}
	}
	catch(Exception e)
	{
	}
    }
    public void sortByFirstName()
	{
        	// TreeMap to store values of HashMap
        	TreeMap<String, ArrayList<String>> sorted = new TreeMap<>();
        	// Copy all data from hashMap into TreeMap
        	sorted.putAll(map);
        	// Display the TreeMap which is naturally sorted
        	map.putAll(sorted);
        	for (Map.Entry<String, ArrayList<String>> entry : sorted.entrySet())
         	{
			 System.out.println(entry);
        	}
    	 }

}
interface ManagerDAO
{
	abstract void createAddress();
	abstract void editAddress();
	abstract void deleteAddress();
	abstract void sortByFirstName();
}


