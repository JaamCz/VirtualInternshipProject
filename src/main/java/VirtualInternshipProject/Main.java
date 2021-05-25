package VirtualInternshipProject;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        CityesMAnipulationns.ReadString("src/main/resources/  CityDirectory.txt");
        CityesMAnipulationns.SortListByNames();
        CityesMAnipulationns.SortListByNamesAndDist();

    }


}
