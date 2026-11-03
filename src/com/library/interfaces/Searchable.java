
package com.library.interfaces;

import java.util.List;

public interface Searchable<T> {

    T searchById(String id);

    List<T> searchByKeyword(String keyword);
}
