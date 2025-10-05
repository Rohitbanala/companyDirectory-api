package com.EmployeeDb.EmployeeDb.Service;
import com.EmployeeDb.EmployeeDb.Payload.CompanyDataRes;



public interface CompaniesDataService {
    CompanyDataRes getAllCompanies(int page, int size,
                                   String sortBy, String direction,
                                   String industry, String location,
                                   String name);

    CompanyDataRes searchCompaniesByName(String name, int page, int size);
}
