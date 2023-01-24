package com.hibernatedemo;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.CollectionId;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;


public class Main {

	public static void main(String[] args) {
		//HQL 
				//from actor a where a.last_name like 'a%' or a.last_name like 'b%'
				//from actor a order by a.last_name
			//	Query("from actor a where a.last_name like 'a%' or a.last_name like 'b%'");
				
		//Insert
			//	insertData("Latife","Şahin" );
				
		//Update
				//updateData(21);
		//Delete
				//Delete(6);
	}

	
	
	
	public static void Query(String query) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(actor.class).buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
	try {
		session.beginTransaction();

		
		  List<actor> actors =session.createQuery(query).getResultList();
		  
		  for(actor actor: actors) { System.out.println(actor.getFirst_Name()); }	
	}finally {
		factory.close();
  }

}
	public static void insertData(String name, String lastname) {
	    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(actor.class) .buildSessionFactory();

	    Session session = factory.getCurrentSession();
	    try {
	        session.beginTransaction();

	        actor actor = new actor();
	        actor.setFirst_Name(name);
	        actor.setLast_Name(lastname);

	        session.save(actor);

	        session.getTransaction().commit();
	        System.out.println("Data inserted successfully");
	    } finally {
	        factory.close();
	    }
	}
	public static void Delete(int id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(actor.class).buildSessionFactory();
	    Session session = factory.getCurrentSession();
	    try {
	        session.beginTransaction();
	        actor actor=session.get(actor.class,id);
	        session.delete(actor);
	        System.out.println("Veri silindi");
	        session.getTransaction().commit();
		
		}finally {
			factory.close();

		}
	}
	public static void updateData(int id) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(actor.class).buildSessionFactory();
		
		
		Session session = factory.getCurrentSession();
	try {
		session.beginTransaction();
		actor actor=session.get(actor.class,id);
		
		actor.setFirst_Name("Ali");
		
		session.save(actor);
		
		System.out.println("Veri guncellendi");
		session.getTransaction().commit();

	}finally {
		factory.close();
  }
	}
}
