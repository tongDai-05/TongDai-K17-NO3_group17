package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import com.example.servingwebcontent.database.InsertToAiven;
import com.example.servingwebcontent.database.AivenConnection;

@Controller
public class LoginController {

    @GetMapping("/Login")
    public String login(@RequestParam(name = "fname", required = false, defaultValue = "OOP Class !") String name,
                        @RequestParam String address,
                        Model model) {

        try {
            System.out.println(name);
            System.out.println(address);
            if (name.equals("")) {
                System.out.println("No name");

            } else {
                model.addAttribute("name", name);
                model.addAttribute("address", address);

                User u = new User();
                u.setUserName(name);
                u.setAddress(address);
                u.printUserName();  // Sửa tại đây

                ArrayList<User> al = new ArrayList<>();
                User u1 = new User();
                u1.setUserName("test1aaaaaaaaaaaaaaaaaaa");

                User u2 = new User();
                u2.setUserName("test2aaaaaaaaaaaaaaaaaaa");

                al.add(u1);
                al.add(u2);
                al.add(u);

                ListUser lu = new ListUser();
                lu.printListUser(al);

                model.addAttribute("users", al); // Sửa tại đây

                WriteToFile wf = new WriteToFile();
                wf.ToFile(al);

                InsertToAiven iu = new InsertToAiven();
                iu.insertToAivenDb(u);

                AivenConnection ac = new AivenConnection();
                ac.aivenConn();
            }

        } catch (RuntimeException e) {
            System.out.println(e);
        } finally {
            System.out.println("done");
        }

        return "greeting";
    }
}
