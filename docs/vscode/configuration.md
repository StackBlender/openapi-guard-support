# VS Code configuration and behavior

OpenAPI Guard compares OpenAPI 3.x operations with Spring Boot Java/Kotlin and
NestJS TypeScript routes and reports:

- a contract operation without a supported implementation;
- a supported implementation without a contract operation; and
- a different HTTP method on an otherwise matching route (on both the contract and
  the implementation).

Analysis is automatic and local-first. Diagnostics identify drift; quick fixes,
the Operations view, CodeLens, and Go to Definition help you resolve it.

## Commands

- **OpenAPI Guard: Analyze Current File**
- **OpenAPI Guard: Go to OpenAPI Operation**
- **OpenAPI Guard: Go to Implementation**
- **OpenAPI Guard: Select OpenAPI Specification**
- **OpenAPI Guard: Refresh**, **Show Problems Only**, **Filter Operations…**, and
  **Copy as Markdown** (Operations view)

The Operations view's context menu adds **Go to Spec**, **Go to Implementation**,
and **Copy Selected as Markdown**. Navigation is also available through editor
context menus, CodeLens, and standard Go to Definition behavior.

## Settings

| Setting                                              | Type         | Default                           | Purpose                                                                                               |
| ---------------------------------------------------- | ------------ | --------------------------------- | ----------------------------------------------------------------------------------------------------- |
| `stackblender.openApiGuard.enabled`                  | boolean      | `true`                            | Enable local contract analysis                                                                        |
| `stackblender.openApiGuard.specs`                    | string array | empty                             | Workspace-relative OpenAPI specifications to analyze; empty analyzes every OpenAPI 3.x document found |
| `stackblender.openApiGuard.spec`                     | string       | empty                             | Deprecated; one specification, analyzed together with `specs`                                         |
| `stackblender.openApiGuard.severity`                 | string       | `warning`                         | `error`, `warning`, `information`, or `hint`                                                          |
| `stackblender.openApiGuard.ruleSeverity`             | object       | empty                             | Per-rule severity or `off` (see below)                                                                |
| `stackblender.openApiGuard.include`                  | string array | `**/*.java`, `**/*.kt`, `**/*.ts` | Source files eligible for analysis                                                                    |
| `stackblender.openApiGuard.exclude`                  | string array | build, target, dist, node_modules | Source files excluded from analysis                                                                   |
| `stackblender.openApiGuard.implementationPathPrefix` | string       | empty                             | Prefix applied to implementation routes before comparison                                             |
| `stackblender.openApiGuard.codeLens`                 | boolean      | `true`                            | Show CodeLens links between endpoints and their OpenAPI operations                                    |

`ruleSeverity` takes the rules `missing-implementation`,
`undocumented-implementation`, and `http-method-mismatch`, each set to `default`
(use `severity`), `error`, `warning`, `information`, `hint`, or `off`.

## Specifications

Any YAML or JSON file that declares `openapi: 3.x` at its top is a contract,
whatever its name; test sources, dependency caches, and build output are skipped.
With several specifications, each covers its own build module and the modules that
depend on it, read from Maven, Gradle, and npm workspace files. Use **Select OpenAPI
Specification** or the `specs` setting to choose specific files. Swagger 2.0 is not
supported.

## Matching and suppression

Path-variable names are ignored during endpoint matching. For Spring, mappings
inherited from interfaces and base classes, constant paths, and `${...}`
placeholders from `application.properties` / `application.yml` are resolved, and
OpenAPI `servers` base paths are aligned with `server.servlet.context-path`.
Computed or unresolved Spring and NestJS routes are skipped instead of guessed; an
operation they could implement is shown as unverified rather than missing. NestJS
support covers `.ts` controllers with directly imported decorators; custom
decorators, runtime module prefixes, versioning, compiled JavaScript, and lossy
route patterns are not inferred.

- `x-openapi-guard-ignore: true` on an operation, its path item, or the document
  exempts it from implementation checks.
- `@SuppressWarnings("OpenApiUndocumentedEndpoint")` (Java) or
  `@Suppress("OpenApiHttpMethodMismatch")` (Kotlin) on a handler or controller
  accepts an intentional difference; the IDs match the IntelliJ plugin, and `ALL`
  suppresses every rule.
- Endpoints hidden with springdoc's `@Hidden` / `@Operation(hidden = true)` or
  NestJS `@ApiExcludeEndpoint()` are never reported as undocumented.

The bundled CLI, agent tool, and MCP adapter are available with the extension. See the [CLI](../cli/README.md) and [MCP](../mcp/README.md) pages for their current distribution boundaries.
