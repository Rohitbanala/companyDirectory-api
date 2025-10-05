package com.Company.Company.Controller;
import com.Company.Company.Service.CompaniesDataService;
import com.Company.Company.Payload.CompanyDataRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class CompanyDataController {
    @Autowired
    private CompaniesDataService companiesDataService;
    @GetMapping("/allcompanies")
    public ResponseEntity<CompanyDataRes> getAllCompanies(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "6") int size,
            @RequestParam(name = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(name = "direction", defaultValue = "asc", required = false) String direction,
            @RequestParam(name = "industry", required = false) String industry,
            @RequestParam(name = "location", required = false) String location,
            @RequestParam(name = "name", required = false) String name
    ) {
        CompanyDataRes response = companiesDataService.getAllCompanies(page, size, sortBy, direction, industry, location, name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<CompanyDataRes> searchCompanies(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "6") int size) {
        return ResponseEntity.ok(companiesDataService.searchCompaniesByName(name, page, size));
    }
}
