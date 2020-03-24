package com.project.software.documents.draw.plain;

import java.util.Collection;

/**
 * A interface to plot an element in the
 * {@link ViewMatrix}.
 */
public interface Plotable {

    /**
     * Get th points that compose this component.
     * @return all points of the component.
     */
    Collection<Point> getPoints ();

    /**
     * change the position of this component.
     * The use of this method may be different to
     * {@link Point}, which have final attributes.
     * @param xAmount the amount added to X coordinates
     *                (negative numbers are accepted).
     * @param yAmount the amount added to Y coordinates
     *                (negative numbers are accepted).
     * @return the modified component.
     */
    Plotable translate (int xAmount, int yAmount);

    /**
     * change the X position of this component.
     * The use of this method may be different to
     * {@link Point}, which have final attributes.
     * @param amount the amount added to X coordinates
     *                (negative numbers are accepted).
     * @return the modified component.
     */
    default Plotable translateX (int amount){
        return translate(amount, 0);
    }

    /**
     * change the Y position of this component.
     * The use of this method may be different to
     * {@link Point}, which have final attributes.
     * @param amount the amount added to Y coordinates
     *                (negative numbers are accepted).
     * @return the modified component.
     */
    default Plotable translateY (int amount){
        return translate(0, amount);
    }

}
