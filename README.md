# planningServiceDesSportsPremierEssai

# Introduction 
Tentative de créer un projet "global" en appliquant les règles "DDD" Domain Driven Developpment,
et l'arichitecture hexagonale.
On essaiera également de gérer l'authentifcation.


# TournoiVolleyPremierEssai
1 - Création d'un fichier POM chapeau. (Même si les projets à l'intérieur seront largement indépendants)

2 - Création des répertoires : domain, infrastructure et frontend
Dans "domain", on va écrire le "coeur" de l'application, qui ne contiendra aucune référence à un framework, une librairie technique quelconque.
Dans "infrastructure", on devrait trouver la partie Accès à une base de données (éventuellement), la partie sécurité.
Dans "frontend", on trouvera les applications qui interrogeront le "domain". Notamment une application Angular. 

3 - Création d'une application "planningsds-database" basée sur Spring boot.
Elle contiendra également un front-end Thymeleaf. Mais ce n'est que provisoire.
Note : l'application possède : 
Spring Web Web
Spring Data JPA SQL
H2 Database SQL
Lombok Developer Tools
Thymeleaf Template Engines
OAuth2 Client Security : Spring Boot integration for Spring Security's OAuth2/OpenID Connect client features.
