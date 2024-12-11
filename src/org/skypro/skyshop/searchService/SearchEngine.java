package org.skypro.skyshop.searchService;

import org.skypro.skyshop.exceptions.BestResultNotFound;

public class SearchEngine {
    public Searchable[] listSearchable;
    private final int SIZE_LIST;

    public SearchEngine(int sizeList) {
        SIZE_LIST = sizeList;
        listSearchable = new Searchable[SIZE_LIST];
    }

    public Searchable[] search(String contentType) {
        Searchable[] searchResult = new Searchable[5];
        int counter = 0;
        for (Searchable searchable : listSearchable) {
            if (searchable == null) {
                break;
            }
            if (searchable.getContentType().contains(contentType)) {
                searchResult[counter] = searchable;
                counter++;
                if (counter == 5) {
                    break;
                }
            }
        }
        return searchResult;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < listSearchable.length; i++) {
            if (listSearchable[i] == null) {
                listSearchable[i] = searchable;
                break;
            }
        }
    }

    public Searchable searchForMostSuitable(String search) throws BestResultNotFound {
        int counter = 0;
        int index = -1;
        for (int i = 0; i < listSearchable.length; i++) {
            if (listSearchable[i] == null) {
                break;
            }
            if (countOccurrences(search, listSearchable[i].getSearchTerm()) > counter) {
                counter = countOccurrences(listSearchable[i].getSearchTerm(), search);
                index = i;
            }
        }
        if (index == -1) {
            throw new BestResultNotFound("Лучший результат не найден.");
        }
        return listSearchable[index];
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
