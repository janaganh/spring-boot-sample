This a spring boot recruitment application 

The application assumes there is running postgresql server

1) please set up appropriate datasource settings in

a. src\main\resources\application.properties - spring datasource properties
b. build.gradle - flyway configuration

2) initialize the database using command
   gradlew flywayMigrate -i
 
3) Run the application
   gradlew bootRun
   
Also note you can clean the database and again reinitialize
   gradlew flywayClean -i
   gradlew flywayMigrate -i
   
Developing vue with js
if make any changes to web folder, run this command to update the spring boot app
  gradlew prod_build  
   
   