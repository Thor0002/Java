import java.io.*;

public class QueueTest {

	public static void main(String[] args) {
		try {
			File input = new File("input.txt");
			File output = new File("output.txt");
			BufferedReader reader = new BufferedReader(new FileReader(input));
			BufferedWriter writer = new BufferedWriter(new FileWriter(output));
			String line = null;
			int k = 0;
			ObjectQueue<Character> q = new ObjectQueue<Character>();
			while((line = reader.readLine()) != null) {
				for(int i = 0; i < line.length(); i++) {
					if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
						q.push(line.charAt(i));
						k++;
					}
				}
				writer.write(line);
				Character c;
				writer.write(" ");
				while((c = q.pull()) != null) {
					writer.write(c);
				}

				if (k != 0) {writer.write(" " + k); k = 0;}
				writer.write("\n");
			}
			writer.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
