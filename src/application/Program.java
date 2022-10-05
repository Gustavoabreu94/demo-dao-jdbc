package application;


import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TEST 1: seller findById =====");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== TEST 2: seller findByDepartment =====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 3: seller FindAll =====");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TEST 4: seller Insert =====");
		
		Seller newseller = new Seller (null, "Greg", "Greg@gmaail.com", new Date(), 4000.0, department);
		sellerDao.insert(newseller);
		
		System.out.println("Inserted! New id = "+ newseller.getId	());
		
		System.out.println("\n=== TEST 5: seller Update =====");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update complete ! ");
		
		System.out.println("\n=== TEST 6: seller Delete =====");
		sellerDao.deleteById(8);
		System.out.println("Delete completed!!");
	}
}