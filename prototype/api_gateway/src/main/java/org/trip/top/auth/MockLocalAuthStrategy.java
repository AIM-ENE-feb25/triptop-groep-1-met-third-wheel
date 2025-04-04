package org.trip.top.auth;

import java.util.Map;

public class MockLocalAuthStrategy implements IAuthStrategy{
    @Override
    public boolean authenticate(Map<String, String> headers) {
        System.out.println("Strategy: " + strategyName());

        return headers.get("username").equals("edevries") && headers.get("token").equals("ju5fdqkszix8cud2");
    }

    @Override
    public String strategyName() {
        return "MockLocalAuthStrategy";
    }
}
