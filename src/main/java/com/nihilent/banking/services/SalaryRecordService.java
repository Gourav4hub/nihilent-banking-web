package com.nihilent.banking.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nihilent.banking.entity.SalaryRecord;
import com.nihilent.banking.repositories.SalaryRecordRepository;

@Service
public class SalaryRecordService implements BaseService<SalaryRecord>
{
	@Autowired
	private SalaryRecordRepository salaryRecordRepo;

	@Override
	public boolean save(SalaryRecord ob) {
		try {
			ob.setCreatedAt(LocalDate.now());
			ob.setUpdatedAt(LocalDate.now());
			salaryRecordRepo.save(ob);
			return true;
		}catch(Exception ex) {
			System.err.println("SalaryRecord Save Error : " + ex.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(SalaryRecord ob) {
		try {
			ob.setUpdatedAt(LocalDate.now());
			salaryRecordRepo.save(ob);
			return true;
		}catch(Exception ex) {
			System.err.println("SalaryRecord Update Error : " + ex.getMessage());
			return false;
		}
	}

	@Override
	public List<SalaryRecord> list() {
		try {
			return salaryRecordRepo.findAll();
		}catch(Exception ex) {
			System.err.println("SalaryRecord List Error : " + ex.getMessage());
			return null;
		}
	}

	@Override
	public SalaryRecord get(int id) {
		try {
			Optional<SalaryRecord> optional =  salaryRecordRepo.findById(id);
			if(optional.isPresent())
				return optional.get();
			else
				return null;
		}catch(Exception ex) {
			System.err.println("SalaryRecord Get Error : " + ex.getMessage());
			return null;
		}
	}

}
