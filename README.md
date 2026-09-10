# StackBlender OpenAPI Guard

OpenAPI Guard keeps OpenAPI contracts synchronized with Spring Boot Java and Kotlin implementations by reporting endpoint-level drift.

This is the public documentation, examples, feedback, and support repository. It is not the source repository for the separately licensed, proprietary OpenAPI Guard products.

## Product status

| Product                  | Status                                                                                                                  | Documentation                                         | Issues                                                                                                                |
| ------------------------ | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| VS Code extension        | [Released on Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=StackBlender.openapi-guard) | [VS Code docs](docs/vscode/README.md)                 | [VS Code bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=vscode-bug.yml)          |
| IntelliJ Platform plugin | In development; not released                                                                                            | [IntelliJ Platform overview](docs/intellij/README.md) | [Feature request form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=feature-request.yml) |
| CLI                      | Bundled with the VS Code extension; no standalone installer                                                             | [CLI docs](docs/cli/README.md)                        | [CLI/MCP bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=cli-mcp-bug.yml)         |
| MCP adapter              | Bundled with the VS Code extension; no stable global path                                                               | [MCP docs](docs/mcp/README.md)                        | [CLI/MCP bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=cli-mcp-bug.yml)         |

Install [OpenAPI Guard](https://marketplace.visualstudio.com/items?itemName=StackBlender.openapi-guard) from Visual Studio Marketplace.

## Current Free checks

OpenAPI Guard's current Free endpoint-level analysis detects:

- OpenAPI operations with no Spring implementation
- Spring endpoints absent from the OpenAPI contract
- HTTP method mismatches for otherwise matching routes

Parameter, body, DTO, schema, nullability, enum, response, licensing, and entitlement checks are planned work and are not currently available.

Free analysis is local-first. OpenAPI Guard does not upload source code, OpenAPI specifications, diagnostics, or repository metadata for analysis. See the [privacy overview](docs/privacy.md) for the precise scope of this statement.

## Start here

- [Install and use the VS Code extension](docs/vscode/README.md)
- [Review release status](docs/release-status.md)
- [Try the sanitized Java and Kotlin examples](examples/README.md)
- [Get support](SUPPORT.md)
- [Report a security concern privately](SECURITY.md)
- [Read the contribution guide](CONTRIBUTING.md)
- [Review the repository license](LICENSE)

The MIT License applies only to content in this support repository. OpenAPI Guard products and their source code are separately licensed. StackBlender and OpenAPI Guard names and branding are not granted under this license.
