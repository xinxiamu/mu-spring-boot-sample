package com.ymu.openaichatgptdemo;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.image.Image;
import com.theokanning.openai.image.ImageResult;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.List;

@SpringBootApplication
public class OpenaiChatgptDemoApplication {

    final static int timeout = 120; //两分钟
    static OpenAiService service;

    static {
        if (service == null) {
            String token = System.getenv("OPENAI_KEY");
            service = new OpenAiService(token, Duration.ofSeconds(timeout));
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(OpenaiChatgptDemoApplication.class, args);
    }

    @RequestMapping(value = "/openai")
    @RestController
    class OpenaiController {

        @GetMapping("/chat")
        public String chat(@RequestParam String ask) {
            CompletionRequest completionRequest = CompletionRequest.builder()
                    .model("text-davinci-003")
                    .prompt(ask)
                    .temperature(0.5)
                    .maxTokens(2048)
                    .topP(1D)
                    .frequencyPenalty(0D)
                    .presencePenalty(0D)
                    .build();
            CompletionResult completion = service.createCompletion(completionRequest);
            completion.getChoices().forEach(System.out::println);

            StringBuilder sb = new StringBuilder();
            List<CompletionChoice> choices = completion.getChoices();
            if (choices == null || choices.size() == 0) {
                return "error, no reply";
            }
            for (CompletionChoice c : choices) {
                sb.append(c.getText());
            }

            return sb.toString();
        }

        @GetMapping("/img")
        public String createImage(@RequestParam String content) {
            CreateImageRequest request = CreateImageRequest.builder()
                    .prompt(content)
                    .build();

            ImageResult result = service.createImage(request);

            System.out.println("\nImage is located at:");
            System.out.println(result.getData().get(0).getUrl());

            return result.getData().get(0).getUrl();
        }
    }
}
