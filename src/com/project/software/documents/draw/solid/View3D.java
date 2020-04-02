package com.project.software.documents.draw.solid;

@Deprecated
public class View3D {

    private final Integer[][] screen;

    private final int xSize;
    private final int ySize;
    private final int zSize;

    public View3D(int xSize, int ySize, int zSize) {
        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
        screen = new  Integer[ySize + zSize][xSize + zSize];
        clear();
    }
    
    public void clear(){
        int i = ySize + zSize - 1;
        int j;
        for (; i >= zSize; i--){
            j = 0;
            for (; j < zSize - (ySize+zSize - (i+1)); j++){
                screen[i][j] = 100;
            }
            for (;j < xSize + zSize; j++){
                screen[i][j] = 0;
            }
        }
        for (; i >= 0; i--){
            j = 0;
            for (; j < xSize+(zSize - (zSize - i)); j++){
                screen[i][j] = 0;
            }
            for (; j < xSize+zSize; j++){
                screen[i][j] = 100;
            }
        }
        for (i = 0; i < zSize; i++){
            screen[i][i] = 2;
            screen[i + ySize][i] = 2;
            screen[i][i + xSize] = 2;
        }
        for (; i < ySize + zSize; i++){
            screen[i][zSize] = 3;
            screen[i -zSize][0] = 3;
            screen[i][zSize + xSize - 1] = 3;
        }
        for (j = zSize; j < xSize + zSize; j++){
            screen[zSize][j] = 4;
            screen[0][j - zSize] = 4;
            screen[zSize + ySize - 1][j] = 4;
        }
    }

    public void plot(Point3D point){
        if(isBetweenEdges(point)) {
            screen[point.Y + point.Z][point.X + point.Z] = 1;
        }
    }

    private boolean isBetweenEdges(Point3D point) {
        return  point.X >= 0 & point.X < xSize &
                point.Y >= 0 & point.Y < ySize &
                point.Z >= 0 & point.Z < zSize;
    }

    public void print(){
        for (int i = ySize+zSize-1; i >= 0; i --){
            for (int j = 0; j < xSize + zSize; j++){
                switch (screen[i][j]){
                    case 0 :
                        System.out.print(". ");
                        break;
                    case 1 :
                        System.out.print("@ ");
                        break;
                    case 2 :
                        System.out.print("/ ");
                        break;
                    case 3 :
                        System.out.print("| ");
                        break;
                    case 4:
                        System.out.print("--");
                        break;
                    default:
                        System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    
}
