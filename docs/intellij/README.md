# OpenAPI Guard for IntelliJ Platform

> **Status: in development, not released.** No download, installation path, or
> release date is available yet.

An IntelliJ Platform plugin for OpenAPI Guard is in active development. The intended
first release brings the same Free analysis as the VS Code extension to IntelliJ
IDEA: endpoint-level drift detection between an OpenAPI 3.x contract and Spring Boot
Java/Kotlin controllers, surfaced as native diagnostics with bidirectional
navigation.

Planned targets and scope (subject to change until release):

- IntelliJ IDEA Community and Ultimate.
- Java and Kotlin Spring Boot controllers.
- Free endpoint drift checks: missing implementations, undocumented Spring
  endpoints, and HTTP method mismatches, matching the VS Code Free behavior.
- Local-first analysis with no required network traffic.

Supported IDE versions, capabilities, distribution links, and a release date are not
yet confirmed. Deeper parameter, body, schema, and response checks are planned work
and are not part of the initial Free scope.

To express interest or describe a desired workflow, use the [feature request form](../../.github/ISSUE_TEMPLATE/feature-request.yml)
and select "IntelliJ Platform plugin." Do not file a bug report for a product that is
not yet available.

Follow [release status](../release-status.md) for confirmed changes.
