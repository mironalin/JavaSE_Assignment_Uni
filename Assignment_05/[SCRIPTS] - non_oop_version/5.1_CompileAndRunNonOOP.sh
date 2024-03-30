#!/bin/bash

# export JAVA_HOME=/opt/software/java/jdks/jdk1.8.0_161
# export PATH=$JAVA_HOME/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games
# export CLASSPATH=.:$JAVA_HOME/jre/lib

find_project_directory() {
    local dir="$1"
    local target_dir="5.1_gastracker"

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

cd $project_dir/src/main/java

sudo javac eu/deic/oop/ProgMain.java

if [ $? -eq 0 ]; then
    echo "Compilation successful - Non OOP version"

    java eu/deic/oop/ProgMain.java

else
    echo "Compilation failed"
fi