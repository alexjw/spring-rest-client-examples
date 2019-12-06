package guru.springframework.springrestclientexamples.services;

import guru.springframework.api.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    private RestTemplate restTemplate;

    private final String API_URL;

    @Autowired
    public ApiServiceImpl(RestTemplate restTemplate, @Value("${api.url}") String api_url) {
        this.restTemplate = restTemplate;
        this.API_URL = api_url;
    }

    @Override
    public List<User> getUsers() {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(API_URL);

        System.out.println(uriComponentsBuilder.toUriString());

        User[] users = restTemplate.getForObject(uriComponentsBuilder.toUriString(), User[].class);
        return Arrays.asList(users);
    }

}
