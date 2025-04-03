# 11. Design pattern voor status van Bouwstenen

Date: 2025-03-28

## Status

Accepted

## Context
Bouwstenen kunnen verschillende statussen hebben, zoals Gepland, Geregeld, Betaald, NietUitvoerbaar en Uitgevoerd. Het gedrag van het systeem is afhankelijk van de huidige status van een Bouwsteen.
nu moeten we beslissen of we het state pattern daarvoor willen volgen of het op een andere manier oplossen door functies te laten checken of bepaalde acties mogelijk zijn.
In een propotype is het uitgewerkt met BouwsteenStatus. De forces worden beoordeeld met behulp van dit prototype.

## Options

| Forces                                | state pattern | geen state pattern |
|---------------------------------------|---------------|--------------------|
| Complexiteit                          | -             | +                  |
| onderhoudbaarheid                     | ++            | -                  |
| leesbaarheid                          | +             | -                  | 
| volgt Single Responsibility Principle | ++            | --                 |
| volgt Open/Closed Principle           | ++            | -                  |

## Decision
Op basis van de forces kies ik er wel voor om de state pattern te gebruiken. het zorgt er namelijk voor dat alle states gescheiden blijven dus kan je er gemakkelijk een toevoegen of veranderen.

## Consequences
- Beter onderhoudbaar
- Voegt veel complexiteit toe
- Volgt de design principes gekozen voor deze opdracht 
