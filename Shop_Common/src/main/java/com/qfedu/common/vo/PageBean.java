package com.qfedu.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：Demos
 * @ Date       ：Created in 20:09 2019/6/19
 * @ Description：设置分页的类
 */
@Data
public class PageBean<T> {
    private int currPage;//当前页
    private int totalCount;//总条数
    private int count;//每页显示多少条
    private int totalPage;//总页数
    private List<T> data;//数据
}
