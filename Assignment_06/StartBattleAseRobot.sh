#!/bin/bash

find_robocode_directory() {
    local dir="$1"
    local target_dir="robocode"

    found_dir=$(find "$dir" -type d -name "$target_dir" -print -quit)

    if [ -n "$found_dir" ]; then
        echo "$found_dir"
    else
        echo "Error: $target_dir directory not found"
        exit 1
    fi
}

robocode_dir=$(find_robocode_directory "$(pwd)")

# Compile the robot
javac -verbose -encoding UTF-8 -classpath $robocode_dir/libs/robocode.jar: $robocode_dir/robots/eu/ase/jrobot/AseRobot.java

if [ $? -eq 0 ]; then
    printf "\n\nCompilation successful\n\n"

    # Run robocode
    cd $robocode_dir
    java -Xmx512M -Dsun.io.useCanonCaches=false -cp libs/robocode.jar robocode.Robocode -battle battles/AseBattle.battle
else
    printf "\n\nCompilation failed"
fi