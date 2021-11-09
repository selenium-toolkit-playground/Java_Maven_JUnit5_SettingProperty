package com.seleniumToolkit.selenium.helper;

import java.util.Objects;

public class TestObject {
    String string;

    public TestObject(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "TestObject{" +
                "string='" + string + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestObject that = (TestObject) o;
        return Objects.equals(string, that.string);
    }

    @Override
    public int hashCode() {
        return Objects.hash(string);
    }
}
