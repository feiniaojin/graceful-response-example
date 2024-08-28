package com.feiniaojin.gracefuresponse.example.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

/**
 * @author <a href="mailto:qinyujie@gingo.cn">Yujie</a>
 * @version 0.1
 */
@Tag(name = "分页容器", description = "分页容器")
public class PageBeanX<T> {

    @Schema(description = "每页数据大小")
    private Integer pageSize;
    @Schema(description = "总数据量")
    private Integer total;
    @Schema(description = "当前页码")
    private Integer page;
    @Schema(description = "数据列表")
    private List<T> list;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
