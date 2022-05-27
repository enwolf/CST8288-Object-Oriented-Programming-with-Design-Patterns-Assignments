/* 
	Author: Robin Phillis
	Course: CST8288 Object Oriented Programming with Design Patterns
	Assignment 1: Object Oriented Programming in Java
	Date: 2022-05-25	
	Objective: To demonstrate principles of OOP with java specifically: Inheritance, Polymorphism, Abstraction, Encapsulation and Composition
*/

public interface LogInterface {
	
	public void create();
	public void read();
	public void update();
	public void delete();
	
	public void atttachFile(File fileName);
	public void generateUSC(); 	// USC = UniqueShortCode formated as "abc-abc-abc"
	public void generateLogID();
	public void generateTimeStamp();
	
} //END OF CLASS
