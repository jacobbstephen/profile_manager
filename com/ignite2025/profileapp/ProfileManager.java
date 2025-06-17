package com.ignite2025.profileapp;

public class ProfileManager {
	private Profile[] profiles;
	public Profile[] readProfile() {
		ProfileReader profileReader = new ProfileReader();
		String data = profileReader.readProfilesFromCSV();
		String[] entries = ProfileUtils.csvToArray(data);
		this.profiles =  ProfileUtils.csvToProfile(entries);
		return profiles;
		
	}
	
	public boolean editProfile(String employeeId, Profile updatedProfile) {
		int len = ProfileUtils.lengthOfProfiles(profiles);
		for(int i = 0; i < len; i++) {
			if(ProfileUtils.isMatchingEmployeeId(profiles[i], employeeId)) {
				profiles[i] = updatedProfile;
				ProfileReader profileWriter = new ProfileReader();
				profileWriter.writeProfilesToCSV(profiles);
				return true;
			}
		}
		return false;
	}
	
	
	public Profile[] getProfiles() {
		return profiles;
	}
	
	public Profile searchByName(String name) {
		int len = ProfileUtils.lengthOfProfiles(profiles);
		for(int i = 0; i < len; i++) {
			if(ProfileUtils.isMatchingName(profiles[i], name)) {
				return profiles[i];
			}
		}
		System.out.println("No Profile Found");
		return null;
	}
	
	public Profile[] searchByCompany(String company) {
		int len = ProfileUtils.lengthOfProfiles(profiles);
		Profile[] result = new Profile[len];
		int resultCount = 0;
		for(int i = 0; i < len; i++) {
			if(ProfileUtils.isMatchingCompany(profiles[i], company)) {
				result[resultCount++] = profiles[i];
			}
		}
		if(resultCount == 0) {
			System.out.println("No Profile Found");
			return null;
		}
		return ProfileUtils.trimResult(result, resultCount);
	}
}
