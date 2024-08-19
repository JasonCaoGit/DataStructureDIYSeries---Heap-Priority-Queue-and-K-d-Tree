package bearmaps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NaivePointSet implements PointSet {

    private List<Point> points;


    public static void main(String[] args) {

        ArrayList<Point> points = new ArrayList<Point>();
        points.add(new Point(0, 0));
        points.add(new Point(-2, 1));
        points.add(new Point(5, 6));
        points.add(new Point(4, 2));
        points.add(new Point(8, 3));
        Random rand = new Random();
        for (int i = 0; i < 10000000; i++) {
            points.add(new Point(rand.nextInt(1000), rand.nextInt(1000)));

        }
       NaivePointSet pointSet = new NaivePointSet(points);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 600; i++) {
            pointSet.nearest(rand.nextInt(1000), rand.nextInt(1000));
        }

        long end = System.currentTimeMillis();
        System.out.println("Total time used " + (end - start)/1000.0 + " seconds");
    }

    public NaivePointSet(List<Point> points) {
        this.points = points;
    }






    public Point nearest(double x, double y) {
        Point goal = new Point(x, y);
        Point best = points.get(0);
        for (Point p : points) {
            if(Point.distance(p,goal) < Point.distance(best,goal)) {
                best = p;
            }
        }
        return best;
    }


}
