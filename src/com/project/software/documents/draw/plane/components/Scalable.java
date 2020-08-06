package com.project.software.documents.draw.plane.components;

import com.project.software.documents.draw.plane.Plotable;

public interface Scalable extends Plotable {

    /**
     * Resize the component.
     * @param xScale the scale of the width.
     * @param yScale the scale of the height.
     * @return the modified Scalable.
     */
    Scalable resize (double xScale, double yScale);

    /**
     * Resize the component.
     * @param scale the scale to resize.
     * @return the modified Scalable.
     */
    default Scalable resize (double scale) {
        return resize(scale, scale);
    }

    /**
     * Resize the width of the element.
     * @param scale the scale to resize.
     * @return a changed Scalable.
     */
    default Scalable resizeX (double scale) {
        return resize (scale, 1);
    }

    /**
     * Resize the height of the element.
     * @param scale the scale to resize.
     * @return a changed Scalable.
     */
   default Scalable resizeY (double scale) {
        return resize(1, scale);
   }




}
