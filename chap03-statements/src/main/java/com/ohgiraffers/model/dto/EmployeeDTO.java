package com.ohgiraffers.model.dto;

import java.sql.Date;

public class EmployeeDTO {

    // 회사 -객체  선동일 -인스턴스
    //

    private String empId;
    private String empName;
    private String empNo;
    private String email;
    private String phone;
    private String deptCode;
    private String jobCode;
    private String salLevel;
    private int salary;
    private double bonus;
    private String managerId;
    private Date hireDate;
    private Date entDAte;

    private String entYn;

    public EmployeeDTO(){

    }

    //기본 생성자 단점
    // this -> 자기 자신을 갖는다 -> 주소
    public EmployeeDTO(String empId, String empName, String empNo, String email, String phone, String deptCode, String jobCode, String salLevel, int salary, double bonus, String managerId, Date hireDate, Date entDAte, String entYn) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.email = email;
        this.phone = phone;
        this.deptCode = deptCode;
        this.jobCode = jobCode;
        this.salLevel = salLevel;
        this.salary = salary;
        this.bonus = bonus;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.entDAte = entDAte;
        this.entYn = entYn;
    }

    public EmployeeDTO setEmpId(String id){
        this.empId = id;
        return this;
    }

    public EmployeeDTO setEmpNo(String empName){
        this.empName = empName;
        return this;
    }

    public EmployeeDTO setEmail(String email){
        this.email = email;
        return this;
    }

    public EmployeeDTO setPhone(String phone){
        this.phone = phone;
        return this;
    }

    public EmployeeDTO setDeptCode(String deptCode){
        this.deptCode = deptCode;
        return this;
    }

    public EmployeeDTO setJobCode(String jobCode){
        this.jobCode = jobCode;
        return this;
    }

    public EmployeeDTO setSalLevel(String salLevel){
        this.salLevel = salLevel;
        return this;
    }

    public EmployeeDTO setSalary(int salary){
        this.salary = salary;
        return this;
    }

    public EmployeeDTO setBonus(double bonus){
        this.bonus = bonus;
        return this;
    }

    public EmployeeDTO setManagerId(String managerId){
        this.managerId = managerId;
        return this;
    }


    public EmployeeDTO setHireDate(Date hireDAte){
        this.hireDate = hireDate;
        return this;
    }

    public EmployeeDTO setEntDate(Date entDate){
        this.entDAte = entDAte;
        return this;
    }

    public EmployeeDTO setEntYn(String entYn){
        this.entYn = entYn;
        return this;
    }




    public EmployeeDTO builder(){
        return new EmployeeDTO(empId,  empName, empNo,  email, phone, deptCode, jobCode, salLevel,  salary, bonus, managerId,  hireDate,  entDAte, entYn);
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getJobCode() {
        return jobCode;
    }

    public String getSalLevel() {
        return salLevel;
    }

    public int getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public String getManagerId() {
        return managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Date getEntDAte() {
        return entDAte;
    }

    public String getEntYn() {
        return entYn;
    }


    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", jobCode='" + jobCode + '\'' +
                ", salLevel='" + salLevel + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", managerId='" + managerId + '\'' +
                ", hireDate=" + hireDate +
                ", entDAte=" + entDAte +
                ", entYn='" + entYn + '\'' +
                '}';
    }
}
