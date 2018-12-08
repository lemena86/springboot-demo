package cl.home.store.demo.service.dto;

import cl.home.store.demo.domain.Review;

import java.util.Objects;

public class ReviewDto {

    private Double average;

    private Long votes;

    public ReviewDto() {
    }

    public ReviewDto(Review review) {
        this.average = review.getAverage();
        this.votes = review.getVotes();
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Long getVotes() {
        return votes;
    }

    public void setVotes(Long votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReviewDto reviewDto = (ReviewDto) o;
        return Objects.equals(average, reviewDto.average) &&
                Objects.equals(votes, reviewDto.votes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(average, votes);
    }

    @Override
    public String toString() {
        return "ReviewDto{" +
                "average=" + average +
                ", votes=" + votes +
                '}';
    }
}
