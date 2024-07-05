package org.samvelaivazian.sort.insertion.model;

/**
 * Represents an immutable key-value pair where the key is an integer and the value is a string.
 * This record is used for storing two related data elements where one acts as a key
 * and the other as its associated value. Records in Java provide a concise syntax
 * for defining immutable data aggregates and automatically implement {@code equals()},
 * {@code hashCode()}, and {@code toString()} methods based on all of its components.
 *
 * @param key   the key associated with this pair, which is an integer
 * @param value the value associated with this key, which is a string
 *
 * <p>Time Complexity:</p>
 * <ul>
 *     <li>Constructor and accessor methods (key, value): O(1)</li>
 *     <li>{@code toString()} method: O(1) for typical usage, potentially O(n) if the string
 *     value is very large where n is the length of the string.</li>
 * </ul>
 *
 * <p>Space Complexity:</p>
 * <ul>
 *     <li>The space complexity of an instance of Pair is O(n), where n is the space
 *     required to store the integer key and the string value. The integer typically requires
 *     a fixed amount of space (e.g., 32 or 64 bits), whereas the space for the string is
 *     proportional to its length.</li>
 * </ul>
 */
public record Pair(int key, String value) {
}
