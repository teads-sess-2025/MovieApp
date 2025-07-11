package com.example.MovieApp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
//import lombok.*;

@Entity
@Table(name = "movietable")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class MovieEntity {

    @Id
    private Integer id;

    private String title;
    private String originalTitle;
    private String tagline;
    private String overview;
    private String releaseDate;
    private String posterPath;
    private String backdropPath;
    private String status;

    private String adult;
    private Integer budget;
    private String revenue;

    private Integer voteCount;
    private Long voteAverage;
    private Integer playlistId;
    @Column(length = 2000)
    private String originCountry; // JSON string

    @Column(length = 2000)
    private String genres; // JSON string

    @Column(length = 3000)
    private String productionCompanies; // JSON string

    public MovieEntity() {}

    public MovieEntity(Integer id, String title, String originalTitle, String tagline, String overview, String releaseDate, String posterPath, String backdropPath, String status, String adult, Integer budget, String revenue, Integer voteCount, Long voteAverage, Integer playlistId, String originCountry, String genres, String productionCompanies) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.tagline = tagline;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
        this.status = status;
        this.adult = adult;
        this.budget = budget;
        this.revenue = revenue;
        this.voteCount = voteCount;
        this.voteAverage = voteAverage;
        this.playlistId = playlistId;
        this.originCountry = originCountry;
        this.genres = genres;
        this.productionCompanies = productionCompanies;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public void setVoteAverage(Long voteAverage) {
        this.voteAverage = voteAverage;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public void setProductionCompanies(String productionCompanies) {
        this.productionCompanies = productionCompanies;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getTagline() {
        return tagline;
    }

    public String getOverview() {
        return overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public String getStatus() {
        return status;
    }

    public String getAdult() {
        return adult;
    }

    public Integer getBudget() {
        return budget;
    }

    public String getRevenue() {
        return revenue;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public Long getVoteAverage() {
        return voteAverage;
    }

    public Integer getPlaylistId() {
        return playlistId;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public String getGenres() {
        return genres;
    }

    public String getProductionCompanies() {
        return productionCompanies;
    }
}
