# 8. Gebruik van Spring Cloud Gateway voor gateway

Date: 2025-03-31

## Status

Accepted

Supercedes [5. gateway security](0005-gateway-security.md)

## Context

Om te zorgen dat alle requests via de gateway doorgaan naar de backend server wanneer ze door alle filters gaan moet er
een technology gebruikt worden voor het doorsturen van requests.

## Options

| Forces        | Maak de doorstuur technology zelf | Spring Cloud Gateway |
|---------------|-----------------------------------|----------------------|
| Complexiteit  | ?                                 | ++                   |
| Onderhoud     | --                                | ++                   |
| Performance   | ?                                 | +                    |
| Flexibiliteit | ?                                 | ++                   |

## Decision

We kiezen om Spring Cloud Gateway te gebruiken, omdat het biedt wat nodig is en in het Spring
ecosysteem zit, waar de rest van de TripTop applicatie ook mee gemaakt wordt.

## Consequences

Consequentie hiervoor is dat er geen gebruik gemaakt kan worden van de Filter interface van Spring Boot Web, maar er moet
gebruik gemaakt worden van de GlobalFilter en Ordered interfaces van Spring Cloud Gateway. 
Het is makkelijk om te wisselen naar een nieuwe server, omdat er maar op een plek het URL domein gebruikt wordt.
Het is makkelijk om te wisselen naar een microservice structuur met meerdere kleine servers.