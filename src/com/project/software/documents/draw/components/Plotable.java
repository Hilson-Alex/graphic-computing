package com.project.software.documents.draw.components;

import com.project.software.documents.draw.Point;

import java.util.List;

/**
 * A interface to plot an element in the
 * {@link com.project.software.documents.draw.ViewMatrix}.
 */
public interface Plotable {

    List<Point> getPoints ();

}
