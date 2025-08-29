package com.example.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HelloServiceTest {

  @Test
  void greet_withName() {
    HelloService svc = new HelloService();
    assertEquals("Hello, Aprameya!", svc.greet("Aprameya"));
  }

  @Test
  void greet_nullOrBlank() {
    HelloService svc = new HelloService();
    assertEquals("Hello, world!", svc.greet(null));
    assertEquals("Hello, world!", svc.greet(""));
    assertEquals("Hello, world!", svc.greet("   "));
  }

  @Test
  void greet_trimsWhitespace() {
    HelloService svc = new HelloService();
    assertEquals("Hello, Jane!", svc.greet("  Jane  "));
  }
}