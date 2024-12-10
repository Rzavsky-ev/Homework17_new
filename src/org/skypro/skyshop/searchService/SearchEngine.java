package org.skypro.skyshop.searchService;

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
}
