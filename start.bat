@echo off
echo "Please fill the path of java source files to check:"
echo Example on Windows: src\\main\\java

set/p x=

java -jar ./target/spoonChecker-0.0.1-SNAPSHOT-jar-with-dependencies.jar %x%

index.html

pause