package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId , Integer.MAX_VALUE);
        calendar  = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        if(calendar.size()==0) return 0;
        if(calendar.size()==1) return 1;
        Collections.sort(calendar , (a,b)->{
                    if(a.getEndTime().compareTo(b.getEndTime())>0)
                        return -1;
                    else if(a.getEndTime().compareTo(b.getEndTime())<0)
                        return 1;
                    else
                        return  0;
                }
        );
        int count  = 0;
        Meeting pm  = calendar.get(0);
        for(int i = 1;i< calendar.size();i++){
            Meeting meeting  = calendar.get(i);

            if(meeting.getStartTime().compareTo(pm.getEndTime())>1){
                count++;
                pm  = meeting;
            }
        }
        return count;
    }
}