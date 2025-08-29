# Contributing Guide

## Branching
- Feature: `feat/<short-desc>`
- Bugfix: `fix/<short-desc>`
- Chore/Docs: `chore/<short-desc>`, `docs/<short-desc>`

## Commits
- Use Conventional Commits:
  - `feat: add greeting endpoint`
  - `fix: handle null name`
  - `chore: bump dependencies`
  - `docs: update design`

## PRs
- One focused change per PR
- Include tests and docs updates
- Ensure pre-push checks pass:
  - `./scripts/pre-push.sh`

## Design & ADRs
- For non-trivial changes, attach a design doc (see `docs/design-doc-template.md`)
- Record key decisions as ADRs under `docs/adr/`

## Code Style & Quality
- Format: `mvn spotless:apply`
- Lint: `mvn -B checkstyle:check`
- Tests: `mvn -B test`
- Coverage: `mvn -B verify` (JaCoCo report under `target/site/jacoco`)