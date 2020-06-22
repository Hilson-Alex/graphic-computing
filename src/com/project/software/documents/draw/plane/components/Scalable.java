package com.project.software.documents.draw.plane.components;

import com.project.software.documents.draw.plane.Plotable;

public interface Scalable extends Plotable {

    Plotable resize (double xScale, double yScale);

    default Plotable resize (double scale) {
        return resize(scale, scale);
    }

    default Plotable resizeX (double scale) {
        return resize (scale, 1);
    }

   default Plotable resizeY (double scale) {
        return resize(1, scale);
   }




}
