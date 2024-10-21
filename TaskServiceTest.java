//Author Name: Robert Robbins
//
//Date: 9/29/2024
//
//Course Id; CS-320


//This is the TaskServiceTest class which is used to test the TaskService class.
//This class tests that the TaskService can create and remove tasks and that 
//the tasks ids are unique. It also tests that task name/descriptions can be updated.



package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import module4.TaskService;

class TaskServiceTest {

	
	//Test that a single task can be created and added to task list
	@Test
	void testTaskCreation() {
			TaskService.createNewTask("new task", "task description");
			int testIndex = TaskService.tasks.size() - 1;
			String taskName = TaskService.tasks.get(testIndex).getTaskName();
			String taskDesc = TaskService.tasks.get(testIndex).getTaskDesc();
			assertEquals(taskName, "new task");
			assertEquals(taskDesc, "task description");
	}
	
	//Test that tasks can be removed using task it
	@Test
	void testTaskRemove() {
		int oldTaskListSize;
		int newTaskListSize;
		String contactId;
		boolean taskDeleted = true;
		
		TaskService.createNewTask("task name", "task Description");
		oldTaskListSize = TaskService.tasks.size();
		contactId = TaskService.tasks.get(0).getTaskId();
		
		TaskService.removeTask(contactId);
		newTaskListSize = TaskService.tasks.size();
		
		
		for (int i = 0; i < TaskService.tasks.size(); i++) {
			if(TaskService.tasks.get(i).getTaskId() == contactId) {
				taskDeleted = false;
			}
		}
		
		assertTrue(taskDeleted);
		assertNotEquals(oldTaskListSize, newTaskListSize);
		
		
	}
	
	//Test multiple tasks created have unique task IDs
	@Test
	void testTaskIdUnique() {
		TaskService.createNewTask("new task1", "task description");
		TaskService.createNewTask("new task2", "task description");
		TaskService.createNewTask("new task3", "task description");
		TaskService.createNewTask("new task4", "task description");
		String taskIdOne = TaskService.tasks.get(0).getTaskId();
		String taskIdTwo = TaskService.tasks.get(1).getTaskId();
		String taskIdThree = TaskService.tasks.get(2).getTaskId();
		String taskIdFour = TaskService.tasks.get(3).getTaskId();
		assertNotEquals(taskIdOne, taskIdTwo);
		assertNotEquals(taskIdThree, taskIdFour);
	}
	
	//Test task name update function updates name 
	@Test
	void testTaskNameUpdate() {
		TaskService.createNewTask("old task name", "task description");
		String taskId = TaskService.tasks.get(0).getTaskId();
		TaskService.updateTaskName(taskId, "new task name");
		assertEquals(TaskService.tasks.get(0).getTaskName(), "new task name");
	}
	
	//Test task description update function updates description
	@Test
	void testTaskDescUpdate() {
		TaskService.createNewTask("task name", "old task description");
		String taskId = TaskService.tasks.get(0).getTaskId();
		TaskService.updateTaskDesc(taskId, "new task description");
		assertEquals(TaskService.tasks.get(0).getTaskDesc(), "new task description");
	}
	

	
	

}
