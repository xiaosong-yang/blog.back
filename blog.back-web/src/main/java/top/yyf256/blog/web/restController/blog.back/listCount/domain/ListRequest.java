package top.yyf256.blog.web.restController.blog.back.listCount.domain;

public class ListRequest {
    private String searchValue1;
    private String searchValue2;
    private String curr;
    private String limit;

    public String getSearchValue1() {
        return searchValue1;
    }

    public void setSearchValue1(String searchValue1) {
        this.searchValue1 = searchValue1;
    }

    public String getSearchValue2() {
        return searchValue2;
    }

    public void setSearchValue2(String searchValue2) {
        this.searchValue2 = searchValue2;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
}
