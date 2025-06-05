// TestSequence.java
// Dựa trên Slide 22: TestSequence

public class TestSequence {
    public static void main(String[] args) {
        // Tạo một Sequence chứa 10 phần tử
        Sequence sequence = new Sequence(10);

        // Thêm các phần tử vào Sequence
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i)); // Thêm các chuỗi số từ "0" đến "9"
        }

        // Lấy một đối tượng Selector từ Sequence
        // Lưu ý: Chúng ta làm việc với interface Selector, không phải inner class SSelector
        Selector selector = sequence.selector();

        // Duyệt qua các phần tử sử dụng Selector
        while (!selector.end()) {
            System.out.println(selector.current()); // In ra phần tử hiện tại
            selector.next(); // Di chuyển đến phần tử tiếp theo
        }
    }
}