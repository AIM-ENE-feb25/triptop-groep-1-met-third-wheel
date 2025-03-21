# 2. Kaarten API

Date: 2025-03-21

## Status

Accepted

## Context

Het Triptop reisplanner systeem heeft een kaarten API nodig zodat gebruikers routes kunnen plannen. De API moet gratis
te gebruiken zijn, de gebruiker kent de coordinaten niet persee en het systeem zal die moeten opzoeken op basis van de
informatie van de locatie.

## Options

| Forces                                   | Google Maps Places | True Way Direction | MapboxDirection |
|------------------------------------------|--------------------|--------------------|-----------------|
| Kan coordinaten vinden op basis van text | ++                 | --                 | --              |
| Snelheid                                 | ++                 | ++                 | --              |
| Kan tussenstops inplannen                | --                 | ++                 | ++              |
| Goede documentatie beschikbaar           | --                 | ++                 | 0               |

## Decisions

Op basis van deze de decisions forces tabel wordt het duidelijk dat er meerdere API's nodig zullen zijn. Google Maps
Places om de coordinaten van locaties te vinden. En True Way Direction om de routes in te plannen.

## Consequences

Er zullen meerdere API verzoeken gedaan moeten worden om routes in te plannen.