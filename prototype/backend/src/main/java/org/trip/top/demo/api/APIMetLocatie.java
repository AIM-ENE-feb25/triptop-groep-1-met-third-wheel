package org.trip.top.demo.api;

import org.trip.top.demo.services.KaartenService;

public abstract class APIMetLocatie<T, V> extends API<T, V> {
    protected KaartenService kaartenService;
}
