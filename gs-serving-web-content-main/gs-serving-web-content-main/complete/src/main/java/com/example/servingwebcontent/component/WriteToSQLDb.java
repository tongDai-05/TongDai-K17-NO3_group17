package com.example.servingwebcontent.component;
import com.example.servingwebcontent.database.InsertToAiven;
import com.example.servingwebcontent.model.User;



public class WriteToSQLDb {
    public void writeToDb(User u){
        InsertToAiven ac = new InsertToAiven();
		ac.insertToAivenDb(u);
    }
    
}
