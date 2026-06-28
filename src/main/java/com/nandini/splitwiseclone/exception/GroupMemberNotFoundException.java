package com.nandini.splitwiseclone.exception;

public class GroupMemberNotFoundException extends RuntimeException{

    public GroupMemberNotFoundException(Long groupId,Long userId){
        super("User with id: " + userId + " is not a user of groupId: " + groupId);
    }
}
