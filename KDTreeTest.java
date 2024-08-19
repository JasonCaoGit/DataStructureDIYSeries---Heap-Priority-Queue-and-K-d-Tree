package bearmaps;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.*;
public class KDTreeTest {

    @Test
    public void nearest() {
        ArrayList<Point> points = new ArrayList<Point>();
           Random rand = new Random();
        for (int i = 0; i < 10000; i++) {
            points.add(new Point(rand.nextInt(1000), rand.nextInt(1000)));

        }
       NaivePointSet pointSet = new NaivePointSet(points);
        KDTree tree = new KDTree(points);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 300; i++) {
            int x = rand.nextInt();
            int y = rand.nextInt();

            assertEquals(pointSet.nearest(x, y), tree.nearest(x, y));

        }

        long end = System.currentTimeMillis();
        System.out.println("Total time used " + (end - start)/1000.0 + " seconds");

    }
}