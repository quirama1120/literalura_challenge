package com.alura.literatura_challenge.service;

public interface ObtainDataI {
    <T> T obtainingData(String json, Class <T> dataClass);
}
