package com.project.software.documents.draw.plane.components.geometry;

import com.project.software.documents.draw.plane.Point;
import com.project.software.documents.draw.plane.components.Scalable;

/**
 * An interface for geometric shapes.
 */
public interface Geometric2D extends Scalable {

    /**
     * Get the center of mass of an regular geometric shape.
     * @return the geometric center of an geometric shape.
     */
    Point getCentroid();

}
