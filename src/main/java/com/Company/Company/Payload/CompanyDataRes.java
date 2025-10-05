package com.Company.Company.Payload;

import com.Company.Company.Model.Companies;

import java.util.List;

public class CompanyDataRes {
    private List<Companies> content;
    private int currentPage;
    private int totalPages;
    private long totalElements;
    private int pageSize;
    private boolean last;

    public CompanyDataRes() {}

    public CompanyDataRes(List<Companies> content, int currentPage, int totalPages, long totalElements, int pageSize, boolean last) {
        this.content = content;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.pageSize = pageSize;
        this.last = last;
    }

    public List<Companies> getContent() {
        return content;
    }
    public void setContent(List<Companies> content) {
        this.content = content;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getTotalPages() {
        return totalPages;
    }
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    public long getTotalElements() {
        return totalElements;
    }
    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public boolean isLast() {
        return last;
    }
    public void setLast(boolean last) {
        this.last = last;
    }
}
