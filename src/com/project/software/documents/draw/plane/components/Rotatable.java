package com.project.software.documents.draw.plane.components;

import com.project.software.documents.draw.plane.Plotable;

/**
 * Rotates a Line or shape. By default, it'll
 * be used the center of the shape as an reference
 * to rotate it.
 */
public interface Rotatable extends Plotable {

    /**
     * Rotate an component in degrees.
     * @param degrees The degrees of the angle.
     * @return the rotated component
     */
    Plotable rotate (double degrees);
    

}
