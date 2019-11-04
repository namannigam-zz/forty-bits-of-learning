package edu.forty.bits.ds.list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RepeatedValues {

    public <T> Set<T> findRepeatedValues(List<T> list) {
        Set<T> set = new HashSet<>();
        return list.stream().filter(i -> !set.add(i)).collect(Collectors.toSet());
    }

}