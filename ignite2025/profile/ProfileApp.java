package ignite2025.profile;

public class ProfileApp {

	public static void main(String[] args) {
		ProfileManager  manager = new ProfileManager();
		Profile profiles[] = manager.getProfile();
		
		for(Profile profile: profiles) {
			System.out.println(profile);
		}
	}

}
