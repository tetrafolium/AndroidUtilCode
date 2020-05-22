package com.blankj.utilcode.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * <pre>
 *     author: blankj
 *     blog  : http://blankj.com
 *     time  : 2020/04/12
 *     desc  : utils about number
 * </pre>
 */
public final class NumberUtils {

    private static final ThreadLocal<DecimalFormat> DF_THREAD_LOCAL = new ThreadLocal<DecimalFormat>() {
        @Override
        protected DecimalFormat initialValue() {
            return (DecimalFormat) NumberFormat.getInstance();
        }
    };

    public static DecimalFormat getSafeDecimalFormat() {
        return DF_THREAD_LOCAL.get();
    }

    private NumberUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Format the value.
     *
     * @param value          The value.
     * @param fractionDigits The number of digits allowed in the fraction portion of value.
     * @return the format value
     */
    public static String format(final float value, final int fractionDigits) {
        return format(value, false, 1, fractionDigits, true);
    }

    /**
     * Format the value.
     *
     * @param value          The value.
     * @param fractionDigits The number of digits allowed in the fraction portion of value.
     * @param isHalfUp       True to rounded towards the nearest neighbor.
     * @return the format value
     */
    public static String format(final float value, final int fractionDigits, final boolean isHalfUp) {
        return format(value, false, 1, fractionDigits, isHalfUp);
    }

    /**
     * Format the value.
     *
     * @param value            The value.
     * @param minIntegerDigits The minimum number of digits allowed in the integer portion of value.
     * @param fractionDigits   The number of digits allowed in the fraction portion of value.
     * @param isHalfUp         True to rounded towards the nearest neighbor.
     * @return the format value
     */
    public static String format(final float value, final int minIntegerDigits, final int fractionDigits, final boolean isHalfUp) {
        return format(value, false, minIntegerDigits, fractionDigits, isHalfUp);
    }

    /**
     * Format the value.
     *
     * @param value          The value.
     * @param isGrouping     True to set grouping will be used in this format, false otherwise.
     * @param fractionDigits The number of digits allowed in the fraction portion of value.
     * @return the format value
     */
    public static String format(final float value, final boolean isGrouping, final int fractionDigits) {
        return format(value, isGrouping, 1, fractionDigits, true);
    }

    /**
     * Format the value.
     *
     * @param value          The value.
     * @param isGrouping     True to set grouping will be used in this format, false otherwise.
     * @param fractionDigits The number of digits allowed in the fraction portion of value.
     * @param isHalfUp       True to rounded towards the nearest neighbor.
     * @return the format value
     */
    public static String format(final float value, final boolean isGrouping, final int fractionDigits, final boolean isHalfUp) {
        return format(value, isGrouping, 1, fractionDigits, isHalfUp);
    }

    /**
     * Format the value.
     *
     * @param value            The value.
     * @param isGrouping       True to set grouping will be used in this format, false otherwise.
     * @param minIntegerDigits The minimum number of digits allowed in the integer portion of value.
     * @param fractionDigits   The number of digits allowed in the fraction portion of value.
     * @param isHalfUp         True to rounded towards the nearest neighbor.
     * @return the format value
     */
    public static String format(final float value, final boolean isGrouping, final int minIntegerDigits, final int fractionDigits, final boolean isHalfUp) {
        return format(float2Double(value), isGrouping, minIntegerDigits, fractionDigits, isHalfUp);
    }

    /**
     * Format the value.
     *
     * @param value          The value.
     * @param fractionDigits The number of digits allowed in the fraction portion of value.
     * @return the format value
     */
    public static String format(final double value, final int fractionDigits) {
        return format(value, false, 1, fractionDigits, true);
    }

    /**
     * Format the value.
     *
     * @param value          The value.
     * @param fractionDigits The number of digits allowed in the fraction portion of value.
     * @param isHalfUp       True to rounded towards the nearest neighbor.
     * @return the format value
     */
    public static String format(final double value, final int fractionDigits, final boolean isHalfUp) {
        return format(value, false, 1, fractionDigits, isHalfUp);
    }

    /**
     * Format the value.
     *
     * @param value            The value.
     * @param minIntegerDigits The minimum number of digits allowed in the integer portion of value.
     * @param fractionDigits   The number of digits allowed in the fraction portion of value.
     * @param isHalfUp         True to rounded towards the nearest neighbor.
     * @return the format value
     */
    public static String format(final double value, final int minIntegerDigits, final int fractionDigits, final boolean isHalfUp) {
        return format(value, false, minIntegerDigits, fractionDigits, isHalfUp);
    }

    /**
     * Format the value.
     *
     * @param value          The value.
     * @param isGrouping     True to set grouping will be used in this format, false otherwise.
     * @param fractionDigits The number of digits allowed in the fraction portion of value.
     * @return the format value
     */
    public static String format(final double value, final boolean isGrouping, final int fractionDigits) {
        return format(value, isGrouping, 1, fractionDigits, true);
    }

    /**
     * Format the value.
     *
     * @param value          The value.
     * @param isGrouping     True to set grouping will be used in this format, false otherwise.
     * @param fractionDigits The number of digits allowed in the fraction portion of value.
     * @param isHalfUp       True to rounded towards the nearest neighbor.
     * @return the format value
     */
    public static String format(final double value, final boolean isGrouping, final int fractionDigits, final boolean isHalfUp) {
        return format(value, isGrouping, 1, fractionDigits, isHalfUp);
    }

    /**
     * Format the value.
     *
     * @param value            The value.
     * @param isGrouping       True to set grouping will be used in this format, false otherwise.
     * @param minIntegerDigits The minimum number of digits allowed in the integer portion of value.
     * @param fractionDigits   The number of digits allowed in the fraction portion of value.
     * @param isHalfUp         True to rounded towards the nearest neighbor.
     * @return the format value
     */
    public static String format(final double value, final boolean isGrouping, final int minIntegerDigits, final int fractionDigits, final boolean isHalfUp) {
        DecimalFormat nf = getSafeDecimalFormat();
        nf.setGroupingUsed(isGrouping);
        nf.setRoundingMode(isHalfUp ? RoundingMode.HALF_UP : RoundingMode.DOWN);
        nf.setMinimumIntegerDigits(minIntegerDigits);
        nf.setMinimumFractionDigits(fractionDigits);
        nf.setMaximumFractionDigits(fractionDigits);
        return nf.format(value);
    }

    /**
     * Float to double.
     *
     * @param value The value.
     * @return the number of double
     */
    public static double float2Double(final float value) {
        return new BigDecimal(String.valueOf(value)).doubleValue();
    }
}
