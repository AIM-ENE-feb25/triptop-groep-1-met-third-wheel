# 10. nieuwe api toevoegen design patterns

Date: 2025-03-31

## Status

Accepted

## Context

Voor TripTop is het belangrijk dat er nieuwe API diensten toegevoegd kunnen worden zonder dat er bestaande bron code
veranderd moet worden. In het prototype is er gebruik gemaakt van het Facade pattern en de vraag is of dit een goed
design pattern is voor deze ontwerp vraag.

## Options

| Forces                               | Ja | nee |
|--------------------------------------|----|-----|
| Volgt Dependency Inversion Principle | ++ | --- |
| Volgt Single Responsibilty Principle | ++ | --  |

## Decision

We gaan gebruik maken van dit design pattern, in het prototype is de facade op de KaartenService. Die verbergt dat er
een API call gedaan wordt om het adres te krijgen vanuit de coordinaten.

## Consequences

Het is makkelijker om te wisselen tussen coordinaten en adressen.
Je moet door meer lagen stappen om de code te begrijpen.