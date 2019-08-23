package com.geekerstar.learnspringboot.repository;

import com.geekerstar.learnspringboot.annotation.SecondLevelRepository;

@SecondLevelRepository(value = "myFirstLevelRepository") //Bean名称
public class MyFirstLevelRepository {
}
