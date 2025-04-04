# 9. Strategy design pattern voor authenticatie

Date: 2025-03-31

## Status

Accepted

## Context

In het prototype is gebruik gemaakt van de Strategy en Factory Method patterns.
In code ziet het er als volgt uit:

```java
IAuthStrategy authStrategy = authStrategyFactory.getStrategy(parameterMap.get("auth-type"));
boolean isAuthenticated = false;
isAuthenticated = authStrategy.authenticate(parameterMap);
```

```java
@Component
public class AuthStrategyFactory {
    public IAuthStrategy getStrategy(String authType) {
        return switch (authType) {
            case "mock" -> new MockAuthStrategy();
            case "local" -> new MockLocalAuthStrategy();
            default -> throw new IllegalArgumentException("Unknown auth type: " + authType);
        };
    }
}
```

```java
public interface IAuthStrategy {
    boolean authenticate(Map<String, String> requestParams);
    String strategyName();
}
```

## Options

| Forces                                            | Strategy ja | Strategy nee | Factory ja | Factory nee |
|---------------------------------------------------|-------------|--------------|------------|-------------|
| Frontend kan authenticatie methode bepalen        | ++          | --           | ++         | ++          |
| Backend code volgt single responsiblity principle | ++          | --           | ++         | --          |


## Decision

Dit werkt goed en staat gemakkelijk toe om nieuwe authenticatie strategien toe te voegen. Ook kan de frontend bepalen
welke strategy gebruikt moet worden. De frontend weet dit omdat het inloggen met de Identity Provider direct vanaf de
frontend gebeurt.

## Consequences

Het is makkelijk om nieuwe inlog-mogelijkheden toe te voegen.
Er moet altijd een inlog-strategy gebruikt worden.
Er moet samengewerkt worden vanuit de frontend en backend voor de namen van de headers.