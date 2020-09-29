package com.company;
import java.util.*;
import java.lang.*;
public class AddressBook {
    public static void main(String args[]) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        System.out.println("Welcome to Address Book");
        Operation object=new Operation();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to create address");
            System.out.println("Enter 2 to edit details of person ");
            System.out.println("Enter 3 to delete person");
            System.out.println("Enter 4 to sort by First Name");
            System.out.println("Enter 5 to sort by zipcode");

            switch (input.nextInt()) {
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
class Operation
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
        System.out.println(map);

    }
 	public void editAddress()
    	{
		ArrayList<String> list = new ArrayList<String>();
        	System.out.println("Enter name whose address you want to edit");
        	String name=input.nextLine();
		System.out.println("enter what you want to edit");
		String edit=input.nextLine();
		System.out.println("Enter final change you want");
		String finalValue=input.nextLine();list.add(finalValue);
        	for(Map.Entry entry:map.entrySet())
        	{
            		if(map.containsKey(name))
            		{
                		map.replace(name,list);
                		System.out.println(map);
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
        	System.out.println(sorted);
 	}


}

