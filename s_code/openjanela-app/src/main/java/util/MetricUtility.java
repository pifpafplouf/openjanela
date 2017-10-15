package util;

import java.math.BigDecimal;

public class MetricUtility
{
	
	/**
	 * Convert To Metric scale
	 * 
	 * @param value
	 *             , BigDecimal
	 * @return BigDecimal
	 */
	public static BigDecimal convertToMetricScale(BigDecimal value)
	{
	
		return value.divide(new BigDecimal("1000").multiply(new BigDecimal("100"))).setScale(6, BigDecimal.ROUND_UP);
	}
	
	/**
	 * Converto To Imperial scale
	 * 
	 * @param value
	 *             , BigDecimal
	 * @return BigDecimal
	 */
	public static BigDecimal convertToImperialScale(BigDecimal value)
	{
	
		return value.divide(new BigDecimal("64").divide(new BigDecimal("12"))).setScale(6, BigDecimal.ROUND_UP);
	}
}
