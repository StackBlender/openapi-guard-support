# VS Code configuration and behavior

OpenAPI Guard compares OpenAPI 3.x operations with Spring Boot Java/Kotlin and
NestJS TypeScript routes and reports:

- a contract operation without a supported implementation;
- a supported implementation without a contract operation; and
- a different HTTP method on an otherwise matching route.

Analysis is automatic and local-first. Diagnostics identify drift, and bidirectional navigation connects related contract and implementation locations when a match is available.

## Commands

- **OpenAPI Guard: Analyze Current File**
- **OpenAPI Guard: Go to OpenAPI Operation**
- **OpenAPI Guard: Go to Implementation**
- **OpenAPI Guard: Select OpenAPI Specification**

Navigation is also available through editor context menus and standard Go to
Definition behavior.

## Settings

| Setting                                              | Type         | Default                           | Purpose                                                        |
| ---------------------------------------------------- | ------------ | --------------------------------- | -------------------------------------------------------------- |
| `stackblender.openApiGuard.enabled`                  | boolean      | `true`                            | Enable local contract analysis                                 |
| `stackblender.openApiGuard.spec`                     | string       | empty                             | Workspace-relative OpenAPI specification; empty uses discovery |
| `stackblender.openApiGuard.severity`                 | string       | `warning`                         | `error`, `warning`, or `information`                           |
| `stackblender.openApiGuard.include`                  | string array | `**/*.java`, `**/*.kt`, `**/*.ts` | Source files eligible for analysis                             |
| `stackblender.openApiGuard.exclude`                  | string array | build, target, dist, node_modules | Source files excluded from analysis                            |
| `stackblender.openApiGuard.implementationPathPrefix` | string       | empty                             | Prefix applied to implementation routes before comparison      |

Automatic discovery recognizes `openapi.yaml`, `openapi.yml`, `openapi.json`, `swagger.yaml`, `swagger.yml`, and `swagger.json`. Use **Select OpenAPI Specification** when a workspace has multiple candidates or a different filename.

Path-variable names are ignored during endpoint matching. Computed or unresolved
Spring and NestJS routes are skipped instead of guessed. NestJS support covers
`.ts` controllers with directly imported decorators; custom decorators, runtime
module prefixes, versioning, compiled JavaScript, and lossy route patterns are not
inferred.

The bundled CLI, agent tool, and MCP adapter are available with the extension. See the [CLI](../cli/README.md) and [MCP](../mcp/README.md) pages for their current distribution boundaries.
