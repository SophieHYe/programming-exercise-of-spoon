#!/bin/bash
echo "Please fill the path of java source files to check:"
echo Example on Mac: ./src/main/java

read -p "path: " path

java -jar ./target/spoonChecker-0.0.1-SNAPSHOT-jar-with-dependencies.jar $path

open index.html