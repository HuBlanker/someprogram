package com.huyan.lucenedemo.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
}
