# Player2Bdd
Ce plugin vise à enregistrer tous les joueurs se connectant dans une base de 
données.  Il retient seulement le dernier pseudo et ip en fonction de l'UUID.     
Aucune action n'est possible en jeu (commande).          

## Sauvegarde des données
Exemple de table possible en BDD:                         

| **UUID**      | **Pseudo**    | **IP** |
| :------------- |:-------------| :-----|
| 069a79f4-44e9-4726-a5be-fca90e38aaf5 | Notch | 127.0.0.2 |
| 7435e399-af44-4491-a50b-7a0cb2a6f842 | Detobel36 | 127.0.0.42 |
               

## Configuration
La seule chose devant être configuré sont les accès à la base de données.
```
SQL:
    hostname: 127.0.0.1
    port: 3306
    database_name: bdd_name
    username: username
    password: password
    table_name: player
```
Il est possible de choisir le nom de la table :smile:  

## Copyright
Ce plugin utilise deux fichiers présent dans d'autres dépos.          
Il s'agit de: 
- BungeeConfig      
Fait par [r-clancy](https://github.com/r-clancy) et disponible par exemple [ici](https://github.com/r-clancy/BungeeMotd/blob/master/src/main/java/com/rylinaux/bungeemotd/configuration/BungeeConfig.java)
- SQLUtilities         
Fait par [chaseoes](https://github.com/chaseoes) et disponible par exemple [ici](https://github.com/chaseoes/PluginSQL/blob/f4dfc1581b19bd8afe2480901740eca43ea7bbb1/src/main/java/com/chaseoes/pluginsql/utilities/SQLUtilities.java)
                  
Tous les autres fichiers sont sous licence GPL.  Ce qui signifie concrètement 
(pour les personnes ne s'y connaissant pas trop) que :

> 1. La liberté d'exécuter le logiciel, pour n'importe quel usage ;
> 2. La liberté d'étudier le fonctionnement d'un programme et de l'adapter à ses besoins, ce qui passe par l'accès aux codes sources ;
> 3. La liberté de redistribuer des copies ;
> 4. L'obligation de faire bénéficier à la communauté des versions modifiées.              

Source: [Wikipedia](https://fr.wikipedia.org/wiki/Licence_publique_g%C3%A9n%C3%A9rale_GNU) (bah oui j'avais pas mieux :dizzy_face:)

## Télécharger
Le téléchargement du plugin se fait sur la page [releases](https://github.com/detobel36/Player2Bdd/releases/)

## En cas de problème
En cas de problème n'hésitez pas à ouvrir une [issue](https://github.com/detobel36/Player2Bdd/issues/new).  Je suis également disponible 
par mail ou sur différent forum (minecraft.fr ou phoenixr.fr).

## Contact
Email: detobel36(at)hotmail(dot)fr
