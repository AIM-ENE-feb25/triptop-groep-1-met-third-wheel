package org.trip.top.auth;

import java.util.Map;

public interface IAuthStrategy {
    boolean authenticate(Map<String, String> headers);
    String strategyName();
}
