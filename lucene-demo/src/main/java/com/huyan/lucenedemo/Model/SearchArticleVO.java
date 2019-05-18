package com.huyan.lucenedemo.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * Created by pfliu on 2019/03/31.
 */
@Data
@Builder
public class SearchArticleVO {

    String url;
    String title;
    String content;
    String targetStr;
    List<String> tags;
    List<String> categories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchArticleVO that = (SearchArticleVO) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, title);
    }
}
