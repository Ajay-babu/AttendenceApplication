package com.ajay.attendenceapplication.FetchDataOnUI;

import com.ajay.attendenceapplication.InsertDataInFirebase.InfoStudentClass;

import java.util.List;

public interface OnItemClickListenerFirebase {
    void onItemClick(int position, List<InfoStudentClass> studentInfo);


}
