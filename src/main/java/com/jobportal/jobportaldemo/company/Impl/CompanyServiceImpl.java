package com.jobportal.jobportaldemo.company.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.jobportaldemo.company.Company;
import com.jobportal.jobportaldemo.company.CompanyRespository;
import com.jobportal.jobportaldemo.company.CompanyService;
import com.jobportal.jobportaldemo.job.Job;

@Service
public class CompanyServiceImpl implements CompanyService {
	private CompanyRespository companyRespository;
	
	public CompanyServiceImpl(CompanyRespository companyRespository)
	{
		this.companyRespository = companyRespository;
	}
	@Override
	public List<Company> findAllCompanies() {
		// TODO Auto-generated method stub
		List<Company> allCompany = companyRespository.findAll();
		return allCompany;
	}
	
	@Override
	public Company updateCompany(Company company, Long id) {
		
		Company toUpdateCompany = companyRespository.findById(id).get();
		if(toUpdateCompany ==  null)
			return null;
		else
		{
			toUpdateCompany.setName(company.getName());
			toUpdateCompany.setDescription(company.getDescription());
			
			
			return toUpdateCompany;
		}
	}
	@Override
	public void createCompany(Company company) {
		
		companyRespository.save(company);
		
	}
	@Override
	public boolean deleteCompany(Long id) {
		if(companyRespository.existsById(id))
		{
			companyRespository.deleteById(id);
			return true;
		}
		return false;
			
		
	}
	@Override
	public Company getCompany(Long id) {
		
		Company company = companyRespository.findById(id).get();
		return company;
	}

}
