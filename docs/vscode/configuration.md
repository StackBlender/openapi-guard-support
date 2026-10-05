# VS Code configuration and behavior

OpenAPI Guard compares OpenAPI 3.x operations with Spring Boot Java/Kotlin routes
and NestJS, Express, and AWS Lambda (API Gateway) routes in TypeScript or JavaScript,
and reports:

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

| Setting                                              | Type         | Default                                                | Purpose                                                                                               |
| ---------------------------------------------------- | ------------ | ------------------------------------------------------ | ----------------------------------------------------------------------------------------------------- |
| `stackblender.openApiGuard.enabled`                  | boolean      | `true`                                                 | Enable local contract analysis                                                                        |
| `stackblender.openApiGuard.specs`                    | string array | empty                                                  | Workspace-relative OpenAPI specifications to analyze; empty analyzes every OpenAPI 3.x document found |
| `stackblender.openApiGuard.spec`                     | string       | empty                                                  | Deprecated; one specification, analyzed together with `specs`                                         |
| `stackblender.openApiGuard.severity`                 | string       | `warning`                                              | `error`, `warning`, `information`, or `hint`                                                          |
| `stackblender.openApiGuard.ruleSeverity`             | object       | empty                                                  | Per-rule severity or `off` (see below)                                                                |
| `stackblender.openApiGuard.include`                  | string array | Java, Kotlin, `.ts`/`.mts`/`.cts`, `.js`/`.mjs`/`.cjs` | Source files eligible for analysis                                                                    |
| `stackblender.openApiGuard.exclude`                  | string array | build, target, dist, node_modules                      | Source files excluded from analysis                                                                   |
| `stackblender.openApiGuard.implementationPathPrefix` | string       | empty                                                  | Prefix applied to implementation routes before comparison                                             |
| `stackblender.openApiGuard.codeLens`                 | boolean      | `true`                                                 | Show CodeLens links between endpoints and their OpenAPI operations                                    |

`ruleSeverity` takes the rules `missing-implementation`,
`undocumented-implementation`, `http-method-mismatch`, and `analysis-limitation`, each
set to `default`, `error`, `warning`, `information`, `hint`, or `off`. `default` uses
`severity`, except for `analysis-limitation`, whose default is `information`.

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
Computed or unresolved routes, routers no application mounts, and AWS Lambda
dispatch that cannot be read are skipped instead of guessed; an operation they could
implement is shown as _Could not verify_ rather than missing, and an
`analysis-limitation` diagnostic marks the place. A custom Lambda router can declare
its routes in an `openapi-guard.routes.json` file. Minified files, test files, and
TypeScript build output (the `outDir` of any `tsconfig*.json`) are skipped. NestJS
support covers controllers with decorators imported directly from `@nestjs/common`;
custom decorators, runtime module prefixes, versioning, and lossy route patterns are
not inferred. The [framework guide](https://stackblender.com/openapiguard/docs/vscode/frameworks)
lists every supported Express and Lambda form.

- `x-openapi-guard-ignore: true` on an operation, its path item, or the document
  exempts it from implementation checks.
- `@SuppressWarnings("OpenApiUndocumentedEndpoint")` (Java) or
  `@Suppress("OpenApiHttpMethodMismatch")` (Kotlin) on a handler or controller
  accepts an intentional difference; the IDs match the IntelliJ plugin, and `ALL`
  suppresses every rule.
- Endpoints hidden with springdoc's `@Hidden` / `@Operation(hidden = true)` or
  NestJS `@ApiExcludeEndpoint()` are never reported as undocumented.

The bundled CLI, agent tool, and MCP adapter are available with the extension. See the [CLI](../cli/README.md) and [MCP](../mcp/README.md) pages for their current distribution boundaries.
