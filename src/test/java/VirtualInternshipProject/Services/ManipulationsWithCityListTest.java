package VirtualInternshipProject.Services;

import VirtualInternshipProject.DAO.DAO;
import VirtualInternshipProject.DB.CitiesDataBase;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ManipulationsWithCityListTest {
    public static ManipulationsWithCityList mpTest;
    @BeforeAll
    static void beforeAll() {
           mpTest  = new ManipulationsWithCityList();
    }


    @Test
    void readString() {
        mpTest.ReadString("src/main/resources/CityDerectoryTEST.txt");
        MatcherAssert.assertThat(mpTest.getDaoInstance().getCitiesList().size(), is(4));
    }

    @Test
    void sortListByNames() {
    }

    @Test
    void sortListByNamesAndDist() {
    }

    @Test
    void getIndexOfCityWithBiggestPopulation() {
    }

    @Test
    void countCitiesInEachRegion() {
    }
}