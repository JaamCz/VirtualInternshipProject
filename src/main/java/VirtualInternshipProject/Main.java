package VirtualInternshipProject;


import VirtualInternshipProject.Services.ManipulationsWithCityList;

public class Main {

    public static void main(String[] args) {
        ManipulationsWithCityList mp = new ManipulationsWithCityList();
        mp.ReadString("src/main/resources/CityDirectory.txt");
        mp.SortListByNames();
        mp.SortListByNamesAndDist();
        mp.GetIndexOfCityWithBiggestPopulation();
        mp.CountCitiesInEachRegion();
    }


}
