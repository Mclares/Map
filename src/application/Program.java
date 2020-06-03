package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
	
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			Map<String, Integer> voting = new HashMap<>();
			
			String line = br.readLine();
			while (line != null) {
				
				String[] fields = line.split(",");
				String candidate = fields[0];
				int wishes = Integer.parseInt(fields[1]);
				
				if (voting.containsKey(candidate)) {
					int wishesSoFar = voting.get(candidate);
					voting.put(candidate, wishes + wishesSoFar);
				}
				else {
					voting.put(candidate, wishes);
				}
				
				line = br.readLine();
			}
			
			System.out.println();
			System.out.println("Total:");
			for (String key : voting.keySet()) {
				System.out.println(key + ": " + voting.get(key));
			}
			
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
	}

}
