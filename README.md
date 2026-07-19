# MiniOS

MiniOS is a Java-based console application that simulates a simple operating system shell. It allows users to execute file management commands through a command-line interface while demonstrating professional Java software architecture and design principles.

---

## 🚀 Features

- Interactive command-line interface
- File creation
- File opening
- File writing
- File deletion
- File renaming
- File copying
- Command history
- Help and About commands
- Date and Time commands
- Clear screen
- Custom exception handling
- Command-based architecture

---

## 🛠️ Tech Stack

- Java 17 (or Java 8+)
- VS Code
- Git & GitHub

---

## 📂 Project Structure

```
src
│
├── app
│   └── Main.java
│
├── command
│   ├── CommandContext.java
│   └── CommandProcessor.java
│
├── commands
│   ├── Command.java
│   ├── CommandRegistry.java
│   ├── HelpCommand.java
│   ├── AboutCommand.java
│   ├── DateCommand.java
│   ├── TimeCommand.java
│   ├── ClearCommand.java
│   ├── ExitCommand.java
│   ├── CreateCommand.java
│   ├── OpenCommand.java
│   ├── WriteCommand.java
│   ├── DeleteCommand.java
│   ├── RenameCommand.java
│   ├── CopyCommand.java
│   └── HistoryCommand.java
│
├── filesystem
│   └── FileManager.java
│
├── history
│   └── CommandHistory.java
│
├── terminal
│   └── Terminal.java
│
└── exceptions
    └── InvalidCommandException.java
```

---

# 📋 Supported Commands

| Command | Description |
|----------|-------------|
| help | Display all available commands |
| about | Show project information |
| date | Display current date |
| time | Display current time |
| clear | Clear console |
| exit | Exit MiniOS |
| create `<file>` | Create a new file |
| open `<file>` | Open and display file contents |
| write `<file>` | Write content to a file |
| delete `<file>` | Delete a file |
| rename `<old>` `<new>` | Rename a file |
| copy `<source>` `<destination>` | Copy a file |
| history | Show previously executed commands |

---

# ▶️ Running the Project

### Clone Repository

```bash
git clone https://github.com/<your-username>/MiniOS.git
```

### Go to Project

```bash
cd MiniOS
```

### Compile

```bash
javac -d out src/**/*.java
```

### Run

```bash
java -cp out app.Main
```

---

# 🧱 Architecture

MiniOS follows the **Command Pattern** to decouple command execution from the main application.

```
Main
   │
   ▼
CommandProcessor
   │
   ▼
CommandRegistry
   │
   ▼
Command
   │
   ▼
Specific Command
   │
   ▼
FileManager
```

---

# 📐 Design Principles

The project follows several Object-Oriented Programming and software engineering principles.

- SOLID Principles
- Command Pattern
- Dependency Injection (Constructor Injection)
- Composition over Inheritance
- Separation of Concerns
- Encapsulation
- Polymorphism

---

# ⚙️ Exception Handling

MiniOS uses Java's exception handling mechanism instead of boolean return values.

### Example

```java
try {
    fileManager.createFile(fileName);
} catch (IOException e) {
    System.out.println(e.getMessage());
}
```

Custom Exception

```java
InvalidCommandException
```

This improves readability, maintainability, and provides meaningful error messages.

---

# 📚 Concepts Implemented

- Java Basics
- Classes & Objects
- Packages
- Methods
- Constructors
- OOP
- Interfaces
- Inheritance
- Collections
- File Handling
- Exception Handling
- Custom Exceptions
- Command Pattern
- Dependency Injection
- Command Registry
- Command Context
- Java I/O
- Java NIO

---

# 📈 Future Enhancements

- Logging Framework
- Global Exception Handling
- Generics
- Java Streams API
- Serialization
- Multithreading
- Unit Testing (JUnit)
- Maven
- Design Patterns
- Spring Boot Integration

---

# 🧪 Example Session

```
JavaOS> help

Available Commands:
help
about
date
time
create
open
write
delete
rename
copy
history
exit

JavaOS> create notes.txt

File created successfully.

JavaOS> write notes.txt

Enter content:
Hello MiniOS
END

Content written successfully.

JavaOS> open notes.txt

Hello MiniOS

JavaOS> history

1. help
2. create notes.txt
3. write notes.txt
4. open notes.txt
```

---

# 🤝 Contributing

Contributions are welcome.

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push the branch.
5. Open a Pull Request.

---

# 👨‍💻 Author

**Pradnya Jadhav**

Computer Engineering Student | Java Developer | MERN Stack Developer

---

# ⭐ If you like this project

Give this repository a ⭐ on GitHub.
