package it.unibo.es2;

import java.util.ArrayList;
import java.util.List;

/** 
 * Implementation of a logic for the GUI.
 */
public class LogicsImpl implements Logics {
    private static final int SINGLE_ELEM = 1;
    private static final String EMPTY = " ";
    private static final String ASTERISK = "*";

    private final transient List<String> matrix = new ArrayList<>();

    /**
     * Contructor of a LogicsImpl.
     * 
     * @param size the number of button per edge
     */
    public LogicsImpl(final int size) {
        for (int i = 0; i < Math.pow(size, 2); i++) {
            this.matrix.add(EMPTY);
        }
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public int computeIndex(final Pair<Integer, Integer> pair) {
        return (pair.x() * (int) Math.sqrt(matrix.size())) + pair.y();
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public void updateLabel(final String label, final Pair<Integer, Integer> pair) {
        this.matrix.set(this.computeIndex(pair), label);
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public String hit(final Pair<Integer, Integer> pair) {
        final String value = this.matrix.get(this.computeIndex(pair));
        if (ASTERISK.equals(value)) {
            this.updateLabel(EMPTY, pair);
            return EMPTY;
        } else {
            this.updateLabel(ASTERISK, pair);
            return ASTERISK;
        }
    }

    /** 
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        final int size = (int) Math.sqrt(matrix.size());
        for (int i = 0; i < size; i++) {
            final List<String> listCol = new ArrayList<>();
            final List<String> listRow = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                final String vCol = this.matrix.get(this.computeIndex(new Pair<>(j, i)));
                listCol.add(vCol);
                final String vRow = this.matrix.get(this.computeIndex(new Pair<>(i, j)));
                listRow.add(vRow);
            }
            if (listCol.stream().allMatch(EMPTY::equals) 
                || listRow.stream().allMatch(EMPTY::equals)) {
                continue;
        }
            if (SINGLE_ELEM == listCol.stream().distinct().count() 
                || SINGLE_ELEM == listRow.stream().distinct().count()) {
                return true;
            }
        }
        return false;
    }
}
