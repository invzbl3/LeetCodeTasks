package com.task.algorithm.Hard.solved;

import java.util.*;

/**
 * 149. Max Points on a Line
 * https://leetcode.com/problems/max-points-on-a-line/
 *
 * Given an array of points where points[i] = [x(i), y(i)] represents a point on the X-Y plane,
 * return the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 *
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 *
 * Example 2:
 *
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 *
 * Constraints:
 *
 * * 1 <= points.length <= 300
 * * points[i].length == 2
 * * -10^4 <= x(i), y(i) <= 10^4
 * * All the points are unique.
 */
class MaxPointsOnALien {

    private static class Line {
        // Slope and Intersection
        double a;
        double b;
        boolean isVertical;
        // When vertical, call a to indicate the intersection with the x-axis
        public Line(double a, double b) {
            this.a = a;
            this.b = b;
            this.isVertical = true;
        }

        public Line(int x1, int y1, int x2, int y2) {
            this.a = calculateA(x1, y1, x2, y2);
            this.b = calculateB(x1, y1);
            this.isVertical = false;
        }

        private double calculateA(int x1, int y1, int x2, int y2) {
            return (double)(y1 - y2) / (x1 - x2);
        }

        private double calculateB(int x, int y) {
            return y - this.a * x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Line line = (Line) o;
            return Double.compare(line.a, a) == 0 && Double.compare(line.b, b) == 0 && isVertical == line.isVertical;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b, isVertical);
        }
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    // Given a set of two-dimensional coordinates,
    // ask how many points are on the same line at most
    public int maxPoints(int[][] points) {
        if (points.length <= 1) return points.length;
        Map<Line, Set<Point>> map = new HashMap<>();
        int res = 0;
        // Two-by-two calculation of straight lines
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Line l = null;
                // Vertical special treatment Vertical will report an error
                if (points[i][0] == points[j][0]) {
                    // vertical
                    l = new Line(points[i][0], 0);
                } else {
                    l = new Line(points[i][0], points[i][1], points[j][0], points[j][1]);
                }
                if (!map.containsKey(l)) {
                    map.put(l, new HashSet<>());
                }
                Set<Point> set = map.get(l);
                set.add(new Point(points[i][0], points[i][1]));
                set.add(new Point(points[j][0], points[j][1]));
                res = Math.max(res, set.size());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxPointsOnALien().maxPoints(new int[][]{{3,3},{1,4},{1,1},{2,1},{2,2}}));
    }
}