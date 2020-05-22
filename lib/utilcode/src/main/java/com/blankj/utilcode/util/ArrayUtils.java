package com.blankj.utilcode.util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author: blankj
 *     blog  : http://blankj.com
 *     time  : 2019/08/10
 *     desc  : utils about array
 * </pre>
 */
public class ArrayUtils {

    public static final int INDEX_NOT_FOUND = -1;

    private ArrayUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Returns a new array only of those given elements.
     *
     * @param array The array.
     * @return a new array only of those given elements.
     */
    @SafeVarargs
    public static <T> T[] newArray(final T... array) {
        return array;
    }

    public static long[] newLongArray(final long... array) {
        return array;
    }

    public static int[] newIntArray(final int... array) {
        return array;
    }

    public static short[] newShortArray(final short... array) {
        return array;
    }

    public static char[] newCharArray(final char... array) {
        return array;
    }

    public static byte[] newByteArray(final byte... array) {
        return array;
    }

    public static double[] newDoubleArray(final double... array) {
        return array;
    }

    public static float[] newFloatArray(final float... array) {
        return array;
    }

    public static boolean[] newBooleanArray(final boolean... array) {
        return array;
    }

    /**
     * Return the array is empty.
     *
     * @param array The array.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean isEmpty(final Object array) {
        return getLength(array) == 0;
    }

    /**
     * Return the size of array.
     *
     * @param array The array.
     * @return the size of array
     */
    public static int getLength(final Object array) {
        if (array == null) return 0;
        return Array.getLength(array);
    }

    public static boolean isSameLength(final Object array1, final Object array2) {
        return getLength(array1) == getLength(array2);
    }

    /**
     * Get the value of the specified index of the array.
     *
     * @param array The array.
     * @param index The index into the array.
     * @return the value of the specified index of the array
     */
    public static Object get(final Object array, final int index) {
        return get(array, index, null);
    }

    /**
     * Get the value of the specified index of the array.
     *
     * @param array        The array.
     * @param index        The index into the array.
     * @param defaultValue The default value.
     * @return the value of the specified index of the array
     */
    public static Object get(final Object array, final int index, final Object defaultValue) {
        if (array == null) return defaultValue;
        try {
            return Array.get(array, index);
        } catch (Exception ignore) {
            return defaultValue;
        }
    }

    /**
     * Set the value of the specified index of the array.
     *
     * @param array The array.
     * @param index The index into the array.
     * @param value The new value of the indexed component.
     */
    public static void set(final Object array, final int index, final Object value) {
        if (array == null) return;
        Array.set(array, index, value);
    }

    /**
     * Return whether the two arrays are equals.
     *
     * @param a  One array.
     * @param a2 The other array.
     * @return {@code true}: yes<br>{@code false}: no
     */
    public static boolean equals(final Object[] a, final Object[] a2) {
        return Arrays.deepEquals(a, a2);
    }

    public static boolean equals(final boolean[] a, final boolean[] a2) {
        return Arrays.equals(a, a2);
    }

    public static boolean equals(final byte[] a, final byte[] a2) {
        return Arrays.equals(a, a2);
    }

    public static boolean equals(final char[] a, final char[] a2) {
        return Arrays.equals(a, a2);
    }

    public static boolean equals(final double[] a, final double[] a2) {
        return Arrays.equals(a, a2);
    }

    public static boolean equals(final float[] a, final float[] a2) {
        return Arrays.equals(a, a2);
    }

    public static boolean equals(final int[] a, final int[] a2) {
        return Arrays.equals(a, a2);
    }

    public static boolean equals(final short[] a, final short[] a2) {
        return Arrays.equals(a, a2);
    }

    ///////////////////////////////////////////////////////////////////////////
    // reverse
    ///////////////////////////////////////////////////////////////////////////

    /**
     * <p>Reverses the order of the given array.</p>
     *
     * <p>There is no special handling for multi-dimensional arrays.</p>
     *
     * <p>This method does nothing for a <code>null</code> input array.</p>
     *
     * @param array the array to reverse, may be <code>null</code>
     */
    public static <T> void reverse(final T[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        T tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    public static void reverse(final long[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        long tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    public static void reverse(final int[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        int tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    public static void reverse(final short[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        short tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    public static void reverse(final char[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        char tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    public static void reverse(final byte[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        byte tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    public static void reverse(final double[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        double tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    public static void reverse(final float[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        float tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    public static void reverse(final boolean[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        boolean tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // copy
    ///////////////////////////////////////////////////////////////////////////

    /**
     * <p>Copies the specified array and handling
     * <code>null</code>.</p>
     *
     * <p>The objects in the array are not cloned, thus there is no special
     * handling for multi-dimensional arrays.</p>
     *
     * <p>This method returns <code>null</code> for a <code>null</code> input array.</p>
     *
     * @param array the array to shallow clone, may be <code>null</code>
     * @return the cloned array, <code>null</code> if <code>null</code> input
     */
    public static <T> T[] copy(final T[] array) {
        if (array == null) return null;
        return subArray(array, 0, array.length);
    }

    public static long[] copy(final long[] array) {
        if (array == null) return null;
        return subArray(array, 0, array.length);
    }

    public static int[] copy(final int[] array) {
        if (array == null) return null;
        return subArray(array, 0, array.length);
    }

    public static short[] copy(final short[] array) {
        if (array == null) return null;
        return subArray(array, 0, array.length);
    }

    public static char[] copy(final char[] array) {
        if (array == null) return null;
        return subArray(array, 0, array.length);
    }

    public static byte[] copy(final byte[] array) {
        if (array == null) return null;
        return subArray(array, 0, array.length);
    }

    public static double[] copy(final double[] array) {
        if (array == null) return null;
        return subArray(array, 0, array.length);
    }

    public static float[] copy(final float[] array) {
        if (array == null) return null;
        return subArray(array, 0, array.length);
    }

    public static boolean[] copy(final boolean[] array) {
        if (array == null) return null;
        return subArray(array, 0, array.length);
    }

    private static Object realCopy(final Object array) {
        if (array == null) return null;
        return realSubArray(array, 0, getLength(array));
    }

    ///////////////////////////////////////////////////////////////////////////
    // subArray
    ///////////////////////////////////////////////////////////////////////////

    public static <T> T[] subArray(final T[] array, final int startIndexInclusive, final int endIndexExclusive) {
        //noinspection unchecked
        return (T[]) realSubArray(array, startIndexInclusive, endIndexExclusive);
    }

    public static long[] subArray(final long[] array, final int startIndexInclusive, final int endIndexExclusive) {
        return (long[]) realSubArray(array, startIndexInclusive, endIndexExclusive);
    }

    public static int[] subArray(final int[] array, final int startIndexInclusive, final int endIndexExclusive) {
        return (int[]) realSubArray(array, startIndexInclusive, endIndexExclusive);
    }

    public static short[] subArray(final short[] array, final int startIndexInclusive, final int endIndexExclusive) {
        return (short[]) realSubArray(array, startIndexInclusive, endIndexExclusive);
    }

    public static char[] subArray(final char[] array, final int startIndexInclusive, final int endIndexExclusive) {
        return (char[]) realSubArray(array, startIndexInclusive, endIndexExclusive);
    }

    public static byte[] subArray(final byte[] array, final int startIndexInclusive, final int endIndexExclusive) {
        return (byte[]) realSubArray(array, startIndexInclusive, endIndexExclusive);
    }

    public static double[] subArray(final double[] array, final int startIndexInclusive, final int endIndexExclusive) {
        return (double[]) realSubArray(array, startIndexInclusive, endIndexExclusive);
    }

    public static float[] subArray(final float[] array, final int startIndexInclusive, final int endIndexExclusive) {
        return (float[]) realSubArray(array, startIndexInclusive, endIndexExclusive);
    }

    public static boolean[] subArray(final boolean[] array, final int startIndexInclusive, final int endIndexExclusive) {
        return (boolean[]) realSubArray(array, startIndexInclusive, endIndexExclusive);
    }

    private static Object realSubArray(final Object array, final int startIndexInclusive, final int endIndexExclusive) {
        if (array == null) {
            return null;
        }
        if (startIndexInclusive < 0) {
            startIndexInclusive = 0;
        }
        int length = getLength(array);
        if (endIndexExclusive > length) {
            endIndexExclusive = length;
        }
        int newSize = endIndexExclusive - startIndexInclusive;
        Class type = array.getClass().getComponentType();
        if (newSize <= 0) {
            return Array.newInstance(type, 0);
        }
        Object subArray = Array.newInstance(type, newSize);
        System.arraycopy(array, startIndexInclusive, subArray, 0, newSize);
        return subArray;
    }

    ///////////////////////////////////////////////////////////////////////////
    // add
    ///////////////////////////////////////////////////////////////////////////

    /**
     * <p>Copies the given array and adds the given element at the end of the new array.</p>
     *
     * <p>The new array contains the same elements of the input
     * array plus the given element in the last position. The component type of
     * the new array is the same as that of the input array.</p>
     *
     * <p>If the input array is <code>null</code>, a new one element array is returned
     * whose component type is the same as the element.</p>
     *
     * <pre>
     * ArrayUtils.realAdd(null, null)      = [null]
     * ArrayUtils.realAdd(null, "a")       = ["a"]
     * ArrayUtils.realAdd(["a"], null)     = ["a", null]
     * ArrayUtils.realAdd(["a"], "b")      = ["a", "b"]
     * ArrayUtils.realAdd(["a", "b"], "c") = ["a", "b", "c"]
     * </pre>
     *
     * @param array   the array to "realAdd" the element to, may be <code>null</code>
     * @param element the object to realAdd
     * @return A new array containing the existing elements plus the new element
     */
    public static <T> T[] add(final T[] array, final T element) {
        Class type = array != null ? array.getClass() : (element != null ? element.getClass() : Object.class);
        return (T[]) realAddOne(array, element, type);
    }

    public static boolean[] add(final boolean[] array, final boolean element) {
        return (boolean[]) realAddOne(array, element, Boolean.TYPE);
    }

    public static byte[] add(final byte[] array, final byte element) {
        return (byte[]) realAddOne(array, element, Byte.TYPE);
    }

    public static char[] add(final char[] array, final char element) {
        return (char[]) realAddOne(array, element, Character.TYPE);
    }

    public static double[] add(final double[] array, final double element) {
        return (double[]) realAddOne(array, element, Double.TYPE);
    }

    public static float[] add(final float[] array, final float element) {
        return (float[]) realAddOne(array, element, Float.TYPE);
    }

    public static int[] add(final int[] array, final int element) {
        return (int[]) realAddOne(array, element, Integer.TYPE);
    }

    public static long[] add(final long[] array, final long element) {
        return (long[]) realAddOne(array, element, Long.TYPE);
    }

    public static short[] add(final short[] array, final short element) {
        return (short[]) realAddOne(array, element, Short.TYPE);
    }

    private static Object realAddOne(final Object array, final Object element, final Class newArrayComponentType) {
        Object newArray;
        int arrayLength = 0;
        if (array != null) {
            arrayLength = getLength(array);
            newArray = Array.newInstance(array.getClass().getComponentType(), arrayLength + 1);
            System.arraycopy(array, 0, newArray, 0, arrayLength);
        } else {
            newArray = Array.newInstance(newArrayComponentType, 1);
        }
        Array.set(newArray, arrayLength, element);
        return newArray;
    }

    /**
     * <p>Adds all the elements of the given arrays into a new array.</p>
     * <p>The new array contains all of the element of <code>array1</code> followed
     * by all of the elements <code>array2</code>. When an array is returned, it is always
     * a new array.</p>
     *
     * <pre>
     * ArrayUtils.add(null, null)     = null
     * ArrayUtils.add(array1, null)   = copy of array1
     * ArrayUtils.add(null, array2)   = copy of array2
     * ArrayUtils.add([], [])         = []
     * ArrayUtils.add([null], [null]) = [null, null]
     * ArrayUtils.add(["a", "b", "c"], ["1", "2", "3"]) = ["a", "b", "c", "1", "2", "3"]
     * </pre>
     *
     * @param array1 the first array whose elements are added to the new array, may be <code>null</code>
     * @param array2 the second array whose elements are added to the new array, may be <code>null</code>
     * @return The new array, <code>null</code> if <code>null</code> array inputs.
     * The type of the new array is the type of the first array.
     */
    public static <T> T[] add(final T[] array1, final T[] array2) {
        return (T[]) realAddArr(array1, array2);
    }

    public static boolean[] add(final boolean[] array1, final boolean[] array2) {
        return (boolean[]) realAddArr(array1, array2);
    }

    public static char[] add(final char[] array1, final char[] array2) {
        return (char[]) realAddArr(array1, array2);
    }

    public static byte[] add(final byte[] array1, final byte[] array2) {
        return (byte[]) realAddArr(array1, array2);
    }

    public static short[] add(final short[] array1, final short[] array2) {
        return (short[]) realAddArr(array1, array2);
    }

    public static int[] add(final int[] array1, final int[] array2) {
        return (int[]) realAddArr(array1, array2);
    }

    public static long[] add(final long[] array1, final long[] array2) {
        return (long[]) realAddArr(array1, array2);
    }

    public static float[] add(final float[] array1, final float[] array2) {
        return (float[]) realAddArr(array1, array2);
    }

    public static double[] add(final double[] array1, final double[] array2) {
        return (double[]) realAddArr(array1, array2);
    }

    private static Object realAddArr(final Object array1, final Object array2) {
        if (array1 == null && array2 == null) return null;
        if (array1 == null) {
            return realCopy(array2);
        }
        if (array2 == null) {
            return realCopy(array1);
        }
        int len1 = getLength(array1);
        int len2 = getLength(array2);
        Object joinedArray = Array.newInstance(array1.getClass().getComponentType(), len1 + len2);
        System.arraycopy(array1, 0, joinedArray, 0, len1);
        System.arraycopy(array2, 0, joinedArray, len1, len2);
        return joinedArray;
    }

    /**
     * <p>Inserts the specified element at the specified position in the array.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).</p>
     *
     * <p>This method returns a new array with the same elements of the input
     * array plus the given element on the specified position. The component
     * type of the returned array is always the same as that of the input
     * array.</p>
     *
     * <p>If the input array is <code>null</code>, a new one element array is returned
     * whose component type is the same as the element.</p>
     *
     * <pre>
     * ArrayUtils.add(null, 0, null)      = [null]
     * ArrayUtils.add(null, 0, "a")       = ["a"]
     * ArrayUtils.add(["a"], 1, null)     = ["a", null]
     * ArrayUtils.add(["a"], 1, "b")      = ["a", "b"]
     * ArrayUtils.add(["a", "b"], 3, "c") = ["a", "b", "c"]
     * </pre>
     *
     * @param array1 the array to realAdd the element to, may be <code>null</code>
     * @param index  the position of the new object
     * @param array2 the array to realAdd
     * @return A new array containing the existing elements and the new element
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (index < 0 || index > array.length).
     */
    public static <T> T[] add(final T[] array1, final int index, final T[] array2) {
        Class clss;
        if (array1 != null) {
            clss = array1.getClass().getComponentType();
        } else if (array2 != null) {
            clss = array2.getClass().getComponentType();
        } else {
            return (T[]) new Object[]{null};
        }
        return (T[]) realAddArr(array1, index, array2, clss);
    }

    public static boolean[] add(final boolean[] array1, final int index, final boolean[] array2) {
        return (boolean[]) realAddArr(array1, index, array2, Boolean.TYPE);
    }

    public static char[] add(final char[] array1, final int index, final char[] array2) {
        return (char[]) realAddArr(array1, index, array2, Character.TYPE);
    }

    public static byte[] add(final byte[] array1, final int index, final byte[] array2) {
        return (byte[]) realAddArr(array1, index, array2, Byte.TYPE);
    }

    public static short[] add(final short[] array1, final int index, final short[] array2) {
        return (short[]) realAddArr(array1, index, array2, Short.TYPE);
    }

    public static int[] add(final int[] array1, final int index, final int[] array2) {
        return (int[]) realAddArr(array1, index, array2, Integer.TYPE);
    }

    public static long[] add(final long[] array1, final int index, final long[] array2) {
        return (long[]) realAddArr(array1, index, array2, Long.TYPE);
    }

    public static float[] add(final float[] array1, final int index, final float[] array2) {
        return (float[]) realAddArr(array1, index, array2, Float.TYPE);
    }

    public static double[] add(final double[] array1, final int index, final double[] array2) {
        return (double[]) realAddArr(array1, index, array2, Double.TYPE);
    }

    private static Object realAddArr(final Object array1, final int index, final Object array2, final Class clss) {
        if (array1 == null && array2 == null) return null;
        int len1 = getLength(array1);
        int len2 = getLength(array2);
        if (len1 == 0) {
            if (index != 0) {
                throw new IndexOutOfBoundsException("Index: " + index + ", array1 Length: 0");
            }
            return realCopy(array2);
        }
        if (len2 == 0) {
            return realCopy(array1);
        }
        if (index > len1 || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", array1 Length: " + len1);
        }
        Object joinedArray = Array.newInstance(array1.getClass().getComponentType(), len1 + len2);
        if (index == len1) {
            System.arraycopy(array1, 0, joinedArray, 0, len1);
            System.arraycopy(array2, 0, joinedArray, len1, len2);
        } else if (index == 0) {
            System.arraycopy(array2, 0, joinedArray, 0, len2);
            System.arraycopy(array1, 0, joinedArray, len2, len1);
        } else {
            System.arraycopy(array1, 0, joinedArray, 0, index);
            System.arraycopy(array2, 0, joinedArray, index, len2);
            System.arraycopy(array1, index, joinedArray, index + len2, len1 - index);
        }
        return joinedArray;
    }

    /**
     * <p>Inserts the specified element at the specified position in the array.
     * Shifts the element currently at that position (if any) and any subsequent
     * elements to the right (adds one to their indices).</p>
     *
     * <p>This method returns a new array with the same elements of the input
     * array plus the given element on the specified position. The component
     * type of the returned array is always the same as that of the input
     * array.</p>
     *
     * <p>If the input array is <code>null</code>, a new one element array is returned
     * whose component type is the same as the element.</p>
     *
     * <pre>
     * ArrayUtils.add(null, 0, null)      = [null]
     * ArrayUtils.add(null, 0, "a")       = ["a"]
     * ArrayUtils.add(["a"], 1, null)     = ["a", null]
     * ArrayUtils.add(["a"], 1, "b")      = ["a", "b"]
     * ArrayUtils.add(["a", "b"], 3, "c") = ["a", "b", "c"]
     * </pre>
     *
     * @param array   the array to realAdd the element to, may be <code>null</code>
     * @param index   the position of the new object
     * @param element the object to realAdd
     * @return A new array containing the existing elements and the new element
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (index < 0 || index > array.length).
     */
    public static <T> T[] add(final T[] array, final int index, final T element) {
        Class clss;
        if (array != null) {
            clss = array.getClass().getComponentType();
        } else if (element != null) {
            clss = element.getClass();
        } else {
            return (T[]) new Object[]{null};
        }
        return (T[]) realAdd(array, index, element, clss);
    }

    public static boolean[] add(final boolean[] array, final int index, final boolean element) {
        return (boolean[]) realAdd(array, index, element, Boolean.TYPE);
    }

    public static char[] add(final char[] array, final int index, final char element) {
        return (char[]) realAdd(array, index, element, Character.TYPE);
    }

    public static byte[] add(final byte[] array, final int index, final byte element) {
        return (byte[]) realAdd(array, index, element, Byte.TYPE);
    }

    public static short[] add(final short[] array, final int index, final short element) {
        return (short[]) realAdd(array, index, element, Short.TYPE);
    }

    public static int[] add(final int[] array, final int index, final int element) {
        return (int[]) realAdd(array, index, element, Integer.TYPE);
    }

    public static long[] add(final long[] array, final int index, final long element) {
        return (long[]) realAdd(array, index, element, Long.TYPE);
    }

    public static float[] add(final float[] array, final int index, final float element) {
        return (float[]) realAdd(array, index, element, Float.TYPE);
    }

    public static double[] add(final double[] array, final int index, final double element) {
        return (double[]) realAdd(array, index, element, Double.TYPE);
    }

    private static Object realAdd(final Object array, final int index, final Object element, final Class clss) {
        if (array == null) {
            if (index != 0) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Length: 0");
            }
            Object joinedArray = Array.newInstance(clss, 1);
            Array.set(joinedArray, 0, element);
            return joinedArray;
        }
        int length = Array.getLength(array);
        if (index > length || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
        }
        Object result = Array.newInstance(clss, length + 1);
        System.arraycopy(array, 0, result, 0, index);
        Array.set(result, index, element);
        if (index < length) {
            System.arraycopy(array, index, result, index + 1, length - index);
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // remove
    ///////////////////////////////////////////////////////////////////////////

    /**
     * <p>Removes the element at the specified position from the specified array.
     * All subsequent elements are shifted to the left (substracts one from
     * their indices).</p>
     *
     * <p>This method returns a new array with the same elements of the input
     * array except the element on the specified position. The component
     * type of the returned array is always the same as that of the input
     * array.</p>
     *
     * <p>If the input array is <code>null</code>, an IndexOutOfBoundsException
     * will be thrown, because in that case no valid index can be specified.</p>
     *
     * <pre>
     * ArrayUtils.remove(["a"], 0)           = []
     * ArrayUtils.remove(["a", "b"], 0)      = ["b"]
     * ArrayUtils.remove(["a", "b"], 1)      = ["a"]
     * ArrayUtils.remove(["a", "b", "c"], 1) = ["a", "c"]
     * </pre>
     *
     * @param array the array to remove the element from, may not be <code>null</code>
     * @param index the position of the element to be removed
     * @return A new array containing the existing elements except the element
     * at the specified position.
     * @throws IndexOutOfBoundsException if the index is out of range
     *                                   (index < 0 || index >= array.length), or if the array is <code>null</code>.
     * @since 2.1
     */
    public static Object[] remove(final Object[] array, final int index) {
        return (Object[]) remove((Object) array, index);
    }

    /**
     * <p>Removes the first occurrence of the specified element from the
     * specified array. All subsequent elements are shifted to the left
     * (substracts one from their indices). If the array doesn't contains
     * such an element, no elements are removed from the array.</p>
     *
     * <p>This method returns a new array with the same elements of the input
     * array except the first occurrence of the specified element. The component
     * type of the returned array is always the same as that of the input
     * array.</p>
     *
     * <pre>
     * ArrayUtils.removeElement(null, "a")            = null
     * ArrayUtils.removeElement([], "a")              = []
     * ArrayUtils.removeElement(["a"], "b")           = ["a"]
     * ArrayUtils.removeElement(["a", "b"], "a")      = ["b"]
     * ArrayUtils.removeElement(["a", "b", "a"], "a") = ["b", "a"]
     * </pre>
     *
     * @param array   the array to remove the element from, may be <code>null</code>
     * @param element the element to be removed
     * @return A new array containing the existing elements except the first
     * occurrence of the specified element.
     * @since 2.1
     */
    public static Object[] removeElement(final Object[] array, final Object element) {
        int index = indexOf(array, element);
        if (index == INDEX_NOT_FOUND) {
            return copy(array);
        }
        return remove(array, index);
    }

    public static boolean[] remove(final boolean[] array, final int index) {
        return (boolean[]) remove((Object) array, index);
    }

    public static boolean[] removeElement(final boolean[] array, final boolean element) {
        int index = indexOf(array, element);
        if (index == INDEX_NOT_FOUND) {
            return copy(array);
        }
        return remove(array, index);
    }

    public static byte[] remove(final byte[] array, final int index) {
        return (byte[]) remove((Object) array, index);
    }

    public static byte[] removeElement(final byte[] array, final byte element) {
        int index = indexOf(array, element);
        if (index == INDEX_NOT_FOUND) {
            return copy(array);
        }
        return remove(array, index);
    }

    public static char[] remove(final char[] array, final int index) {
        return (char[]) remove((Object) array, index);
    }

    public static char[] removeElement(final char[] array, final char element) {
        int index = indexOf(array, element);
        if (index == INDEX_NOT_FOUND) {
            return copy(array);
        }
        return remove(array, index);
    }

    public static double[] remove(final double[] array, final int index) {
        return (double[]) remove((Object) array, index);
    }

    public static double[] removeElement(final double[] array, final double element) {
        int index = indexOf(array, element);
        if (index == INDEX_NOT_FOUND) {
            return copy(array);
        }
        return remove(array, index);
    }

    public static float[] remove(final float[] array, final int index) {
        return (float[]) remove((Object) array, index);
    }

    public static float[] removeElement(final float[] array, final float element) {
        int index = indexOf(array, element);
        if (index == INDEX_NOT_FOUND) {
            return copy(array);
        }
        return remove(array, index);
    }

    public static int[] remove(final int[] array, final int index) {
        return (int[]) remove((Object) array, index);
    }

    public static int[] removeElement(final int[] array, final int element) {
        int index = indexOf(array, element);
        if (index == INDEX_NOT_FOUND) {
            return copy(array);
        }
        return remove(array, index);
    }

    public static long[] remove(final long[] array, final int index) {
        return (long[]) remove((Object) array, index);
    }

    public static long[] removeElement(final long[] array, final long element) {
        int index = indexOf(array, element);
        if (index == INDEX_NOT_FOUND) {
            return copy(array);
        }
        return remove(array, index);
    }

    public static short[] remove(final short[] array, final int index) {
        return (short[]) remove((Object) array, index);
    }

    public static short[] removeElement(final short[] array, final short element) {
        int index = indexOf(array, element);
        if (index == INDEX_NOT_FOUND) {
            return copy(array);
        }
        return remove(array, index);
    }

    private static Object remove(final Object array, final int index) {
        int length = getLength(array);
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
        }

        Object result = Array.newInstance(array.getClass().getComponentType(), length - 1);
        System.arraycopy(array, 0, result, 0, index);
        if (index < length - 1) {
            System.arraycopy(array, index + 1, result, index, length - index - 1);
        }

        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // object indexOf
    ///////////////////////////////////////////////////////////////////////////

    public static int indexOf(final Object[] array, final Object objectToFind) {
        return indexOf(array, objectToFind, 0);
    }

    public static int indexOf(final Object[] array, final Object objectToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (objectToFind == null) {
            for (int i = startIndex; i < array.length; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = startIndex; i < array.length; i++) {
                if (objectToFind.equals(array[i])) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final Object[] array, final Object objectToFind) {
        return lastIndexOf(array, objectToFind, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(final Object[] array, final Object objectToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        if (objectToFind == null) {
            for (int i = startIndex; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = startIndex; i >= 0; i--) {
                if (objectToFind.equals(array[i])) {
                    return i;
                }
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(final Object[] array, final Object objectToFind) {
        return indexOf(array, objectToFind) != INDEX_NOT_FOUND;
    }

    ///////////////////////////////////////////////////////////////////////////
    // long indexOf
    ///////////////////////////////////////////////////////////////////////////

    public static int indexOf(final long[] array, final long valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(final long[] array, final long valueToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final long[] array, final long valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(final long[] array, final long valueToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(final long[] array, final long valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    ///////////////////////////////////////////////////////////////////////////
    // int indexOf
    ///////////////////////////////////////////////////////////////////////////

    public static int indexOf(final int[] array, final int valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(final int[] array, final int valueToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final int[] array, final int valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(final int[] array, final int valueToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(final int[] array, final int valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    ///////////////////////////////////////////////////////////////////////////
    // short indexOf
    ///////////////////////////////////////////////////////////////////////////

    public static int indexOf(final short[] array, final short valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(final short[] array, final short valueToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final short[] array, final short valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(final short[] array, final short valueToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(final short[] array, final short valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    ///////////////////////////////////////////////////////////////////////////
    // char indexOf
    ///////////////////////////////////////////////////////////////////////////

    public static int indexOf(final char[] array, final char valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(final char[] array, final char valueToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final char[] array, final char valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(final char[] array, final char valueToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(final char[] array, final char valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    ///////////////////////////////////////////////////////////////////////////
    // byte indexOf
    ///////////////////////////////////////////////////////////////////////////

    public static int indexOf(final byte[] array, final byte valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(final byte[] array, final byte valueToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final byte[] array, final byte valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(final byte[] array, final byte valueToFind, final int startIndex) {
        if (array == null) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(final byte[] array, final byte valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    ///////////////////////////////////////////////////////////////////////////
    // double indexOf
    ///////////////////////////////////////////////////////////////////////////

    public static int indexOf(final double[] array, final double valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(final double[] array, final double valueToFind, final double tolerance) {
        return indexOf(array, valueToFind, 0, tolerance);
    }

    public static int indexOf(final double[] array, final double valueToFind, final int startIndex) {
        if (ArrayUtils.isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int indexOf(final double[] array, final double valueToFind, final int startIndex, final double tolerance) {
        if (ArrayUtils.isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        double min = valueToFind - tolerance;
        double max = valueToFind + tolerance;
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] >= min && array[i] <= max) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final double[] array, final double valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(final double[] array, final double valueToFind, final double tolerance) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE, tolerance);
    }

    public static int lastIndexOf(final double[] array, final double valueToFind, final int startIndex) {
        if (ArrayUtils.isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final double[] array, final double valueToFind, final int startIndex, final double tolerance) {
        if (ArrayUtils.isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        double min = valueToFind - tolerance;
        double max = valueToFind + tolerance;
        for (int i = startIndex; i >= 0; i--) {
            if (array[i] >= min && array[i] <= max) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(final double[] array, final double valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    public static boolean contains(final double[] array, final double valueToFind, final double tolerance) {
        return indexOf(array, valueToFind, 0, tolerance) != INDEX_NOT_FOUND;
    }

    ///////////////////////////////////////////////////////////////////////////
    // float indexOf
    ///////////////////////////////////////////////////////////////////////////

    public static int indexOf(final float[] array, final float valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(final float[] array, final float valueToFind, final int startIndex) {
        if (ArrayUtils.isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final float[] array, final float valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(final float[] array, final float valueToFind, final int startIndex) {
        if (ArrayUtils.isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(final float[] array, final float valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    ///////////////////////////////////////////////////////////////////////////
    // bool indexOf
    ///////////////////////////////////////////////////////////////////////////

    public static int indexOf(final boolean[] array, final boolean valueToFind) {
        return indexOf(array, valueToFind, 0);
    }

    public static int indexOf(final boolean[] array, final boolean valueToFind, final int startIndex) {
        if (ArrayUtils.isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        for (int i = startIndex; i < array.length; i++) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static int lastIndexOf(final boolean[] array, final boolean valueToFind) {
        return lastIndexOf(array, valueToFind, Integer.MAX_VALUE);
    }

    public static int lastIndexOf(final boolean[] array, final boolean valueToFind, final int startIndex) {
        if (ArrayUtils.isEmpty(array)) {
            return INDEX_NOT_FOUND;
        }
        if (startIndex < 0) {
            return INDEX_NOT_FOUND;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        for (int i = startIndex; i >= 0; i--) {
            if (valueToFind == array[i]) {
                return i;
            }
        }
        return INDEX_NOT_FOUND;
    }

    public static boolean contains(final boolean[] array, final boolean valueToFind) {
        return indexOf(array, valueToFind) != INDEX_NOT_FOUND;
    }

    ///////////////////////////////////////////////////////////////////////////
    // char converters
    ///////////////////////////////////////////////////////////////////////////

    public static char[] toPrimitive(final Character[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new char[0];
        }
        final char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].charValue();
        }
        return result;
    }

    public static char[] toPrimitive(final Character[] array, final char valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new char[0];
        }
        final char[] result = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            Character b = array[i];
            result[i] = (b == null ? valueForNull : b.charValue());
        }
        return result;
    }

    public static Character[] toObject(final char[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new Character[0];
        }
        final Character[] result = new Character[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = new Character(array[i]);
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // long converters
    ///////////////////////////////////////////////////////////////////////////

    public static long[] toPrimitive(final Long[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new long[0];
        }
        final long[] result = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].longValue();
        }
        return result;
    }

    public static long[] toPrimitive(final Long[] array, final long valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new long[0];
        }
        final long[] result = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            Long b = array[i];
            result[i] = (b == null ? valueForNull : b.longValue());
        }
        return result;
    }

    public static Long[] toObject(final long[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new Long[0];
        }
        final Long[] result = new Long[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = new Long(array[i]);
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // int converters
    ///////////////////////////////////////////////////////////////////////////

    public static int[] toPrimitive(final Integer[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new int[0];
        }
        final int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].intValue();
        }
        return result;
    }

    public static int[] toPrimitive(final Integer[] array, final int valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new int[0];
        }
        final int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            Integer b = array[i];
            result[i] = (b == null ? valueForNull : b.intValue());
        }
        return result;
    }

    public static Integer[] toObject(final int[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new Integer[0];
        }
        final Integer[] result = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = new Integer(array[i]);
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // short converters
    ///////////////////////////////////////////////////////////////////////////

    public static short[] toPrimitive(final Short[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new short[0];
        }
        final short[] result = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].shortValue();
        }
        return result;
    }

    public static short[] toPrimitive(final Short[] array, final short valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new short[0];
        }
        final short[] result = new short[array.length];
        for (int i = 0; i < array.length; i++) {
            Short b = array[i];
            result[i] = (b == null ? valueForNull : b.shortValue());
        }
        return result;
    }

    public static Short[] toObject(final short[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new Short[0];
        }
        final Short[] result = new Short[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = new Short(array[i]);
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // byte converters
    ///////////////////////////////////////////////////////////////////////////

    public static byte[] toPrimitive(final Byte[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new byte[0];
        }
        final byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].byteValue();
        }
        return result;
    }

    public static byte[] toPrimitive(final Byte[] array, final byte valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new byte[0];
        }
        final byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            Byte b = array[i];
            result[i] = (b == null ? valueForNull : b.byteValue());
        }
        return result;
    }

    public static Byte[] toObject(final byte[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new Byte[0];
        }
        final Byte[] result = new Byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = new Byte(array[i]);
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // double converters
    ///////////////////////////////////////////////////////////////////////////

    public static double[] toPrimitive(final Double[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new double[0];
        }
        final double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].doubleValue();
        }
        return result;
    }

    public static double[] toPrimitive(final Double[] array, final double valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new double[0];
        }
        final double[] result = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            Double b = array[i];
            result[i] = (b == null ? valueForNull : b.doubleValue());
        }
        return result;
    }

    public static Double[] toObject(final double[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new Double[0];
        }
        final Double[] result = new Double[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = new Double(array[i]);
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // float converters
    ///////////////////////////////////////////////////////////////////////////

    public static float[] toPrimitive(final Float[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new float[0];
        }
        final float[] result = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].floatValue();
        }
        return result;
    }

    public static float[] toPrimitive(final Float[] array, final float valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new float[0];
        }
        final float[] result = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            Float b = array[i];
            result[i] = (b == null ? valueForNull : b.floatValue());
        }
        return result;
    }

    public static Float[] toObject(final float[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new Float[0];
        }
        final Float[] result = new Float[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = new Float(array[i]);
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////
    // boolean converters
    ///////////////////////////////////////////////////////////////////////////

    public static boolean[] toPrimitive(final Boolean[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new boolean[0];
        }
        final boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].booleanValue();
        }
        return result;
    }

    public static boolean[] toPrimitive(final Boolean[] array, final boolean valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new boolean[0];
        }
        final boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            Boolean b = array[i];
            result[i] = (b == null ? valueForNull : b.booleanValue());
        }
        return result;
    }

    public static Boolean[] toObject(final boolean[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return new Boolean[0];
        }
        final Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = (array[i] ? Boolean.TRUE : Boolean.FALSE);
        }
        return result;
    }

    public static <T> List<T> asList(final T... array) {
        if (array == null || array.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(array);
    }

    public static <T> List<T> asUnmodifiableList(final T... array) {
        return Collections.unmodifiableList(asList(array));
    }

    public static <T> List<T> asArrayList(final T... array) {
        List<T> list = new ArrayList<>();
        if (array == null || array.length == 0) return list;
        list.addAll(Arrays.asList(array));
        return list;
    }

    public static <T> List<T> asLinkedList(final T... array) {
        List<T> list = new LinkedList<>();
        if (array == null || array.length == 0) return list;
        list.addAll(Arrays.asList(array));
        return list;
    }

    public static <T> void sort(final T[] array, final Comparator<? super T> c) {
        if (array == null || array.length < 2) return;
        Arrays.sort(array, c);
    }

    public static void sort(final byte[] array) {
        if (array == null || array.length < 2) return;
        Arrays.sort(array);
    }

    public static void sort(final char[] array) {
        if (array == null || array.length < 2) return;
        Arrays.sort(array);
    }

    public static void sort(final double[] array) {
        if (array == null || array.length < 2) return;
        Arrays.sort(array);
    }

    public static void sort(final float[] array) {
        if (array == null || array.length < 2) return;
        Arrays.sort(array);
    }

    public static void sort(final int[] array) {
        if (array == null || array.length < 2) return;
        Arrays.sort(array);
    }

    public static void sort(final long[] array) {
        if (array == null || array.length < 2) return;
        Arrays.sort(array);
    }

    public static void sort(final short[] array) {
        if (array == null || array.length < 2) return;
        Arrays.sort(array);
    }

    /**
     * Executes the given closure on each element in the array.
     * <p>
     * If the input array or closure is null, there is no change made.
     *
     * @param array   The array.
     * @param closure the closure to perform, may be null
     */
    public static <E> void forAllDo(final Object array, final Closure<E> closure) {
        if (array == null || closure == null) return;
        if (array instanceof Object[]) {
            Object[] objects = (Object[]) array;
            for (int i = 0, length = objects.length; i < length; i++) {
                Object ele = objects[i];
                closure.execute(i, (E) ele);
            }
        } else if (array instanceof boolean[]) {
            boolean[] booleans = (boolean[]) array;
            for (int i = 0, length = booleans.length; i < length; i++) {
                boolean ele = booleans[i];
                closure.execute(i, (E) (ele ? Boolean.TRUE : Boolean.FALSE));
            }
        } else if (array instanceof byte[]) {
            byte[] bytes = (byte[]) array;
            for (int i = 0, length = bytes.length; i < length; i++) {
                byte ele = bytes[i];
                closure.execute(i, (E) Byte.valueOf(ele));
            }
        } else if (array instanceof char[]) {
            char[] chars = (char[]) array;
            for (int i = 0, length = chars.length; i < length; i++) {
                char ele = chars[i];
                closure.execute(i, (E) Character.valueOf(ele));
            }
        } else if (array instanceof short[]) {
            short[] shorts = (short[]) array;
            for (int i = 0, length = shorts.length; i < length; i++) {
                short ele = shorts[i];
                closure.execute(i, (E) Short.valueOf(ele));
            }
        } else if (array instanceof int[]) {
            int[] ints = (int[]) array;
            for (int i = 0, length = ints.length; i < length; i++) {
                int ele = ints[i];
                closure.execute(i, (E) Integer.valueOf(ele));
            }
        } else if (array instanceof long[]) {
            long[] longs = (long[]) array;
            for (int i = 0, length = longs.length; i < length; i++) {
                long ele = longs[i];
                closure.execute(i, (E) Long.valueOf(ele));
            }
        } else if (array instanceof float[]) {
            float[] floats = (float[]) array;
            for (int i = 0, length = floats.length; i < length; i++) {
                float ele = floats[i];
                closure.execute(i, (E) Float.valueOf(ele));
            }
        } else if (array instanceof double[]) {
            double[] doubles = (double[]) array;
            for (int i = 0, length = doubles.length; i < length; i++) {
                double ele = doubles[i];
                closure.execute(i, (E) Double.valueOf(ele));
            }
        } else {
            throw new IllegalArgumentException("Not an array: " + array.getClass());
        }
    }

    /**
     * Return the string of array.
     *
     * @param array The array.
     * @return the string of array
     */
    public static String toString(final Object array) {
        if (array == null) return "null";
        if (array instanceof Object[]) {
            return Arrays.deepToString((Object[]) array);
        } else if (array instanceof boolean[]) {
            return Arrays.toString((boolean[]) array);
        } else if (array instanceof byte[]) {
            return Arrays.toString((byte[]) array);
        } else if (array instanceof char[]) {
            return Arrays.toString((char[]) array);
        } else if (array instanceof double[]) {
            return Arrays.toString((double[]) array);
        } else if (array instanceof float[]) {
            return Arrays.toString((float[]) array);
        } else if (array instanceof int[]) {
            return Arrays.toString((int[]) array);
        } else if (array instanceof long[]) {
            return Arrays.toString((long[]) array);
        } else if (array instanceof short[]) {
            return Arrays.toString((short[]) array);
        }
        throw new IllegalArgumentException("Array has incompatible type: " + array.getClass());
    }

    public interface Closure<E> {
        void execute(int index, E item);
    }
}
