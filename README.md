# Mancala

IMPORTANT NOTE:
Make sure you use java version 11 or higher!

This repository contains the files for three modules:
- Object orientated programming: make your own implementation of the mancala game.
- Model view controller: build a website for your own mancala game (or use the sloppy default implementation).
- CI/CD: run your tests automatically when pushing code to Gitlab.


## Repository structure

- Main folder (this folder): contains the files relevant for the whole project. For example the Gradle-wrapper files, the .gitignore, and this readme.
- api/: contains the files for the API or service layer of your application.
- api/src/main/java/mancala/api: contains the web endpoints.
- api/src/main/java/mancala/api/models: contains the web endpoints.
- domain/: contains the files that model the business domain (game rules). This is the folder you develop your OO mancala case in.
- client/: contains the client (front-end)

## Two servers

The project consists of two servers. The front-end uses a Node.js server. It is mainly used to compile your React code into Javascript files during development. This will shorten the feedback loop between changing your code and seeing the results in the browser. The second server is the back-end, which uses a Jetty server. The back-end server allows your Java API to be accessible for other programs, including the front-end server. To prevent [cross-origin request shenanigans (CORS)](https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS), all requests from the browser will be sent to the front-end server. That server will then forward to the back-end server if needed.

The front-end assumes that the back-end will run on port 8080. If that is not the case, edit the webpack.config.js file.

To run the application you need to have both servers running at the same time. This probably means you'll need to open two different terminals/command prompts to do so.


## React project structure

A React project is generally structured as follows:

```
package.json
public/
   index.html
src/
   Feature1/
      Feature1.css
      Feature1.tsx
      Feature1.tests.tsx
   Feature2/
      Feature2.css
      Feature2.tsx
      Feature2.tests.tsx
      Feature2B.tsx
      Feature2B.tests.tsx
```

The public directory contains static files, such as the relatively empty index.html file needed to run React. The src file contains the React code. The convention for TypeScript projects is to use the .tsx file extension for files that contain React components. Files are generally grouped together in directories by feature. These directories contain all files related to that feature, such as coponents, stylesheets, images and tests.

## Installing front-end dependencies

To run the React application you'll first need to install the required dependencies. These dependencies are defined in the package.json file. Run the command `npm install` from the `/client` directory.

## Running the front-end

The package.json specifies which commands can be run using npm (e.g. npm run start). In this sample repository, two commands have been defined. You should also run these in the `/client` directory.

```bash
# Start a development server
npm run start
# Check code for common mistakes and style conventions
npm run lint
```



## Java project structure

A Java project is generally structured as follows:

```
build.gradle
src/
   main/
       (package)/
            (Java files)
   test/
       (package)/
            (Java test files)
```

In the project root folder (for example, the domain/ folder), a project definition is found. As we use Gradle, we have a build.gradle file. For Maven (another commonly used build tool), we would have a pom.xml. These files contain roughly the same: the project metadata and its dependencies. The build tool can then resolve those dependencies by downloading them from an online registry or compile related projects and link the resulting jar files.

A build tool also makes sure multiple Java files inside the same project are compiled in one go. Basically it acts as a wrapper around the compiler. You can invoke the compiler manually by typing `javac mancala/domain/Foo.java mancala/domain/Bar.java` over and over, or let your build tool generate and execute the command for you.

To tell the build tool which files to compile, the above structure is used. In src/main/ you place your application code, the actual implementation of the game rules. You should also adhere to the Java file structure, meaning that your folder structure should match your package definition (mancala/domain/) and your filename should match your class name (Foo.java). In src/test/ you place the files that test your main code. By convention, the test file structure mimics the main file structure (mancala/domain/FooTest.java).

## Using Gradle

You can either install Gradle on your machine and use the installation or use the Gradle wrapper files found next to this README. Replace the `./gradlew` command with `gradle` if using the globally installed Gradle or `.\gradlew.bat` if you're running the Windows batch script.

```bash
# Building
./gradlew build
# Testing (will fail with the initial code)
./gradlew test
# Running (only relevant for the MVC case)
./gradlew run
```

If you run the build tool with either the `build` or `test` options, you will see that the tests in the `api/src/test/.../StartMancalaTest.java` file fail. Check the test output and see if you can figure out why these tests fail.

The tests fail because we have no domain classes implemented yet.

In our `StartMancala` servlet, we instantiate our domain as `null` on line 22. Instead, we should instantiate a class here that implements the `Playable` interface. You can do so by merging the mainline branch (where you first wrote your mancala game) into this branch and implementing a `MancalaGame.java` class that uses the methods from your classes to adhere to the `Playable` interface. 

If you do so correctly, these tests should succeed, and the back-end should build successfully.

If you run the program, you will notice the build "progress" is stuck on 87% or so. That means your application is running and Gradle is waiting for it to succeed. You can ignore the progress bar when running the application; it should print some lines when it's ready.

## Building and deployment

The project is configured to build the domain- and api layers separately and in parallel. Both layers are tested separately with an overview of all test results available in the pipline  report. Both layers require all unit tests to be succesful, 83.3% of all lines of codes covered and 69.4% of all branches in the code to be covered by unit tests.
