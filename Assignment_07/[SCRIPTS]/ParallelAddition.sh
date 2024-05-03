#!/bin/bash

find_project_directory() {
    local dir="$1"
    local target_dir="parallel_addition"

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

sudo javac eu/deic/multithreading/ParallelVectorAddition.java

if [ $? -eq 0 ]; then
    echo "Compilation successful"

    java eu/deic/multithreading/ParallelVectorAddition

else
    echo "Compilation failed"
fi