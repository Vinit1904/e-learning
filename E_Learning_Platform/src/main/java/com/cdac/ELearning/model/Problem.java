package com.cdac.ELearning.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem {

    String problemName;
    String difficulty;
    String tags;
    String description;
    HashMap<String,String> testCases = new HashMap<>();

    public Problem() { }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, String> getTestCases() {
        return testCases;
    }

    public void setTestCases(HashMap<String, String> testCases) {
        this.testCases = testCases;
    }
}

