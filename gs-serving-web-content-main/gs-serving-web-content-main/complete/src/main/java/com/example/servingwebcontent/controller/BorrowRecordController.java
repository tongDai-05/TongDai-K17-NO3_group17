package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.BorrowRecordAiven;
import com.example.servingwebcontent.model.BorrowRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/borrowrecords")
public class BorrowRecordController {

    private final BorrowRecordAiven borrowRecordAiven;

    @Autowired
    public BorrowRecordController(BorrowRecordAiven borrowRecordAiven) {
        this.borrowRecordAiven = borrowRecordAiven;
    }

    // ✅ Danh sách phiếu mượn
    @GetMapping
    public String listRecords(Model model) {
        List<BorrowRecord> records = borrowRecordAiven.getAllRecords();
        model.addAttribute("borrowrecords", records);
        return "borrowrecords/list"; // templates/borrowrecords/list.html
    }

    // ✅ Hiển thị form thêm mới
    @GetMapping("/add")
    public String showAddForm(Model model) {
        BorrowRecord record = new BorrowRecord();
        record.setBorrowDate(LocalDate.now());
        record.setDueDate(LocalDate.now().plusDays(14)); // ví dụ mặc định 2 tuần
        model.addAttribute("borrowrecord", record);
        return "borrowrecords/add"; // templates/borrowrecords/add.html
    }

    // ✅ Xử lý thêm phiếu mượn
    @PostMapping("/add")
    public String addRecord(@ModelAttribute("borrowrecord") BorrowRecord record) {
        record.setRecordId(UUID.randomUUID().toString());
        borrowRecordAiven.insert(record);
        return "redirect:/borrowrecords";
    }

    // ✅ Hiển thị form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        BorrowRecord record = borrowRecordAiven.findById(id);
        if (record == null) {
            return "redirect:/borrowrecords";
        }
        model.addAttribute("borrowrecord", record);
        return "borrowrecords/edit"; // templates/borrowrecords/edit.html
    }

    // ✅ Xử lý cập nhật phiếu mượn
    @PostMapping("/edit/{id}")
    public String updateRecord(@PathVariable("id") String id,
                               @ModelAttribute("borrowrecord") BorrowRecord record) {
        record.setRecordId(id); // đảm bảo đúng ID
        borrowRecordAiven.update(record);
        return "redirect:/borrowrecords";
    }

    // ✅ Xoá phiếu mượn
    @GetMapping("/delete/{id}")
    public String deleteRecord(@PathVariable("id") String id) {
        borrowRecordAiven.delete(id);
        return "redirect:/borrowrecords";
    }
}
