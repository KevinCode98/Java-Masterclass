package domain;

import java.util.Comparator;

public class StoreEmployee extends Employee {
    private String store;

    public class StoreComparator<T extends StoreEmployee> implements Comparator<StoreEmployee>{

        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            return 0;
        }
    }
}
