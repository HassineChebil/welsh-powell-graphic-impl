welsh-powell-graphic-impl
=========================


## Implémentation graphique de l'algorithme de Welsh et Powell - Introduction

============

En théorie des graphes, ```colorer un graphe``` signifie attribuer une couleur à tous les sommets de telle sorte que deux sommets adjacents soient de couleurs différentes. On appelle ```nombre chromatique``` d'un graphe le nombre minimum de couleurs nécessaires pour colorier chaque sommet du graphe de façon que deux sommets adjacents soient de couleurs différentes. Le problème de coloration qui consiste à trouver ```le nombre chromatique``` d'un graphe donné est un problème difficile. ```L'algorithme de Welsh et Powell``` est un algorithme qui se base sur les degrés des sommets pour proposer une assez bonne coloration du graphe. Cependant l'algorithme n'assure pas que la coloration soit minimale.


## Quelques illustrations pour démontrer l'utilité du nombre chromatique 

============

# Exemple 1 

![Image not found](http://nabil.zz.mu/projets/photo/chimique.jpg " ")

vous voulez transporter des produits chimiques d'un lieu à un autre. chaque cercle représente un produit et la liaison signifie que les deux produits ne peuvent etre transportés ensembles. Vous vous demandez, avec tous ces produits, combien de camions il vous faut au minimum.

# Exemple 2

vous organisez une fete. Chaque cercle représente une personne et la liaison signifie que les deux personnes ne s'entendent pas. Vous vous demandez combien de tables au minimum il faut mettre en place pourque deux personnes qui ne s'entendent pas ne soient pas sur la meme table.


## Limitation de l'algorithme 

============

Il est bon de savoir que l'algorithme de Welsh et Powell peut donner des résultats erronés et aboutir parfois à la pire des colorations possible. Par exemple si le graphe G a ```la structure de couronne à n sommets```, son nombre chromatique est de 2 si n est pair, alors que l'algorithme de Welsh et Powell donne dans certains cas une coloration utilisant n/2 couleurs selon l'ordre dans lequel sont rangés les sommets. 

![Image not found](http://nabil.zz.mu/projets/photo/graphe-couronne.png "graphe-couronne")

## Screenshot
============

![Image not found](http://nabil.zz.mu/projets/photo/WelshPowell.png "screenshot")

By Noureddine Tiouajni & Nabil Andriantomanga


