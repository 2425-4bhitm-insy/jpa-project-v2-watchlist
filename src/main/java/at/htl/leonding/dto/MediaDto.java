package at.htl.leonding.dto;

import java.time.LocalDate;

public record MediaDto(Long mediaId, Integer duration, LocalDate date) {
}
