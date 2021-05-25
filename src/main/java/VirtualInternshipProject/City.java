package VirtualInternshipProject;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class City{
    private String name;
    private String regeion;
    private String district;
    private int population;
    private int foundation;

    public City (String name, String region, String district, int population, int foundation){
        this.name = name;
        this.regeion = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return regeion;
    }

    public String getDistrict() {
        return district;
    }

    public int getPopulation() {
        return population;
    }

    public int getFoundation() {
        return foundation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegion(String region) {
        this.regeion = region;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setFoundation(int foundation) {
        this.foundation = foundation;
    }
    @Override
        public String toString() {
            return "City{name='" + this.name +
                    "', regeion='" + this.regeion +
                    "', district='" + this.district +
                    "', population= " + this.population +
                    ", foundation='" + this.foundation + "'}";
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population && foundation == city.foundation && Objects.equals(name, city.name) && Objects.equals(regeion, city.regeion) && Objects.equals(district, city.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, regeion, district, population, foundation);
    }
}
