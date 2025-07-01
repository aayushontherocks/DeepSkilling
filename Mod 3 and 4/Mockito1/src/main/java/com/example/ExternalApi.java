package com.example;

public interface ExternalApi {
    String getData();              // for original fetchData()
    String getData(String id);     // for argument matching
}
