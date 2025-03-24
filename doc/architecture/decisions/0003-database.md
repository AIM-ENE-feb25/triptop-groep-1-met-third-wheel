# 3. Database

Date: 2025-03-21

## Status

Accepted

## Context

Het Triptop systeem moet data over de reis van een reiziger kunnen opslaan. Het systeem zelf is niet verantwoordelijk
voor de vormgeving van de data. Het systeem zal data opslaan die gevonden is via externe API's.

## Options

| Forces                       | PostgreSQL | MongoDB | Redis | Couchbase |
|------------------------------|------------|---------|-------|-----------|
| Kan flexibiele data opslaan  | 0          | ++      | ++    | ++        |
| Kennis                       | +          | 0       | -     | -         |
| Schaalbaarheid               | +          | ++      | ++    | ++        |
| Query mogelijkheden          | ++         | +       | 0     | +         |
| Community support            | ++         | ++      | 0     | +         |
| Goed voor langduring opslaan | ++         | ++      | --    | ++        |
| Goed voor caching            | --         | --      | ++    | --        |

## Decision

We kiezen voor MongoDB aangezien deze database zeer geschikt is voor het opslaan van flexibele reisinformatie en goede
community support heeft. Deze twee onderdelen wogen zwaarder mee in de beslissing, omdat Triptop geen controle heeft
over de vormgeving van de data.

## Consequences

Het team moet leren hoe MongoDB werkt.
Reis data wordt opdezelfde manier opgeslagen als dat het gebruikt wordt in de frontend.