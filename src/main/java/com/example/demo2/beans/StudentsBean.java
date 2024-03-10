package com.example.demo2.beans;

import com.example.demo2.dao.StudentDAO;
import com.example.demo2.models.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class StudentsBean {

    private final StudentDAO dao;
    private Boolean addForm;
    private Student newStudent;
    private Student selectedStd;
    private int pageSize = 10; // Update page size to 10
    private int currentPage = 1;
    private int totalpages;

    public StudentsBean() {
        dao = new StudentDAO();
        newStudent = new Student();
        addForm = false;
    }

    public void showAddForm() {
        addForm = true;
    }

    public List<Student> listStudents(){

        List<Student> list = dao.getStudents();

        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, list.size());

        List<Student> pageStudents = list.subList(startIndex, endIndex);

        totalpages = (int) Math.ceil((double) list.size() / pageSize);
        return pageStudents;
    }

    public void addStudent(){
        this.addForm = false;
        dao.addStudent(newStudent);
    }

    public Boolean getAddForm() {
        return addForm;
    }

    public Student getNewStudent() {
        return newStudent;
    }

    public void setNewStudent(Student newStudent) {
        this.newStudent = newStudent;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Student getSelectedStd() {
        return selectedStd;
    }

    public void setSelectedStd(Student selectedStd) {
        this.selectedStd = selectedStd;
    }

    public void editStudent(Student std){
        System.out.println(std.getAge());
        dao.editStudent(std);
        selectedStd = null;
    }

    public void deleteStudent(int id){
        dao.deleteStudent(id);
    }

    public void previousPage() {
        currentPage--;
    }

    public void nextPage() {
        currentPage++;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(int totalpages) {
        this.totalpages = totalpages;
    }
}
