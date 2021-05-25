package VirtualInternshipProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CityesMAnipulationns {
    private static String[] readedLine = new String[6];
    private static ArrayList<City> citiesList = new ArrayList<>();

    public static void ReadString(String path) {
        try {
            File cityDirectory = new File(path);
            Scanner sc = new Scanner(cityDirectory);

            while (sc.hasNextLine()) {
                readedLine = sc.nextLine().split(";");
                citiesList.add(new City(readedLine[1], readedLine[2], readedLine[3], Integer.parseInt(readedLine[4]), Integer.parseInt(readedLine[5])));// write your code here
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("\n\n\t------------ LIST OF CITIES ------------\n");
        for (City city : citiesList)
        System.out.println(city.toString());
    }

    public static void SortListByNames() {
        System.out.println("\n\n\t------------ LIST SORTED BY NAMES ------------\n");
        SortList(1, citiesList);
    }

    public static void SortListByNamesAndDist() {
        System.out.println("\n\n\t ------------ LIST SORTED BY DISTRICT AND NAMES ------------\n");
        SortList(0, citiesList);
    }

    private static void SortList(int pos, List<City> ScityesList) {
        List<City> list = new ArrayList<>(ScityesList);
        Comparator<City> compNames = (city1, city2) -> city2.getName().compareToIgnoreCase(city1.getName());
        Comparator<City> compNamesAndDist = (city1, city2) -> city2.getDistrict().compareToIgnoreCase(city1.getDistrict());
        if (pos == 1)
            Collections.sort(list, compNames);
        else if (pos == 0)
            Collections.sort(list, compNamesAndDist.thenComparing(compNames));
        for (City cityes : list)
            System.out.println(cityes.toString());
    }

    public static void GetIndexOfCityWithBiggestPopulation() {
        System.out.println("\n\n\t ------------ INDEX OF CITY LIST ELEMENT WITH BIGGEST POPULATION  ------------\n");
        City[] cities = citiesList.toArray(new City[0]);
//        for (City city : cities)
//        System.out.println(city.toString());
        int maxIndex = 0;
        for (int i = 0; i<cities.length; i++){
            if (cities[i].getPopulation() > cities[maxIndex].getPopulation())
                maxIndex = i;
        }
        System.out.println("[" + maxIndex + "] = " + cities[maxIndex].getPopulation());
    }
}

