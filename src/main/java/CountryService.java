import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

class CountryService implements CountryRestService {
    private static final String COUNTRY_REST_API_URL = "https://restcountries.eu/rest/v2/name/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Country getCountryByName(String name) {
        ResponseEntity<List<Country>> countries = restTemplate.exchange(
                buildRequestURL(name),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Country>>() {
                });

        return Optional.ofNullable(countries.getBody())
                .orElse(Collections.emptyList()).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find country for name: " + name));
    }

    private String buildRequestURL(String requestParam) {
        return COUNTRY_REST_API_URL + requestParam;
    }
}
