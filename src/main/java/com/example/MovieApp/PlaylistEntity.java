package com.example.MovieApp;

import jakarta.persistence.*;

@Entity
@Table(name = "playlisttable")
public class PlaylistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @Column(name = "user_id")
    private int userId;

    public PlaylistEntity() {}

    public PlaylistEntity(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = 1;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getUserId() {
        return userId;
    }
}
