package com.epam.rd.autotasks;

//import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.currentCompassDegrees = degrees;
    }

    private int currentCompassDegrees;
    public int getDegrees(){
        return this.currentCompassDegrees;
    }

    public static Direction ofDegrees(int degrees) {
        int degreesOfDegrees = degrees;
        while ( degreesOfDegrees < 0) {
            degreesOfDegrees += 360;}
        while ( degreesOfDegrees >= 360) {
            degreesOfDegrees -= 360;}

        if (degreesOfDegrees == 360) return Direction.N;
        for (Direction direction : Direction.values()) {
            if (degreesOfDegrees == direction.getDegrees()) return direction;}
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        int degreesClosestToDegrees = degrees;
        while ( degreesClosestToDegrees < 0) {degreesClosestToDegrees += 360;}
        while ( degreesClosestToDegrees >= 360) {degreesClosestToDegrees -= 360;}
        for (Direction closeDirection : Direction.values()) {
            if (Math.abs(degreesClosestToDegrees - closeDirection.getDegrees()) < 22.5) return closeDirection;}
        return null;
    }

    public Direction opposite() {
        int oppositeDegrees = getDegrees() - 180;
        while ( oppositeDegrees < 0) {oppositeDegrees += 360;}
        while ( oppositeDegrees >= 360) {oppositeDegrees -= 360;}

        if (oppositeDegrees == 360) return Direction.N;
        for (Direction oppositeDirection : Direction.values()) {
            if (oppositeDegrees == oppositeDirection.getDegrees()) return oppositeDirection;}
        return null;
    }

    public int differenceDegreesTo(Direction direction) {
        if (Math.abs(currentCompassDegrees - direction.getDegrees()) >=315)
            return 360 - Math.abs(currentCompassDegrees - direction.getDegrees());
        return Math.abs(currentCompassDegrees - direction.getDegrees());
    }
}
