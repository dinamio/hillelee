package com.kuznetsov.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "themes", schema = "quiz")
public class ThemesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String theme;

    public ThemesEntity(String theme) {
        this.theme = theme;
    }

    public ThemesEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThemesEntity that = (ThemesEntity) o;
        return id == that.id &&
                Objects.equals(theme, that.theme);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, theme);
    }
}
