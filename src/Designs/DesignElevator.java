package Designs;

public class DesignElevator {
/*
 * https://github.com/mission-peace/Design/tree/master/Elevator/src/com/elevator/base
 */
/*
 * https://softwareengineering.stackexchange.com/questions/336282/design-elevator-system-algorithm-and-classes
 Elevator - Here is the State
floorButton(will contain the list of floor buttons in elevator)
elevatorRequest it will contain the elevator requests in ascending order if direction is UP otherwise it will contain in descending order if direction is DOWN.
currentDirection(UP or DOWN)
currentFloor
currentState(Running/Idle/Maintenance etc)

Here is the behavior
run(...) :- It will process the elevatorRequest till it is empty. if list is not empty, it will set its state to Running , set the directiion based on comparison of it currentFloor and any request in elevatorRequest and print running . Tt will also check the each elevator Request in list elevatorRequests in sequential order and check if it is equal to getcurrentFloor(). If yes print "Reached Floor" + currentFloor. Else make the state as Stopped
setCurrentFloor() :- Whenever elevator reach to any floor , it will call this method to set the currentFloor.
openDoor()
closeDoor()
reset()


Button -
Floor Button (Button inside elevator to place elevator request)
Direction Button(Button outside elevator to call elevator)


ElevatorRequest
floorNumber
direction
time


Controller/Business Objects :-
ElevatorController - For handling http request and delegate it to ElevatorRequestManager


processElevatorRequest(..)
processFloorRequest(..)
ElevatorScheduleManager - To place the request we can use different kind of strategies like timebased, direction based etc. Here i will use DirectionBased Strategy.
 Here is the DirectionBasedStrategy
processRequest(...) Pattern- It will follow factory pattern to create the one of the child object of strategy based on parameter(can be configured in property file)


DirectionBasedStrategy -
It will check the currentState of elevator,
If Elev is in Idle state, it will place the floorRequest in list named as ElevatorRequest. Else call ElevatorRequestManager to place the request in set(Tree based) pendingRequests
If Elev is in Running state, it will get the currentDirection . If it matches with ElevatorRequest direction and current floor is less than ElevatorRequest floor it will place the request in floorRequest list. Else call ElevatorRequestManager to place the request in set pendingRequests 
I have chosen the TreeSet so that request can be stored in in order of time and does not contain duplicate entries
processRequest(...)


ElevatorRequestManager- This will place the ElevatorRequest in some data structure like list. Here we wil two classes DownwardElevatorRequestManager and UpwardElevatorRequestManager
processRequest(...)
processPendingRequest(...) This method will start the thread that will keep on running. This will again use the DirectionBasedStrategy. 
This will poll the pendingRequests to pick the requests in the same direction until the last request in that direction.
 Once all the requests are picked , it will remove the requests from pendingRequests and put it in elevatorRequest and call run method on elevator. To pick the move direction , it will pick the direction from first request under pendingRequests(it already contains the request in time order)
*/	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
