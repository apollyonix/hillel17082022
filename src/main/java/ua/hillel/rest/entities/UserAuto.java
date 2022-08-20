package ua.hillel.rest.entities;

import lombok.*;

/**
 * @author Maxim Karpenko mkarpenko@modeln.com
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class UserAuto {
  private Integer id;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String phone;
  private Integer userStatus;

  private String customField;


  public void setPassword(String password) {

    this.password = password;
  }

}
