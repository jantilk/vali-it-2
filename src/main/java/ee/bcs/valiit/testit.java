package ee.bcs.valiit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class testit {
    public void main(String[] Args) {

    }

    public void testCollections() {
        Iterable<String> linksIterable = new ArrayList<>();
        Collection<String> linksCollection = new ArrayList<>();
        List<String> carList = new ArrayList<>();
        Iterator<String> carIterator = new Iterator<String>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public String next() {
                return null;
            }
        };


    }
}
