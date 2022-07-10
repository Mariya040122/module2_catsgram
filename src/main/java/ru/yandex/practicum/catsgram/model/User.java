package ru.yandex.practicum.catsgram.model;

import lombok.Data;

import java.time.LocalDate;

   @Data
   public class User {
       private String email;
       private String nickname;
       private LocalDate birthdate;

       public User(String email, String nickname, LocalDate birthdate) {
           this.email = email;
           this.nickname = nickname;
           this.birthdate = birthdate;
       }
   }

