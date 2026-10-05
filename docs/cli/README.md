# OpenAPI Guard CLI

> **Status: version 0.4.1 is available from [npm](https://www.npmjs.com/package/@stackblender/openapi-guard).**

The local `openapi-guard` CLI provides the same endpoint analysis as the VS Code
extension outside the editor: Spring Boot in Java and Kotlin, and NestJS, Express, and
AWS Lambda (API Gateway `routeKey` dispatch) in TypeScript or JavaScript. Run the published package from a
project containing an OpenAPI document and supported implementation sources:

```sh
npx --yes @stackblender/openapi-guard@0.4.1 .
```

For a repeatable project dependency, install and expose it through an npm script:

```sh
npm install --save-dev @stackblender/openapi-guard@0.4.1
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

--spec <path>       Workspace-relative OpenAPI specification; may be
                    repeated (default: every OpenAPI 3.x file found)
--include <glob>    Source include glob; may be repeated
--exclude <glob>    Additional exclude glob; may be repeated
--implementation-path-prefix <path>
                    Prefix applied to discovered implementation routes
--format <format>   text (default) or json
-h, --help          Show help
```

Exit code `0` means clean, `1` means contract drift, and `2` means analysis or configuration failed. JSON output uses a versioned report with `clean`, `drift`, or `error` status. Source that could not be analyzed, such as a computed route or unrecognized `routeKey` dispatch, is listed under `limitations`, and the operations it might serve are not reported as missing. In JSON mode, standard output is reserved for the machine-readable report.

The CLI performs analysis locally; the initial `npx` or `npm install` command still
contacts the npm registry to download the package. See the
[privacy overview](../privacy.md). For reproducible problems, use the
[CLI/MCP bug form](https://github.com/StackBlender/openapi-guard-support/issues/new?template=cli-mcp-bug.yml).
