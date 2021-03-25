package com.nikanorov.rest.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Component
public class Communication {

    final private String URL = "http://91.241.64.178:7081/api/users";
    private RestTemplate restTemplate;
    private String myHeader;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<User> showAllUser() {
        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null
                        , new ParameterizedTypeReference<List<User>>() {
                        });
        List<User> allUsers = responseEntity.getBody();
        HttpHeaders cook = responseEntity.getHeaders();
        myHeader = cook.get("Set-Cookie").get(0);
        System.out.println(myHeader);
        return allUsers;
    }

    public User getUser(int id) {
        return null;
    }

    public String saveUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Cookie",myHeader);

        User james = new User((long)3, "James", "Brown",(byte)10);
        HttpEntity<User> user = new HttpEntity<>(james , headers);
        return restTemplate.exchange(URL, HttpMethod.POST, user, String.class).getBody();
    }


    public String editUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Cookie", myHeader);

        User james = new User( 3l,"Thomas", "Shelby",(byte)10);
        HttpEntity<User> user = new HttpEntity<>(james , headers);
        ResponseEntity<String > entity= restTemplate.exchange(URL, HttpMethod.PUT, user, String.class);
        return entity.getBody();
    }

    public String deleteUser(int id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("Cookie", myHeader);
        HttpEntity<User>  entity = new HttpEntity<>(headers);
        return restTemplate.exchange(
                URL+"/3", HttpMethod.DELETE, entity, String.class).getBody();
    }




//    public String updateUser3(){
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.add("Cookie", cookies);
//        User user3 = getUser(3L,"Thomas", "Shelby", (byte) 12);
//        ResponseEntity<String > entity = restTemplate.exchange(URL, HttpMethod.PUT,
//                new HttpEntity<>(user3, httpHeaders), String.class);
//        return entity.getBody();
//    }
}
