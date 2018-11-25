package de.karnik.auverso.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
  @Id
  String id;
  String userName;
  String password;
  String mail;

}
