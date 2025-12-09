package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    // private static final String ERROR_MESSAGE = "Unimplemented method";
    private static final int START_VALUE = 0;
    private static final int SINGLE_ELEM = 1;
    private final List<Integer> listValues = new ArrayList<>();

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        for (int i = 0; i < size; i++) {
            listValues.add(START_VALUE);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return listValues.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return new ArrayList<>(listValues);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        /* final List<Boolean> booleansList = new ArrayList<>();
        for (int i : listValues) {
            if (i < listValues.size()) {
                booleansList.add(true);
            } else {
                booleansList.add(false);
            }
        }
        return booleansList; */
        return listValues.stream()
            .map(e -> e < listValues.size())
            .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        int value = this.listValues.get(elem) + 1;
        this.listValues.set(elem, value);
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        if (this.toQuit()) {
            return "";
        } 
        String state = "<<";
        for (int i : listValues) {
            state += String.valueOf(i) + "|";
        }
        state += ">>";
        return state;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return SINGLE_ELEM == Math.toIntExact(this.listValues.stream()
            .distinct()
            .count());
    }
}
