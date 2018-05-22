# plaintext-writer
A plaintext editor for writers; designed to enforce minimality.

## Commands
| Command        | Description           | Example  |
| ------------- |-------------| -----|
| `new` | Creates a new empty file | `new` |
| `save` | Saves the open file | `save` |
| `saveas <dest>` | Saves the open file at the passed in destination | `saveas "/home/stephen/example.txt"` |
| `open <dest>` | Opens the file at the passed in destination | `open "/home/stephen/example.txt"` |
| `theme <name>` | Changes the theme. | `theme dark` |
| `hide <target>`| Hides the target UI element | `hide command` or `hide all`|
| `set_width <width>` | Sets the view width of the editor | `set_width 1200`|
| `set_fontsize <size>` | Sets the font size of the editor | `set_fontsize 24`|
