// ********RoostGPT********
/*
Test generated by RoostGPT for test junit4-petstore using AI Type  and AI Model

ROOST_METHOD_HASH=equals_2a3d98178a
ROOST_METHOD_SIG_HASH=equals_e72790a55e

Scenario 1: Testing the equals method with identical objects
Details:
  TestName: testEqualsWithIdenticalObjects
  Description: This test is meant to check if the equals method correctly identifies two identical objects.
Execution:
  Arrange: Create two Country objects with the same isoCode.
  Act: Invoke the equals method by passing one of the objects as a parameter to the equals method of the other object.
  Assert: Assert that the equals method returns true.
Validation:
  The assertion verifies that the equals method correctly identifies two identical objects. This is important for ensuring the consistency of the application's data.

Scenario 2: Testing the equals method with different objects
Details:
  TestName: testEqualsWithDifferentObjects
  Description: This test is meant to check if the equals method correctly identifies two different objects.
Execution:
  Arrange: Create two Country objects with different isoCodes.
  Act: Invoke the equals method by passing one of the objects as a parameter to the equals method of the other object.
  Assert: Assert that the equals method returns false.
Validation:
  The assertion verifies that the equals method correctly identifies two different objects. This is crucial for ensuring the uniqueness of each Country object.

Scenario 3: Testing the equals method with null object
Details:
  TestName: testEqualsWithNullObject
  Description: This test is meant to check if the equals method correctly handles a null object.
Execution:
  Arrange: Create a Country object and a null object.
  Act: Invoke the equals method by passing the null object as a parameter to the equals method of the Country object.
  Assert: Assert that the equals method returns false.
Validation:
  The assertion verifies that the equals method correctly handles a null object. This is important for preventing null pointer exceptions.

Scenario 4: Testing the equals method with a different class object
Details:
  TestName: testEqualsWithDifferentClassObject
  Description: This test is meant to check if the equals method correctly handles objects of a different class.
Execution:
  Arrange: Create a Country object and an object of a different class.
  Act: Invoke the equals method by passing the different class object as a parameter to the equals method of the Country object.
  Assert: Assert that the equals method returns false.
Validation:
  The assertion verifies that the equals method correctly handles objects of a different class. This is crucial for maintaining type safety in the application.
*/

// ********RoostGPT********

package org.agoncal.application.petstore.model;

import org.agoncal.application.petstore.model.Country;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import static org.junit.Assert.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

public class CountryEqualsTest {

	@Category(Categories.valid.class)
	@Test
	public void testEqualsWithIdenticalObjects() {
		Country country1 = new Country("US", "United States", "USA", "US", "840");
		Country country2 = new Country("US", "United States", "USA", "US", "840");
		assertTrue(country1.equals(country2));
	}

	@Category(Categories.valid.class)
	@Test
	public void testEqualsWithDifferentObjects() {
		Country country1 = new Country("US", "United States", "USA", "US", "840");
		Country country2 = new Country("GB", "United Kingdom", "UK", "GB", "826");
		assertFalse(country1.equals(country2));
	}

	@Category(Categories.valid.class)
	@Test
	public void testEqualsWithNullObject() {
		Country country = new Country("US", "United States", "USA", "US", "840");
		assertFalse(country.equals(null));
	}

	@Category(Categories.valid.class)
	@Test
	public void testEqualsWithDifferentClassObject() {
		Country country = new Country("US", "United States", "USA", "US", "840");
		Object obj = new Object();
		assertFalse(country.equals(obj));
	}

}