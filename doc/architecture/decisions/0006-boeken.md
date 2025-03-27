# 6. boeken

Date: 2025-03-27

## Status

Proposed

## Context

Reizigers willen bouwstenen van hun reis kunnen boeken.

## Options

| Forces                     | Via TripTop direct boeken | Reiziger boekt zelf via bouwsteen |
|----------------------------|---------------------------|-----------------------------------|
| Gemak voor eindgebruiker   | ++                        | --                                |
| Ontwikkel complexiteit     | --                        | ++                                |
| Vereist extra API requests | --                        | ++                                |
| Data privacy               | --                        | ++                                |
| Flexibiliteit              | -                         | ++                                |

## Decision

Wij kiezen ervoor dat de reiziger zelf boekt via de bouwsteen, omdat we het belangrijk vinden dat TripTop eerst snel
ontwikkeld kan worden voordat extra functionaliteiten aangeboden worden. TripTop geeft de reiziger een link om te
boeken.

## Consequences

- TripTop moet een URL geven waarmee de reiziger de bouwsteen kan boeken
- Het is minder gebruikersvriendelijk
- De gebruiker heeft meer controle over zijn eigen reserveringen
- Minder technische ondersteuning nodig bij problemen met boeken
- Snellere time-to-market voor het product
- Mogelijk lagere conversie doordat het externe proces minder soepel kan zijn
- Geen direct zicht op boekingsdata van reizigers