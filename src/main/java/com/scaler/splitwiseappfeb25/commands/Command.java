package com.scaler.splitwiseappfeb25.commands;

public interface Command {
    boolean matches(String input);

    void execute(String input);
}
