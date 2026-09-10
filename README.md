# StackBlender OpenAPI Guard

OpenAPI Guard keeps OpenAPI contracts synchronized with Spring Boot Java/Kotlin
and NestJS TypeScript implementations by reporting endpoint-level drift.

This is the public documentation, examples, feedback, and support repository. It is not the source repository for the separately licensed, proprietary OpenAPI Guard products.

## Product status

| Product                  | Status                                                                                                                  | Documentation                                         | Issues                                                                                                                |
| ------------------------ | ----------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------- |
| VS Code extension        | [Released on Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=StackBlender.openapi-guard) | [VS Code docs](docs/vscode/README.md)                 | [VS Code bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=vscode-bug.yml)          |
| IntelliJ Platform plugin | In development; not released                                                                                            | [IntelliJ Platform overview](docs/intellij/README.md) | [Feature request form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=feature-request.yml) |
| CLI                      | [Version 0.2.0 released on npm](https://www.npmjs.com/package/@stackblender/openapi-guard)                               | [CLI docs](docs/cli/README.md)                        | [CLI/MCP bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=cli-mcp-bug.yml)         |
| MCP adapter              | Included in the [public npm package](https://www.npmjs.com/package/@stackblender/openapi-guard)                          | [MCP docs](docs/mcp/README.md)                        | [CLI/MCP bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=cli-mcp-bug.yml)         |

Install [OpenAPI Guard](https://marketplace.visualstudio.com/items?itemName=StackBlender.openapi-guard) from Visual Studio Marketplace.

Run the CLI without installing it globally:

```sh
npx --yes @stackblender/openapi-guard@0.2.0 .
```

## Current checks

OpenAPI Guard's endpoint-level analysis detects:

- OpenAPI operations with no supported implementation
- Spring or NestJS endpoints absent from the OpenAPI contract
- HTTP method mismatches for otherwise matching routes

Analysis is local-first. OpenAPI Guard does not upload source code, OpenAPI
specifications, diagnostics, or repository metadata for analysis. See the
[privacy overview](docs/privacy.md) for details.

## Start here

- [Install and use the VS Code extension](docs/vscode/README.md)
- [Review release status](docs/release-status.md)
- [Try the sanitized Java and Kotlin examples](examples/README.md)
- [Get support](SUPPORT.md)
- [Report a security concern privately](SECURITY.md)
- [Read the contribution guide](CONTRIBUTING.md)
- [Review the repository license](LICENSE)

The MIT License applies only to content in this support repository. OpenAPI Guard products and their source code are separately licensed. StackBlender and OpenAPI Guard names and branding are not granted under this license.
