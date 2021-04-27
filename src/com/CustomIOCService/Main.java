package com.CustomIOCService;

//import com.mantiso.Drivable;


import com.CustomContainer.Container;
import com.CustomContainer.IoCException;

public class Main {

    public static void main(String[] args) {
        try {
            Container container = new Container("C:\\Users\\manish.madhusoodhan\\IdeaProjects\\Test1\\src\\config.json");
            com.CustomIOCService.IMeeting meeting = container.resolve(com.CustomIOCService.IMeeting.class);
            meeting.getMeeting();
            for (String attendee : meeting.getAttendees()) {
                System.out.println(attendee);
            }
        } catch (IoCException e) {
            e.printStackTrace();
        }
    }
}

