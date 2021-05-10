package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@RestController
public class servController {

    //first point of the code test
    //method that gets All of the post and counts all of the entries by user
    //using streams and collections
    //accessed via: localhost:8080/firstPoint
    @GetMapping("/firstPoint")
	public String firstPoint() {
        
        String responseFinal = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            String inline = serv.getGetterGettingGets(new URL("http://jsonplaceholder.typicode.com/posts"));
            List<posts> arrPost = Arrays.asList(mapper.readValue(inline, posts[].class));
            Map<String, List<posts>> resra =arrPost.stream().collect(Collectors.groupingBy(posts::getUserId));
            for (Map.Entry<String, List<posts>> entry : resra.entrySet()) {
                responseFinal += "idName: "+entry.getKey() + " number results:" + entry.getValue().size()+ "\r\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseFinal;
	}

    //second point of the code test
    //mtehod that gets all of the posts and modifies the fourth item in the list and changes the title and the body for: 1800Flowers
    //using List 
    //accessed via: localhost:8080/secondPoint
    @GetMapping("/secondPoint")
	public String secondPoint() {
        
        String responseFinal = "";
        try {
            ObjectMapper mapper = new ObjectMapper();
            String inline = serv.getGetterGettingGets(new URL("http://jsonplaceholder.typicode.com/posts"));
            List<posts> arrPost = Arrays.asList(mapper.readValue(inline, posts[].class));
            posts a = arrPost.get(4);
            a.setBody("1800Flowers");
            a.setTitle("1800Flowers");
            arrPost.set(4,a);
            for (posts is : arrPost) {
                responseFinal += is.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseFinal;
	}
}
