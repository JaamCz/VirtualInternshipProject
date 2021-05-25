package VirtualInternshipProject;


public class Main {

    public static void main(String[] args) {
        ManipulationsWithCityList.ReadString("src/main/resources/  CityDirectory.txt");
        ManipulationsWithCityList.SortListByNames();
        ManipulationsWithCityList.SortListByNamesAndDist();
        ManipulationsWithCityList.GetIndexOfCityWithBiggestPopulation();
        ManipulationsWithCityList.CountCitiseInEachRegeion();
    }


}
