package com.study.search;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class BoardSearch {

    private String title;
    private Sort.Direction sortBy;

    public BoardSearch(String title) {
        this.title = title;
        this.sortBy = Sort.Direction.DESC;
    }
}
