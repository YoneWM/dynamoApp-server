package engComp.dynamometerApp_server.dto;

import java.time.LocalDate;

public class WeeklyStatsResponseDTO {
    private LocalDate weekStart;
    private LocalDate weekEnd;
    private Long count;
    private Double avgPinch;
    private Double maxPinch;
    private Double avgPalm;
    private Double maxPalm;

    //Constructor
    public WeeklyStatsResponseDTO(WeeklyStatsProjection projection, LocalDate weekStart, LocalDate weekEnd) {
        this.weekStart = weekStart;
        this.weekEnd = weekEnd;
        this.count = projection.getCount();
        this.avgPinch = projection.getAvgPinch();
        this.maxPinch = projection.getMaxPinch();
        this.avgPalm = projection.getAvgPalm();
        this.maxPalm = projection.getMaxPalm();
    }

    // Getters
    public LocalDate getWeekStart() { return weekStart; }
    public LocalDate getWeekEnd() { return weekEnd; }
    public Long getCount() { return count; }
    public Double getAvgPinch() { return avgPinch; }
    public Double getMaxPinch() { return maxPinch; }
    public Double getAvgPalm() { return avgPalm; }
    public Double getMaxPalm() { return maxPalm; }
}
