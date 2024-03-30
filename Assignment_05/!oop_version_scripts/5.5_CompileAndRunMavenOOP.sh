#!/bin/bash

find_project_directory() {
    local dir="$1"
    local target_dir="5.5_parkinglot"

    found_dir=$(find "$dir" -type d -name "$target_dir" -print -quit)

    if [ -n "$found_dir" ]; then
        echo "$found_dir"
    else
        echo "Error: $target_dir directory not found"
        exit 1
    fi
}

cd ..

project_dir=$(find_project_directory "$(pwd)")

cd "$project_dir"

sudo mvn clean compile

if [ $? -eq 0 ]; then
    echo "Compilation successful - OOP version"

    mvn exec:java -Dexec.mainClass="eu.deic.oop.ProgMainOOP"
else
    echo "Compilation failed"
fi