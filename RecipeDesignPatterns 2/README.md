# RecipeDesignPatterns


### to run the project 

```sh 
 mvn clean package
 ```

### then run

```sh 
  java -jar target\project.jar
 ```


# Contents
[1.	Factory Method Pattern](#_toc135335096)

[2.	Strategy Pattern](#_toc135335097)

[3.	Singleton Pattern](#_toc135335098)

[4.	Facade Pattern ](#_toc135335099)




 ## 1. <a name="_toc135335096"></a>Factory Method Pattern 
In this project, we implemented the Factory Design Pattern to improve the flexibility and scalability of our codebase. The Factory pattern allowed us to encapsulate recipe creation logic into a central factory class (RecipeFactory), simplifying the process of creating and managing different types of recipes within our system. By employing this pattern, we achieved a clear separation between recipe creation and recipe usage, promoting code reusability and maintainability. 

Additionally, the Factory Design Pattern enabled us to easily incorporate new recipes in the future, as we only needed to modify the factory class rather than modifying multiple parts of our codebase. 

Here we are using the factory method to create different recipe styles. The creation operation is done in the subclasses of the RecipeFactory.

Overall, the implementation of the Factory Design Pattern played a crucial role in enhancing the extensibility and efficiency of our project.

|Recipe       |            |RecipeFactory||
| :-: | :-: | :-: | :-: |
|**Interface**|**Concretes**|**Interfaces**|**Concretes**|
|Recipe       |AfroRecipe   |RecipeFactory |AfroRecipeFactory|
|             |AsianRecipe||AsianRecipeFactory|
|             |MiddleEasternRecipe||MiddleEasternRecipeFactory|
|             |WesternRecipe||WesternRecipeFactory|
|             |OthersRecipe||OthersRecipeFactory|

![](assets/images/Aspose.Words.506d3cf7-55e5-4eb7-a262-b042ed8ba705.002.png)


## 2. <a name="_toc135335097"></a>Strategy Pattern
The design pattern used for rating model in our project is the Strategy design pattern. This pattern allows for the encapsulation of different algorithms or strategies (two different ways of computing the impact of a rate on a recipe) within separate classes, making them interchangeable at runtime.

In the context of the recipe management system, the Strategy pattern was employed to compute the impact property of each recipe based on user ratings. Two concrete strategies were implemented: the AverageRatingStrategy and the TotalRatingsStrategy. The Recipe class acts as the context and maintains a reference to the current rating computation strategy. 

By dynamically switching between strategies, the system can calculate the impact using either the average rating or the total number of ratings. This design promotes flexibility, extensibility, and separation of concerns, as each strategy encapsulates a specific algorithm while remaining independent from the Recipe class.

![](assets/images/Aspose.Words.506d3cf7-55e5-4eb7-a262-b042ed8ba705.003.png)


## 3. <a name="_toc135335098"></a>Singleton Pattern.
The **RecipeBookSingleton** class demonstrates the usage of the Singleton Design Pattern in our recipe management project. It ensures that only one instance of the class exists throughout the system. This singleton instance provides a centralized recipe list that can be accessed, and recipes can be added or removed from it. The Singleton Design Pattern guarantees data consistency and prevents duplication, promoting efficient and synchronized recipe management.

The class features a private static instance variable **instance** of type **RecipeBookSingleton**, which holds the single instance of the class. The constructor is also marked as private, preventing direct instantiation of **RecipeBookSingleton** objects from outside the class.

To access the instance, a public static method **getInstance()** is provided. This method checks if the instance variable is null and, if so, creates a new instance of **RecipeBookSingleton** and assigns it to the **instance** variable. Subsequent calls to **getInstance()** simply return the existing instance.

![](assets/images/Aspose.Words.506d3cf7-55e5-4eb7-a262-b042ed8ba705.004.png)



## 4. <a name="_toc135335099"></a>Facade Pattern.
The provided **MainPage** class demonstrates the usage of the Facade Design Pattern in our recipe management project. The purpose of this pattern is to simplify the interaction between the client code (main class) and the complex subsystem (various components and functionalities of the recipe management system).

The **showMainPage()** method serves as the facade method that presents the main menu and handles user choices. It encapsulates the complexity of interacting with different components by providing a simplified interface for the client code.

The homepage class, represented by **MainPage**, is only aware of the facade and doesn't directly interact with the individual components such as **CreateRecipeComponent**, **SearchRecipeComponent**, **ModifyRecipeComponent**, **RateRecipeComponent**, **RecipeLister**, and **RecipeRatingComponent**.

Each menu option within the switch statement corresponds to a specific functionality, and the facade method delegates the execution of these functionalities to the respective components. For example, when the user selects "Create Recipe," the facade method calls **CreateRecipeComponent.handleCreateRecipe()**, which handles the creation of a new recipe.

By using the Facade Design Pattern, the complexity of the underlying recipe management system is abstracted away from the main class. The facade class acts as a simplified interface, providing a cohesive and high-level API for the main class to interact with. This promotes modularity, encapsulation, and loose coupling between the client code and the system's components, resulting in a more maintainable and manageable codebase.

So basically we are using the facade design pattern in multiple places throughout the project one example is shown below.

![](assets/images/Aspose.Words.506d3cf7-55e5-4eb7-a262-b042ed8ba705.005.png)





