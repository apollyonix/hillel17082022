package ua.hillel.rest.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.hillel.rest.PetEndpoint;
import ua.hillel.rest.entities.Pet;
import ua.hillel.rest.entities.UserAuto;

import java.io.IOException;

/**
 * @author Maxim Karpenko mkarpenko@modeln.com
 */

public class PetTest {
  @Test
  public void petTest() throws IOException {
    new PetEndpoint().getPetById(111);
  }

  @Test
  public void createPet() throws IOException {
    PetEndpoint petEndpoint = new PetEndpoint();
//    petEndpoint.createPet();

//    String dog1 = petEndpoint.createPetWithJSON("dog1", "available");
//    System.out.println(dog1);
//    String cat1 = petEndpoint.createPetWithJSON("cat1", "pending");
//    System.out.println(cat1);

    Pet dog = new Pet();
    dog.setName("Spike");
    dog.setStatus("available");

    Pet newDog = petEndpoint.createPetWithGson(dog);
    System.out.println(newDog);

    Assert.assertEquals(dog.getName(), newDog.getName());

    UserAuto user = new UserAuto();
    user.setEmail("asdasd");
    user.setPassword("asd");
  }
}
