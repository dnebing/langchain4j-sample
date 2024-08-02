package com.liferay.community.langchain4j.sample.impl;

import org.osgi.service.component.annotations.Component;
import com.liferay.community.langchain4j.sample.service.AITextGenerator;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * OpenAITextGeneratorImpl is an implementation of AITextGenerator using OpenAI.
 */
@Component(
    immediate = true,
    service = AITextGenerator.class
)
public class OpenAITextGeneratorImpl implements AITextGenerator {
    private static final Log _log = LogFactoryUtil.getLog(OpenAITextGeneratorImpl.class);

    private static final String API_KEY = "YOUR_API_KEY";

    @Override
    public String generateText(String prompt) {
        try {
            ChatLanguageModel model = OpenAiChatModel.withApiKey(API_KEY);

            String answer = model.generate(prompt);

            _log.info("Generated text: " + answer);

            return answer;
        } catch (Exception e) {
            _log.error("Error generating text", e);
            return "Error generating text";
        }
    }
    

}

