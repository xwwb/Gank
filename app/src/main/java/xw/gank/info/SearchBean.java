package xw.gank.info;

import java.util.List;

public class SearchBean {
    private String title;
    private List<String>itemTitle;

    public SearchBean(String title, List<String> itemTitle) {
        this.title = title;
        this.itemTitle = itemTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(List<String> itemTitle) {
        this.itemTitle = itemTitle;
    }
}
