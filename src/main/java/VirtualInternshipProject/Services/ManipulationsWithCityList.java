package VirtualInternshipProject.Services;

import VirtualInternshipProject.DAO.DAO;
import VirtualInternshipProject.DB.CitiesDataBase;
import VirtualInternshipProject.Essence.City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ManipulationsWithCityList {
    private static DAO daoInstance;

    public ManipulationsWithCityList(){
        daoInstance = new DAO(new CitiesDataBase());
    }

    /**
     * @param  path путь к файлу со вписком городов.
     * @return
     */
    public void ReadString(String path) {
        File cityDirectory = new File(path);

        try (Scanner sc = new Scanner(cityDirectory)){
            while (sc.hasNextLine()) {
                String[] readLine = sc.nextLine().split(";");
                daoInstance.add(new City(readLine[1], readLine[2], readLine[3], Integer.parseInt(readLine[4]), Integer.parseInt(readLine[5])));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
        System.out.println("\n\n\t------------ LIST OF CITIES ------------\n");
        justPrintIt(daoInstance.getCitiesList());
    }

    /**
     * @param forPrint Метод выводит на экран принятый список.
     */
    private void justPrintIt (ArrayList<City> forPrint){
        for (City city : forPrint)
            System.out.println(city.toString());
    }

    public DAO getDaoInstance() {
        return daoInstance;
    }

    /**
     * Вызывает метод для сортиировки саиска, который будет отсортирован по названиям городов.
     */
    public void SortListByNames() {
        System.out.println("\n\n\t------------ LIST SORTED BY NAMES ------------\n");
        SortList(1);
    }

    /**
     * Вызывает метод для сортиировки саиска, который будет отсортирован по названиям городов, а затем по названиию областей.
     */
    public void SortListByNamesAndDist() {
        System.out.println("\n\n\t ------------ LIST SORTED BY DISTRICT AND NAMES ------------\n");
        SortList(0);
    }

    /**
     * @param pos Получает на вход маркер по которому определяет какиим образом сортировать список.
     * @return
     */
    public ArrayList<City> SortList(int pos) {
        ArrayList<City> list = new ArrayList<>(daoInstance.getCitiesList());
        Comparator<City> compNames = (city1, city2) -> city2.getName().compareToIgnoreCase(city1.getName());
        Comparator<City> compNamesAndDist = (city1, city2) -> city2.getDistrict().compareToIgnoreCase(city1.getDistrict());
        if (pos == 1)
            list.sort(compNames);
        else if (pos == 0)
            list.sort(compNamesAndDist.thenComparing(compNames));
        justPrintIt(list);
        return list;
    }

    /**
     * Преобразует список в массиив, ищет порядковый номер элемента массива с максимальным количеством населениия,
     * возвращает индекс полученного элемента (индекс по текстовому списку) и количество человек.
     */
    public void GetIndexOfCityWithBiggestPopulation() {
        System.out.println("\n\n\t ------------ INDEX OF CITY LIST ELEMENT WITH BIGGEST POPULATION  ------------\n");
        City[] cities = daoInstance.getCitiesList().toArray(new City[0]);
        int maxIndex = 0;
        for (int i = 0; i<cities.length; i++){
            if (cities[i].getPopulation() > cities[maxIndex].getPopulation())
                maxIndex = i;
        }
        System.out.println("[" + (maxIndex + 1) + "] = " + cities[maxIndex].getPopulation());
    }

    /**
     * Определяет сколько городов в каждом регионе.
     */
    public void CountCitiesInEachRegion(){
        Map<String,Integer> CitiesMap = new HashMap<>();
        for (City cities : daoInstance.getCitiesList()){
            String reg = cities.getRegion();
            if(CitiesMap.containsKey(reg)){
                CitiesMap.put(reg, CitiesMap.get(reg) + 1);
            } else {
                CitiesMap.put(reg,1);
            }
        }
        System.out.println("\n\n\t ------------ HOW MANY CITIES IN EACH REGION  ------------\n");
        CitiesMap.forEach((key, value) -> System.out.println(key + ":" + value));
    }
}

