package com.ohgiraffers.restaurant.model.dto;

public class MenuDTO {

    private String menuName;
    private int price;
    private String category;
    private String status;


    public MenuDTO() { //vo 와 분리하는 이유 사용자에게 입력 받는 값이 다름  vo는 보여주기 용 DTO는 데이터 옮기기 위한 실제 데이터 값
    }

    public MenuDTO(String menuName, int price, String category, String status) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
        this.status = status;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuName='" + menuName + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
