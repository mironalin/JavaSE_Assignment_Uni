package eu.ase.jrobot;

import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * AseRobot - a robot by Alin Miron
 */
public class AseRobot extends Robot {
    /**
     * run: AseRobot's default behavior
     */

    int noOfSquares = 0;
    int directionCounter = 0;
    boolean aggresive = true;
    boolean scanForRobots = true;
    int sizeOfSquare = 150;

    public void run() {
        // Initialization of the robot should be put here

        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:

        setColors(Color.red, Color.blue, Color.green); // body,gun,radar

        // Robot main loop

        while (true) {
            printDirection();
            moveInSquare(sizeOfSquare);
            noOfSquares++;
            directionCounter++;
        }
    }

    public void moveInSquare(int lengthOfSide) {
        for (int i = 0; i < 4; i++) {
            ahead(lengthOfSide);
            if (directionCounter % 2 == 0) {
                if (scanForRobots) {
                    turnRadarRight(90);
                }

                turnRight(90);

                if (aggresive) {
                    fire(1);
                }

            } else {
                if (scanForRobots) {
                    turnRadarLeft(90);
                }

                turnLeft(90);

                if (aggresive) {
                    fire(1);
                }
            }
        }
    }

    public void printDirection() {
        if (directionCounter % 2 == 0) {
            System.out.println("Direction: Clockwise");
        } else {
            System.out.println("Direction: Anticlockwise");
        }
    }

    public void onScannedRobot(ScannedRobotEvent robotEvent) {
        System.out.println("Scanned Robot: " + robotEvent.getName() + ", Energy: " + robotEvent.getEnergy()
                + ", Distance: " + robotEvent.getDistance());
        fire(1);
    }

    public void onRoundEnded(RoundEndedEvent e) {
        System.out.println("Round ended | Squares travelled: " + noOfSquares);
    }

    public void onHitByBullet(HitByBulletEvent e) {
        back(10);
    }

    public void onHitWall(HitWallEvent e) {
        back(20);
    }

}