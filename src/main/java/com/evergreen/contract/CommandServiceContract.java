package com.evergreen.contract;

public interface CommandServiceContract {
    Integer execute(String[] args) throws Exception;
}
