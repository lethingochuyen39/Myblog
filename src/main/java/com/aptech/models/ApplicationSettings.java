package com.aptech.models;


import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ApplicationSettings {
    private final TopicList topicList;
    private final NewsItemList newsItemList;
    public static final String topic = "topic";
    public static final String newsitem = "newstem";
    public static final String all = "all";

    public ApplicationSettings() {
        topicList = new TopicList();
        newsItemList = new NewsItemList();
    }

    public List<NewsItem> getNewsForTopic(int type) {
        var itemStream = getNewsItemList().getNewsItems().stream().filter(t -> ((t.getTopic() == type) || type == 0));
        var items = itemStream.collect(Collectors.toList());
        return items;
    }

    public List<NewsItem> setupData (String type, String detail){
        if(type.equals(topic)){
            var topic = getTopicList()
                    .getTopics().stream()
                    .filter(t-> t.getTitle().equalsIgnoreCase(detail)).findFirst().orElseGet(()-> new Topic(all,"",0));
            return  getNewsForTopic(topic.getId());
        }else {
            return getNewsForTopic(0);
        }
    }


}
