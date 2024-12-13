package org.skypro.skyshop.searchService;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> setSearchable = new HashSet<>();

    public Set<Searchable> search() {
        Set<Searchable> resultSearch = new TreeSet<>(new NameComparator());
        resultSearch.addAll(setSearchable);
        return resultSearch;
    }

    public void printSearch(Set<Searchable> search) {
        for (Searchable p : search) {
            System.out.println(p.getSearchTerm());
        }
    }


    public void add(Searchable searchable) {
        setSearchable.add(searchable);
    }

    public Searchable searchForMostSuitable(String search) throws BestResultNotFound {
        int counter = 0;
        Searchable result = null;
        for (Searchable searchable : setSearchable) {
            if (countOccurrences(search, searchable.getSearchTerm()) > counter) {
                counter = countOccurrences(searchable.getSearchTerm(), search);
                result = searchable;
            }
        }
        if (result == null) {
            throw new BestResultNotFound("Лучший результат не найден.");
        }
        return result;
    }

    private int countOccurrences(String search, String searchTerm) {
        int index = 0;
        int counter = 0;
        int indexSubstring = searchTerm.indexOf(search, index);
        while (indexSubstring != -1) {
            counter++;
            index += search.length();
            indexSubstring = searchTerm.indexOf(search, index);
        }
        return counter;
    }

    private static class NameComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable o1, Searchable o2) {
            if (Integer.compare(o1.getSearchTerm().length(), o2.getSearchTerm().length()) != 0) {
                return Integer.compare(o1.getSearchTerm().length(), o2.getSearchTerm().length());
            }
            return o1.getSearchTerm().compareTo(o2.getSearchTerm());
        }
    }
}
