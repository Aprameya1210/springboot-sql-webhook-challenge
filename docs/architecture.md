# Architecture

This starter is a minimal HTTP service in Java:
- Spark Java provides lightweight routing:
  - `GET /health` — liveness/readiness
  - `GET /hello?name=...` — demo endpoint
- Business logic is separated into service classes for unit testing
- Build tooling enforces format, lint, and tests with coverage
- Containerized via Docker; includes Kubernetes manifests

You can evolve this to a more complex framework (e.g., Spring Boot) as needs grow:
- Replace Spark with Spring Boot (web starter)
- Introduce DI, configuration profiles, metrics, tracing, etc.
- Add integration tests and e2e tests as the surface area grows