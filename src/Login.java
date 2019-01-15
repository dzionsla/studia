
public class Login {
	public Login() {
		String[] studentNames = { "Budynek Piotr", 
								  "Chalupa Krystyna", 
								  "Wiezowiec Jan",
								  "Szkieletor Andrzej",
                				  "Domek Marianna" };
		String postfix = "@student.agh.edu.pl";
		
		for (int i = 0; i < studentNames.length; i++) {
			System.out.println(createName(studentNames[i])+postfix);
		}
	}
	
	public int findSpace(String name) {
		if (name.indexOf(' ') != -1) 
			return name.indexOf(' ');
		else
			return -1;	
	}
	
	public String createName(String name) {
		String temp = name.toLowerCase();
		String[] parts = temp.split(" ");
		
		return (parts[1].substring(0, 3) + parts[0].substring(0, 2)); 
	}
	
}
