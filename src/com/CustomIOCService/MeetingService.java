package com.CustomIOCService;

public class MeetingService implements  IMeetingService {

    @Override
    public String[] getAttendees() {
        return new String[]{"Alice", "Bob", "Charlie","Donald"};
    }
}
