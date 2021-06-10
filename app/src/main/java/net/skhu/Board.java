package net.skhu;

public class Board {
    String title;
    String date;
    String content;
    int type;

    Board(){ }

    Board(String title, String date, String content, int layouttype){
        this.title = title;
        this.date = date;
        this.content = content;
        this.type = layouttype;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setType(int type) {
        this.type = type;
    }
}
