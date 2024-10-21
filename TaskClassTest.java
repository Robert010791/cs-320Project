//Author Name: Robert Robbins
//
//Date: 10/9/2024
//
//Course Id; CS-320


//Added tests for setter methods to bring coverage up to 100%



package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import module4.TaskClass;


class TaskClassTest {

	
	//test task object can be created
	@Test
	void testTaskObjectCreation() {
	TaskClass newTask = new TaskClass("task one", "This is the first task");
	assertEquals(newTask.getTaskName(), "task one");
	assertEquals(newTask.getTaskDesc(), "This is the first task");
	}
	
	// tests that task ids are unique
	@Test 
	void  testUniqueId() {
		TaskClass taskOne = new TaskClass("task one", "This is the first task");
		TaskClass taskTwo = new TaskClass("task two", "This is the second task");
		TaskClass taskThree = new TaskClass("task three", "This is the third task");
		TaskClass taskFour = new TaskClass("task four", "This is the fourth task");
		String taskOneId = taskOne.getTaskId();
		String taskTwoId = taskTwo.getTaskId();
		String taskThreeId = taskThree.getTaskId();
		String taskFourId = taskFour.getTaskId();
		
		assertNotEquals(taskOneId, taskTwoId);
		assertNotEquals(taskThreeId, taskFourId);
	}
	
	//Test that task object cannot be created with a null value for name.
	@Test
	void testTaskNameNotNull() {
		TaskClass nullNameTask = new TaskClass(null, "null task description");
		String nullName = nullNameTask.getTaskName();
		assertEquals(nullName, "Null");
	}
	
	//Tests that task description cannot be created with null value.
	@Test 
	void testTaskDescNull() {
		TaskClass nullDescTask = new TaskClass("task name", null);
		String nullDesc = nullDescTask.getTaskDesc();
		assertEquals(nullDesc, "Null");
	}
	
	//Test task name cannot be created with name longer than 20 characters.
	@Test
	void testTaskNameNotTooLong() {
		String tooLongName = "Lorem ipsum dolor sit ame";
		String shortendName = "Lorem ipsum dolor si";
		TaskClass longNameTask = new TaskClass(tooLongName, "task description");
		assertEquals(longNameTask.getTaskName(), shortendName);
		
	}
	
	
	//Test task description cannot be created with description longer than 50 characters.
	@Test
	void testTaskDescNotTooLong() {
		String tooLongDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
		String shortendDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing";
		TaskClass longDescTask = new TaskClass("name", tooLongDesc);
		assertEquals(longDescTask.getTaskDesc(), shortendDesc);
		
	}
	
	//Tests that setter methods update
	@Test
	void testUpdate() {
		TaskClass updateTask = new TaskClass("task", "This is a task");
		updateTask.setTaskName("new name");
		updateTask.setTaskDesc("new description");
		assertEquals("new name", updateTask.getTaskName());
		assertEquals("new description", updateTask.getTaskDesc());
		
	}
	
	//Test setter methods cannot update to null
	@Test
	void testNullUpdate() {
		TaskClass setToNull = new TaskClass("task", "This is a task");
		setToNull.setTaskName(null);
		setToNull.setTaskDesc(null);
		assertNotNull(setToNull.getTaskName());
		assertEquals("task", setToNull.getTaskName());
		assertNotNull(setToNull.getTaskDesc());
		assertEquals("This is a task", setToNull.getTaskDesc());
	}
	
	//Test setter methods cannot update to invalid value
	@Test
	void testInvalidUpdate() {
		String tooLongName = "Lorem ipsum dolor sit ame";
		String shortendName = "Lorem ipsum dolor si";
		
		String tooLongDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";
		String shortendDesc = "Lorem ipsum dolor sit amet, consectetur adipiscing";
		
		TaskClass setToNull = new TaskClass("task", "This is a task");
		setToNull.setTaskName(tooLongName);
		setToNull.setTaskDesc(tooLongDesc);
		assertEquals(shortendName, setToNull.getTaskName());
		assertEquals(shortendDesc, setToNull.getTaskDesc());
	}
	
	
	
	
	
	
	

}































