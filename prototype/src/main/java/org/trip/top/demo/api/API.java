package org.trip.top.demo.api;

import org.springframework.web.client.RestTemplate;

public abstract class API<T, V> {
    protected RestTemplate restTemplate;

    public abstract T voerAPICallUit(V value);
}
