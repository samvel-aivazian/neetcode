package org.samvelaivazian.prototype.model;

/**
 * A rectangle shape with a specified width and height.
 */
public record Rectangle(int width, int height) implements Shape {

    /**
     * Creates a copy of this rectangle.
     *
     * @return a new {@code Rectangle} with the same width and height.
     * <p>
     * {@code @SuppressWarnings({"CloneDoesntCallSuperClone", "RedundantSuppression"})} is used to suppress warnings
     * about the clone method not calling super.clone() and to avoid redundant suppression warnings.
     * <p>
     * - {@code CloneDoesntCallSuperClone}: This warning indicates that the clone method should call super.clone().
     * However, for records, which are inherently immutable and final, calling super.clone() is not necessary.
     * The clone method implementation here is correct because it creates a new instance of the record with the
     * same values, which is enough for immutable types.
     * <p>
     * - {@code RedundantSuppression}: This warning indicates that a suppression annotation is redundant.
     * By combining this with {@code CloneDoesntCallSuperClone}, we explicitly acknowledge that the suppression
     * is intentional and necessary due to the specific implementation of cloning for records.
     * <p>
     * We use the {@code Shape} interface to override the {@code clone()} method, providing a consistent interface
     * for cloning shapes.
     */
    @Override
    @SuppressWarnings({"CloneDoesntCallSuperClone", "RedundantSuppression"})
    public Rectangle clone() {
        return new Rectangle(this.width, this.height);
    }

}
