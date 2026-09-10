# OpenAPI Guard CLI

> **Status: version 0.2.0 is available from [npm](https://www.npmjs.com/package/@stackblender/openapi-guard).**

The local `openapi-guard` CLI provides the same Spring Java/Kotlin and NestJS
TypeScript endpoint analysis outside the editor. Run the published package from a
project containing an OpenAPI document and supported implementation sources:

```sh
npx --yes @stackblender/openapi-guard@0.2.0 .
```

For a repeatable project dependency, install and expose it through an npm script:

```sh
npm install --save-dev @stackblender/openapi-guard@0.2.0
```

```json
{
  "scripts": {
    "openapi:check": "openapi-guard ."
  }
}
```

The executable interface is:

```text
openapi-guard [workspace] [options]

--spec <path>       Workspace-relative OpenAPI specification
--include <glob>    Source include glob; may be repeated
--exclude <glob>    Additional exclude glob; may be repeated
--implementation-path-prefix <path>
                    Prefix applied to discovered implementation routes
--format <format>   text (default) or json
-h, --help          Show help
```

Exit code `0` means clean, `1` means contract drift, and `2` means analysis or configuration failed. JSON output uses a versioned report with `clean`, `drift`, or `error` status. In JSON mode, standard output is reserved for the machine-readable report.

The CLI performs analysis locally; the initial `npx` or `npm install` command still
contacts the npm registry to download the package. See the
[privacy overview](../privacy.md). For reproducible problems, use the
[CLI/MCP bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=cli-mcp-bug.yml).
