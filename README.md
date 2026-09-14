# LangChain4j Practice

A small Java playground for learning [LangChain4j](https://github.com/langchain4j/langchain4j) — the Java-native library for building LLM-powered applications — as part of exploring agentic AI development in Java (alongside Spring AI and MCP).

Each demo talks to an LLM through Groq's OpenAI-compatible API (fast, free-tier inference over Llama models) rather than OpenAI directly, so it's cheap to run and experiment with.

## Demos

| Class | What it shows |
| --- | --- |
| `Main.java` | The simplest possible call — a single-string prompt to `ChatModel.chat(...)` with no system prompt |
| `Demo01.java` | System + user messages: a "fitness coach" persona constrained to bullet-point answers within its domain, plus reading back token usage and model metadata from the response |
| `Demo02.java` | Placeholder — work in progress |

## Tech stack

- Java 23
- Maven
- [LangChain4j](https://github.com/langchain4j/langchain4j) `1.18.1` (BOM-managed) — core + `langchain4j-open-ai` + `langchain4j-ollama`
- [Groq](https://groq.com) as the OpenAI-compatible inference backend (`llama-3.1-8b-instant`)
- Logback for logging

## Running

Requires a Groq API key (free at [console.groq.com](https://console.groq.com)):

```bash
export GROQ_API_KEY=your-key-here
mvn compile exec:java -Dexec.mainClass="org.example.Main"
# or
mvn compile exec:java -Dexec.mainClass="org.example.Demo01"
```

(Or run `Main.java` / `Demo01.java` directly from your IDE, provided `GROQ_API_KEY` is set in its run configuration.)

## Project structure

```
src/main/java/org/example/
  Main.java      Minimal single-prompt chat call
  Demo01.java    System + user messages, fitness-coach persona, token usage
  Demo02.java    WIP
pom.xml          Maven config — LangChain4j BOM, OpenAI-compatible + Ollama modules
```
