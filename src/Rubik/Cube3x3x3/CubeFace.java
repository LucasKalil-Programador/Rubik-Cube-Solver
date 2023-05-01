package Rubik.Cube3x3x3;

import java.util.Arrays;

public class CubeFace {
    public Byte[][] values;

    public CubeFace(byte value) {
        this.values = new Byte[][] {
                {value, value, value},
                {value, value, value},
                {value, value, value}
        };
    }

    public CubeFace(Byte[][] values){
        this.values = values;
    }

    public void rotateClockWise() {
        // rotate corner
        byte tmp = values[0][0];
        values[0][0] = values[2][0];
        values[2][0] = values[2][2];
        values[2][2] = values[0][2];
        values[0][2] = tmp;

        // rotate center
        tmp = values[0][1];
        values[0][1] = values[1][0];
        values[1][0] = values[2][1];
        values[2][1] = values[1][2];
        values[1][2] = tmp;
    }

    public void rotateAntiClockWise() {
        // rotate corner
        byte tmp = values[0][0];
        values[0][0] = values[0][2];
        values[0][2] = values[2][2];
        values[2][2] = values[2][0];
        values[2][0] = tmp;

        // rotate center
        tmp = values[0][1];
        values[0][1] = values[1][2];
        values[1][2] = values[2][1];
        values[2][1] = values[1][0];
        values[1][0] = tmp;
    }

    public void rotate180() {
        // rotate corner
        byte tmp = values[0][0];
        values[0][0] = values[2][2];
        values[2][2] = tmp;
        tmp = values[0][2];
        values[0][2] = values[2][0];
        values[2][0] = tmp;

        // rotate center
        tmp = values[0][1];
        values[0][1] = values[2][1];
        values[2][1] = tmp;
        tmp = values[1][0];
        values[1][0] = values[1][2];
        values[1][2] = tmp;
    }

    @Override
    public String toString() {
        return String.format("%s%s%s\r\n%s%s%s\r\n%s%s%s",
                values[0][0], values[0][1], values[0][2],
                values[1][0], values[1][1], values[1][2],
                values[2][0], values[2][1], values[2][2]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CubeFace cubeFace = (CubeFace) o;

        return Arrays.deepEquals(values, cubeFace.values);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(values);
    }
}
