package com.project.software.documents.draw.plain.components;

import com.project.software.documents.draw.plain.Plotable;

public interface Scalable extends Plotable {

    Plotable resize (float xScale, float yScale);

    default Plotable resize (float scale) {
        return resize(scale, scale);
    }

    default Plotable resizeX (float scale) {
        return resize (scale, 1);
    }

   default Plotable resizeY (float scale) {
        return resize(1, scale);
   }




}
