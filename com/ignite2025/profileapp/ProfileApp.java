package com.ignite2025.profileapp;

public class ProfileApp {

	public static void main(String[] args) {
		ProfileManager manager = new ProfileManager();
		Profile[] profiles = manager.readProfile();
		for(Profile profile: profiles) {
			System.out.println(profile);
		}
		System.out.println();
		
		System.out.println("--------SEARCH BY NAME---------");
		Profile profile = manager.searchByName("A");
		System.out.println(profile);
		System.out.println();
		
		System.out.println("-------SEARCH BY COMPANY--------");
		Profile[]  results = manager.searchByCompany("Envestnet");
		for(Profile result: results) {
			System.out.println(result);
		}
		System.out.println();
		
		System.out.println("----------EDIT PROFILE-----------");
		Profile updatedProfile = new Profile();
		updatedProfile.setProfile("G", "E3", "Amazon", "SDE-1");
		if(manager.editProfile("E3", updatedProfile)) System.out.println("Profile Edited Succesfully");
		else System.out.println("Profile Not Edited. Try Again later.");
		System.out.println();
		results = manager.getProfiles();
		for(Profile result: results) {
			System.out.println(result);
		}
	}

}

