Dans le package reference_metier :
Dans api : une liste d'interface pour interroger les différents éléments du référentiel
Dans core : les objets interrogés par 'api' qui vont : 
    - soit fournir concrètement les éléments réels.
    - soit faire appel à une méthode du repository dans 'spi'.

Dans spi : contient l'objet 'Repository' qui est normalement chargé de faire "l'interface" entre le domain et la couche de persistence.




Indépendemment : 
voir : https://beyondxscratch.com/fr/2018/09/11/architecture-hexagonale-le-guide-pratique-pour-une-clean-architecture/