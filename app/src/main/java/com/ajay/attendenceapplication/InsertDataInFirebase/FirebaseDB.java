package com.ajay.attendenceapplication.InsertDataInFirebase;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class FirebaseDB {
    public DatabaseReference databaseReference;


    public FirebaseDB() {
        databaseReference = FirebaseDatabase.getInstance().getReference(InfoStudentClass.class.getSimpleName());


    }
    public Task<Void> add(InfoStudentClass infoStudentClass){
        return databaseReference.push().setValue(infoStudentClass);
    }

    public Query get(){
        return databaseReference;
    }

}
