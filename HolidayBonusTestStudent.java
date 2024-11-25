package application;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class HolidayBonusTestStudent {

    private double[][] dataSet1 = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };

    @Test
    void testCalculateHolidayBonus() {
        double[] bonuses = HolidayBonus.calculateHolidayBonus(dataSet1);
        assertEquals(3000.0, bonuses[0], 0.001);
        assertEquals(4000.0, bonuses[1], 0.001);
        assertEquals(15000.0, bonuses[2], 0.001);
    }

    @Test
    void testCalculateTotalHolidayBonus() {
        double totalBonus = HolidayBonus.calculateTotalHolidayBonus(dataSet1);
        assertEquals(22000.0, totalBonus, 0.001);
    }
}
