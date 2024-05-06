package org.example.demo_flyweight;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyWeightFactory {
    private Map<String, SharedBookState> flyweights = new HashMap<>();

    public SharedBookState getFlyweight(String title, String author, String category, List<String> tags) {
        String key = title + "|" + author;
        if(!flyweights.containsKey(key)){
            flyweights.put(key, new SharedBookState(author,category, tags));
        }
        return flyweights.get(key);
    }
}
