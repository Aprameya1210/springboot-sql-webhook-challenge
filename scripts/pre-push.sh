#!/usr/bin/env bash
set -euo pipefail

echo "==> Formatting (spotless:apply)"
mvn -q spotless:apply

echo "==> Linting (checkstyle:check)"
mvn -q -B checkstyle:check

echo "==> Running tests"
mvn -q -B test

echo "==> Verifying (coverage, packaging)"
mvn -q -B verify

echo "All checks passed."