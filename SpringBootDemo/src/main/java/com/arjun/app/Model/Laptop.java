package com.arjun.app.Model;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    private int graphicsCardVersion;
    public void compile(){
        System.out.println("Your code is compiling in laptop...");
    }

    public int getGraphicsCardVersion() {
        return graphicsCardVersion;
    }

    public void setGraphicsCardVersion(int graphicsCardVersion) {
        this.graphicsCardVersion = graphicsCardVersion;
    }
}
