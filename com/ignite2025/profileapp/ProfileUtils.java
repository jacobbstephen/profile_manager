package com.ignite2025.profileapp;

public class ProfileUtils implements CSVInfo {
	public static  boolean isMatchingCompany(Profile profile, String company) {
		return profile.getCompany().equals(company);
	}
	public static  boolean isMatchingDesigination(Profile profile, String desigination) {
		return profile.getDesigination().equals(desigination);
	}
	public static  boolean isMatchingEmployeeId(Profile profile, String employeeId) {
		return profile.getEmployee_id().equals(employeeId);
	}
	public static  boolean isMatchingName(Profile profile, String name) {
		return profile.getName().equals(name);
	}
	
	public static int  lengthOfProfiles(Profile[] profiles) {
		return profiles.length;
	}
	
	public static String[] csvToArray(String csv) {
		return csv.split("\n");
	}
	public static int lengthOfRecord(String[] entries) {
		return entries.length;
	}
	public static String[] splitString(String str) {
		return str.split(",");
	}
	public static Profile[] csvToProfile(String [] entries) {
		int size = ProfileUtils.lengthOfRecord(entries);
		Profile[] profiles = new Profile[size];
		Profile profilePrototype = new Profile();
		for(int i = 0; i < size; i++) {
			String[] fields = ProfileUtils.splitString(entries[i]);
			if(ProfileUtils.lengthOfRecord(fields) == NO_OF_FIELDS) {
				try {
					Profile p = profilePrototype.clone();
					p.setProfile(fields[NAME], fields[EMPLOYEE_ID], fields[COMPANY], fields[DESIGINATION]);
					if(ProfileUtils.validProfile(p)) profiles[i] = p;
					
				}catch(CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
		}
		return profiles;
	}
	public static Profile[] trimResult(Profile[] result, int size) {
		Profile[] trimmedResult = new Profile[size];
		for(int i = 0; i < size; i++) {
			trimmedResult[i] = result[i];
		}
		return trimmedResult;
	}
	
	public static boolean validProfile(Profile profile) {
		return profile !=  null && profile.getName() != null && profile.getEmployee_id() != null && profile.getCompany() != null && profile.getDesigination() != null;
	}
	public static String makeProfile(Profile profile) {
		return String.join(",", profile.getName(), profile.getEmployee_id(), profile.getCompany(), profile.getDesigination());
	}
}