public void chuyenSach(String maSach, String viTriMoi) {
    for (Book b : bookList) {
        if (b.masach.equals(maSach)) {
            String viTriCu = b.vitri;
            b.vitri = viTriMoi;
            System.out.println("→ Đã chuyển sách mã: " + maSach);
            System.out.println("  Từ vị trí: " + viTriCu + " → " + viTriMoi);
            return;
        }
    }
    System.out.println("⚠ Không tìm thấy sách có mã: " + maSach);
}