package at.htl.leonding.dto;

import java.time.LocalDate;

public record MediaDto(Long mediaId, Integer length, LocalDate date) {
}
