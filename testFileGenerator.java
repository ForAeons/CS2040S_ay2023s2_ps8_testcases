import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class testFileGenerator {
		
		public static void generateNPointsFile(double maxCoordinate, int numberOfPoints,
																																									String fileName) {
				try {
						FileWriter fileWriter = new FileWriter(fileName);
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
						
						// Write max coordinate
						bufferedWriter.write(String.valueOf(maxCoordinate));
						bufferedWriter.newLine();
						
						// Write number of points
						bufferedWriter.write(String.valueOf(numberOfPoints));
						bufferedWriter.newLine();
						
						Random random = new Random();
						
						// Generate and write points
						for (int i = 0; i < numberOfPoints; i++) {
								double x = random.nextDouble() * maxCoordinate;
								double y = random.nextDouble() * maxCoordinate;
								bufferedWriter.write(String.format("%.2f,%.2f", x, y));
								bufferedWriter.newLine();
						}
						
						bufferedWriter.close();
						fileWriter.close();
				} catch (IOException e) {
						System.out.println("Error writing file: " + e);
				}
		}
		
		public static void main(String[] args) {
				generateNPointsFile(100.0, 1000, "thousandpoints.txt");
				System.out.println("thousandpoints.txt created.");
		}
}