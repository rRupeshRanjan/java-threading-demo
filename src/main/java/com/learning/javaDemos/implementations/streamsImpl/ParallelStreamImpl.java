package com.learning.javaDemos.implementations.streamsImpl;

import com.learning.javaDemos.utils.HttpUtils;
import com.learning.javaDemos.utils.ResponseUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParallelStreamImpl {
    public static void main(String[] args) {
        HttpUtils httpUtils = HttpUtils.getInstance();
        List<String> urls = httpUtils.getUrls();

        Map<String, Integer> responseMap = urls.parallelStream()
                .flatMap(url -> httpUtils.makeHttpCalls(url).entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        ResponseUtils.printResponses(responseMap);
    }
}
