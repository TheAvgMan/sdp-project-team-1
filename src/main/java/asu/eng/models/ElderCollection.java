package asu.eng.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ElderCollection implements Iterable<Elder> {
    private List<Elder> elders = new ArrayList<>();

    public void addElder(Elder elder) {
        elders.add(elder);
    }

    @Override
    public Iterator<Elder> iterator() {
        return elders.iterator();
    }

}
