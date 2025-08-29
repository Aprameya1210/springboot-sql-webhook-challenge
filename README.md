# Java Service Starter

A well-structured, production-ready Java service scaffold with:
- Opinionated project layout (src, test, docs, deploy, CI)
- Local dev ergonomics (Maven, formatting, lint, test, coverage)
- Containerization (Dockerfile, docker-compose)
- Kubernetes manifests (readiness/liveness, resource requests)
- GitHub Actions CI (build, test, lint, coverage)
- Pre-push checks script to prevent broken commits
- Design docs and ADRs workflow

## Stack
- Java 21 (Temurin)
- Maven 3.9+
- Spark Java (lightweight HTTP) + SLF4J
- JUnit 5, JaCoCo (coverage), Checkstyle (Google), Spotless (Google Java Format)
- Docker, Kubernetes manifests
- GitHub Actions CI

## Prerequisites
- Java 21 (Temurin) and Maven 3.9+
- Docker (optional for container-based run)
- kubectl (optional for K8s deploy)
- Make (optional convenience)

## Quick Start

- Build, test, coverage:
  - `mvn -B verify`
  - HTML coverage report: `target/site/jacoco/index.html`
- Run locally (HTTP on port 8080 by default):
  - `mvn -B -DskipTests package`
  - `java -jar target/app-0.1.0-SNAPSHOT-shaded.jar`
- Try endpoints:
  - `curl http://localhost:8080/health` -> `ok`
  - `curl "http://localhost:8080/hello?name=Aprameya"` -> `Hello, Aprameya!`

## Project Layout

```
.
├─ .github/workflows/ci.yml          # CI: build, test, lint, coverage
├─ config/checkstyle/checkstyle.xml  # Checkstyle rules (Google as base)
├─ deploy/k8s/deployment.yaml        # K8s Deployment (readiness/liveness)
├─ deploy/k8s/service.yaml           # K8s Service
├─ docs/architecture.md              # High-level architecture
├─ docs/design-doc-template.md       # RFC template
├─ docs/adr/0001-record-architecture-decisions.md # ADR template
├─ scripts/pre-push.sh               # Pre-push checks
├─ docker-compose.yml                # Local container run
├─ Dockerfile                        # Multi-stage build
├─ Makefile                          # Dev ergonomics (optional)
├─ pom.xml                           # Maven config
├─ src/main/java/...                 # Service source
├─ src/test/java/...                 # Unit tests
├─ .editorconfig, .gitignore         # Editors & VCS hygiene
├─ CONTRIBUTING.md                   # Contrib & PR guidelines
└─ LICENSE                           # Your license (MIT by default)
```

## Design First (before you code)

1. Open an issue describing the change (bug/feature).
2. If change is notable, write a short design doc using `docs/design-doc-template.md`.
3. For architectural choices, add an ADR under `docs/adr/` (start with `0001-...`).
4. Get feedback/review on the design before implementation.

## Development Workflow

- Create a branch: `feat/short-description` or `fix/short-description`
- Implement with tests (TDD preferred)
- Keep code formatted and linted:
  - Format: `mvn spotless:apply`
  - Lint: `mvn -B checkstyle:check`
- Run full pre-push checks locally:
  - `./scripts/pre-push.sh`

## Testing & Quality Gates

- Unit tests: `mvn -B test`
- Full verify (tests + coverage + checks): `mvn -B verify`
- Coverage report: `target/site/jacoco/index.html`
- CI enforces build, tests, lint on every PR

## Container Run

- Build image: `docker build -t java-starter:dev .`
- Run: `docker run -p 8080:8080 --rm java-starter:dev`
- Compose: `docker compose up --build`

## Kubernetes Deploy (example)

- Adjust image in `deploy/k8s/deployment.yaml` to your registry (e.g., `ghcr.io/<owner>/<repo>:<tag>`)
- Apply manifests:
  - `kubectl apply -f deploy/k8s/`
- Port forward for local test:
  - `kubectl port-forward deploy/java-starter 8080:8080`
- Health check:
  - `curl http://localhost:8080/health`

## Pre-push Checklist

- [ ] Design doc/ADR updated (if applicable)
- [ ] Code formatted (`mvn spotless:apply`)
- [ ] Lint passes (`mvn -B checkstyle:check`)
- [ ] Tests green (`mvn -B test`)
- [ ] Coverage acceptable (check JaCoCo)
- [ ] CI status green on PR

## Releasing

- Tag following SemVer (e.g., `v0.1.0`)
- Optionally wire a release workflow to build/push container to GHCR/Docker Hub
