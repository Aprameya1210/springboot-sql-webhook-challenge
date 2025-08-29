package com.example.app;

import java.util.Objects;

public class HelloService {
  public String greet(String name) {
    String n = (name == null || name.isBlank()) ? "world" : name.trim();
    return "Hello, " + n + "!";
  }
}