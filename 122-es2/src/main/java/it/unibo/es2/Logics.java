package it.unibo.es2;

/**
 * Interface defining the logic for a matrix application.
 */
public interface Logics {

    /**
     * Increment the value of the specified slot.
     *
     * @param elem the slot to increment
     * @return the new value a button should show after being pressed
     */
    String hit(Pair<Integer, Integer> elem);

    /**
     * Add a label * or " " in the matrix.
     * 
     * @param label the element to add
     * @param pair wich element of the matrix to update
     */
    void updateLabel(String label, Pair<Integer, Integer> pair);

    /**
     * Compute the index of the {@code List} given a {@code Pair<Integer, Integer>}.
     * 
     * @param pair the element to trasform in index
     * @return the index correspondig the parameter
     */
    int computeIndex(Pair<Integer, Integer> pair);

    /**
     * Checks if there's a row or column full of "*".
     * 
     * @return true if there's an occurence
     */
    boolean toQuit();
}

