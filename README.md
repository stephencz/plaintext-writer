# plaintext-writer
A plaintext editor for writers; designed to enforce simplicity. 

**NOTE:** I am no longer working on this project. It *should* work, but if it becomes defunt in the future I will not be fixing it. My reason for deciding not to improve or refine this project is that I do not like JavaFX which this project uses heavily. It is a better use of my time to abandon this project and start over. I still have a personal need for this kind of software, a minimal plaintext editor, so I am starting a new projected called [Dynamo](https://github.com/stephencz/dynamo).



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
| `hide <target>`| Hides the target UI element | `hide feature` or `hide all`|
| `show <target>` | Shows the target UI element | `show feature` or `show all`|
| `update <target>`|Updates the target UI element| `update count` or `update all`|
| `top` | Jumps to the top of the file | `top`|
| `bottom`| Jumps to the bottom of the file|`bottom|
| `set_width <width>` | Sets the view width of the editor | `set_width 1200`|
| `set_fontsize <size>` | Sets the font size of the editor | `set_fontsize 24`|


### Screenshots
![Light theme](/screenshots/light.png?raw=true)
![Dark theme](/screenshots/dark.png?raw=true)
![Hacker theme](/screenshots/hacker.png?raw=true)
![Relaxed theme](/screenshots/relaxed.png?raw=true)
