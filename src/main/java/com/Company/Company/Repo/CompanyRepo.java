package com.Company.Company.Repo;
import com.Company.Company.Model.Companies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Companies, Long> {
    Page<Companies> findByIndustryIgnoreCase(String industry, Pageable pageable);
    Page<Companies> findByLocationIgnoreCase(String location, Pageable pageable);
    Page<Companies> findByIndustryIgnoreCaseAndLocationIgnoreCase(String industry, String location, Pageable pageable);
    Page<Companies> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
