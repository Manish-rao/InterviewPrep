package com.com.wipro.mocklinux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MockLinuxCommand {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque fileList = new ArrayDeque<String>();
        MockLinuxHelper mckHelper = new MockLinuxHelper();
        while (true){
        String command = br.readLine();
        processAndExecuteCmd(command, fileList, mckHelper);
        }
    }

    public static void processAndExecuteCmd(String command, Deque fileList, MockLinuxHelper mckHelper){
        if(command.startsWith("mkdir")){
            mckHelper.createNewDirectory(command);
        }else if(command.startsWith("cd")){
            mckHelper.navigateInPath(command, fileList);
        }else if ("pwd".equals(command)){
            mckHelper.peekIntoDirectory(fileList);
        }else{
            System.out.println("Invalid command");
        }
    }

}
