package com.liferay.community.langchain4j.sample.service;

/**
 * AITextGenerator is an interface for generating text using AI.
 */
public interface AITextGenerator {

    /**
     * Generate text using AI.
     * @param prompt
     * @return generated text
     */
    public String generateText(String prompt);
}
