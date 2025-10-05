package com.Company.Company.Service;
import com.Company.Company.Payload.CompanyDataRes;



public interface CompaniesDataService {
    CompanyDataRes getAllCompanies(int page, int size,
                                   String sortBy, String direction,
                                   String industry, String location,
                                   String name);

    CompanyDataRes searchCompaniesByName(String name, int page, int size);
}
