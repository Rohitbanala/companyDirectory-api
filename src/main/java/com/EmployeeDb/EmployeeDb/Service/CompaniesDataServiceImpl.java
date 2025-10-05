package com.EmployeeDb.EmployeeDb.Service;
import com.EmployeeDb.EmployeeDb.GlobalExceptionHandler.APIException;
import com.EmployeeDb.EmployeeDb.Model.Companies;
import com.EmployeeDb.EmployeeDb.Payload.CompanyDataRes;
import com.EmployeeDb.EmployeeDb.Repo.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CompaniesDataServiceImpl implements CompaniesDataService {

    @Autowired
    private CompanyRepo companyRepo;

    @Override
    public CompanyDataRes getAllCompanies(
            int page, int size,
            String sortBy, String direction,
            String industry, String location,
            String name) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        if (sortBy != null && direction != null) {
            sort = Sort.by(Sort.Direction.fromString(direction.toUpperCase()), sortBy);
        }
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Companies> companyPage;
        if (name != null && !name.trim().isEmpty()) {
            companyPage = companyRepo.findByNameContainingIgnoreCase(name, pageable);
        } else if (industry != null && location != null && !industry.trim().isEmpty() && !location.trim().isEmpty()) {
            companyPage = companyRepo.findByIndustryIgnoreCaseAndLocationIgnoreCase(industry, location, pageable);
        } else if (industry != null && !industry.trim().isEmpty()) {
            companyPage = companyRepo.findByIndustryIgnoreCase(industry, pageable);
        } else if (location != null && !location.trim().isEmpty()) {
            companyPage = companyRepo.findByLocationIgnoreCase(location, pageable);
        } else {
            companyPage = companyRepo.findAll(pageable);
        }
        if (companyPage.isEmpty()) {
            throw new APIException("No companies found.");
        }
        CompanyDataRes response = new CompanyDataRes();
        response.setContent(companyPage.getContent());
        response.setCurrentPage(companyPage.getNumber());
        response.setPageSize(companyPage.getSize());
        response.setTotalElements(companyPage.getTotalElements());
        response.setTotalPages(companyPage.getTotalPages());
        response.setLast(companyPage.isLast());

        return response;
    }


    @Override
    public CompanyDataRes searchCompaniesByName(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Companies> companyPage = companyRepo.findByNameContainingIgnoreCase(name, pageable);

        if (companyPage.isEmpty()) {
            throw new APIException("No companies found with name: " + name);
        }

        CompanyDataRes response = new CompanyDataRes();
        response.setContent(companyPage.getContent());
        response.setCurrentPage(companyPage.getNumber());
        response.setPageSize(companyPage.getSize());
        response.setTotalElements(companyPage.getTotalElements());
        response.setTotalPages(companyPage.getTotalPages());
        response.setLast(companyPage.isLast());

        return response;
    }


    private CompanyDataRes mapToResponse(Page<Companies> companyPage) {
        CompanyDataRes response = new CompanyDataRes();
        response.setContent(companyPage.getContent());
        response.setCurrentPage(companyPage.getNumber());
        response.setPageSize(companyPage.getSize());
        response.setTotalElements(companyPage.getTotalElements());
        response.setTotalPages(companyPage.getTotalPages());
        response.setLast(companyPage.isLast());
        return response;
    }
}
