package com.EmployeeDb.EmployeeDb.Payload;

public class CompanyDataDTO {
    private Long id;
    private String name;
    private String industry;
    private String location;
    private int employees;
    private String description;
    private int founded;
    private String website;
    public CompanyDataDTO() {}
    public CompanyDataDTO(Long id, String name, String industry, String location, int employees, String description, int founded, String website) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.location = location;
        this.employees = employees;
        this.description = description;
        this.founded = founded;
        this.website = website;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getIndustry() {
        return industry;
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getEmployees() {
        return employees;
    }
    public void setEmployees(int employees) {
        this.employees = employees;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getFounded() {
        return founded;
    }
    public void setFounded(int founded) {
        this.founded = founded;
    }
    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }
}
