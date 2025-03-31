<!-- TOC -->
* [Software Guidebook Triptop](#software-guidebook-triptop)
  * [1. Introduction](#1-introduction)
  * [2. Context](#2-context)
  * [3. Functional Overview](#3-functional-overview)
    * [3.1 User Stories](#31-user-stories)
      * [3.1.1 User Story 1: Reis plannen](#311-user-story-1-reis-plannen)
      * [3.1.2 User Story 2: Reis boeken](#312-user-story-2-reis-boeken)
      * [3.1.3 User Story 3: Reis cancelen](#313-user-story-3-reis-cancelen)
      * [3.1.4 User Story 4: Reisstatus bewaren](#314-user-story-4-reisstatus-bewaren-)
      * [3.1.5 User Story 5: Bouwstenen flexibel uitbreiden](#315-user-story-5-bouwstenen-flexibel-uitbreiden)
    * [3.2 Domain Story Reis Boeken (AS IS)](#32-domain-story-reis-boeken-as-is)
    * [3.3 Domain Story Reis Boeken (TO BE)](#33-domain-story-reis-boeken-to-be)
    * [3.4 Domain Model](#34-domain-model)
  * [4. Quality Attributes](#4-quality-attributes)
  * [5. Constraints](#5-constraints)
  * [6. Principles](#6-principles)
  * [7. Software Architecture](#7-software-architecture)
    * [7.1. Containers](#71-containers)
      * [7.1.1 Inloggen](#711-inloggen)
      * [7.1.2 Reis boeken](#712-reis-boeken)
    * [7.2. Components](#72-components)
    * [7.3. Design & Code](#73-design--code)
  * [8. Architectural Decision Records](#8-architectural-decision-records)
    * [8.1. ADR-001 Kaarten API](#81-adr-001-kaarten-api)
      * [Context](#context-)
      * [Considered Options](#considered-options)
      * [Decision](#decision)
      * [Status](#status-)
      * [Consequences](#consequences-)
    * [8.2. ADR-002 Database](#82-adr-002-database)
      * [Context](#context)
      * [Considered Options](#considered-options-1)
      * [Decision](#decision-1)
      * [Status](#status)
      * [Consequences](#consequences)
    * [8.3. ADR-003 Mail API](#83-adr-003-mail-api)
      * [Context](#context-1)
      * [Considered Options](#considered-options-2)
      * [Decision](#decision-2)
      * [Status](#status-1)
      * [Consequences](#consequences-1)
        * [Development](#development)
      * [Operations](#operations)
      * [Business](#business)
  * [9. Deployment, Operation and Support](#9-deployment-operation-and-support)
<!-- TOC -->

# Software Guidebook Triptop

## 1. Introduction
Dit software guidebook geeft een overzicht van de Triptop-applicatie. Het bevat een samenvatting van het volgende: 
1. De vereisten, beperkingen en principes. 
1. De software-architectuur, met inbegrip van de technologiekeuzes op hoog niveau en de structuur van de software. 
1. De ontwerp- en codebeslissingen die zijn genomen om de software te realiseren.
1. De architectuur van de infrastructuur en hoe de software kan worden geinstalleerd. 

## 2. Context

Het context diagram ziet er als volgt uit:

![Context diagram](../opdracht-diagrammen/Context%20diagram.png)

De gebruiker is een reiziger die een reis wil plannen en boeken. Met de Triptop applicatie kan de reiziger dit doen.
Triptop gebruikt externe API's om informatie over de bouwstenen op te halen.
De Identity Provider zorgt voor authenticatie en autorisatie van de gebruiker op de website.
## 3. Functional Overview

Om de belangrijkste features toe te lichten zijn er user stories en twee domain stories gemaakt en een overzicht van het domein in de vorm van een domeinmodel. Op deze plek staat typisch een user story map maar die ontbreekt in dit voorbeeld.

### 3.1 User Stories

#### 3.1.1 User Story 1: Reis plannen

Als gebruiker wil ik een zelfstandig op basis van diverse variabelen (bouwstenen) een reis kunnen plannen op basis van mijn reisvoorkeuren (wel/niet duurzaam reizen, budget/prijsklasse, 's nachts reizen of overdag etc.) zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.2 User Story 2: Reis boeken

Als gebruiker wil ik een geplande reis als geheel of per variabele (bouwsteen) boeken en betalen zodat ik op vakantie kan gaan zonder dat hiervoor een reisbureau benodigd is.

#### 3.1.3 User Story 3: Reis cancelen

Als gebruiker wil ik een geboekte reis, of delen daarvan, kunnen annuleren zodat ik mijn geld terug kan krijgen zonder inmenging van een intermediair zoals een reisbureau.

#### 3.1.4 User Story 4: Reisstatus bewaren 

Als gebruiker wil ik mijn reisstatus kunnen bewaren zonder dat ik een extra account hoef aan te maken zodat ik mijn reis kan volgen zonder dat ik daarvoor extra handelingen moet verrichten.

#### 3.1.5 User Story 5: Bouwstenen flexibel uitbreiden

Als gebruiker wil ik de bouwstenen van mijn reis flexibel kunnen uitbreiden met een zelf te managen stap (bijv. met providers die niet standaard worden aangeboden zoals een andere reisorganisatie, hotelketen etc.) zodat ik mijn reis helemaal kan aanpassen aan mijn wensen.

### 3.2 Domain Story Reis Boeken (AS IS)

![Domain Story Reis Boeken AS IS](../opdracht-diagrammen/reis-boeken-asis-coursegrained_2024-06-11.egn.svg)

### 3.3 Domain Story Reis Boeken (TO BE)

![Domain Story Reis Boeken TO BE](../opdracht-diagrammen/reis-boeken-tobe-coursegrained_2024-06-11.egn.svg)

### 3.4 Domain Model

![Domain Model](../opdracht-diagrammen/Domain%20Model.png)

## 4. Quality Attributes

Voordat deze casusomschrijving tot stand kwam, heeft de opdrachtgever de volgende ISO 25010 kwaliteitsattributen benoemd als belangrijk:
* Compatibility -> Interoperability (Degree to which a system, product or component can exchange information with other products and mutually use the information that has been exchanged)
* Reliability -> Fault Tolerance (Degree to which a system or component operates as intended despite the presence of hardware or software faults)
* Maintainability -> Modularity (Degree to which a system or computer program is composed of discrete components such that a change to one component has minimal impact on other components)
* Maintainability -> Modifiability (Degree to which a product or system can be effectively and efficiently modified without introducing defects or degrading existing product quality)
* Security -> Integrity (Degree to which a system, product or component ensures that the state of its system and data are protected from unauthorized modification or deletion either by malicious action or computer error)
* Security -> Confidentiality (Degree to which a system, product or component ensures that data are accessible only to those authorized to have access)

## 5. Constraints

> [!IMPORTANT]
> Beschrijf zelf de beperkingen die op voorhand bekend zijn die invloed hebben op keuzes die wel of niet gemaakt kunnen of mogen worden.

## 6. Principles
- Open/Closed Principle
- Dependency Inversion Principle
- Program to Interface
## 7. Software Architecture

###     7.1. Containers
Het statische container diagram staat hieronder.
![Statisch container diagram](../opdracht-diagrammen/Static%20container%20diagram.png)
De reiziger bezoekt de website, deze communiceert met de Identity Provider bij het inloggen.
Als de reiziger al ingelogd is en andere acties doet, controleert de backend dat de token klopt.
De backend vraagt informatie op van de externe API's en geeft deze terug naar de webapplicatie.
De database slaat de planning van een reis op. 

In de volgende stukken worden de dynamische container diagrammen weergegeven voor bij het inloggen en het boeken van een reis.

#### 7.1.1 Inloggen
![Dynamisch diagram inloggen](../opdracht-diagrammen/Dynamisch%20container%20diagram%20inloggen.png)

De reiziger logt in op de website met de inloggegevens. De webapplciatie stuurt die door naar de Identity Provider en deze geeft een token terug.

#### 7.1.2 Reis boeken
![Dynamisch diagram reis boeken](../opdracht-diagrammen/Dynamisch%20container%20diagram%20reis%20boeken.png)  
De reiziger voegt op de website een bouwsteen toe. Deze bevat informatie van een externe API.
De web applicatie stuurt een API-request door naar de backend met deze bouwsteen en de token van de reiziger.
De backend stuurt de token op naar de Identity Provider om deze te laten controleren.
Bij goedkeuring wordt de bouwsteen opgeslagen in de database.
###     7.2. Components

> [!IMPORTANT]
> Voeg toe: Component Diagram plus een Dynamic Diagram van een aantal scenario's inclusief begeleidende tekst.

###     7.3. Design & Code

> [!IMPORTANT]
> Voeg toe: Per ontwerpvraag een Class Diagram plus een Sequence Diagram van een aantal scenario's inclusief begeleidende tekst.

## 8. Architectural Decision Records

In dit hoofdstukken worden verschillende beslissingen uitgelegd met behulp van ADR's.

### 8.1. ADR-001 Kaarten API

Datum: 2025-03-21

#### Context 

Het Triptop reisplanner systeem heeft een kaarten API nodig zodat gebruikers routes kunnen plannen. De API moet gratis
te gebruiken zijn, de gebruiker kent de coordinaten niet persee en het systeem zal die moeten opzoeken op basis van de
informatie van de locatie.

#### Considered Options

| Forces                                   | Google Maps Places | True Way Direction | MapboxDirection |
|------------------------------------------|--------------------|--------------------|-----------------|
| Kan coordinaten vinden op basis van text | ++                 | --                 | --              |
| Snelheid                                 | ++                 | ++                 | --              |
| Kan tussenstops inplannen                | --                 | ++                 | ++              |
| Goede documentatie beschikbaar           | --                 | ++                 | 0               |

#### Decision

Op basis van deze de decisions forces tabel wordt het duidelijk dat er meerdere API's nodig zullen zijn. Google Maps
Places om de coordinaten van locaties te vinden. En True Way Direction om de routes in te plannen.

#### Status 

Accepted

#### Consequences 

Er zullen meerdere API verzoeken gedaan moeten worden om routes in te plannen.
Er zal code nodig zijn om de API's samen te laten werken.
De totale kosten zullen hoger worden omdat er meerdere API's nodig zijn.

### 8.2. ADR-002 Database

Datum: 2025-03-21

#### Context

Het Triptop systeem moet data over de reis van een reiziger kunnen opslaan. Het systeem zelf is niet verantwoordelijk
voor de vormgeving van de data. Het systeem zal data opslaan die gevonden is via externe API's.

#### Considered Options

| Forces                      | PostgreSQL | MongoDB | Redis | Couchbase |
|-----------------------------|------------|---------|-------|-----------|
| Kan flexibiele data opslaan | 0          | ++      | ++    | ++        |
| Kennis                      | +          | 0       | -     | -         |
| Schaalbaarheid              | +          | ++      | ++    | ++        |
| Query mogelijkheden         | ++         | +       | 0     | +         |
| Community support           | ++         | ++      | 0     | +         |    

#### Decision

We kiezen voor MongoDB aangezien deze database zeer geschikt is voor het opslaan van flexibele reisinformatie en goede
community support heeft. Deze twee onderdelen wogen zwaarder mee in de beslissing, omdat Triptop geen controle heeft
over de vormgeving van de data.

#### Status

Accepted

#### Consequences

Het team moet leren hoe MongoDB werkt.
Reis data wordt opdezelfde manier opgeslagen als dat het gebruikt wordt in de frontend.

### 8.3. ADR-003 Mail API

Datum: 2025-03-21

#### Context

Het Triptop vakantieplanningssysteem moet integreren met een externe mail service API om e-mails naar klanten te
versturen, waaronder reserveringsbevestigingen, reiswijzigingen en betalingsnotificaties. In plaats van zelf
e-mailfunctionaliteit te implementeren, moeten we een geschikte externe API selecteren om deze verantwoordelijkheid te
beheren.

Belangrijke vereisten zijn:

- Lage kosten per e-mail (essentieel voor operaties met hoog volume)
- Mogelijkheid om een groot aantal e-mails per dag te ondersteunen
- Betrouwbare aflevering van e-mails om te verzekeren dat klantcommunicatie wordt ontvangen

#### Considered Options

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

#### Decision

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

#### Status

Accepted

#### Consequences

##### Development

- Eigen templating-mechanisme vereist
- Robuuste foutafhandeling noodzakelijk voor bezorgingsissues

#### Operations

- IAM-permissies en AWS-account setup nodig
- Monitoring voor quotumlimieten opzetten
- Domeinverificatie en reputatiebeheer regelen

#### Business

- Lagere e-mailkosten bij schaalvergroting
- Enige initiële vertragingen door AWS-configuratie

## 9. Deployment, Operation and Support

> [!TIP]
> Zelf beschrijven van wat je moet doen om de software te installeren en te kunnen runnen.