# OpenAPI Guard for IntelliJ Platform

> **Status: released.** Install [OpenAPI Guard](https://plugins.jetbrains.com/plugin/34193-openapi-guard)
> from JetBrains Marketplace, or from inside the IDE under Settings, Plugins, Marketplace.
> The current version is 0.3.0. The plugin identifier is `com.stackblender.openapiguard`.

OpenAPI Guard for IntelliJ IDEA compares a local OpenAPI 3.x specification with your
Spring MVC controllers in Java and Kotlin. It flags operations nobody implemented,
endpoints the specification does not document, and HTTP methods that disagree. It
understands spec-first projects built with openapi-generator, including interface
and delegate styles.

The full user guide (inspections, quick fixes, the Operations tool window, path
completion, and settings) is at
[stackblender.com/openapiguard/docs/intellij](https://stackblender.com/openapiguard/docs/intellij).

Works in IntelliJ IDEA Community and Ultimate, 2024.1 and later. Supports OpenAPI 3.x;
Swagger 2.0 is not supported. NestJS support is available in the VS Code extension and
the CLI, not in this plugin.

## What it does

- **Drift inspections** on both the controller and the specification, with per-rule
  severity, `@SuppressWarnings` / `@Suppress`, and Code | Inspect Code.
- **Quick fixes**: add an undocumented endpoint to a YAML specification, implement a
  missing operation in the best-matching controller, or align the HTTP method on
  either side.
- **Operations tool window**: every operation's status (implemented, missing,
  mismatched, undocumented), with search, a problems-only filter, and Copy as Markdown
  for pull requests and reviews.
- **Path completion** from the specification inside `@GetMapping`, `@RequestMapping`,
  and the other mapping annotations.
- **Navigation both ways**: gutter icons and Go to Declaration between mappings and
  operations.
- **Specification discovery** by content, with support for several specifications per
  project or explicitly configured paths.

## Privacy

Analysis runs entirely on your machine. The plugin never uploads source code,
specifications, or diagnostics, and needs no account or network access. See the
[privacy overview](../privacy.md).

## Support

Report a reproducible problem with the
[IntelliJ bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=intellij-bug.yml),
or use the
[feature request form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=feature-request.yml).
Release history is on the [marketplace page](https://plugins.jetbrains.com/plugin/34193-openapi-guard/versions)
and summarized in [release status](../release-status.md).
