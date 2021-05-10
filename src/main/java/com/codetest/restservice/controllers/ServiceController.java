package com.codetest.restservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;

import java.net.URL;

import com.codetest.restservice.entities.Posts;
import com.codetest.restservice.utils.URLUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ServiceController {

    @Autowired
    URLUtils util;

    private final ObjectMapper mapper = new ObjectMapper();


    @GetMapping("/firstpoint")
    public ResponseEntity<JSONObject> getCountUsersId() {

        try {

            String jsonPosts = util.readURLData(new URL("http://jsonplaceholder.typicode.com/posts"));
            List<Posts> postList = Arrays.asList(mapper.readValue(jsonPosts, Posts[].class));
            Map<String, List<Posts>> mapUsersPosts = postList.stream().collect(Collectors.groupingBy(Posts::getUserId));
            int count = mapUsersPosts.size();
            JSONObject counter = new JSONObject();
            counter.appendField("usersId", count);
            return new ResponseEntity<>(counter, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/secondpoint")
    public ResponseEntity<List<Posts>> getModifyFourPost() {

        try {
            String jsonPosts = util.readURLData(new URL("http://jsonplaceholder.typicode.com/posts"));
            List<Posts> postsList = Arrays.asList(mapper.readValue(jsonPosts, Posts[].class));
            Posts post = postsList.get(4);
            post.setBody("1800Flowers");
            post.setTitle("1800Flowers");
            postsList.set(4, post);

            return new ResponseEntity<>(postsList, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
