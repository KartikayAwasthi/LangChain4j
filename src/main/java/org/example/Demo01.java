package org.example;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;


public class Demo01 {

    public static void main(String[]args)
    {
        System.out.println("Langchian4j using SYSTEM msg , USER msg , AI response");

        ChatModel chatModel = OpenAiChatModel.builder()
                .baseUrl("https://api.groq.com/openai/v1/")
                .apiKey(System.getenv("GROQ_API_KEY"))
                .modelName("llama-3.1-8b-instant")
                .build();

       SystemMessage systemMessage = SystemMessage.from("you are a fitness coach  , always answer in bullet points of 5 " + " do not answer out of fitness domain");

       UserMessage userMessage = UserMessage.from("how much calorie should a young person burn for fitness");

        ChatResponse chatResponse =  chatModel.chat(systemMessage,userMessage);

        AiMessage reply = chatResponse.aiMessage();

        System.out.println(reply.text());

        System.out.println(chatResponse.metadata().modelName());
        System.out.println(chatResponse.modelName());
        System.out.println(chatResponse.metadata().modelName());
        System.out.println(chatResponse.tokenUsage());
        System.out.println(chatResponse.aiMessage().text());
    }

}
