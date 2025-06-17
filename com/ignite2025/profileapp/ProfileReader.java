package com.ignite2025.profileapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

public class ProfileReader implements Path {
	public String readProfilesFromCSV() {
		StringBuilder sb = new StringBuilder();
		try(Reader reader = new FileReader(FILE_PATH);
				BufferedReader bufferedReader = new BufferedReader(reader);
				){
			String line =  "";
			while(( line = bufferedReader.readLine()) != null) {
				sb.append(line).append("\n");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	public void writeProfilesToCSV(Profile[] profiles) {
		try(FileWriter writer = new FileWriter(FILE_PATH);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
				){
			for(Profile profile: profiles) {
				if(ProfileUtils.validProfile(profile)) {
					String line = ProfileUtils.makeProfile(profile);
					bufferedWriter.write(line + "\n");
				}
			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
