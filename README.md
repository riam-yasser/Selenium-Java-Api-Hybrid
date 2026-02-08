# 🎯 Test Automation Framework
Selenium + Cucumber + Function Libraries + JUnit + RestAssured

## 🚀 Introduction
Ce projet propose un framework d’automatisation complet (UI + API), incluant :

- 🧪 Tests UI Selenium WebDriver
- 🥒 Tests BDD Cucumber
- 📚 Function Libraries (UI actions, API helpers, utils)
- 🌐 Tests API RestAssured
- ⚙️ Exécution via JUnit
- 📊 Rapport HTML Cucumber généré automatiquement

# 🎯 Test Automation Framework
Selenium + Cucumber + Function Libraries + JUnit + RestAssured

## 🧩 Définition des Technologies Utilisées

### 🔹 Selenium
Selenium est un framework open-source permettant d’automatiser les tests UI sur navigateurs web.  
Il simule des interactions utilisateur (clics, saisies, navigation) et permet d’automatiser des scénarios complexes dans un environnement cross-browser.

### 🔹 Cucumber
Cucumber est un outil BDD (Behavior-Driven Development) qui permet d’écrire les tests sous forme de scénarios lisibles par les équipes métier.  
Les scénarios sont écrits en Gherkin (Given / When / Then), puis liés à des *step definitions* Java.

### 🔹 JUnit
JUnit est un framework de tests Java.  
Dans ce projet, il sert de runner pour exécuter les scénarios Cucumber et gérer les cycles de tests (setup, teardown…).

### 🔹 RestAssured
RestAssured est une librairie Java dédiée aux tests API REST.  
Elle facilite l’envoi de requêtes HTTP (GET/POST/PUT/DELETE), la validation des réponses, des schémas JSON et des assertions complexes.

## Approche
Behavior-Driven Development (BDD) est une méthode qui étend TDD en mettant l’accent sur la collaboration et la spécification via des scénarios lisibles. L’automatisation des tests fait partie intégrante de cette approche.

## Script P.O.M (POM pattern)
Les scripts Selenium sont développés selon le design pattern POM (Page Object Model) : chaque page/élément possède une classe dédiée réutilisable, ce qui facilite la maintenance.

## 🚦 Badge GitLab Pipeline
![pipeline status](https://gitlab.com/<group>/<project>/badges/main/pipeline.svg)

## 🚀 Introduction
Ce projet propose un framework d’automatisation complet (UI + API), incluant :

- 🧪 Tests UI Selenium WebDriver
- 🥒 Tests BDD Cucumber
- 📚 Function Libraries (UI actions, API helpers, utils)
- 🌐 Tests API RestAssured
- ⚙️ Exécution via JUnit
- 📊 Rapport HTML Cucumber généré automatiquement

## 📁 Structure du Projet
project-root │ ├── src │ ├── main/java │ │ ├── base/ │ │ ├── helpers/ │ │ └── libraries/ │ │ │ └── test/java │ ├── steps/ │ ├── runners/ │ ├── hooks/ │ └── models/ │ ├── test/resources │ ├── features/ │ ├── config/ │ └── schemas/ │ ├── target/ │ └── cucumber-reports/ │ ├── docs/ │ └── architecture.png │ ├── pom.xml └── README.md

## 🧭 Diagramme d’Architecture du Framework
ASCII
+----------------------+
|     test suite       |
|   (Cucumber .feature)|
+----------+-----------+
|
v
+---------+---------+
| Step Definitions  |
+---------+---------+
|
+-----------------+------------------+
|                                    |
v                                    v
+---------+---------+               +-----------+----------+
| UI Function Libs  |               | API Function Libs    |
| (Selenium actions)|               | (RestAssured helpers)|
+---------+---------+               +-----------+----------+
|                                    |
v                                    v
+---------+---------+               +-----------+----------+
| Page Objects       |              | API Client / Models  |
+---------+---------+               +-----------+----------+
|                                    |
v                                    |
+---------+---------+                          |
| WebDriver Manager |                          |
+-------------------+                          |
|
+--------------------------+
|
v
+------+------+
|   Reporting |
| Cucumber HTML|
+-------------+

## 🖼️ Version Image PNG
Placer l'image dans : `docs/architecture.png`

Puis l’afficher :

![Architecture du Framework](docs/architecture.png)

## 🧪 Exemple de Runner JUnit
    package runners;

    import org.junit.platform.suite.api.ConfigurationParameter;
    import org.junit.platform.suite.api.IncludeEngines;
    import org.junit.platform.suite.api.SelectClasspathResource;
    import org.junit.platform.suite.api.Suite;

    import static io.cucumber.junit.platform.engine.Constants.*;

    @Suite
    @IncludeEngines("cucumber")
    @SelectClasspathResource("features")
    @ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps,hooks")
    @ConfigurationParameter(
            key = PLUGIN_PROPERTY_NAME,
            value = "pretty, html:target/cucumber-reports/cucumber-html-report.html, json:target/cucumber.json")
    @ConfigurationParameter(key = SNIPPET_TYPE_PROPERTY_NAME, value = "camelcase")
    public class RunCucumberTests {
    }

## 🧩 Function Libraries

### UI
- `click()`
- `type()`
- `waitForVisible()`
- `scrollTo()`

### API
- `get()`, `post()`, `put()`, `delete()`
- `validateSchema()`

### Utils
- `ConfigManager`
- JSON utilities
- File manager

## 📸 Screenshots
![Screenshot exemple](data:image/jpeg;base64,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)

## 📊 Reporting Cucumber
`target/cucumber-reports/cucumber-html-report.html`

## 🚀 Exécuter les tests
Tout :
mvn test

Par TAG :
mvn test -Dcucumber.filter.tags="@UI"

