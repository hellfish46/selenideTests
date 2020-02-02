package com.petclinic.tests;

import com.codeborne.selenide.Configuration;

public class TestBase {

    static {
        Configuration.baseUrl = "http://localhost:8000/petclinic";
    }
    //protected static final String BASE_URL = "http://localhost:8000/petclinic";
}
