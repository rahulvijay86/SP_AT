@echo %CD%
cd src/main/java/resources
java -jar selenium-server-standalone-2.53.1.jar -role hub -port 4444
