package com.example.servingwebcontent;
import com.example.servingwebcontent.database.InsertToAiven;



public class WriteToSQLDb {
    public void writeToDb(User u){
        InsertToAiven ac = new InsertToAiven();
		ac.insertToAivenDb(u);
    }
    
}
