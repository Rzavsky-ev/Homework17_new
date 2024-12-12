package org.skypro.skyshop.searchService;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    private List<Searchable> listSearchable = new ArrayList<>();

    public Map<String, Searchable> search(String contentType) {
        Map<String, Searchable> searchResult = new TreeMap<>();
        for (Searchable searchable : listSearchable) {
            if (searchable.getContentType().contains(contentType)) {
                searchResult.put(searchable.getSearchTerm(), searchable);
            }
        }
        return searchResult;
    }

    public void printSearch(Map<String, Searchable> searchResult) {
        for (Map.Entry<String, Searchable> search : searchResult.entrySet()) {
            System.out.println(search.getValue().getSearchTerm());
        }
    }

    public void add(Searchable searchable) {
        listSearchable.add(searchable);
    }

    public Searchable searchForMostSuitable(String search) throws BestResultNotFound {
        int counter = 0;
        int index = -1;
        for (int i = 0; i < listSearchable.size(); i++) {
            if (countOccurrences(search, listSearchable.get(i).getSearchTerm()) > counter) {
                counter = countOccurrences(listSearchable.get(i).getSearchTerm(), search);
                index = i;
            }
        }
        if (index == -1) {
            throw new BestResultNotFound("Лучший результат не найден.");
        }
        return listSearchable.get(index);
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
}
