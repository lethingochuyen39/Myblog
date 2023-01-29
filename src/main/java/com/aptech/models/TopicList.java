package com.aptech.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TopicList {
    private final List<Topic> topics = new ArrayList();
    public TopicList(){
        topics.add(new Topic("Servlets", "servlets", 1));
        topics.add(new Topic("JSP", "jsp", 2));
        topics.add(new Topic("Security", "security", 3));
    }
}
