# tag - tag maker for points of discussion (and other things)

Create tags to use during recordings as tags for points of discussions, etc. Add tags to docs, code, etc, as breadcrumbs to find everything you need when rewatching / developing.

## Installation

Download from http://example.com/FIXME.

## Usage

Generate 3 tags and print to stdout:

    $ java -jar tag-0.1.0-SNAPSHOT-standalone.jar 3 "-"

```
dancing-doggy-doggie
smiling-llama-yokohama
smiling-mule-vestibule
```

Add final "-v" arg to print out additional information:

    $ java -jar tag-0.1.0-SNAPSHOT-standalone.jar 3 "-" -v
    
```
tag maker running with config: {:num-rhymes 3, :separator "", :verbose? "-v"}
...
```

## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2021 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
