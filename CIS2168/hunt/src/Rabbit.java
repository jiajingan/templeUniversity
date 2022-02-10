/* Jiajin(Jackie) Gan
 * Andrew Rosen Data Structures
 * The purpose of the program is to modify the Rabbit class
 * and escape from the Fox
 */
public class Rabbit extends Animal {

    // instance variables
    private int currentDirection;
    private int distanceToWall;

    /**
     * Constructs a Fox in the given model, at the given position
     * in the field.
     *
     * @param model  the model that controls this fox.
     * @param row    the row of the field containing this fox.
     * @param column the column of the field containing this fox.
     */
    public Rabbit(Model model, int row, int column) {
        super(model, row, column);
    }

    /**
     * Controls the movement of the fox.
     *
     * @return the direction in which the fox wishes to move.
     */

    //how to make it stay at it's own place when not spotting the fox
    //dodging corners or edges by locking all the side of the grid?

    int decideMove() {

        // look all around for rabbit

        for (int i = Model.MIN_DIRECTION; i <= Model.MAX_DIRECTION; i++) {
            if (look(i) == Model.FOX) {
                //make a run away function
                currentDirection = i;
                //i is fox direction

                //instance fox is north
                //ranking the directions it would go first
                /* Southwest
                 * Southeast
                 * west
                 * east
                 * northwest
                 * northeast
                 * south
                 * north
                 */
                //it would only move rabbit spots the fox else it will STAY at initial location
                //if (distanceToWall)
                if (canMove(Model.turn(currentDirection, 5))) {//Southwest
                    return Model.turn(currentDirection, 5);
                } else if (canMove(Model.turn(currentDirection, 3))) {//Southeast
                    return Model.turn(currentDirection, 3);
                }

                if (canMove(Model.turn(currentDirection, 6))) {//west
                    return Model.turn(currentDirection, 6);
                } else if (canMove(Model.turn(currentDirection, 2))) {//east
                    return Model.turn(currentDirection, 2);
                }

                if (canMove(Model.turn(currentDirection, 7))) {//northwest
                    return Model.turn(currentDirection, 7);
                } else if (canMove(Model.turn(currentDirection, 1))) {//northeast
                    return Model.turn(currentDirection, 1);
                }

                if (canMove(Model.turn(currentDirection, 4))) {//south
                    return Model.turn(currentDirection, 4);
                } else {
                    return currentDirection;
                }
                //check the walls and move to the center

            }
        }


        // stuck! cannot move
        return Model.STAY;
    }
}