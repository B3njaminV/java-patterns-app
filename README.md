<p align="center">
<img alt="DataHub" src="https://cdn-icons-png.flaticon.com/512/2659/2659980.png" height="200px" />
</p>
<h1 align="center"> Système multi-agents</h1>

---

## 📝 Description

Voici notre projet de système multi-agents réalisé dans le cadre du cours de Software Engineering.

Les différentes classes sont implémentées dans le dossier src, mais on pourrait les séparer en deux catégories :
* la librairie générique avec les classes : `Agent, AgentFactory, Environnement et Strategy`.
* le cas pratique visualisant la propagation de cellules infectées en ajoutant les classes : `Virus, Cellule, InfectedStrategy et HealthyStrategy`.

## 📍 Prérequis pour la compilation
- Java


## 🖼️ Screenshots

| Jeu Temps 1            | Jeu Temps 2            | Jeu Temps 3            |
|------------------------|------------------------|------------------------|
| ![Image](./img/t1.png) | ![Image](./img/t2.png) | ![Image](./img/t3.png) |


## 🏁 Pour commencer
1. Cloner le projet
2. Compilez les fichiers Java avec
```java
javac *.java
```
3. Exécutez le programme avec java Main.
4. Ou sinon sous IntelliJ, vous pouvez exécuter le programme en cliquant sur le bouton "Run" en haut à droite de l'écran.

> [!WARNING]  
> Si jamais les ressources (dossier img) ne sont pas trouvées, c'est peut-être parce que le chemin d'accès est incorrect. Pour corriger cela, vous devrez définir à nouveau le dossier img comme ressource dans votre IDE.

## 🚀 Patterns

- **Singleton** : Utilisé pour la classe Simulator afin de garantir qu'il n'y ait qu'une seule instance de la simulation.
- **Factory** : Utilisé pour créer des instances d'agents dans AgentFactory, ce qui permet d'instancier facilement différents types d'agents sans changer le code du contrôleur.
- **Strategy** : Utilisé pour définir les comportements des cellules en fonction de leur état (HealthyStrategy et InfectedStrategy). On peut ainsi changer dynamiquement le comportement des cellules lorsqu'elles changent d'état.
- **State** : Implémenté implicitement par la stratégie, où l'état de la cellule change et la stratégie appropriée est appliquée.

## 📦 Quelques explications sur les conceptions de certaines classes du projet
- **HealthyStrategy** : Les cellules saines évitent les virus en se déplaçant à une position aléatoire si elles détectent un virus à proximité.
- **InfectedStrategy** : Les cellules infectées propagent l'infection aux cellules saines voisines.
- **AgentFactory** : Permet de créer des instances d'agents en fonction de leur type.
- **Simulator** : Classe principale qui gère la simulation. Elle contient une instance de la grille, des agents et des stratégies. Elle gère également le déroulement de la simulation.

# 🔥 Diagramme de Conception

Le diagramme ci-dessous représente la conception de notre projet, en mettant en évidence les designs patterns implémentés

> [!NOTE] 
> Vous pourrez également retrouver le diagramme de conception (format plantUML) dans le fichier `Diagramme.puml` à la racine du projet.

![Diagramme de Conception](https://www.plantuml.com/plantuml/png/hLF1QXin4BtxAqHEwuRD1vXWKaAXXUOKoANqe6gdQr6jP3IpTKtQV-z8aQBPPW-1Pa-MvhqtJs_6DqWwqZovpL6R7te4THS6SEfne_WpJYEgzoDuAZVfwzMt41nehwp_3ePWU2vTAcses-RpdutGk0NdNYjXyLEvxBPgLv42W43FYCflm9Nk3pREADfVbhQTIRPssLsbCR56SHiynU0Sn4KUznGrmNXU2C8lC3D1ftDOkwVGLgnKurM4YGH--4_LZw0T7SvlAtflfzbf2d4nE2HDreYYzNpb3GZC1__Jnk2df0_jj_0GPzzjnNdaaHQTDFGc_t8g3nPESXuDMofDTR1uTFhSWV2pa-x4qBEMh1MbNdssIDTfHVOgxGlAwvpTNkKekL3Vaj2O7YB8hPf9kIn5ceaxRRrwBFY93vsE8wPKA5e_VlcwJTZyHxtANDL7EnwetukLlQgpPzx5Z80NIyOGJfu9JtV9OC9PJn2r8LGdImTcjEhrxxvNKe7XXhknFPPUwviPel3lwh-AL3TxZLFdtfulnbVzCLZwaxHtifKiC1KvQ0SK_3gtvfUtiLsdKyxxE6XAaQ-K-vS-ovuo_WRyC4_kBm00)

## 📦 Packaging
Pour créer un exécutable, vous pouvez utiliser les commande suivantes :
1. Créez un fichier manifeste avec le contenu suivant :
```shell
Main-Class: Main
```
2. Compilez les fichiers Java avec la commande suivante :
```shell
javac -d bin *.java
```
3. Créez un fichier jar avec la commande suivante :
```shell
jar cfm ../Executable.jar ../manifest.txt -C bin .
```
4. Exécutez le fichier jar avec la commande suivante :
```shell
java -jar Executable.jar
```

> [!NOTE]
> Vous pourrez trouver un fichier jar déjà compilé dans les releases du projet mais aussi à la racine du projet.
> Vous pouvez créer un fichier jar en suivant les étapes ci-dessus.


## ✍️ Auteurs

👤 **VALLEIX Benjamin**

* GitHub: [@B3njaminV](https://github.com/B3njaminV)
* LinkedIn: [@Benjamin VALLEIX](https://www.linkedin.com/in/benjamin-valleix-27115719a)

👤 **GIRAUDIER Augustin**

* GitHub: [@GIRAUDIERAugustin](https://github.com/AugustinGiraudier)
* LinkedIn: [@GIRAUDIER Augustin](https://fr.linkedin.com/in/augustin-giraudier)


## 📝 License

Copyright © 2024
