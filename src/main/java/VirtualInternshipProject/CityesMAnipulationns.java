package VirtualInternshipProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CityesMAnipulationns {
    private static String[] readedLine = new String[6];
    private static ArrayList<City> cityesList = new ArrayList<>();

    public static void ReadString(String path) {
        try {
            File cityDirectory = new File(path);
            Scanner sc = new Scanner(cityDirectory);

            while (sc.hasNextLine()) {
                readedLine = sc.nextLine().split(";");
                cityesList.add(new City(readedLine[1], readedLine[2], readedLine[3], Integer.parseInt(readedLine[4]), Integer.parseInt(readedLine[5])));// write your code here
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
    public static void SortListByNames(){
        System.out.println("\n\n\t ------------ LIST SORTED BY NAMES ------------\t");
        SortList(1, cityesList);
    }
    public static void SortListByNamesAndDist(){
        System.out.println("\n\n\t ------------ LIST SORTED BY DISTRICT AND NAMES ------------\t");
        SortList(0, cityesList);
    }

    private static void SortList(int pos, List<City> ScityesList){
        List<City> list = ScityesList;
        Comparator<City> compNames = (city1, city2) -> city2.getName().compareToIgnoreCase(city1.getName());
        Comparator<City> compNamesAndDist = (city1, city2) -> city2.getDistrict().compareToIgnoreCase(city1.getDistrict());
        if (pos == 1)
        Collections.sort(list, compNames);
        else if(pos == 0)
        Collections.sort(list, compNamesAndDist.thenComparing(compNames));
        for (City cityes : list)
            System.out.println(cityes.toString());

    }
}
