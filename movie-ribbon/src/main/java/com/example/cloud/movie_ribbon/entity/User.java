package com.example.cloud.movie_ribbon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by liupengfei on 2017/12/30.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;

    private String username;

    private String name;

    private int age;

    private double balance;
}
