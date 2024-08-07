package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;

import com.example.nagoyameshi.entity.Company;
import com.example.nagoyameshi.form.CompanyEditForm;
import com.example.nagoyameshi.repository.CompanyRepository;


@Service
public class CompanyService {
	private final CompanyRepository companyRepository;
	
	public CompanyService(CompanyRepository companyRepository) {
	
		this.companyRepository=companyRepository;
	}

	

//	companyEditFormの郵便番号の加工
	public String []splitPostalCode(Company company)
	{
		return company.getPostalCode().split("-");
	}
	
//	郵便番号バリデーション１
	public boolean hasPostalCode(CompanyEditForm companyEditForm)
	{
		return companyEditForm.getPostalFirstcode()!=null&&companyEditForm.getPostalLastcode()!=null;
	}
//	郵便番号バリデーション２
	public boolean isMatchPostalCode(CompanyEditForm companyEditForm)
	{
		try {
			Integer a=Integer.parseInt(companyEditForm.getPostalFirstcode());
			Integer b=Integer.parseInt(companyEditForm.getPostalLastcode());
			
			if(a>=0&&b>=0)
			{
				return true;
			}
			return false;
		}
		catch(NumberFormatException nfex)
		{
			return false;
		}
	}
	
//	会社情報の変更
	public void update(CompanyEditForm companyEditForm)
	{
		Company company=companyRepository.getById(1);
		
		company.setName(companyEditForm.getName());
		company.setAddress(company.getAddress());
		company.setPrseident(companyEditForm.getPresident());
		company.setEstablishedAt(companyEditForm.getEstablishedAt());
		company.setCapital(companyEditForm.getCapital());
		company.setContents(companyEditForm.getContents());
		company.setEmployees(companyEditForm.getEmployees());
		company.setPostalCode(postalCode(companyEditForm.getPostalFirstcode(), companyEditForm.getPostalLastcode()));
		
		companyRepository.save(company);
	}
	
	
	public String postalCode(String postalFirstCode,String postalLastCode)
	{
		return postalFirstCode.toString()+"-"+postalLastCode.toString();
	}
	
}
