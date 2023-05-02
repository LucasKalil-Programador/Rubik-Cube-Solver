package Rubik.Cube3x3x3;

import java.util.Arrays;

/**
 * Represent a Face in cube
 */
public class CubeFace implements Cloneable{

    /**
     * Values in face
     */
    public Byte[][] values;

    /**
     *
     * @param value fill the 3x3 values with value
     */
    public CubeFace(byte value) {
        this.values = new Byte[][] {
                {value, value, value},
                {value, value, value},
                {value, value, value}
        };
    }

    /**
     *
     * @param values custom value array
     */
    public CubeFace(Byte[][] values){
        this.values = values;
    }

    /**
     * Rotate content clockwise
     */
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

    /**
     * Rotate content anti clockwise
     */
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

    /**
     * rotate 180 degrees
     */
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

    /**
     * @return representation of face in string
     */
    @Override
    public String toString() {
        return String.format("%s%s%s\r\n%s%s%s\r\n%s%s%s",
                values[0][0], values[0][1], values[0][2],
                values[1][0], values[1][1], values[1][2],
                values[2][0], values[2][1], values[2][2]);
    }

    /**
     * Compare content of CubeFace instances
     * @param o other face instance
     * @return true or false if two faces is equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CubeFace cubeFace = (CubeFace) o;

        return Arrays.deepEquals(values, cubeFace.values);
    }

    /**
     * Generate hashcode based in Arrays.deepHashCode
     * @return generated hashcode
     */
    @Override
    public int hashCode() {
        return Arrays.deepHashCode(values);
    }

    @Override
    public CubeFace clone() {
        try {
            CubeFace clone = (CubeFace) super.clone();
            clone.values = this.values.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
