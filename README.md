# plaintext-writer
A plaintext editor for writers; designed to enforce simplicity.

## Philosophy
The main design principle behind plaintext-writer is enforced simplicity. Plaintext-writer strips away the fancy additions of modern word-processors in favor a singular, distraction-free, writing experience. 

## Usage Guide

### The Command Line
To keep things clean and simple plaintext-writer uses a command line in favor of dialog boxes and menus. The command line can be hidden or shown as needed using the keyboard shortcut `Ctrl + Shift + H`. Currently all commands that manipulate files, such as new, save, saveas, and open, **do not** provide safeguards to make sure the open file is saved. Here is a list of available command:

#### Commands
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

