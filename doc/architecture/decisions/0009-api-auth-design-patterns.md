# 9. api auth design patterns

Date: 2025-03-31

## Status

Accepted

## Context

In het prototype is gebruik gemaakt van de Strategy en Factory Method patterns.

In code ziet het er als volgt uit:

```java
AuthStrategy authStrategy = authStrategyFactory.getStrategy(parameterMap.get("auth-type"));
boolean isAuthenticated = false;
isAuthenticated =authStrategy.

authenticate(parameterMap);
```

```java

@Component
public class AuthStrategyFactory {
    private final RestTemplate restTemplate = new RestTemplate();

    public AuthStrategy getStrategy(String authType) {
        return switch (authType) {
            case "mock" -> new MockAuthStrategy(restTemplate);
            case "google" -> new GoogleMockAuthStrategy(restTemplate);
            default -> throw new IllegalArgumentException("Unknown auth type: " + authType);
        };
    }
}
```

```java
public abstract class AuthStrategy {
    protected final RestTemplate restTemplate;
    protected final String authApiLink;
    protected final String strategyName;

    protected AuthStrategy(RestTemplate restTemplate, String authApiLink, String strategyName) {
        this.restTemplate = restTemplate;
        this.authApiLink = authApiLink;
        this.strategyName = strategyName;
    }

    public abstract boolean authenticate(Map<String, String> requestParams);
}
```

## Options

| Forces                                            | Strategy ja | Strategy nee | Factory ja | Factory nee |
|---------------------------------------------------|-------------|--------------|------------|-------------|
| Frontend kan authenticatie methode bepalen        | ++          | --           | ++         | ++          |
| Backend code volgt single responsiblity principle | ++          | --           | ++         | --          |


## Decision

Dit werkt goed en staat gemakkelijk toe om nieuwe authenticatie strategien toe te voegen. Ook kan de frontend bepalen
welke strategy gebruikt moet worden, de frontend weet dit omdat het inloggen met de Identity Provider direct vanaf de
frontend gebeurt.

## Consequences

Het is makkelijk om nieuwe inlog mogelijkheden toe te voegen.
Er moet altijd een inlog strategy gebruikt worden.
Er moet samengewerkt worden vanuit de frontend en backend voor de namen van de headers.