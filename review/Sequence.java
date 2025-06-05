// Sequence.java
// Dựa trên Slide 29 và Slide 21: Sequence với Inner class SSelector triển khai interface Selector

public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    // Inner class SSelector triển khai interface Selector
    private class SSelector implements Selector {
        private int i = 0;

        @Override // Annotation này không bắt buộc nhưng tốt cho việc kiểm tra
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            // Đảm bảo không truy cập ngoài giới hạn mảng
            if (i >= 0 && i < items.length) {
                return items[i];
            }
            return null; // Hoặc ném một Exception phù hợp
        }

        @Override
        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    // Phương thức selector() bây giờ trả về interface Selector
    public Selector selector() {
        return new SSelector();
    }

    // Phương thức main có thể được sử dụng để thử nghiệm nhanh trong cùng một file
    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }

        // Sử dụng interface Selector để duyệt qua Sequence
        Selector selector = sequence.selector(); // Lưu ý kiểu trả về là Selector interface
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        System.out.println();
    }
}