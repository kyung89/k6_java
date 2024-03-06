package practice;

// p.27
// 두 개의 직선 좌표가 주어 졌을 때 두 직선의 교차점을 구해서 출력 하세요
class IntersectOfLines {
	public double x1, y1, x2, y2, x3, y3, x4, y4;
	
	public IntersectOfLines(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
		this.x1 = x1;
		this.y1 = y1;
		
		this.x2 = x2;
		this.y2 = y2;
		
		this.x3 = x3;
		this.y3 = y3;
		
		this.x4 = x4;
		this.y4 = y4;
	}
	
	public double[] getIntersect() {
		double[] line1 = {y1 - y2, x2 - x1, x1 * y2 - x2 * y1};
        double[] line2 = {y3 - y4, x4 - x3, x3 * y4 - x4 * y3};

        double det = line1[0] * line2[1] - line2[0] * line1[1];
        if (det == 0) {
            // 두 직선이 평행한 경우
            return null;
        } else {
            double x = (line2[1] * line1[2] - line1[1] * line2[2]) / det;
            double y = (line1[0] * line2[2] - line2[0] * line1[2]) / det;
            return new double[]{x, y};
        }	
	}
	
	public void printIntersect() {
		double[] intersect = getIntersect();
		System.out.println("x = " + intersect[0] +", y = "+ intersect[1]);
	}
	
}

public class Practice_2024_03_04_01 {

//	// 챗GPT 코드
//	static class Point {
//        double x, y;
//
//        public Point(double x, double y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//    // 두 점을 이용하여 직선의 방정식을 계산하는 함수
//    static double[] lineEquation(Point p1, Point p2) {
//        double a = p1.y - p2.y;
//        double b = p2.x - p1.x;
//        double c = p1.x * p2.y - p2.x * p1.y;
//        return new double[]{a, b, c};
//    }
//
//    // 두 직선이 교차하는 점을 찾는 함수
//    static Point findIntersection(Point p1, Point p2, Point p3, Point p4) {
//        double[] line1 = lineEquation(p1, p2);
//        double[] line2 = lineEquation(p3, p4);
//
//        double det = line1[0] * line2[1] - line2[0] * line1[1];
//        if (det == 0) {
//            // 두 직선이 평행한 경우
//            return null;
//        } else {
//            double x = (line2[1] * line1[2] - line1[1] * line2[2]) / det;
//            double y = (line1[0] * line2[2] - line2[0] * line1[2]) / det;
//            return new Point(x, y);
//        }
//    }

    public static void main(String[] args) {
//        Point p1 = new Point(1, 1);
//        Point p2 = new Point(4, 4);
//        Point p3 = new Point(1, 3);
//        Point p4 = new Point(4, 1);
        
        double x1 = 1, y1 = 1;
        double x2 = 4, y2 = 4;
        double x3 = 1, y3 = 3;
        double x4 = 4, y4 = 1;
        
        IntersectOfLines intersect = new IntersectOfLines(x1, y1, x2, y2, x3, y3, x4, y4);

        double[] intersection = intersect.getIntersect();
        if (intersection != null) {
            System.out.println("두 직선이 교차하는 점: (" + intersection[0] + ", " + intersection[1] + ")");
        } else {
            System.out.println("두 직선은 교차하지 않습니다.");
        }
    }
}