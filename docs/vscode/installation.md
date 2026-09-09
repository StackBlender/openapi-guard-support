# VS Code installation

> **Pre-launch:** OpenAPI Guard for VS Code is not presented here as publicly released.

The extension identifier is `stackblender.stackblender-openapi-guard` and the current package requires desktop VS Code 1.96.0 or later. A Marketplace link and public VSIX download are not available until launch. Do not install a similarly named extension.

Once a trusted release VSIX is available, it can be installed from VS Code with **Extensions: Install from VSIX...** or from a terminal:

```sh
code --install-extension /path/to/stackblender-openapi-guard-x.y.z.vsix
```

After installation:

1. Open a Spring Boot Java or Kotlin workspace containing an OpenAPI 3.x document.
2. Allow automatic analysis to run, or invoke **OpenAPI Guard: Analyze Current File**.
3. Open the Problems panel to review endpoint drift.
4. Use Go to Definition or the OpenAPI Guard navigation commands to move between the contract and implementation.

Continue with [configuration](configuration.md), or consult [troubleshooting](troubleshooting.md) after verified installation instructions are published.
