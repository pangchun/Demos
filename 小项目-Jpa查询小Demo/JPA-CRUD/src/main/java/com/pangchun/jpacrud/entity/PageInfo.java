package com.pangchun.jpacrud.entity;

import lombok.Data;

@Data
public class PageInfo {
    private Integer pageNum;
    private Integer pageSize;//我们没有设置可变的 x条/页，因此固定为8条
    private Integer totalPages;
    private Integer totalRecords;
}
