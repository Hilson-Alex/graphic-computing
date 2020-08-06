# graphic-computing

This is a ibrary for graphic Computing in Java, but using no windows nor graphics. All the visual part are made by console, the focus in this library is for the processing part, and not the visual.

## Installation

You may want to download the jar [here](/out/artifacts/draw_jar/draw.jar) to use it in your project.

## Usage

There are not too many components already done, but the enphasis in this project are the interfaces.
For Examples you can run the [Main](/src/com/project/software/documents/Main.java) class, wich run the Demo project.

---

### Plotable

**Every** component is a [Plotable](/src/com/project/software/documents/draw/plane/Plotable.java), even the Screen. This means that every component can be ploted anywhere in a [ViewMatrix](/src/com/project/software/documents/draw/plane/ViewMatrix.java), even the ViewMatrix itself can be ploted in another ViewMatrix.

**Every** Plotable can be translated by X axis, Y axis or both.

**Every** Plotable must implement the *.getPoints()* method. This is the method that give to the screen the coordinates of every point to be plotted.

As the [Line](/src/com/project/software/documents/draw/plane/components/Line.java) is already implemented with the [Bresenham's line algorithm](https://en.wikipedia.org/wiki/Bresenham%27s_line_algorithm), every new component can use the line to get its points (see [Triangle](/src/com/project/software/documents/draw/plane/components/geometry/Triangle.java)).

Circle, elipsis and curves are not implemented yet.

---

### ViewMatrix

The [ViewMatrix](/src/com/project/software/documents/draw/plane/ViewMatrix.java) works as the screen of this project.

The coordinate in the bottom left corner is defined by the index attribute wich default value is \[0, 0]. The index is used to define the points that will be ploted and where the screen will be ploted in other screen. It's value can be modified by the *.translate(x, y)* method. 

Example: 
```java
ViewMatrix screen = New ViewMatrix(90, 90); // Start the screen with 90 weight and height
screen.plot(new Point(0, 0));               // Plot a point on [0, 0] coordinate. the index of the screen
screen.clean();
screen.translateX(3)                        // Now the index is the coordinate [3, 0]. Minimum x now is 3 
screen.plot(new Point(0, 0));               // The point will not be ploted, because it is out of the edges
```

---

### Scalable

The [Scalable](/src/com/project/software/documents/draw/plane/components/Scalable.java) interface says who can have its scales changed

### Rotatable

The [Rotatable](/src/com/project/software/documents/draw/plane/components/Rotatable.java) interface define which components can be Rotated

### Geometric2D

The [Geometric2D](/src/com/project/software/documents/draw/plane/components/geometry/Geometric2D.java) defines the plane geometric components.
Until now, only the method .getCentroid() is implemented.

---

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

## License

This project follows the [MIT](https://choosealicense.com/licenses/mit/) license
