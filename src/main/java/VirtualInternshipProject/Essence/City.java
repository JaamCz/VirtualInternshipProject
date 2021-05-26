package VirtualInternshipProject.Essence;


import java.util.Objects;

public class City{
    private String name;
    private String region;
    private String district;
    private int population;
    private int foundation;

    public City (String name, String region, String district, int population, int foundation){
        setName(name);
        setRegion(region);
        setDistrict(district);
        setPopulation(population);
        setFoundation(foundation);
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
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

    private void setName(String name) {
        this.name = name;
    }

    private void setRegion(String region) {
        this.region = region;
    }

    private void setDistrict(String district) {
        this.district = district;
    }

    private void setPopulation(int population) {
        this.population = population;
    }

    private void setFoundation(int foundation) {
        this.foundation = foundation;
    }
    @Override
        public String toString() {
            return "City{name='" + this.name +
                    "', region='" + this.region +
                    "', district='" + this.district +
                    "', population= " + this.population +
                    ", foundation='" + this.foundation + "'}";
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population && foundation == city.foundation && Objects.equals(name, city.name) && Objects.equals(region, city.region) && Objects.equals(district, city.district);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, region, district, population, foundation);
    }
}
