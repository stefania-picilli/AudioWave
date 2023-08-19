package helpers;

public class InputFilter {

	
	public static String filter(String input) {
		
		if(input == null)
			return null;
		
		StringBuffer filtered = new StringBuffer(input.length());
		
		char c;
		
		for(int i = 0; i < input.length(); i++) {
			
			c = input.charAt(i);
			
			if(c == '<')
				filtered.append("&lt");
			else if(c == '>')
				filtered.append("&gt");
			else if(c == '"')
				filtered.append("&quot");
			else if(c == '&')
				filtered.append("&amp");
			else
				filtered.append(c);
			
		}
		
		
		return filtered.toString();
		
	}
	
}
