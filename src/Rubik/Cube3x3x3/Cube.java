package Rubik.Cube3x3x3;

import Rubik.Colors;

import java.util.Objects;

public class Cube {

    /**
     * Variables represent the faces of cube
     */
    public CubeFace front, back, left, right, up, down;

    /**
     * Construct a new solved cube
     */
    public Cube() {
        this.front = new CubeFace((byte) Colors.White.ordinal());
        this.left = new CubeFace((byte) Colors.Blue.ordinal());
        this.right = new CubeFace((byte) Colors.Green.ordinal());
        this.up = new CubeFace((byte) Colors.Red.ordinal());
        this.down = new CubeFace((byte) Colors.Orange.ordinal());
        this.back = new CubeFace((byte) Colors.Yellow.ordinal());
    }

    /**
     * Construct a new cube with custom faces values
     * @param front CubeFace represent the front
     * @param back CubeFace represent the back
     * @param left CubeFace represent the left
     * @param right CubeFace represent the right
     * @param up CubeFace represent the up
     * @param down CubeFace represent the down
     * @see CubeFace
     */
    public Cube(CubeFace front, CubeFace back, CubeFace left, CubeFace right, CubeFace up, CubeFace down) {
        this.front = front;
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
        this.back = back;
    }

    // Simulate cube moves

    /**
     * Simulate a right clockwise move in Cube
     */
    public void R1() {
        byte tmp = front.values[0][2];
        front.values[0][2] = down.values[0][2];
        down.values[0][2] = back.values[2][0];
        back.values[2][0] = up.values[0][2];
        up.values[0][2] = tmp;

        tmp = front.values[2][2];
        front.values[2][2] = down.values[2][2];
        down.values[2][2] = back.values[0][0];
        back.values[0][0] = up.values[2][2];
        up.values[2][2] = tmp;

        tmp = front.values[1][2];
        front.values[1][2] = down.values[1][2];
        down.values[1][2] = back.values[1][0];
        back.values[1][0] = up.values[1][2];
        up.values[1][2] = tmp;

        right.rotateClockWise();
    }

    public void R2() {
        // TODO R2
    }

    public void R_() {
        // TODO R'
    }

    public void L1() {
        // TODO L1
    }

    public void L2() {
        // TODO L2
    }

    public void L_() {
        // TODO L'
    }

    public void U1() {
        // TODO U1
    }

    public void U2() {
        // TODO U2
    }

    public void U_() {
        // TODO U'
    }

    public void D1() {
        // TODO D1
    }

    public void D2() {
        // TODO D2
    }

    public void D_() {
        // TODO D'
    }

    public void F1() {
        // TODO F1
    }

    public void F2() {
        // TODO F2
    }

    public void F_() {
        // TODO F'
    }

    public void B1() {
        // TODO B1
    }

    public void B2() {
        // TODO B2
    }

    public void B_() {
        // TODO B'
    }


    /* overwrite default methods */

    /**
     * @return representation of cube in 2D
     */
    @Override
    public String toString() {
        return String.format(
                """
                   %s%s%s
                   %s%s%s
                   %s%s%s
                %s%s%s%s%s%s%s%s%s%s%s%s
                %s%s%s%s%s%s%s%s%s%s%s%s
                %s%s%s%s%s%s%s%s%s%s%s%s
                   %s%s%s
                   %s%s%s
                   %s%s%s
                """
        , up.values[0][0], up.values[0][1], up.values[0][2]
        , up.values[1][0], up.values[1][1], up.values[1][2]
        , up.values[2][0], up.values[2][1], up.values[2][2]
        , left.values[0][0], left.values[0][1], left.values[0][2], front.values[0][0], front.values[0][1], front.values[0][2], right.values[0][0], right.values[0][1], right.values[0][2], back.values[0][0], back.values[0][1], back.values[0][2]
        , left.values[1][0], left.values[1][1], left.values[1][2], front.values[1][0], front.values[1][1], front.values[1][2], right.values[1][0], right.values[1][1], right.values[1][2], back.values[1][0], back.values[1][1], back.values[1][2]
        , left.values[2][0], left.values[2][1], left.values[2][2], front.values[2][0], front.values[2][1], front.values[2][2], right.values[2][0], right.values[2][1], right.values[2][2], back.values[2][0], back.values[2][1], back.values[2][2]
        , down.values[0][0], down.values[0][1], down.values[0][2]
        , down.values[1][0], down.values[1][1], down.values[1][2]
        , down.values[2][0], down.values[2][1], down.values[2][2]
        );
    }

    /**
     * Compare 2 cube instances
     * @param o other instance
     * @see CubeFace#equals(Object) 
     * @return if two cubes faces is equals return true else false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cube cube = (Cube) o;

        if (!Objects.equals(front, cube.front)) return false;
        if (!Objects.equals(left, cube.left)) return false;
        if (!Objects.equals(right, cube.right)) return false;
        if (!Objects.equals(up, cube.up)) return false;
        if (!Objects.equals(down, cube.down)) return false;
        return Objects.equals(back, cube.back);
    }

    /**
     * Generate a cube hash code based in CubeFace.hashcode
     * @see CubeFace#hashCode() 
     * @return generated cube hashcode
     */
    @Override
    public int hashCode() {
        int result = front != null ? front.hashCode() : 0;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        result = 31 * result + (up != null ? up.hashCode() : 0);
        result = 31 * result + (down != null ? down.hashCode() : 0);
        result = 31 * result + (back != null ? back.hashCode() : 0);
        return result;
    }
}
