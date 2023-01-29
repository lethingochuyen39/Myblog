package com.aptech.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
public class NewsItem {
    private  final String title;
    private final String entry;
    private final int topic;


}
