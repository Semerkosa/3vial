# 3vial
A web application built to keep track of multiple asset classes (stocks, options, crypto, NFTs…) on multiple platforms (stock brokerages, crypto exchanges, DEX, neobanks, cold storage…). It also provides its users with the world's most unique and efficient portfolio tracking system!

## Getting started

### Run all services (client and server part)

1. <b>Prerequisites</b>

    1. <b>Gradle</b> should be available. If it is not then you should install it.
       If you are on Windows OS then after installing Gradle you can add the absolute path to it's `bin` folder to the `Path` system variable.
    2. <b>MySQL</b> database should be available. If it is not then you should install it.

2. <b>Edit Configurations (Optional)</b>

    Below files are stored in the project's root directory:
    
    1. File `settings.gradle` can be modified to include only the projects that you want to start.
    2. File `gradle.properties` can be modified to include different gradle properties.
    
3. <b>Run instructions</b>

    1. Make sure that you set the proper `database credentials` as environment variables as below services need a running database:
        * account
        * asset
        * MockDataProvider
    
    2. Open the command line or the terminal tab in the IDE .
    3. Navigate to the project's root folder (3vial).
    4. Execute command `gradle bootRun` (or `gradlew bootRun` if you have added gradle wrapper).
       After you execute the command, `client` project should start first and then the rest of the services.
  
4. <b>Terminating the run</b>

    When you terminate the run with `ctrl + C` and then typing `Y`, the services will still keep running.
    This is because of an issue with the `gradle node plugin` which is used to build and run `React` apps.
    The current solution is to kill the process id from the command line. To do so,
    first identify the process id by executing command `netstat -aon | find "3000"` (where 3000 is the default port on which react applications run)
    and then execute command `taskkill /F /PID <pid>` where `<pid>` is the process id from the netstat command.