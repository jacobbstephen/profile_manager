package ignite2025.profile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ProfileReader implements Path {
	public String readProfiles() {
		StringBuilder sb = new StringBuilder();
		String fileName = SOURCE_FILE_PATH;
		try(Reader r = new FileReader(fileName);
				BufferedReader br = new BufferedReader(r);
				)
		{
			String line = "";
				while((line = br.readLine()) != null){
					sb.append(line).append("\n");
				}
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
