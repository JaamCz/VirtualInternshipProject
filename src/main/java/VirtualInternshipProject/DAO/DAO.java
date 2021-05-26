package VirtualInternshipProject.DAO;

import VirtualInternshipProject.DB.CitiesDataBase;
import VirtualInternshipProject.Essence.City;

import java.util.ArrayList;

public class DAO {
    private static CitiesDataBase citiesDAO;

    public DAO (CitiesDataBase citiesDB){
        citiesDAO = citiesDB;
        citiesDAO.citiesDataBase = new ArrayList<>();
    }


    public ArrayList<City> getCitiesList() {
        return citiesDAO.citiesDataBase;
    }

   public void add(City city){
        citiesDAO.citiesDataBase.add(city);
   }
}
