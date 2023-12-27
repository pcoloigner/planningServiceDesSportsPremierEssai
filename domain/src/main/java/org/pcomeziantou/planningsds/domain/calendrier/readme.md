Explications au sujet du package calendrier :

contient les packages :
api
core
spi

core : contient les classes de base.
api : contient les interfaces qui sont utilisées par le FrontEnd
spi : contient entre autre les interfaces qui sont utilisées par le back-end. Elles servent à sauvegarder et lire les données Calendrier dans le mode de persistence que l'on choisira.

Dans ce cas particulier, la saison 2023/2024 est généré par la classe CalendrierSaisonSportive2023_2024_Builder. Il n'est pas forcément utile de la "persister" dans une base de données quelconque.


api : contienr "l'action" CreerCalendrierSaisonSportive


