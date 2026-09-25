# Release status

This page records current product behavior. It was last reviewed on September 25, 2026.

| Product or capability                                          | Status                                                                                                                                |
| -------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------- |
| OpenAPI Guard for VS Code                                      | Version 0.3.2 released on [Visual Studio Marketplace](https://marketplace.visualstudio.com/items?itemName=StackBlender.openapi-guard) |
| Spring Java/Kotlin and NestJS TypeScript endpoint drift checks | Available in the released VS Code extension, CLI, and MCP adapter. The IntelliJ plugin checks Spring Java/Kotlin only              |
| CLI                                                            | Version 0.3.2 released in [`@stackblender/openapi-guard`](https://www.npmjs.com/package/@stackblender/openapi-guard)                    |
| Local MCP adapter                                              | Version 0.3.2 released in the same public npm package                                                                                  |
| VS Code agent tool                                             | Included in the released VS Code extension                                                                                            |
| IntelliJ Platform plugin                                       | Version 0.3.0 released on [JetBrains Marketplace](https://plugins.jetbrains.com/plugin/34193-openapi-guard); IntelliJ IDEA 2024.1 and later |

Version 0.3.2 (VS Code and npm) is current. It has the same behavior as 0.3.0; 0.3.1
added the 0.3.0 screenshots to the Marketplace page and 0.3.2 points the homepage and
documentation links at stackblender.com and brings the CLI and MCP adapter to the 0.3
line.

Version 0.3.0 of the VS Code extension brings it to feature parity with the IntelliJ
plugin 0.3.0: content-based multi-spec discovery, cross-file Spring inheritance,
two-sided diagnostics with per-rule severity and suppression, quick fixes, the
Operations view with Markdown export, contract-path completion, first-run feedback,
and CodeLens navigation. The release VSIX passed 340 unit/process tests and 41 VS
Code integration tests on Stable and VS Code 1.96.0; its SHA-256 is
`ac9f3a0b4bc7ebf2813bc653287919b8f218de7421a2ac24efb0251e4fd8a364`.

Version 0.2.0 added NestJS TypeScript support and an explicit implementation-path
prefix shared by VS Code, the CLI, and MCP. The packaged VSIX passed 153
unit/process tests and 32 VS Code integration tests on Stable and VS Code 1.96.0,
was installed into a clean profile, and passed a functional NestJS smoke test.
The minified 1,048,861-byte release VSIX has SHA-256
`487cc354afb5db1f98477cee5485f367f4e165923b4bc1e59fdb379a121f73ce`.

The separately installable npm package publishes the same CLI and local MCP
adapter as a six-file, dependency-free tarball. Version 0.2.0 passed an
installed-package CLI run and MCP initialization/tool-discovery smoke test with
network entry points blocked during analysis. Its registry SHA-1 is
`99e4680c7061e2e06915b1e6aa7aa6c4cfd8ba19`.

The released extension requires desktop VS Code 1.96.0 or later.
