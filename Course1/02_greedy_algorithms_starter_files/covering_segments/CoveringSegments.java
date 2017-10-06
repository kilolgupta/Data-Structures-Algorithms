import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {

        int[] points = new int[segments.length];
        //sort segments by end points
        for (int i = 0; i < segments.length-1; i++) {
            for(int j=0;j<segments.length-i-1; j++) {
                if(segments[j].end > segments[j+1].end) {
                    Segment tempSegment = new Segment(segments[j].start, segments[j].end);
                    segments[j] = segments[j+1];
                    segments[j+1] = tempSegment;
                }
            }
        }
        int counter = 0;
        points[counter] = segments[0].end;
        for(int i=1;i<segments.length;i++){
            if((points[counter]>segments[i].start && points[counter]<segments[i].end)||
                    points[counter]==segments[i].start || points[counter]==segments[i].end) {
                continue;
            }
            else {
                counter++;
                points[counter] = segments[i].end;
            }
        }
        int[] finalPoints = new int[counter+1];
        for(int k=0;k<finalPoints.length;k++) finalPoints[k] = points[k];
        return finalPoints;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}