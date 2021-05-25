package VirtualInternshipProject;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class Main {

    public static void main(String[] args) {
        String[] readedLine = new String[6];
        ArrayList<City> cityesList = new ArrayList<>();
	try {
	    File cityDirectory = new File("/Users/u19223205/IdeaProjects/VirtualInternshipProject/src/VirtualInternshipProject/  CityDirectory.txt");
	    Scanner sc = new Scanner(cityDirectory);

	    while (sc.hasNextLine()){
	        readedLine = sc.nextLine().split(";");
	        cityesList.add(new City(readedLine[1], readedLine[2], readedLine[3], Integer.parseInt(readedLine[4]), Integer.parseInt(readedLine[5])));// write your code here
        }
	    for (City city : cityesList)
            System.out.println(city.toString());
    }catch (FileNotFoundException e){
        System.out.println(e);
    }
    }
}
