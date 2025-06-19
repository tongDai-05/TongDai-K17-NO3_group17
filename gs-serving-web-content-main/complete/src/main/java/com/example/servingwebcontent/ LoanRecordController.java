package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoanRecordController{
    @GetMapping("/loanRecord")
     public String loanrecord(Model model) {
        // Lấy danh sách phiếu mượn từ database hoặc service
        LoanRecordData data = new LoanRecordData();
        ArrayList<LoanRecord> records = data.getLoanRecords();

        // Đưa vào Model để truyền cho View
        model.addAttribute("loanRecords", records);

        // Trả về view loanrecord.html
        return "LoanRecord";
     }
    }