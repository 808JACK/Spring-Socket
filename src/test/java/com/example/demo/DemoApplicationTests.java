package com.example.demo;

import com.example.demo.entities.Department;
import com.example.demo.entities.School;
import com.example.demo.repositories.DepartmentRepo;
import com.example.demo.repositories.SchoolRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.hibernate.cfg.Configuration;


import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@SpringBootTest
class DemoApplicationTests {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	SchoolRepo sr;




	@Autowired
	DepartmentRepo dr;

	@Test
	void contextLoads() {
	}

	@Test
	void envVariable(@Value("${myVar}") String myVar){
		log.error(new Supplier<String>() {
			@Override
			public String get() {
				return myVar;
			}
		});
	}

	@Test
	void addSchoolRepo(){
		School s1 = new School(1,"GKEHS");
		School s2 = new School(2,"GMEHS");
		School s3 = new School(3,"SEHS");

		sr.save(s1);
		sr.save(s2);
		sr.save(s3);
	}

	@Test
	void addDeptRepo(){
		School s1 = new School(1,"GKEHS");
		School s2 = new School(2,"GMEHS");
		School s3 = new School(3,"SEHS");

		Department d1 = new Department(1,"English",s1);
		Department d2 = new Department(2,"Maths",s1);
		Department d3 = new Department(3,"Science",s1);
		Department d4 = new Department(4,"History",s1);
		Department d5 = new Department(5,"Geography",s1);
		Department d6 = new Department(6,"Music",s1);

		Department d7 = new Department(7,"English",s2);
		Department d8 = new Department(8,"Maths",s2);
		Department d9 = new Department(9,"Science",s2);

		Department d11 = new Department(11,"Maths",s3);
		Department d12 = new Department(12,"Science",s3);

		dr.save(d1);
		dr.save(d2);
		dr.save(d3);
		dr.save(d4);
		dr.save(d5);
		dr.save(d6);
		dr.save(d7);
		dr.save(d8);
		dr.save(d9);

		dr.save(d11);
		dr.save(d12);

	}

	@Test
	void getSchoolRepo(){

		//There are two types of loading LAZY and EAGER
		//By default LAZY is select. To call this we have to use getters
		//To use the EAGER in OneToMany use fetch = fetchType.EAGER

//		Optional<School> school = sr.findById(1);
//		School sl = school.get();
		//school.get().getDepartments().stream().forEach(System.out::println);
//		for(Department d : departmentsList){
//			System.out.println(d.toString());
//		}
//		Configuration cfg = new org.hibernate.cfg.Configuration();
//		SessionFactory factory = cfg.buildSessionFactory();
//		Session s = factory.openSession();
//		Transaction tx = s.beginTransaction();
//		School s3 = (School) s.get(School.class, 1);
//		System.out.println(s3.getDepartments().size());
//		tx.commit();
//		s.close();
	}
}
