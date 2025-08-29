package com.example.app;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
    port(port);

    // Health
    get(
        "/health",
        (req, res) -> {
          res.type("text/plain");
          return "ok";
        });

    // Greeting
    HelloService hello = new HelloService();
    get(
        "/hello",
        (req, res) -> {
          res.type("text/plain");
          String name = req.queryParams("name");
          return hello.greet(name);
        });
  }
}