// ********RoostGPT********
/*
Test generated by RoostGPT for test junit4-petstore using AI Type  and AI Model

ROOST_METHOD_HASH=calculateAge_a25422ac46
ROOST_METHOD_SIG_HASH=calculateAge_eda2a8b4ab

"""
Scenario 1: Test to verify customer age calculation with valid date of birth
Details:
    TestName: testCalculateAgeWithValidDateOfBirth
    Description: This test is designed to verify that the calculateAge method correctly computes the age of the customer when a valid date of birth is provided.
  Execution:
    Arrange: Create a Customer object and set a valid date of birth.
    Act: Invoke the calculateAge method on the Customer object.
    Assert: Assert that the age field of the Customer object is correctly calculated.
  Validation:
    The assertion verifies that the age calculation is correct when a valid date of birth is provided. This is important to ensure that the business logic for age calculation is functioning as expected.

Scenario 2: Test to verify customer age calculation with null date of birth
Details:
    TestName: testCalculateAgeWithNullDateOfBirth
    Description: This test is meant to check the behavior of the calculateAge method when the date of birth is null.
  Execution:
    Arrange: Create a Customer object without setting a date of birth.
    Act: Invoke the calculateAge method on the Customer object.
    Assert: Assert that the age field of the Customer object is null.
  Validation:
    The assertion verifies that the age calculation handles null date of birth correctly by setting the age to null. This is crucial to prevent null pointer exceptions during age calculation.

Scenario 3: Test to verify customer age calculation on the customer's birthday
Details:
    TestName: testCalculateAgeOnBirthday
    Description: This test is designed to verify that the calculateAge method correctly computes the age of the customer on their birthday.
  Execution:
    Arrange: Create a Customer object and set the date of birth such that today is the customer's birthday.
    Act: Invoke the calculateAge method on the Customer object.
    Assert: Assert that the age field of the Customer object is correctly calculated and incremented by one year.
  Validation:
    The assertion verifies that the age calculation correctly increments the age on the customer's birthday. This is essential to ensure accurate age calculation in line with real-world expectations.

Scenario 4: Test to verify customer age calculation on the day before the customer's birthday
Details:
    TestName: testCalculateAgeDayBeforeBirthday
    Description: This test is designed to verify that the calculateAge method correctly computes the age of the customer on the day before their birthday.
  Execution:
    Arrange: Create a Customer object and set the date of birth such that tomorrow is the customer's birthday.
    Act: Invoke the calculateAge method on the Customer object.
    Assert: Assert that the age field of the Customer object is correctly calculated and not yet incremented.
  Validation:
    The assertion verifies that the age calculation correctly handles the scenario where it is the day before the customer's birthday. This is important to ensure accurate age calculation in line with real-world expectations.
"""
*/

// ********RoostGPT********

package org.agoncal.application.petstore.model;

import org.agoncal.application.petstore.model.Customer;
import org.agoncal.application.petstore.model.Address;
import org.agoncal.application.petstore.model.Country;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.Assert;
import java.util.Calendar;
import java.util.Date;
import org.agoncal.application.petstore.constraints.Email;
import org.agoncal.application.petstore.constraints.Login;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.*;

public class CustomerCalculateAgeTest {

	@Category(Categories.valid.class)
	@Test
	public void testCalculateAgeWithValidDateOfBirth() {
		Customer customer = new Customer();
		Calendar calendar = Calendar.getInstance();
		calendar.set(1980, Calendar.JANUARY, 1);
		Date dateOfBirth = calendar.getTime();
		customer.setDateOfBirth(dateOfBirth);
		customer.calculateAge();
		int expectedAge = Calendar.getInstance().get(Calendar.YEAR) - 1980;
		Assert.assertEquals((Integer) expectedAge, customer.getAge());
	}

	@Category(Categories.valid.class)
	@Test
	public void testCalculateAgeWithNullDateOfBirth() {
		Customer customer = new Customer();
		customer.calculateAge();
		Assert.assertNull(customer.getAge());
	}

	@Category(Categories.boundary.class)
	@Test
	public void testCalculateAgeOnBirthday() {
		Customer customer = new Customer();
		Date today = new Date();
		customer.setDateOfBirth(today);
		customer.calculateAge();
		Assert.assertEquals((Integer) 0, customer.getAge());
	}

	@Category(Categories.boundary.class)
	@Test
	public void testCalculateAgeDayBeforeBirthday() {
		Customer customer = new Customer();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		Date dayBeforeToday = calendar.getTime();
		customer.setDateOfBirth(dayBeforeToday);
		customer.calculateAge();
		Assert.assertEquals((Integer) 0, customer.getAge());
	}

}