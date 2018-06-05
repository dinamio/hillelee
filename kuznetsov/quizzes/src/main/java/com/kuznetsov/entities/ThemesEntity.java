package com.kuznetsov.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "themes", schema = "quiz", catalog = "")
public class ThemesEntity {
    private int id;
    private String theme;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "theme", nullable = true, length = 45)
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
