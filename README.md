# TP 1 : Programmation dynamique par réflexion en Java

## 1. Présentation du projet

Ce TP a pour objectif de comprendre et de mettre en pratique la programmation dynamique en Java à travers l'API Reflection.

Le projet consiste à développer un mécanisme de chargement dynamique de classes permettant d'instancier des objets et d'injecter leurs dépendances à partir d'un fichier de configuration, sans créer directement les objets dans le code de présentation.

Cette approche permet de comprendre les principes fondamentaux de l'Inversion of Control (IoC) et de l'Injection de Dépendances (DI), utilisés notamment dans les frameworks comme Spring.

## 2. Objectifs du TP

- Comprendre le fonctionnement de l'API Java Reflection.
- Utiliser `Class.forName()` pour charger une classe dynamiquement.
- Créer des objets à l'aide de `Constructor.newInstance()`.
- Invoquer une méthode à l'exécution avec `Method.invoke()`.
- Mettre en œuvre l'injection de dépendances via un setter.
- Externaliser la configuration des classes dans un fichier `config.txt`.
- Comprendre le découplage entre les interfaces et leurs implémentations.

## 3. Technologies utilisées

- **Langage :** Java
- **Version :** JDK 11 ou supérieure
- **IDE :** IntelliJ IDEA
- **API principale :** Java Reflection (`java.lang.reflect`)
- **Configuration :** Fichier texte `config.txt`

Aucune dépendance externe ni aucun framework d'injection de dépendances ne sont nécessaires.

## 4. Architecture du projet

```text
TP1_Reflection/
├── src/
│   └── main/
│       └── java/
│           ├── dao/
│           │   ├── IDao.java
│           │   └── DaoImpl.java
│           ├── metier/
│           │   ├── IMetier.java
│           │   └── MetierImpl.java
│           └── presentation/
│               └── Presentation2.java
├── config.txt
├── pom.xml
└── README.md
```

## 5. Description des composants

### 5.1. Couche DAO

**IDao.java**
=
**DaoImpl.java**

### 5.2. Couche métier

**IMetier.java**

**MetierImpl.java**

### 5.3. Couche présentation et conteneur

**Presentation2.java**

### 5.4. Fichier de configuration

**config.txt**

## 6. Concepts de Java Reflection utilisés

| Méthode | Rôle |
|---|---|
| `Class.forName()` | Charge une classe à partir de son nom complet. |
| `getDeclaredConstructor()` | Récupère le constructeur sans paramètre déclaré. |
| `newInstance()` | Crée une nouvelle instance à partir du constructeur. |
| `getMethod()` | Recherche une méthode publique par son nom et ses paramètres. |
| `invoke()` | Appelle une méthode sur un objet à l'exécution. |

## 7. Exécution du projet

### Prérequis

- Installer un JDK compatible.
- Ouvrir le projet dans IntelliJ IDEA.
- Vérifier que les classes sont compilées.
- Vérifier que `config.txt` est accessible depuis le répertoire de travail de l'application.

### Lancement

1. Ouvrir `Presentation2.java`.
2. Cliquer sur le bouton **Run** situé à côté de la méthode `main()`.
3. Consulter le résultat dans la console.

## 8. Résultat attendu

Avec une implémentation DAO qui retourne `100.0` et une méthode métier qui multiplie cette valeur par deux, la console doit afficher un résultat final égal à `200.0`.

Exemple :

```text
[CONTAINER] DAO instancié : dao.DaoImpl
[CONTAINER] Métier instancié : metier.MetierImpl
[DAO] Recuperation de la valeur
[METIER] Resultat : 200.0
Résultats = 200.0

Process finished with exit code 0
```

Les messages exacts peuvent varier selon les instructions `System.out.println()` présentes dans les classes.

## 9. Gestion des erreurs courantes

- **ClassNotFoundException :** vérifier les noms complets des classes dans `config.txt`.
- **NoSuchMethodException :** vérifier l'existence du constructeur sans paramètre ou de la méthode setter recherchée.
- **InstantiationException :** vérifier que la classe peut être instanciée et qu'il ne s'agit pas d'une interface ou d'une classe abstraite.
- **IllegalAccessException :** vérifier l'accessibilité du constructeur ou de la méthode.
- **NullPointerException :** vérifier que les objets et les lignes de configuration ont bien été initialisés.
- **InvocationTargetException :** vérifier si une exception a été déclenchée à l'intérieur de la méthode invoquée.

## 10. Lien avec l'Inversion of Control (IoC)

