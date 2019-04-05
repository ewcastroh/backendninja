package com.udemy.backendninja.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backendninja.entity.Course;
import com.udemy.backendninja.entity.QCourse;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public Course find(boolean exist) {
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		

		Predicate predicate1 = qCourse.description.endsWith("ar");
		BooleanBuilder predicateBuilder = new BooleanBuilder(predicate1);
		
		if(exist) {
			Predicate predicate2 = qCourse.id.eq(23);
			predicateBuilder.and(predicate2);
		} else {
			Predicate predicate3 = qCourse.name.endsWith("ar");
			predicateBuilder.or(predicate3);
		}
		
		Course course1 = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(2)).fetchOne();
		
		return (Course) query.select(qCourse).from(qCourse).where(predicateBuilder).fetch();
	}
}
