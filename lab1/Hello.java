public class Hello {
	public static void main(String[] args) {
		int i = 0;
		switch (args.length) {
		case 0:
			System.out.println("Привет, мир!");
		break;
		default:
			do {
				System.out.println("Привет, "+args[i]+"!");
				i++;
			} while (i < args.length);
		}


		
	}
}
