# 4. mail api

Date: 2025-03-21

## Status

Accepted

## Context

Het Triptop systeem moet confirmatie mails kunnen versturen.

## Options

| Forces                                      | RapidMail | Mail Sender | GmailAPI |
|---------------------------------------------|-----------|-------------|----------|
| Goede documentatie beschikbaar              | 0         | +           | ++       |
| Kan zelf het verzender email adress bepalen | ?         | ++          | ++       |
| Kan HTML based emails verzenden             | ++        | ++          | ++       |
| Snelheid                                    | --        | +           | ++       |

## Decision

We kiezen voor de GmailAPI omdat deze API alles biedt wat we zoeken.

## Consequences

Triptop zal een gmail account moeten aanmaken.