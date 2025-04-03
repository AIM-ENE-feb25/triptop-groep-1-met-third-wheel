# 10. Design pattern voor toevoegen API's

Date: 2025-03-31

## Status

Accepted

## Context

Voor TripTop is het belangrijk dat er nieuwe API diensten toegevoegd kunnen worden zonder dat er bestaande bron code
veranderd moet worden. In het prototype is er gebruik gemaakt van het Facade pattern en de vraag is of dit een goed
design pattern is voor deze ontwerp vraag.

## Options

| Forces                                      | Ja | nee |
|---------------------------------------------|----|-----|
| Volgt Dependency Inversion Principle        | ++ | --  |
| Volgt Single Responsibilty Principle        | ++ | --  |
| Makkelijk uit te breiden met meerdere API's | ++ | -   |

## Decision

We gaan gebruik maken van dit design pattern, in het prototype is de facade op de KaartenService en de RestaurantService. Die verbergt dat er
een API call gedaan wordt om informatie uit de API's te krijgen..

## Consequences

- Het is makkelijker om te wisselen tussen coordinaten en adressen.
- Je moet door meer lagen stappen om de code te begrijpen.