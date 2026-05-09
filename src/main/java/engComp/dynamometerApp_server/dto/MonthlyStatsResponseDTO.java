package engComp.dynamometerApp_server.dto;

import java.time.YearMonth;

public class MonthlyStatsResponseDTO {

    private int month;
    private int year;
    private Long count;
    private Double avgPinch;
    private Double maxPinch;
    private Double avgPalm;
    private Double maxPalm;

    public MonthlyStatsResponseDTO(WeeklyStatsProjection projection, YearMonth yearMonth) {
        this.month = yearMonth.getMonthValue();
        this.year = yearMonth.getYear();
        this.count = projection.getCount();
        this.avgPinch = projection.getAvgPinch();
        this.maxPinch = projection.getMaxPinch();
        this.avgPalm = projection.getAvgPalm();
        this.maxPalm = projection.getMaxPalm();
    }

    // Getters
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public Long getCount() { return count; }
    public Double getAvgPinch() { return avgPinch; }
    public Double getMaxPinch() { return maxPinch; }
    public Double getAvgPalm() { return avgPalm; }
    public Double getMaxPalm() { return maxPalm; }
}
