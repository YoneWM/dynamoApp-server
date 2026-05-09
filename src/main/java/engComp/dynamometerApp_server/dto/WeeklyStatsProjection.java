package engComp.dynamometerApp_server.dto;

public interface WeeklyStatsProjection {
    Long getCount();
    Double getAvgPinch();
    Double getMaxPinch();
    Double getAvgPalm();
    Double getMaxPalm();
}
