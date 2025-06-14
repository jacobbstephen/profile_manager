package ignite2025.profile;

public class ProfileManager implements CSVHeaders {
	public  Profile[] getProfile() {
		
		ProfileReader profileReader = new ProfileReader();
		String data = profileReader.readProfiles();
		String[] lines = csvToArray(data);
		return csvToProfile(lines);
	}
	
	
	private int countRecord(String[] record) {
		return record.length;
	}
	
	private String[] csvToArray(String csv) {
		return csv.split("\n");
	}
	
	private Profile[] csvToProfile(String[] csvArray) {
		Profile[] profiles = new Profile[countRecord(csvArray)];
		Profile profileProtoType = new Profile();
		for(int i = 0; i < csvArray.length; i++) {
			String[] fields = csvArray[i].split(",");
			if(fields.length == 4) {
				try {
					Profile p = profileProtoType.clone();					
					p.setProfile(fields[NAME], fields[EMPLOYEE_ID], fields[COMPANY], fields[DESIGINATION]);
					profiles[i] = p;
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				}
		}
		return profiles;
	}
}


