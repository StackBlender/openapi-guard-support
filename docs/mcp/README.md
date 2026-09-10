# OpenAPI Guard MCP adapter

> **Status: version 0.2.0 is available from [npm](https://www.npmjs.com/package/@stackblender/openapi-guard).**

The MCP adapter is a local child process that communicates over standard input and
output. It analyzes supported Spring Java/Kotlin and NestJS TypeScript projects,
is not a hosted REST service, and does not require uploading a repository.

Configure a compatible client to launch a pinned npm package version, set the
process working directory to the repository being analyzed, and use
standard-input/output transport:

```text
command: npx
arguments: --yes --package=@stackblender/openapi-guard@0.2.0 openapi-guard-mcp
working directory: /absolute/path/to/project
transport: stdio
```

Pinning the version makes upgrades deliberate. The first launch may contact npm to
download the package; subsequent analysis is local and OpenAPI Guard itself makes
no analysis network request.

The server exposes one read-only tool named `check_openapi_contract`. It accepts
optional `workspaceFolder`, `implementationPathPrefix`, `offset`, and `limit`
arguments. `workspaceFolder` must be a relative descendant of the process working
directory. `implementationPathPrefix` applies an explicit route prefix before
comparison. The maximum page size is 100 issues.

Installing the VSIX does not create a global executable path. Use the npm package
for terminal or external-agent integration. Client-specific configuration examples
will be added only after their current formats are verified.

Keep standard output reserved for protocol messages when integrating a stdio MCP process. Process logs and errors belong on standard error.

See [privacy](../privacy.md) for the scope of local-first analysis. Report reproducible adapter problems with the [CLI/MCP bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=cli-mcp-bug.yml), using only sanitized content.
