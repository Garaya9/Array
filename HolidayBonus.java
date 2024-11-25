package application;

public class HolidayBonus {

    private static final double HIGH_BONUS = 5000.0;
    private static final double LOW_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;

    /**
     * Calculates the holiday bonus for each store based on sales.
     * @param data the two-dimensional ragged array of sales
     * @return an array of holiday bonuses for each store
     */
    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];

        for (int i = 0; i < data.length; i++) {
            double bonus = 0;

            for (int col = 0; col < getMaxColumns(data); col++) {
                double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
                double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);

                if (col < data[i].length && data[i][col] > 0) {
                    if (data[i][col] == highest) {
                        bonus += HIGH_BONUS;
                    } else if (data[i][col] == lowest) {
                        bonus += LOW_BONUS;
                    } else {
                        bonus += OTHER_BONUS;
                    }
                }
            }

            bonuses[i] = bonus;
        }

        return bonuses;
    }

    /**
     * Calculates the total holiday bonus for all stores.
     * @param data the two-dimensional ragged array of sales
     * @return the total holiday bonus
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0;
        double[] bonuses = calculateHolidayBonus(data);

        for (double bonus : bonuses) {
            totalBonus += bonus;
        }

        return totalBonus;
    }

    private static int getMaxColumns(double[][] data) {
        int max = 0;
        for (double[] row : data) {
            max = Math.max(max, row.length);
        }
        return max;
    }
}
