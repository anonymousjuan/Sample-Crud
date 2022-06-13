package com.example.samplecrud;

public class DataModel {


    private Integer studentID;
    private String name;
    private String address;


    public DataModel(Integer studentID, String name, String address) {
        this.studentID = studentID;
        this.name = name;
        this.address = address;
    }
    public DataModel() {
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
