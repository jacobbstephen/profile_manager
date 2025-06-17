package com.ignite2025.profileapp;

import java.util.Scanner;

public class ProfileApp {
	static Scanner sc = new Scanner(System.in);
	
	public static void editProfile(ProfileManager manager) {
		System.out.println("----------EDIT PROFILE-----------");
		
		System.out.print("Enter the Employee ID to edit: ");
		String id = sc.next();
		
		Profile updatedProfile = ProfileUtils.createProfileFromInput();
		
		if(manager.editProfile(id, updatedProfile)) System.out.println("Profile Edited Succesfully");
		else System.out.println("Profile Not Edited. Try Again later.");
		System.out.println();
		ProfileUtils.printAllProfilesFromManager(manager);
		
	}
	
	public static void searchByNameRequest(ProfileManager manager) {
		System.out.println("--------SEARCH BY NAME---------");
		System.out.print("Enter the name to search: ");
		String name = sc.next();
		Profile profile = manager.searchByName(name);
		System.out.println(profile);
		System.out.println();
	}
	
	public static void searchByCompanyRequest(ProfileManager manager) {
		System.out.println("-------SEARCH BY COMPANY--------");
		System.out.print("Enter the Company name to search: ");
		String company = sc.next();
		Profile[]  profiles = manager.searchByCompany(company);
		ProfileUtils.printProfiles(profiles);
		System.out.println();
	}
	
	

	public static void main(String[] args) {
		ProfileManager manager = new ProfileManager();
		
		Profile[] profiles = manager.readProfile();
		ProfileUtils.printProfiles(profiles);
		
		
		System.out.print("Do You want to edit any profile? yes or no: ");
		String answer = sc.next();
		if(answer.equals("yes")) editProfile(manager);

		System.out.print("Do You want to search by name or company? name or company or no: ");
		answer = sc.next();
		if(answer.equals("name")) searchByNameRequest(manager);
		else if(answer.equals("company")) searchByCompanyRequest(manager);
		
	}

}

