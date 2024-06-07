package com.edubridge.sewing_machine.main;

import java.util.List;
import java.util.Scanner;


import com.edubridge.sewing_machine.model.Sewing_machine;
import com.edubridge.sewing_machine.service.SM_service;
import com.edubridge.sewing_machine.service.SM_serviceImpl;

public class Sewing_machineMainApp {

	public static void main(String[] args) {
		SM_service service = new SM_serviceImpl();
		Sewing_machine s = null;
		
		Scanner in = new Scanner(System.in);
		int option;

		do {
			System.out.println("Welcome to Sewing_machine App");
			System.out.println("*****************************");
			System.out.println("1.Add Machine");
			System.out.println("2.View Machines");
			System.out.println("3.Search Machine");
			System.out.println("4.Update Machines");
			System.out.println("5.Delete Machine");
			System.out.println("6.DeleteAll Machines");
			System.out.println("0.Exit");
			System.out.println("Please choose an Option");
			option = in.nextInt();
			switch (option) {
			case 1:
				System.out.println("ADD NEW SEWING_MACHINE");
				System.out.println("-----------------");
				System.out.println("Please enter brand:");
				String brand = in.next();
				System.out.println("Please enter colour");
				String colour = in.next();
				System.out.println("Please enter price");
				Float price = in.nextFloat();
				System.out.println("Please enter rating");
				Float rating = in.nextFloat();

				s = new Sewing_machine();
				s.setBrand(brand);
				s.setColour(colour);
				s.setPrice(price);
				s.setRating(rating);
				int status = service.addContact(s);
				if (status == 1) {
					System.out.println("new Machine added!");
				} else {
					System.out.println("Something is Wrong");
				}
				break;
			case 2:
				System.out.println("view  All Machines");
				List<Sewing_machine> machines = service.findmachine();
				System.out.println("BRAND\tCOLOUR\tPRICE\tRATING");
				System.out.println("----\t----\t----\t-----");

				for (Sewing_machine machine :machines ) {
					System.out.println(machine.getBrand()+ "\t" + machine.getColour()+ "\t" +machine.getPrice()+ "\t" +machine.getRating());
				}
				break;
			case 3:	
				System.out.println("Search Machine By Brand");
				System.out.println("Please enter Machine Brand");
				brand = in.next();
				Sewing_machine searchmachine = service.findmachineByBrand(brand);
				if (searchmachine != null) {
					System.out.println("Machine found");
					System.out.println(searchmachine.getId() + "\t" + searchmachine.getBrand() + "\t"
							+ searchmachine.getColour() + "\t" + searchmachine.getPrice()+ "\t" +searchmachine.getRating());
				} else {
					System.out.println("Machine not found");
				}
				break;
			case 4:
				
				System.out.println("Update Machines");
				System.out.println("Please enter machine brand");
				brand = in.next();
				searchmachine = service.findmachineByBrand(brand);
				if (searchmachine != null) {
					System.out.println(searchmachine.getId() + "\t" + searchmachine.getBrand() + "\t"
							+searchmachine.getColour() + "\t" + searchmachine.getPrice()+"\t"+searchmachine.getRating());
					System.out.println("Please enter machine brand");
					brand = in.next();
					System.out.println("Please enter machine colour");
					colour = in.next();
					System.out.println("Please enter machine price");
					price = in.nextFloat();
					System.out.println("Please enter machine rating");
					rating = in.nextFloat();
					System.out.println("Please enter id");
					int id = in.nextInt();
					Sewing_machine updatemachine = new Sewing_machine();
					updatemachine.setBrand(brand);
					updatemachine.setColour(colour);
					updatemachine.setPrice(price);
					updatemachine.setRating(rating);
					updatemachine.setId(searchmachine.getId());
					int updateStatus = service.updatemachine(updatemachine);
					if (updateStatus == 1) {
						System.out.println("Updated Succesfull");
					} else {
						System.out.println("Something is wrong Added");
					}
				} else {
					System.out.println("No Machine found with name ");
				}

				break;
			case 5:
				System.out.println("Delete machine");
				System.out.print("Please enter machine Brand : ");
				brand = in.next();

				searchmachine = service.findmachineByBrand(brand);
				if (searchmachine != null) {

					int deleteStatus = service.deletemachineByBrand(brand);
					if (deleteStatus == 1) {
						System.out.println("Deleted Successfully");
					} else {
						System.out.println("somthing went wrong");
					}
				} else {
					System.out.println("No Machine  Found");
				}

				break;
			case 6:	
				System.out.println("Are you sure Delete All Contact[Y/N]");
				String deleteConfirmStatus = in.next();

				if (deleteConfirmStatus.equalsIgnoreCase("Y")) {
					service.deletemachines();
					System.out.println("All machines are Deleted");
				}

				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Option");

				break;

			}

		} while (option != 0);

		in.close();


	}

}

