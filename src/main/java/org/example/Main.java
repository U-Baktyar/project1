package org.example;

import org.example.runner.Runner;
import org.example.utils.data.DBInitializer;
import org.example.utils.data.impl.DBInitializePSQL;

public class Main {
    public static void main(String[] args) {
        Runner runner = Runner.getInstance();
        runner.run();
    }
}