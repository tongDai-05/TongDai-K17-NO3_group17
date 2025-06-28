package com.example.servingwebcontent.component;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.example.servingwebcontent.model.User;

public class WriteToFile {
    public void ToFile(ArrayList<User> u) {
        try {
            int i = u.size() - 1;
            FileWriter writer = new FileWriter("./complete/File/Login.txt", true);
            writer.append("\n");

            writer.write(u.get(i).getUserName() + "\n");
            writer.write(u.get(i).getAddress() + "\n");

            writer.close();
        } catch (IOException e) {
            System.out.println("Error at write to File!");
            e.printStackTrace();
        }
    }
}
