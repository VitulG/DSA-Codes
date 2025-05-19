public class TypeOfTriangle {

    public static String triangleType(int[] nums) {
        int a = nums[0], b = nums[1], c = nums[2];
        if (a + b <= c || a + c <= b || b + c <= a) return "none";
        if (a == b && b == c) return "equilateral";
        if (a == b || b == c || a == c) return "isosceles";
        return "scalene";
    }

    public static void main(String[] args) {
        System.out.println(triangleType(new int[]{8,4,2}));
    }
}
