package com.anass.puissance4.app.classes;

public abstract class Jeton {
    private String content;

    public Jeton(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
