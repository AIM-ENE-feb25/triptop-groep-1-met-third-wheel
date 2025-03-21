# 4. Mail API Architectuur Beslissing

Date: 2025-03-21

## Status

Accepted

## Context

Het Triptop vakantieplanningssysteem moet integreren met een externe mail service API om e-mails naar klanten te
versturen, waaronder reserveringsbevestigingen, reiswijzigingen en betalingsnotificaties. In plaats van zelf
e-mailfunctionaliteit te implementeren, moeten we een geschikte externe API selecteren om deze verantwoordelijkheid te
beheren.

Belangrijke vereisten zijn:

- Lage kosten per e-mail (essentieel voor operaties met hoog volume)
- Mogelijkheid om een groot aantal e-mails per dag te ondersteunen
- Betrouwbare aflevering van e-mails om te verzekeren dat klantcommunicatie wordt ontvangen

## Options

| Forces                      | Amazon SES API | SendGrid API | Mailgun API | Postmark API |
|-----------------------------|----------------|--------------|-------------|--------------|
| Kostenefficiëntie           | ++             | 0            | +           | -            |
| Volumecapaciteit            | ++             | ++           | +           | 0            |
| API Integratie              | +              | ++           | +           | ++           |
| Betrouwbaarheid             | ++             | ++           | +           | ++           |
| Documentatiekwaliteit       | +              | ++           | +           | ++           |
| HTML E-mail Ondersteuning   | ++             | ++           | ++          | ++           |
| Template Ondersteuning      | 0              | ++           | +           | +            |
| Aangepaste Afzenderdomeinen | ++             | ++           | ++          | ++           | 
| Prestaties                  | +              | +            | +           | ++           |
| Bijlage Ondersteuning       | +              | ++           | ++          | +            |

## Decision

We zullen integreren met de **Amazon SES API** voor de e-mail behoeften van Triptop.

Amazon SES API biedt:

- Kosten: €0,10 per 1.000 e-mails zonder maandelijkse basistarieven
- 100K e-mails zouden precies €10,00 kosten
- Geen extra kosten voor bijlagen (alleen standaard S3-opslagkosten indien bijlagen worden opgeslagen)
- Standaard verzendquotum van 50.000 e-mails/dag (kan op verzoek worden verhoogd)

Vergeleken met alternatieven:

- SendGrid: Vanaf €14,95/maand voor 40K e-mails (€0,37/1K extra) = ~€36,95 voor 100K
- Mailgun: €35/maand voor 50K e-mails (€0,80/1K extra) = ~€75 voor 100K
- Postmark: €10/maand voor 10K e-mails (€1,25/1K extra) = ~€122,50 voor 100K

## Consequences

### Development

- Eigen templating-mechanisme vereist
- Robuuste foutafhandeling noodzakelijk voor bezorgingsissues

### Operations

- IAM-permissies en AWS-account setup nodig
- Monitoring voor quotumlimieten opzetten
- Domeinverificatie en reputatiebeheer regelen

### Business

- Lagere e-mailkosten bij schaalvergroting
- Enige initiële vertragingen door AWS-configuratie