import java.util.Objects;

public class Country {
    private String capital;
    private Long population;
    private String nativeName;

    public Country() {

    }

    Country(String capital, Long population, String nativeName) {
        this.capital = capital;
        this.population = population;
        this.nativeName = nativeName;
    }

    @Override
    public String toString() {
        return "Country{" +
                "capital='" + capital + '\'' +
                ", population=" + population +
                ", nativeName='" + nativeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(capital, country.capital) &&
                Objects.equals(population, country.population) &&
                Objects.equals(nativeName, country.nativeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capital, population, nativeName);
    }

}
