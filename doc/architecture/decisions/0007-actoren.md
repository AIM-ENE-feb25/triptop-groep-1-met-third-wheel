# 7. actoren

Date: 2025-03-27

## Status

Proposed

## Context

De vraag is voor welke actoren de TripTop applicatie gemaakt moet worden.

## Options

| Forces                 | Beheerder | Reisagent | Reiziger |
|------------------------|-----------|-----------|----------|
| Complexiteit           | --        | -         | +        |
| Relevant voor opdracht | --        | -         | ++       |
| Ontwikkeltijd          | --        | -         | +        |
| Onderhoudbaarheid      | --        | -         | +        |
| Gebruikerservaring     | +         | +         | ++       |

## Decision

We kiezen ervoor om in het begin alleen de reiziger als actor te beschouwen om de time to market te verkleinen. Wanneer
er meer tijd is wordt er eerst voor de reisagent ontwikkeld omdat er voor een beheerder niet veel te beheren is.

## Consequences

- Door in eerste instantie alleen de reiziger te ondersteunen, kan er sneller een eerste versie van de applicatie op de
  markt worden gebracht.
- Het risico bestaat dat andere belanghebbenden, zoals reisagenten, minder snel betrokken raken.
- Extra kosten en inspanningen zijn mogelijk nodig bij het later toevoegen van functionaliteiten voor andere actoren.
- De beperkte scope biedt strategisch voordeel door een gerichtere en meer gefocuste applicatie te ontwikkelen.