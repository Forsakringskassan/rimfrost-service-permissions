# Krav: Mock tjänst för Identity API

## Bakgrund: 

Implementera en provider för Permissions API (definierat i `rimfrost-service-permissions-openapi`) som svarar
om en angiven identitet har de efterfrågade rättigheterna. Syftet är att ha en fungerande stub att testa mot innan riktig integration
finns på plats.

## Funktionella krav

### PERM-FR-01 - Kontroll av SID behörighet

- **PERM-FR-01.1** `POST /hasSidPermission` ska returnera `true` om den angivna identiteten har rätt att se SID ärenden. Annars ska den returnera `false`.
- **PERM-FR-01.2** `POST /hasSidPermission` ska returnera HTTP 400 status om identitet inte är inkluderad med förfrågan.