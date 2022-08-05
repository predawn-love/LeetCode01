package myleetcode.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class FindKNearestPoints {
    /**
     * LeetCode 原题只有到原点的距离,Q973
     */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) ->
                -a[0] * a[0] - a[1] * a[1] + b[0] * b[0] + b[1] * b[1]);
        for (int[] ints : points) {
            priorityQueue.offer(ints);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        int[][] res = new int[k][2];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }
}
class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}



class Solution{
    public Point[] Solution1(Point[] array, Point origin, int k){
        Point[] res = new Point[k];
        int index = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point>(k,new Comparator<Point>(){
            public int compare(Point a,Point b){
                return (int) (getDistance(b,origin)- getDistance(a,origin));
            }
        });
        for(int i =0; i<array.length;i++){
            pq.offer(array[i]);
            if(pq.size()>k){
                pq.poll();
            }
        }
        while(!pq.isEmpty()){
            res[index++] = pq.poll();
        }
        return res;
    }
    public double getDistance(Point a, Point b){

        return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
    }




    public static void main(String args[]) {
        Solution test = new Solution();
        List<Point> list = new ArrayList<Point>();
        Point[] p = new Point[5];

        Point p2 = new Point(2, 2);
        Point p4 = new Point(4, 4);
        Point p3 = new Point(6, 6);
        Point p1 = new Point(6, 6);
        Point p5 = new Point(5, 5);

        p[0] = p1;
        p[1] = p2;
        p[2] = p3;
        p[3] = p4;
        p[4] = p5;
        Point origin = new Point(0, 0);

        int k = 3;
        Point[] kPoints =  test.Solution1(p,origin,2);

        for(int i = 0; i < kPoints.length; i++) {
            System.out.print("(" + kPoints[i].getX() + ", " + kPoints[i].getY() + ")");
            if(i < kPoints.length- 1)
                System.out.print(", ");
        }
    }
}
