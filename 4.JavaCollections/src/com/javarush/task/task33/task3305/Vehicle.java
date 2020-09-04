package com.javarush.task.task33.task3305;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = As.PROPERTY, property="className")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class, name = "com.javarush.task.task33.task3305.Car"),
        @JsonSubTypes.Type(value = Motorbike.class, name = "com.javarush.task.task33.task3305.Motorbike"),
        @JsonSubTypes.Type(value = RacingBike.class, name = "com.javarush.task.task33.task3305.RacingBike")

})
public abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}