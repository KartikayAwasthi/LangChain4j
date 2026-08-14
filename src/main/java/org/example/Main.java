package org.example;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to LangChain4j");

        ChatModel chatModel = OpenAiChatModel.builder()
                .baseUrl("https://api.groq.com/openai/v1/")
                .apiKey(System.getenv("GROQ_API_KEY"))
                .modelName("llama-3.1-8b-instant")
                .build();

        String answer = chatModel.chat("hello , tell me who is viladimir putin");
        System.out.println(answer);


    }
}