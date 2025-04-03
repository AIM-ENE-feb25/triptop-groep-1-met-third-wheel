# 5. gateway security

Date: 2025-03-27

## Status

Accepted

Superceded by [8. Use Spring Cloud Gateway for gateway](0008-use-spring-cloud-gateway-for-gateway.md)

## Context

De applicatie moet beveiligd worden. Op alle requests moeten tokens aanwezig zijn en geverifieerd worden. Er hoeft enkel
gekeken te worden of de gebruiker geauthorizeerd is, verder moeten geen acties ondernomen worden.

## Options

| Forces                                 | Spring Security | Spring Boot Filters | ClientHttpRequestInterceptor |
|----------------------------------------|-----------------|---------------------|------------------------------|
| Moet incoming requests kunnen filteren | ++              | ++                  | --                           |
| Moet eenvoudig zijn                    | -               | ++                  | +                            |
| Staat custom filters toe               | ++              | ++                  | ++                           |    

## Decision

We kiezen voor Spring Boot Filters omdat dit een envoudige manier is om een filter uit te voeren op alle requests. Omdat
het voor ons enorm belangrijk is dat het eenvoudig is en we geen extra acties moeten ondernemen, daarom is de extra
complexiteit van Spring Security ongewenst.

## Consequences

- We kunnen eenvoudig nieuwe filters toevoegen.
- We moeten Spring Boot gebruiken.
