package com.developer;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeveloperMain {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		configuration.configure("hibernate.cfg.xml");

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number of Developer Details");
		int no = scan.nextInt();

		for (int a = 1; a <= no; a++) {

			System.out.println("Enter your Name");
			String name = scan.next();

			System.out.println("Enter your Address");
			String address = scan.next();

			System.out.println("Enter your Gender");
			String gender = scan.next();

			System.out.println("Enter your Contact Number");
			String contactNumber = scan.next();

			System.out.println("Enter your E-mail I'd");
			String email = scan.next();

			// insert data into database

			Developer dev = new Developer();

			dev.setName(name);
			dev.setAddress(address);
			dev.setGender(gender);
			dev.setContactNumber(contactNumber);
			dev.setEmail(email);

			session.save(dev);
		}

		transaction.commit();
		session.close();
		System.out.println("Record saved successfully...");

	}

}
