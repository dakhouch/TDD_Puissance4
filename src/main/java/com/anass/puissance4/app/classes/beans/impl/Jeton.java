package com.anass.puissance4.app.classes.beans.impl;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || o instanceof JetonVide) return false;
        Jeton jeton = (Jeton) o;
        return content!= null && Objects.equals(content, jeton.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content);
    }
}
