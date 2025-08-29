# 0001 — Record architecture decisions

- Date: 2025-08-29
- Status: Accepted

## Context

We want a lightweight, well-structured Java service starter that is easy to build, test, containerize, and deploy.

## Decision

- Use Java 21 with Maven for build
- Use Spark Java for minimal HTTP endpoints
- Enforce code style (Spotless + Google format) and lint (Checkstyle)
- Use JaCoCo for coverage
- Provide Dockerfile, docker-compose, and Kubernetes manifests
- Use GitHub Actions for CI
- Pre-push script to gate quality locally

## Consequences

- Low overhead to start; easier to swap frameworks later
- Clear quality gates
- Ready for local dev, containers, and K8s