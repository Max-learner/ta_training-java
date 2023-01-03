package com.epam.rd.autotasks;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        String shotsBinaryString = Long.toBinaryString(shots);
        String shotsFullBinaryString = String.format("%64s", shotsBinaryString).replace(' ', '0');

        String shipsBinaryString = Long.toBinaryString(ships);
        String shipsFullBinaryString = String.format("%64s", shipsBinaryString).replace(' ', '0');

        int indexOfShotInShotsRowByRowArray = getShotNumberIndexFromString(shot) - 1;
        char[] shotsRowByRowArray = shotsFullBinaryString.toCharArray();
        shotsRowByRowArray[indexOfShotInShotsRowByRowArray] = '1';
        shotsFullBinaryString = "";
        for (int i = 0; i < shotsRowByRowArray.length; i++){
            shotsFullBinaryString += shotsRowByRowArray[i];
        }
        shots = Long.parseUnsignedLong(shotsFullBinaryString, 2);
        state();
        if (shipsFullBinaryString.charAt(indexOfShotInShotsRowByRowArray) == '1') {
            return true;
        }
        return false;
    }

    public String state() {
        StringBuilder mapStateStringBuilder = new StringBuilder("");

        String shotsFullBinaryString = getBinaryString(shots);
        String shipsFullBinaryString = getBinaryString(ships);

        for (int i = 0; i < shipsFullBinaryString.length(); i++) {
            if (shipsFullBinaryString.charAt(i) == '0' && shotsFullBinaryString.charAt(i) == '0') {
                mapStateStringBuilder.append('.');
            }
            if (shipsFullBinaryString.charAt(i) == '0' && shotsFullBinaryString.charAt(i) == '1') {
                mapStateStringBuilder.append('×');
            }
            if (shipsFullBinaryString.charAt(i) == '1' && shotsFullBinaryString.charAt(i) == '0') {
                mapStateStringBuilder.append('☐');
            }
            if (shipsFullBinaryString.charAt(i) == '1' && shotsFullBinaryString.charAt(i) == '1') {
                mapStateStringBuilder.append('☒');
            }
            if (i==7 || i==15 || i==23 || i==31 || i==39 || i==47 || i==55) mapStateStringBuilder.append('\n');
        }
        return mapStateStringBuilder.toString();
    }

    private String getBinaryString(long number) {
        String binaryString = Long.toBinaryString(number);
        return String.format("%64s", binaryString).replace(' ', '0');
    }

    private int getShotNumberIndexFromString(String s) {
        char letterPointer = s.charAt(0);
        char numberPointer = s.charAt(1);

        int column = 1, row = 0;

        switch (letterPointer) {
            case 'A' : { column = 1; break;}
            case 'B' : { column = 2; break;}
            case 'C' : { column = 3; break;}
            case 'D' : { column = 4; break;}
            case 'E' : { column = 5; break;}
            case 'F' : { column = 6; break;}
            case 'G' : { column = 7; break;}
            case 'H' : { column = 8; break;}
        };
        switch (numberPointer) {
            case '1' : { row = 0; break;}
            case '2' : { row = 8; break;}
            case '3' : { row = 16; break;}
            case '4' : { row = 24; break;}
            case '5' : { row = 32; break;}
            case '6' : { row = 40; break;}
            case '7' : { row = 48; break;}
            case '8' : { row = 56; break;}
        };
        return row + column;
    }
}
