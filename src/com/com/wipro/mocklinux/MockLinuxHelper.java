package com.com.wipro.mocklinux;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MockLinuxHelper {
    private List folderNameList = new ArrayList<String>();
    private boolean isCommandInvalid = false;


    public void createNewDirectory(String command){
        String folderName = getFolderNames(command);
        folderNameList.clear();
        if(folderName!=null){
            if(folderName.contains("/")){
                String folderNames[] = folderName.split("/");
                folderNameList.addAll(Arrays.asList(folderNames));
            }else{
                folderNameList.add(folderName);
            }
        }
    }

    public String getFolderNames(String command){
        String folderNames[] = command.trim().split(" ");
        if (folderNames.length==1 || folderNames.length>2){
            System.out.println("Please enter a valid command");
            return null;
        }
        return folderNames[1];
    }

    public void navigateInPath(String command,Deque fileList){
        String folderName = getFolderNames(command);
        isCommandInvalid = false;
        if(folderName!=null){
            if(folderName.contains("..") && folderName.contains("/")){
                String folderNames[] = folderName.split("/");
                for(String folder:folderNames){
                    if("..".equals(folder) && fileList.size()>0){
                        fileList.pop();
                    }
                }
            }else if("..".equals(folderName) && fileList.size()>0){
                fileList.pop();
            }
            else if(folderName.contains("/")){
                String folderNames[] = folderName.split("/");
                for(String folder:folderNames){
                    pushToDeque(folder, fileList);
                }
            }else{
                pushToDeque(folderName, fileList);
            }
        }
        if (isCommandInvalid)
            System.out.println("Invalid Command");
        else
            folderNameList.clear();
    }

    private void pushToDeque(String folderName, Deque fileList){
        if(!checkIfFileNameIsValid(folderName))
            System.out.println("Invalid Command");
        else if(folderNameList.contains(folderName)){
            fileList.push(folderName);
        }else
            isCommandInvalid = true;
    }

    public void peekIntoDirectory(Deque fileList){
        if(fileList.size()>0){
            List<String> copiedList = new ArrayList<>(fileList);
            Collections.reverse(copiedList);
            StringBuilder sb = new StringBuilder();
            for(String s:copiedList){
                sb = sb.append("/"+s);
            }
            System.out.println(sb.toString());
        }else{
            System.out.println("No folder to display");
        }
    }

    private boolean checkIfFileNameIsValid(String fileName){
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]*");
        Matcher match = pattern.matcher(fileName);
        if(!match.find()){
            return false;
        }
        return true;
    }
}
