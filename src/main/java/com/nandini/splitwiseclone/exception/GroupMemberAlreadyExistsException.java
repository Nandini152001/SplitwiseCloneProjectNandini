package com.nandini.splitwiseclone.exception;

public class GroupMemberAlreadyExistsException extends RuntimeException{

    public GroupMemberAlreadyExistsException(Long groupId, Long userId){
        super("user with id: " + userId + " is already a member of group with group id: " + groupId);
    }
}
