# VS Code configuration and behavior

Current Free behavior compares OpenAPI 3.x operations with Spring Boot Java and Kotlin request mappings and reports:

- a contract operation without a Spring handler;
- a Spring handler without a contract operation; and
- a different HTTP method on an otherwise matching route.

Analysis is automatic and local-first. Diagnostics identify drift, and bidirectional navigation connects related contract and implementation locations when a match is available.

## Commands

- **OpenAPI Guard: Analyze Current File**
- **OpenAPI Guard: Go to OpenAPI Operation**
- **OpenAPI Guard: Go to Spring Implementation**
- **OpenAPI Guard: Select OpenAPI Specification**

Navigation is also available through editor context menus and standard Go to Definition behavior. Analyze Entire Contract and licensing commands are planned but are not present in the current package.

## Settings

| Setting                              | Type         | Default                               | Purpose                                                        |
| ------------------------------------ | ------------ | ------------------------------------- | -------------------------------------------------------------- |
| `stackblender.openApiGuard.enabled`  | boolean      | `true`                                | Enable local contract analysis                                 |
| `stackblender.openApiGuard.spec`     | string       | empty                                 | Workspace-relative OpenAPI specification; empty uses discovery |
| `stackblender.openApiGuard.severity` | string       | `warning`                             | `error`, `warning`, or `information`                           |
| `stackblender.openApiGuard.include`  | string array | `**/*.java`, `**/*.kt`                | Source files eligible for analysis                             |
| `stackblender.openApiGuard.exclude`  | string array | build, target, and node_modules globs | Source files excluded from analysis                            |

Automatic discovery recognizes `openapi.yaml`, `openapi.yml`, `openapi.json`, `swagger.yaml`, `swagger.yml`, and `swagger.json`. Use **Select OpenAPI Specification** when a workspace has multiple candidates or a different filename.

Deeper parameter, request/response body, DTO, schema, nullability, enum, and response checks are planned and should not be expected from the current Free analyzer. Computed Spring mapping paths are skipped instead of guessed.

The bundled CLI, agent tool, and MCP adapter are available with the extension. See the [CLI](../cli/README.md) and [MCP](../mcp/README.md) pages for their current distribution boundaries.
