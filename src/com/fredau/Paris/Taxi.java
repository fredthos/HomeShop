package com.fredau.Paris;

public class Taxi implements MoyenDeLocomotion{
    @Override
    public void deplace(String adresse) {
        System.out.println("je suis un taxi et je vais a l'adresse" + adresse);
    }
}
