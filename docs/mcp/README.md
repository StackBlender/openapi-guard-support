# OpenAPI Guard MCP adapter

> **Status: pre-launch; bundled with the VS Code extension.**

The MCP adapter is a local child process that communicates over standard input and output. It is not a hosted REST service, and it does not require uploading a repository for Free analysis.

The packaged executable is `dist/mcp.js`. Configure a compatible client to launch it with Node, set the process working directory to the repository being analyzed, and use standard-input/output transport:

```text
command: node
arguments: /absolute/path/to/dist/mcp.js
working directory: /absolute/path/to/project
transport: stdio
```

The server exposes one read-only tool named `check_openapi_contract`. It accepts optional `workspaceFolder`, `offset`, and `limit` arguments. `workspaceFolder` must be a relative descendant of the process working directory. The maximum page size is 100 issues.

Installing the VSIX does not create a stable global executable path. Client-specific configuration examples will be added only after their current formats and the public distribution path are verified.

Keep standard output reserved for protocol messages when integrating a stdio MCP process. Process logs and errors belong on standard error, subject to the final released behavior.

See [privacy](../privacy.md) for the scope of local-first analysis. Report reproducible adapter problems with the [CLI/MCP bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=cli-mcp-bug.yml), using only sanitized content.
